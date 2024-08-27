package com.pavan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pavan.entity.Enquiry;

import java.util.List;

@Repository
public interface EnquiryRepo extends JpaRepository<Enquiry, Integer> {
    // Example of custom query methods:
    List<Enquiry> findByCounsellor_CounsellorId(int counsellorId);
    List<Enquiry> findByEnqStatus(String enqStatus);
    
    @Query(value = "select * from enquiry_tbl where counsellor_id=:counsellorId", nativeQuery =true)
    public List<Enquiry> getEnquiriesByCounsellorId(Integer counsellorId);
}

