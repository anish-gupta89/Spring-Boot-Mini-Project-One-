package com.ag.db;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_citizen_plan")
@EntityListeners(AuditingEntityListener.class)
public class CitizenPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "citizen_id")
	private Integer Id;

	private String citizenName;
	private String gender;
	private String planName;
	private String planStatus;
	
	
	private LocalDate planStartDate;
	

	private LocalDate planEndDate;
	private Integer benefitAmount;
	private String denialRsn;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private LocalDate terminatedDate;
	private String terminationRsn;

	@Column(name = "created_date", updatable = false)
	@CreatedDate
	private Date createdDate;

	@Column(name = "updated_date", updatable = true)
	@UpdateTimestamp
	private Date updatedDate;
}
