package com.dao;

import java.util.List;
import java.util.ArrayList;

import com.dto.House;
import com.dto.Tenant;
import com.dto.TravellerPlaceRegistration;
import com.ts.db.HibernateTemplate;

public class TravellerPlaceRegistrationDAO {

	public int register(TravellerPlaceRegistration travellerPlaceRegistration) {
		// TODO Auto-generated method stub
		return HibernateTemplate.addObject(travellerPlaceRegistration);
		
	}
	public List<TravellerPlaceRegistration> getDetailsByPlace(String place) {
		// TODO Auto-generated method stub
		return (List)HibernateTemplate.getObjectListByName(TravellerPlaceRegistration.class,"travellerDestination",place);
			}
	/*return (List)HibernateTemplate.getObjectListByName(TravellerPlaceRegistration.class,"travellerDestination",place);
	*/
	public List<TravellerPlaceRegistration> getAllTravellerDetails() {
		// TODO Auto-generated method stub
		List<TravellerPlaceRegistration> travellerPlaceRegistration = (List)HibernateTemplate.getObjectListByQuery("From TravellerPlaceRegistration");
		return travellerPlaceRegistration;
	}

}
