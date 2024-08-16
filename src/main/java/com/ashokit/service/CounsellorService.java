package com.ashokit.service;

import java.util.List;

import com.ashokit.model.Counsellor;
import com.ashokit.model.DashboardResponse;
import com.ashokit.model.Enquiry;
import com.ashokit.model.ViewEnqFilterRequest;

public interface CounsellorService {
    
    Counsellor createCounsellor(Counsellor counsellor);
    
    Counsellor updateCounsellor(Counsellor counsellor);
    
    void deleteCounsellor(int counsellorId);
    
    List<Counsellor> getAllCounsellors();
    
    Counsellor getCounsellorById(int counsellorId);

    DashboardResponse getDashboardData(int counsellorId);

    List<Enquiry> viewEnquiries(ViewEnqFilterRequest filterRequest);
}

