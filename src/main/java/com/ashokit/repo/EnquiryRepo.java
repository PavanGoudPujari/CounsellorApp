package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.model.Enquiry;

import java.util.List;

@Repository
public interface EnquiryRepo extends JpaRepository<Enquiry, Integer> {
    // Example of custom query methods:
    List<Enquiry> findByCounsellor_CounsellorId(int counsellorId);
    List<Enquiry> findByEnqStatus(String enqStatus);
}

