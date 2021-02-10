package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement

public class House {
	@Id
	@GeneratedValue
	private int houseId;
	
	private String houseName;
	private String details;
	private String place;
	private String 	Address;
	private String rent;
	private String houseImage;
	private String status;
	
	
	@ManyToOne
	@JoinColumn(name="tenantId")
	private Tenant tenant;
	
	public int getHouseId() {
		return houseId;
	}
	
	public House() {
		
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getHouseImage() {
		return houseImage;
	}
	public void setHouseImage(String houseImage) {
		this.houseImage = houseImage;
	}
	
}
