package com.pavan.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.dto.DashboardResponse;
import com.pavan.dto.ViewEnqFilterRequest;
import com.pavan.entity.Counsellor;
import com.pavan.entity.Enquiry;
import com.pavan.repo.CounsellorRepo;
import com.pavan.repo.EnquiryRepo;

@Service
public class CounsellorServiceImpl implements CounsellorService {

	@Autowired
	private CounsellorRepo counsellorRepo;
	
	@Autowired
	private EnquiryRepo enquiryRepo;
	
	@Override
	public Counsellor login(String email, String pwd) {
		return counsellorRepo.findByEmailAndPwd(email, pwd);
	
	}

	
	@Override
	public Counsellor findByEmail(String email) {
		return counsellorRepo.findByEmail(email);
	}
	@Override
	public boolean register(Counsellor counsellor) {
		
		Counsellor savedCounsellor = counsellorRepo.save(counsellor);
		if(null != savedCounsellor.getCounsellorId()) {
			return true;
		}
		return false;
	}

	@Override
	public DashboardResponse getDashboardInfo(Integer counsellorId) {
		DashboardResponse response = new DashboardResponse();
		
		List<Enquiry> enqList =enquiryRepo.getEnquiriesByCounsellorId(counsellorId);
		int totalEnq = enqList.size();
		
		int enrolledEnqs=enqList.stream().filter(e->e.getEnqStatus().equals("Enrolled")).collect(Collectors.toList())
		.size();
		
		int openEnqs=enqList.stream().filter(e->e.getEnqStatus().equals("Open")).collect(Collectors.toList())
				.size();
		
		int lostEnqs=enqList.stream().filter(e->e.getEnqStatus().equals("Lost")).collect(Collectors.toList())
				.size();
		
		
		response.setTotalEnquiries(totalEnq);
		response.setEnrolledEnquiries(enrolledEnqs);
		response.setOpenEnquiries(openEnqs);
		response.setLostEnquiries(lostEnqs);
		
		return response;
	}

	@Override
	public Counsellor createCounsellor(Counsellor counsellor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Counsellor updateCounsellor(Counsellor counsellor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCounsellor(int counsellorId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Counsellor> getAllCounsellors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Counsellor getCounsellorById(int counsellorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DashboardResponse getDashboardData(int counsellorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enquiry> viewEnquiries(ViewEnqFilterRequest filterRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
