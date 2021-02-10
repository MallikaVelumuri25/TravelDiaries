package com.ts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.dao.HouseDAO;
import com.dao.ReviewDAO;
import com.dao.TenantDAO;
import com.dao.TravellerDAO;
import com.dao.TravellerPlaceRegistrationDAO;
import com.dto.House;
import com.dto.Review;
import com.dto.Tenant;
import com.dto.Traveller;
import com.dto.TravellerPlaceRegistration;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    @Path("registertraveller")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registertraveller(Traveller traveller) {
		System.out.println("Data Recieved in traveller Register : " + traveller);
		TravellerDAO travellerDAO = new TravellerDAO();
		travellerDAO.register(traveller);
	
	}
    @Path("updateDetails")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateDetails(Traveller traveller) {
		System.out.println("Data Recieved in traveller Register : " + traveller);
		TravellerDAO travellerDAO = new TravellerDAO();
		travellerDAO.updateDetails(traveller);
	
	}
    @Path("updateHouseDetails")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateHouseDetails(House house) {
		System.out.println("Data Recieved in traveller Register : " + house);
		HouseDAO houseDAO = new HouseDAO();
		houseDAO.updateDetails(house);
	
	}
    
    @Path("getTravellerByUserPass/{mailId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Traveller getTravellerByUserPass(@PathParam("mailId") String mailId,@PathParam("password") String password) {
		System.out.println("Recieved path params: "+mailId+" "+password); 
		TravellerDAO travellerDAO = new TravellerDAO();
		Traveller traveller = travellerDAO.getTravellerByUserPass(mailId, password);
		System.out.println("Traeller details in myresource : "+traveller);
		return traveller;
	}
    @Path("getTenantByUserPass/{mailId}/{password}")
   	@GET
   	@Produces(MediaType.APPLICATION_JSON)
   	public Tenant getTenantByUserPass(@PathParam("mailId") String mailId,@PathParam("password") String password) {
   		System.out.println("Recieved path params: "+mailId+" "+password); 
   		TenantDAO tenantDAO = new TenantDAO();
   		Tenant tenant = tenantDAO.getTenantByUserPass(mailId, password);
   		System.out.println("Traeller details in myresource : "+tenant);
   		return tenant;
   	}
    
    @Path("registertenant")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registertenant(Tenant tenant) {
		System.out.println("Data Recieved in tenant Register : " + tenant);
		TenantDAO tenantDAO = new TenantDAO();
		tenantDAO.register(tenant);
	
	}
    
    @Path("getTravellerByEmail/{email}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Traveller getTravellerByEmail(@PathParam("email") String email) {
		System.out.println("Recieved path params: "+email); 
		TravellerDAO travellerDAO = new TravellerDAO();
		Traveller traveller = travellerDAO.getTravellerByEmail(email);
		return traveller;
	}
    
    @Path("getTenantByEmail/{email}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Tenant getTenantByEmail(@PathParam("email") String email) {
		System.out.println("Recieved path params: "+email); 
		TenantDAO tenantDAO = new TenantDAO();
		Tenant tenant = tenantDAO.getenantByEmail(email);
		return tenant;
	}
    @Path("uploadImage")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void uploadImage(@FormDataParam("houseImage") InputStream fileInputStream,@FormDataParam("houseImage") FormDataContentDisposition
    formDataContentDisposition,  @FormDataParam("houseName") String houseName,@FormDataParam("place") String place
    ,@FormDataParam("Address") String Address,@FormDataParam("rent") String rent,@FormDataParam("details") String details,@FormDataParam("status") String status,@FormDataParam("tenantId") Integer tenantId) throws IOException {;
    int read = 0;
    byte[] bytes = new byte[1024];

    String path = this.getClass().getClassLoader().getResource("").getPath();

    String pathArr[] = path.split("/WEB-INF/classes/");

    FileOutputStream out = new FileOutputStream(new File(pathArr[0]+"/image/", formDataContentDisposition.getFileName()));


    while((read = fileInputStream.read(bytes)) != -1){

    out.write(bytes,0,read);
    }
    out.flush();
    out.close();
    Tenant tenant=new Tenant();
    tenant.setTenantId(tenantId);
    House house = new House();
    house.setHouseImage(formDataContentDisposition.getFileName());
    house.setHouseName(houseName);
    house.setDetails(details);
    house.setPlace(place);
    house.setAddress(Address);
    house.setRent(rent);
    house.setStatus(status);
    house.setTenant(tenant);
    
    
    HouseDAO houseDAO = new HouseDAO();
    houseDAO.additem(house);
    }
    @Path("getHouses")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<House> getHouses() {

    HouseDAO houseDAO = new HouseDAO();
    List <House> house = houseDAO.getAllItemDetails();

    return house;
    }
    @Path("gettravellers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravellerPlaceRegistration> gettravellers() {

    TravellerPlaceRegistrationDAO travellerPlaceRegistrationDAO = new TravellerPlaceRegistrationDAO();
    List <TravellerPlaceRegistration> travellerPlaceRegistration = travellerPlaceRegistrationDAO.getAllTravellerDetails();

    return travellerPlaceRegistration;
    }
    @Path("registerplace")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    public void registerplace(TravellerPlaceRegistration travellerPlaceRegistration) {
		System.out.println("Data Recieved in traveller place Register : " + travellerPlaceRegistration);
		TravellerPlaceRegistrationDAO travellerPlaceRegistrationDAO = new TravellerPlaceRegistrationDAO();
		travellerPlaceRegistrationDAO.register(travellerPlaceRegistration);
	
	}
    
    @Path("getDetailsByPlace/{place}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TravellerPlaceRegistration> getDetailsByPlace(@PathParam("place") String place) {
		System.out.println("Recieved path params: "+place); 
		TravellerPlaceRegistrationDAO travellerPlaceRegistrationDAO = new TravellerPlaceRegistrationDAO();
		List<TravellerPlaceRegistration> travellerPlaceRegistration = travellerPlaceRegistrationDAO.getDetailsByPlace(place);
		return travellerPlaceRegistration;
	}
    @Path("getHousesByTenantId/{Id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<House> getHousesByTenantId(@PathParam("Id") int Id) {
		System.out.println("Recieved path params: "+Id); 
		HouseDAO houseDAO = new HouseDAO();
		List<House> house = houseDAO.getHousesByTenantId(Id);
		return house;
	}
    
    @Path("postreview")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postreview(Review review) {
		System.out.println("Data Recieved in Review Register : " + review);
		ReviewDAO 	reviewDAO = new ReviewDAO();
		reviewDAO.postreview(review);
	
	}
    
    @Path("getreviews")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Review> getreviews() {

    	ReviewDAO reviewDAO = new ReviewDAO();
    List <Review> review = reviewDAO.getAllReviews();

    return review;
    }
    @Path("mail/{tenantMailId}/{subject}/{body}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String mail(@PathParam("tenantMailId") String emailId,@PathParam("subject") String subject1,@PathParam("body") String body1) throws MessagingException {
			String subject= subject1;
			String body= body1;
			String email= emailId;
			String host = "smtp.gmail.com";
			String from = "mallikav1234@gmail.com";
			String pass = "Mallika@2505";

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true"); // added this line
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.password", pass);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");

			String[] to = {email}; // added this line

			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			InternetAddress[] toAddress = new InternetAddress[to.length];

			// To get the array of addresses

			for( int i=0; i < to.length; i++ )
			{
				// changed from a while loop
				toAddress[i] = new InternetAddress(to[i]);
			}

			for( int i=0; i < toAddress.length; i++)
			{
				// changed from a while loop
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}

			message.setSubject(subject);
			message.setText(body);

			Transport transport = session.getTransport("smtp");

			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());

			transport.close();

			return "Successful";
    	}
	

    /*
    @Path("getTenantById/{id}")
   	@GET
   	@Produces(MediaType.APPLICATION_JSON)
   	public Tenant getTenantById(@PathParam("id") int id) {
   		System.out.println("Recieved path params: "+id); 
   		TenantDAO tenantDAO = new TenantDAO();
   		Tenant tenant = tenantDAO.getenantById(id);
   		return tenant;
   	}*/
   /* @Path("getDeptByName/{deptName}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> getDeptByName(@PathParam("deptName") String deptName) {        
		System.out.println(deptName);      
		DeptDAO deptDao = new DeptDAO();
		List<Department> depts = deptDao.getDeptByName(deptName);
		System.out.println(depts); 
		return depts;
	}*/
}
