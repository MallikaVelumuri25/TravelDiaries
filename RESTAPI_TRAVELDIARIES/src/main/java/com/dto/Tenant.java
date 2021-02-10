package com.dto;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@XmlRootElement

public class Tenant {
	
	
	@Id
	@GeneratedValue
	private int tenantId;
	
	private String tenantName;
	private String tenantPhoneNo;
	private String tenantMailId;
	private String tenantCity;
	private String tenantState;
	private String tenantCountry;
	private String tenantPassword;
	
	@JsonIgnore
	@OneToMany(mappedBy="tenant",fetch = FetchType.LAZY)
	private Set<House> house = new HashSet<House>();
	
	public Set<House> getHouse() {
		return house;
	}

	public void setHouse(Set<House> house) {
		this.house = house;
	}

	public String getTenantPassword() {
		return tenantPassword;
	}

	public void setTenantPassword(String tenantPassword) {
		this.tenantPassword = tenantPassword;
	}

	/*@OneToOne(mappedBy="travellerId")
	private Traveller traveller;
	
	public Traveller getTraveller() {
		return traveller;
	}

	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}
*/
	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getTenantId() {
		return tenantId;
	}
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getTenantPhoneNo() {
		return tenantPhoneNo;
	}
	public void setTenantPhoneNo(String tenantPhoneNo) {
		this.tenantPhoneNo = tenantPhoneNo;
	}
	public String getTenantMailId() {
		return tenantMailId;
	}
	public void setTenantMailId(String tenantMailId) {
		this.tenantMailId = tenantMailId;
	}
	public String getTenantCity() {
		return tenantCity;
	}
	public void setTenantCity(String tenantCity) {
		this.tenantCity = tenantCity;
	}
	public String getTenantState() {
		return tenantState;
	}
	public void setTenantState(String tenantState) {
		this.tenantState = tenantState;
	}
	public String getTenantCountry() {
		return tenantCountry;
	}
	public void setTenantCountry(String tenantCountry) {
		this.tenantCountry = tenantCountry;
	}
	
	

}
