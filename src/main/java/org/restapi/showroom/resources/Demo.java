package org.restapi.showroom.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/")
public class Demo 
{
	
	@Context 
	private UriInfo uriInfo;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String useFullAnnotations(@HeaderParam("HeaderValue") String headerValue,
			@CookieParam("CokieValue") String cokieValue)
	{
		return "Index Page having headerValue "+headerValue+ " Cookie Value "+ cokieValue
				+" Complete path is " + uriInfo.getAbsolutePath();
	}
}
