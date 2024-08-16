package com.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.model.Counsellor;
import com.ashokit.model.DashboardResponse;
import com.ashokit.model.Enquiry;
import com.ashokit.model.ViewEnqFilterRequest;
import com.ashokit.repo.CounsellorRepo;
import com.ashokit.repo.EnquiryRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CounsellorServiceImpl implements CounsellorService {
    
    @Autowired
    private CounsellorRepo counsellorRepo;
    
    @Autowired
    private EnquiryRepo enquiryRepo;

    @Override
    public Counsellor createCounsellor(Counsellor counsellor) {
        return counsellorRepo.save(counsellor);
    }

    @Override
    public Counsellor updateCounsellor(Counsellor counsellor) {
        Optional<Counsellor> existingCounsellor = counsellorRepo.findById(counsellor.getCounsellorId());
        if (existingCounsellor.isPresent()) {
            return counsellorRepo.save(counsellor);
        } else {
            throw new RuntimeException("Counsellor not found with id: " + counsellor.getCounsellorId());
        }
    }

    @Override
    public void deleteCounsellor(int counsellorId) {
        counsellorRepo.deleteById(counsellorId);
    }

    @Override
    public List<Counsellor> getAllCounsellors() {
        return counsellorRepo.findAll();
    }

    @Override
    public Counsellor getCounsellorById(int counsellorId) {
        return counsellorRepo.findById(counsellorId)
                             .orElseThrow(() -> new RuntimeException("Counsellor not found with id: " + counsellorId));
    }

    @Override
    public DashboardResponse getDashboardData(int counsellorId) {
        int totalEnquiries = enquiryRepo.findByCounsellor_CounsellorId(counsellorId).size();
        int openEnquiries = enquiryRepo.findByCounsellor_CounsellorId(counsellorId).stream()
                                       .filter(e -> e.getEnqStatus().equalsIgnoreCase("Open")).toList().size();
        int enrolledEnquiries = enquiryRepo.findByCounsellor_CounsellorId(counsellorId).stream()
                                           .filter(e -> e.getEnqStatus().equalsIgnoreCase("Enrolled")).toList().size();
        int lostEnquiries = enquiryRepo.findByCounsellor_CounsellorId(counsellorId).stream()
                                       .filter(e -> e.getEnqStatus().equalsIgnoreCase("Lost")).toList().size();
        
        return new DashboardResponse(totalEnquiries, openEnquiries, enrolledEnquiries, lostEnquiries);
    }

    @Override
    public List<Enquiry> viewEnquiries(ViewEnqFilterRequest filterRequest) {
        if (filterRequest.getEnqStatus() != null) {
            return enquiryRepo.findByCounsellor_CounsellorId(filterRequest.getCounsellorId()).stream()
                              .filter(e -> e.getEnqStatus().equalsIgnoreCase(filterRequest.getEnqStatus())).toList();
        } else {
            return enquiryRepo.findByCounsellor_CounsellorId(filterRequest.getCounsellorId());
        }
    }
}
