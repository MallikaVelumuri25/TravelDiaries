package com.dao;

import java.util.List;

import com.dto.House;
import com.dto.Traveller;
import com.dto.TravellerPlaceRegistration;
import com.ts.db.HibernateTemplate;

public class HouseDAO {

	public List<House> getAllItemDetails() {
	// TODO Auto-generated method stub
		List<House> house = (List)HibernateTemplate.getObjectListByQuery("From House");
		return house;
	}

	public int additem(House house) {
		// TODO Auto-generated method stub
		System.out.println(house); 
		return HibernateTemplate.addObject(house);
	}
	public int updateDetails(House house) {
		System.out.println(house); 
		return HibernateTemplate.updateObject(house);
	}

	public List<House> getHousesByTenantId(int id) {
		// TODO Auto-generated method stub
		return (List)HibernateTemplate.getObjectListById(House.class,"tenantId",id);
		
	}

}
