package com.dao;

import java.util.List;

import com.dto.House;
import com.dto.Review;
import com.ts.db.HibernateTemplate;

public class ReviewDAO {

	public int postreview(Review review) {
		// TODO Auto-generated method stub
		return HibernateTemplate.addObject(review);
	}

	public List<Review> getAllReviews() {
		// TODO Auto-generated method stub
		List<Review> review = (List)HibernateTemplate.getObjectListByQuery("From Review");
		return review;
	}

}
