package com.pavan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pavan.entity.Counsellor;

@Repository
public interface CounsellorRepo extends JpaRepository<Counsellor, Integer> {

	
	//select * from counsellor_tbl where email=:email
	public Counsellor findByEmail(String email);
	
	//query will be constructed by data jpa// select * from counsellor_tbl where email=:email and pwd=:pwd
	public Counsellor findByEmailAndPwd(String email, String pwd);

}

