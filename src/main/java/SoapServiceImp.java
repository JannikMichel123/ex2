import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.jws.WebService;

import com.google.gson.Gson;

@WebService(endpointInterface = "SoapService", targetNamespace = "http://tk1ex2/")
public class SoapServiceImp implements SoapService{
	static ArrayList<Flight> flightList = new ArrayList<Flight>();
	
	public SoapServiceImp() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR_OF_DAY, 1);

		// this needs to be done 3 times a day and 7 days
		for (int j = 0; j < 7; j++) {
			for (int i = 1; i < 4; i++) {
				flightList.add(new Flight(""+(j*9+i*3+1), "Boing 737-900", "FRA", c.getTime().toString()));
				flightList.add(new Flight(""+(j*9+i*3+2), "Airbus 319", "FRA", c.getTime().toString()));
				flightList.add(new Flight(""+(j*9+i*3+3), "Embraer E170", "FRA", c.getTime().toString()));
				c.add(Calendar.HOUR_OF_DAY, 6);
			}
			c.add(Calendar.DATE, 1);
			c.set(Calendar.HOUR_OF_DAY, 1);
		}
	}
	@Override
	public String getFlightlist() {
		// TODO Auto-generated method stub
		return new Gson().toJson(flightList);
	}
	@Override
	public boolean bookFlight(String flightnumber, String seatclass, String seatnumber) {
		// TODO Auto-generated method stub
		String[] classes = {"United First Class","Economy Plus","Economy"};
		for(int i=0; i<flightList.size();i++) {
			if(flightList.get(i).flightNumber.equals(flightnumber)) {
				if(seatclass.equals(classes[0])) {
					for(int j=0; j<flightList.get(i).UFSeats.size();j++) {
						if(flightList.get(i).UFSeats.get(j).toPlace().equals(seatnumber)) {
							if(flightList.get(i).UFSeats.get(j).getisFree()) {
								flightList.get(i).UFSeats.get(j).setisFree(false);
								return true;
							}else {
								return false;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
}
