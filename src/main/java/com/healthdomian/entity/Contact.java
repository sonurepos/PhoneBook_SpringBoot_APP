package com.healthdomian.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data //lombok , to create setter and getter and by default  no arg const generate
@Entity
@Table(name="CONTACT_DETAILS")
public class Contact {
	
	@Id
	@GeneratedValue
	@Column(name="CONTACT_ID")
	private Integer contactId;
	
	@Column(name="CONTGACT_NAME")
	private String contactName;
	
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name="CONTACT_NUMBER")
	private Long contactNumber;
	
	@Column(name="CREATE_DATE" , updatable=false)
	@CreationTimestamp
	private LocalDate createdate;
	
	@Column(name="UPDATE_DATE" , insertable =false)
	@UpdateTimestamp
	private LocalDate updateDate;
	
	@Column(name="ACTIVE_SW")
	private String activeSw;
	

}
