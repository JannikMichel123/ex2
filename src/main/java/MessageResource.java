
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("flight")
public class MessageResource {
	static ArrayList<Flight> flightList = new ArrayList<Flight>();

	public MessageResource() {


	}

	@GET
	@Path("flightlist")
	@Produces(MediaType.APPLICATION_JSON)
	public String Flights() {

		return new Gson().toJson(flightList );
	}
	
	@GET
	@Path("seatlist/{flightnumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public String Flights(@PathParam("flightnumber")String flightNumber,@DefaultValue("") @QueryParam("seatclass") String seatClass) {
		Flight obj = null;
		String[] classes = {"United First Class","Economy Plus","Economy"};
		System.out.println(flightNumber);
		for(int i = 0; i<flightList.size();i++){
			if(flightList.get(i).flightNumber.equals(flightNumber)){
				obj = flightList.get(i);
			}
		}
		if(seatClass.equals(classes[0])) {
			return new Gson().toJson(obj.UFSeats);
		}
		if(seatClass.equals(classes[1])) {
			return new Gson().toJson(obj.EPSeats);
		}
		if(seatClass.equals(classes[2])) {
			return new Gson().toJson(obj.ESeats);
		}
		return "";
	}
	@GET
	@Path("reservation/{flightnumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public String reservate(@PathParam("flightnumber")String flightNumber,@DefaultValue("") @QueryParam("row") String row,@DefaultValue("") @QueryParam("number") String number,@DefaultValue("") @QueryParam("seatclass") String seatClass) {
		Flight obj = null;
		String[] classes = {"United First Class","Economy Plus","Economy"};
		for(int i = 0; i<flightList.size();i++){
			if(flightList.get(i).flightNumber.equals(flightNumber)){
				obj = flightList.get(i);
				if(seatClass.equals(classes[0])) {
					//check if the selected seat is available
					//return a message that shows the user if he can book this seat
					for(int j = 0;j<obj.UFSeats.size();j++){
						if(obj.UFSeats.get(j).number.equals(number) && obj.UFSeats.get(j).row.equals(row)) {
							if(obj.UFSeats.get(j).isFree) {
								obj.UFSeats.get(j).isFree = false;
								return "true";
							}
						}
					}
					return "false";
					
				}
				if(seatClass.equals(classes[1])) {
					for(int j = 0;j<obj.EPSeats.size();j++){
						if(obj.EPSeats.get(j).number.equals(number) && obj.EPSeats.get(j).row.equals(row)) {
							if(obj.EPSeats.get(j).isFree) {
								obj.EPSeats.get(j).isFree = false;
								return "true";
							}
						}
					}
					return "false";
				}
				if(seatClass.equals(classes[2])) {
					for(int j = 0;j<obj.ESeats.size();j++){
						if(obj.ESeats.get(j).number.equals(number) && obj.ESeats.get(j).row.equals(row)) {
							if(obj.ESeats.get(j).isFree) {
								obj.ESeats.get(j).isFree = false;
								return "true";
							}
						}
					}
					return "false";
				}
				
			}
		}
		return "false";
	}
}
