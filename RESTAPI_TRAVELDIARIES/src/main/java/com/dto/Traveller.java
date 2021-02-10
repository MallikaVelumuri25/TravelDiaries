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


@XmlRootElement
@Entity
public class Traveller {
	
	@Id
	@GeneratedValue
	private int travellerId;
	
	private String travellerName;
	private String travellerDOB;
	private String travellerGender;
	private String travellerGmailId;
	private String travellerCity;
	private String travellerState;
	private String travellerCountry;
	private String travellerPassword;
	private String travellerPhoneNo;
	private String travellerAadharNo;
	
	@JsonIgnore
	@OneToMany(mappedBy="traveller",fetch = FetchType.LAZY)
	private Set<TravellerPlaceRegistration> travellerPlaceRegistration = new HashSet<TravellerPlaceRegistration>();
	
	@JsonIgnore
	@OneToMany(mappedBy="traveller",fetch = FetchType.LAZY)
	private Set<Review> review = new HashSet<Review>();
	
	
	
	
	public Set<Review> getReview() {
		return review;
	}

	public void setReview(Set<Review> review) {
		this.review = review;
	}

	public Traveller() {
	}

	public int getTravellerId() {
		return travellerId;
	}

	public void setTravellerId(int travellerId) {
		this.travellerId = travellerId;
	}

	public String getTravellerName() {
		return travellerName;
	}

	public void setTravellerName(String travellerName) {
		this.travellerName = travellerName;
	}

	public String getTravellerDOB() {
		return travellerDOB;
	}

	public void setTravellerDOB(String travellerDOB) {
		this.travellerDOB = travellerDOB;
	}

	public String getTravellerGender() {
		return travellerGender;
	}

	public void setTravellerGender(String travellerGender) {
		this.travellerGender = travellerGender;
	}

	public String getTravellerGmailId() {
		return travellerGmailId;
	}

	public void setTravellerGmailId(String travellerGmailId) {
		this.travellerGmailId = travellerGmailId;
	}

	public String getTravellerCity() {
		return travellerCity;
	}

	public void setTravellerCity(String travellerCity) {
		this.travellerCity = travellerCity;
	}

	public String getTravellerState() {
		return travellerState;
	}

	public void setTravellerState(String travellerState) {
		this.travellerState = travellerState;
	}

	public String getTravellerCountry() {
		return travellerCountry;
	}

	public void setTravellerCountry(String travellerCountry) {
		this.travellerCountry = travellerCountry;
	}

	public String getTravellerPassword() {
		return travellerPassword;
	}

	public void setTravellerPassword(String travellerPassword) {
		this.travellerPassword = travellerPassword;
	}

	public String getTravellerPhoneNo() {
		return travellerPhoneNo;
	}

	public void setTravellerPhoneNo(String travellerPhoneNo) {
		this.travellerPhoneNo = travellerPhoneNo;
	}

	public String getTravellerAadharNo() {
		return travellerAadharNo;
	}

	public void setTravellerAadharNo(String travellerAadharNo) {
		this.travellerAadharNo = travellerAadharNo;
	}

	public Set<TravellerPlaceRegistration> getTravellerPlaceRegistration() {
		return travellerPlaceRegistration;
	}

	public void setTravellerPlaceRegistration(Set<TravellerPlaceRegistration> travellerPlaceRegistration) {
		this.travellerPlaceRegistration = travellerPlaceRegistration;
	}
	
	

}
