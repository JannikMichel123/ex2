
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path( "message" )
public class MessageResource {
	  ArrayList<Flight> flightList = new ArrayList<Flight>();
	  
	  @GET
	  @Produces( MediaType.TEXT_PLAIN )
	  public String message()
	  {
	    return "Yea! ";
	  }
	  @GET
	  @Path ("flight")
	  @Produces( MediaType.TEXT_PLAIN )
	  public String Flights()
	  {
		  flightList.add(new Flight("ok","ok","ok","ok"));
	    return flightList.toString();
	  }
	
}
