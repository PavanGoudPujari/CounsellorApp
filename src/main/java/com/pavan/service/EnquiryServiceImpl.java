package com.pavan.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.pavan.dto.ViewEnqFilterRequest;
import com.pavan.entity.Counsellor;
import com.pavan.entity.Enquiry;
import com.pavan.repo.CounsellorRepo;
import com.pavan.repo.EnquiryRepo;

import io.micrometer.common.util.StringUtils;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	
	private EnquiryRepo enqRepo;
	
	private CounsellorRepo counsellorRepo;
	
	public EnquiryServiceImpl(EnquiryRepo enqRepo, CounsellorRepo counsellorRepo) {
		this.enqRepo = enqRepo;
		this.counsellorRepo= counsellorRepo;
	}
	@Override
	public boolean addEnquiry(Enquiry enq, Integer counsellorId) throws Exception{
		
		Counsellor counsellor = counsellorRepo.findById(counsellorId).orElse(null);
		
		if(counsellor==null) {
			throw new Exception("No counsellor found");
		}
		//associating counsellor to enquiry
		enq.setCounsellor(counsellor);
		Enquiry save=enqRepo.save(enq);  //UPSERT (Update+insert)
		
		if(save.getEnqId() !=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Enquiry> getAllEnquiries(Integer counsellorId) {
		return enqRepo.getEnquiriesByCounsellorId(counsellorId);
		
	}

	@Override
	public List<Enquiry> getEnquiresWithFilter(ViewEnqFilterRequest filterReq, Integer counsellorId) {
		
		//Query by Example implementation (Dynamic Query Preparation)
		
		Enquiry enq = new Enquiry();
		
		if(StringUtils.isNotEmpty(filterReq.getClassMode())) {
			enq.setClassMode(filterReq.getClassMode());
		}
		
		if(StringUtils.isNotEmpty(filterReq.getCourseName())) {
			enq.setCourseName(filterReq.getCourseName());
		}
		if(StringUtils.isNotEmpty(filterReq.getEnqStatus())) {
			enq.setEnqStatus(filterReq.getEnqStatus());
		}
		
		Counsellor c= counsellorRepo.findById(counsellorId).orElse(null);
		
		enq.setCounsellor(c);
		Example<Enquiry> of=Example.of(enq);
		
		List<Enquiry>enqList = enqRepo.findAll(of);
		
		return enqList;
	}

	@Override
	public Enquiry getEnquiryById(Integer enqId) {
	    return enqRepo.findById(enqId).orElse(null);
		
	}

}
