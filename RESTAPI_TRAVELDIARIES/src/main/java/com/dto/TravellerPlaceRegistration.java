package com.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@XmlRootElement


public class TravellerPlaceRegistration {
	
	@Id
	@GeneratedValue
	private int travellerPlaceId;
	
	private String travellerDestination;
	private String startingPoint;
	public String getStartingPoint() {
		return startingPoint;
	}


	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	private int days;
	private Date date;
	
	
	@ManyToOne
	@JoinColumn(name="travellerId")
	private Traveller traveller;
	
	
	
	
	public TravellerPlaceRegistration() {
		super();
	}
	
	
	public String getTravellerDestination() {
		return travellerDestination;
	}
	public void setTravellerDestination(String travellerDestination) {
		this.travellerDestination = travellerDestination;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTravellerPlaceId() {
		return travellerPlaceId;
	}
	public void setTravellerPlaceId(int travellerPlaceId) {
		this.travellerPlaceId = travellerPlaceId;
	}
	
	
	public Traveller getTraveller() {
		return traveller;
	}
	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}
	
	
}
