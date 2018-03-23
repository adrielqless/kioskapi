package com.qless.api.kiosk;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import java.sql.*;

// create a new kiosk object


	import javax.ws.rs.Consumes;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;
	import javax.ws.rs.core.Response;

	import org.json.JSONException;
	import org.json.JSONObject;

import com.qless.api.db.QLessDb;
import com.qless.api.utils.Kiosk;

	@Path("")
	public class KioskResource {
		@POST
	    @Consumes({MediaType.APPLICATION_JSON})
	    @Produces({MediaType.APPLICATION_JSON})
	    @Path("/create")
	    public Response createKiosk(String j) throws Exception{
	        
			JSONObject obj = new JSONObject(j);
			 System.out.println(obj.get("userid").toString());
			
			 Kiosk kiosk = new Kiosk();
			 kiosk.setUserid(obj.get("userid").toString());
			 
			 QLessDb db = new QLessDb();
			 System.out.println("this is "+obj.get("userid"));
	         db.createNewKiosk(kiosk);
		    
			return Response.status(200).entity(obj.toString()).build();
	    }
		@GET
		@Path("/{param}")
		public Response getKioskList(@PathParam("param") String msg) {

			String output = "Here are the Kiosks : " + msg;
	        JSONObject obj = new JSONObject();
	        try {
				obj.append("name", msg);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        StringBuilder sb = new StringBuilder();
	        sb.append(obj);
	        
			return Response.status(200).entity(sb.toString()).build();

		}
	}