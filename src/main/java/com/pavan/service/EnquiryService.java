package com.pavan.service;

import java.util.List;

import com.pavan.dto.ViewEnqFilterRequest;
import com.pavan.entity.Enquiry;

public interface EnquiryService {

	
	public boolean addEnquiry(Enquiry enq, Integer counsellorId) throws Exception;
	
	public List<Enquiry> getAllEnquiries(Integer counsellorId);
	
	public List<Enquiry> getEnquiresWithFilter(ViewEnqFilterRequest filterReq, Integer counsellorId);

    public Enquiry getEnquiryById(Integer enqId);
}
