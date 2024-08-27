package com.pavan.entity;

//import javax.persistence.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "enquiry_tbl")
@Access(AccessType.FIELD)
public class Enquiry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enq_id")
    private Integer enqId;
    
    @Column(name = "student_name", nullable = false)
    private String studentName;
    
    @Column(name = "student_phno", nullable = false)
    private String studentPhno;
    
    @Column(name = "course_name", nullable = false)
    private String courseName;
    
    public Integer getEnqId() {
		return enqId;
	}

	public void setEnqId(Integer enqId) {
		this.enqId = enqId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentPhno() {
		return studentPhno;
	}

	public void setStudentPhno(String studentPhno) {
		this.studentPhno = studentPhno;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getClassMode() {
		return classMode;
	}

	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}

	public String getEnqStatus() {
		return enqStatus;
	}

	public void setEnqStatus(String enqStatus) {
		this.enqStatus = enqStatus;
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

	public Counsellor getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counsellor counsellor) {
		this.counsellor = counsellor;
	}

	@Column(name = "class_mode", nullable = false)
    private String classMode;
    
    @Column(name = "enq_status", nullable = false)
    private String enqStatus;
    
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;
    
    @Column(name = "updated_date")
    @UpdateTimestamp
    private LocalDateTime updatedDate;
    
    @ManyToOne
    @JoinColumn(name = "counsellor_id", nullable = false)
    private Counsellor counsellor;

    // Constructors, getters, setters, toString() methods
    
    
}

