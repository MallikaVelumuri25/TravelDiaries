package com.ts.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.dto.Tenant;
import com.dto.Traveller;
import com.dto.TravellerPlaceRegistration;


//import com.rest.dto.Department;
//import com.rest.dto.Employee;

public class HibernateTemplate {

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj)
	{
		System.out.println("Inside Template...");
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;
		
		try {			
			return sessionFactory.openSession().get(c,serializable);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return obj;
	}

	public static Traveller getObjectByUserPassTraveller(String emailId, String password) {
		// TODO Auto-generated method stub
		System.out.println("mailId" + emailId + " password " + password);
		
		String queryString = "from Traveller where travellerGmailId = :emailId and travellerPassword =:password";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("emailId", emailId);
		  query.setString("password", password);
		  Object queryResult = query.uniqueResult();
		  Traveller traveller = (Traveller)queryResult;
		  System.out.println(traveller);
		  return traveller; 

		// select *  from Traveller where travellerGmailId = 'xyz@gmail.com' and travellerPassword = 'xyzxyz';
	}

	public static Tenant getObjectByUserPassTenant(String mailId, String password) {
		// TODO Auto-generated method stub
		System.out.println("mailId" + mailId + " password " + password);
		
		String queryString = "from Tenant where tenantMailId = :emailId and tenantPassword =:password";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("emailId", mailId);
		  query.setString("password", password);
		  Object queryResult = query.uniqueResult();
		  Tenant tenant = (Tenant)queryResult;
		  System.out.println(tenant);
		  return tenant; 
	}
	
public static Object getObjectByEmail(String email) {
		
		String queryString = "from Traveller where travellerGmailId = :email";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("email", email);
		  Object queryResult = query.uniqueResult();
		  Traveller traveller = (Traveller)queryResult;
		  return traveller; 
		}
public static Tenant getTenantByEmail(String email) {
	String queryString = "from Tenant where tenantMailId = :email";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setString("email", email);
	  Object queryResult = query.uniqueResult();
	  Tenant tenant = (Tenant)queryResult;
	  return tenant; 
}

 public static List<Object> getObjectListByQuery(String query)
	{
		return sessionFactory.openSession().createQuery(query).list();
	}
	
	
	
 
	/*public static Object getObjectByUserPass(String loginId,String password) {
	
	String queryString = "from Employee where email = :loginId and password =:password";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setString("loginId", loginId);
	  query.setString("password", password);
	  Object queryResult = query.uniqueResult();
	  Employee employee = (Employee)queryResult;
	  return employee; 
	}
	public static Object getObjectByEmail(String email) {
		
		String queryString = "from Employee where email = :email";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("email", email);
		  Object queryResult = query.uniqueResult();
		  Employee employee = (Employee)queryResult;
		  return employee; 
		}
	
	public static List<Object> getObjectListByQuery(String query)
	{
		return sessionFactory.openSession().createQuery(query).list();
	}
	
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
		}
		
		return result;
	}

	public static List<Object> getObjectListByName(Class c, String columName, String value) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
	}*/
	public static List<Object> getObjectListByName(Class c, String columName, String value) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
	}
	public static List<Object> getObjectListById(Class c, String columName, int value) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
	}

	public static TravellerPlaceRegistration getDetailsByPlace(String place) {
		String queryString = "from TravellerPlaceRegistration where  travellerDestination= :place";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("place", place);
		  Object queryResult = query.uniqueResult();
		  TravellerPlaceRegistration travellerPlaceRegistration = (TravellerPlaceRegistration)queryResult;
		  return travellerPlaceRegistration; 
	}
	 public static Tenant getTenantById(int id) {
			String queryString = "from Tenant where tenantId = :id";
			  Query query = sessionFactory.openSession().createQuery(queryString);
			  query.setInteger("id", id);
			  Object queryResult = query.uniqueResult();
			  Tenant tenant = (Tenant)queryResult;
			  return tenant; 
}
	 public static int updateObject(Object obj)
		{
			int result=0;
			
			Transaction tx=null;
			
			try {
				
				Session session=sessionFactory.openSession();
				tx=session.beginTransaction();
				
				session.saveOrUpdate(obj);
				
				tx.commit();
				
				result=1;
				
			} catch (Exception e) {
			
				tx.rollback();
				
				e.printStackTrace();
			}
			
			return result;
		}
}
