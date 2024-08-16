package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.model.Counsellor;

@Repository
public interface CounsellorRepo extends JpaRepository<Counsellor, Integer> {
    
}

