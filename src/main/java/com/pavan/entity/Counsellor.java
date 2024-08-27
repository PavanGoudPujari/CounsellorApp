package com.pavan.entity;


//import javax.persistence.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Counsellor_tbl")
@Access(AccessType.FIELD)
public class Counsellor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counsellor_id")
    private Integer counsellorId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "pwd", nullable = false)
    private String pwd;
    
    @Column(name = "phno", nullable = false)
    private Long phno;
    
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;
    
    @Column(name = "updated_date")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

	public Integer getCounsellorId() {
		return counsellorId;
	}

	public void setCounsellorId(Integer counsellorId) {
		this.counsellorId = counsellorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	

    // Constructors, getters, setters, toString() methods
    
}

