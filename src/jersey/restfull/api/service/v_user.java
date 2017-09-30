package jersey.restfull.api.service;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import jersey.restfull.api.connection.*;
import jersey.restfull.api.dao.*;
import jersey.restfull.api.model.user_object;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.List;



@Path("/v1")
public class v_user {

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/v_user")
	public String view_user() {
		
		return "<h1>Return from web service</h1>";		
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/v_userbyid/{id}")
	public String v_userbyid(@PathParam("id") int id) {
		
		return "your id is "+id;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getUser")
	public List<user_object> getAllUser(){
		
		return  dao_user.findAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/getUserXml")
	public List<user_object> getAllUserJson(){
		
		return  dao_user.findAll();
	}
}
