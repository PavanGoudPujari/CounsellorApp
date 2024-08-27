package com.pavan.service;

import java.util.List;

import com.pavan.dto.DashboardResponse;
import com.pavan.dto.ViewEnqFilterRequest;
import com.pavan.entity.Counsellor;
import com.pavan.entity.Enquiry;

public interface CounsellorService {
	
	
	public Counsellor findByEmail(String email);
	
    
	public Counsellor login(String email, String pwd);
	
	public boolean register(Counsellor counsellor);
	
	public DashboardResponse getDashboardInfo(Integer counsellorId);
	
	
	
	
	
	
	
	
	
	
	
	
    Counsellor createCounsellor(Counsellor counsellor);
    
    Counsellor updateCounsellor(Counsellor counsellor);
    
    void deleteCounsellor(int counsellorId);
    
    List<Counsellor> getAllCounsellors();
    
    Counsellor getCounsellorById(int counsellorId);

    DashboardResponse getDashboardData(int counsellorId);

    List<Enquiry> viewEnquiries(ViewEnqFilterRequest filterRequest);
}

