package org.prashanth.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String mParam,
											@HeaderParam("headerParam") String hParam,
											@CookieParam("name") String cParam) {
		return "Matrix Param is: " + mParam
				+ "\nHeader Param is: " + hParam
				+ "\nCookie Param is: " + cParam;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo,
										@Context HttpHeaders headerInfo) {
		String path = uriInfo.getAbsolutePath().toString();
		String cookie = headerInfo.getCookies().toString();
		
		return "Path: " + path + "\nCookie: " + cookie;
	}
	
}