import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.xml.ws.Endpoint;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class RestServer {
	

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		// TODO Auto-generated method stub
		HttpServer server = HttpServerFactory.create( "http://localhost:8080/" );
		server.start();
		
		Endpoint.publish("http://localhost:8090/soapservices", new SoapServiceImp());
		

		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR_OF_DAY, 1);

		// this needs to be done 3 times a day and 7 days
		for (int j = 0; j < 7; j++) {
			for (int i = 1; i < 4; i++) {
				MessageResource.flightList.add(new Flight(""+(j*9+i*3+1), "Boing 737-900", "FRA", c.getTime().toString()));
				MessageResource.flightList.add(new Flight(""+(j*9+i*3+2), "Airbus 319", "BER", c.getTime().toString()));
				MessageResource.flightList.add(new Flight(""+(j*9+i*3+3), "Embraer E170", "MUN", c.getTime().toString()));
				c.add(Calendar.HOUR_OF_DAY, 6);
			}
			c.add(Calendar.DATE, 1);
			c.set(Calendar.HOUR_OF_DAY, 1);
		}
		JOptionPane.showMessageDialog( null, "Ende" );
		server.stop( 0 );
	}

}
