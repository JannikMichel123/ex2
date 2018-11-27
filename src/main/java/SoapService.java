
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


@WebService(targetNamespace = "http://tk1ex2/")
@SOAPBinding(style = Style.RPC)
public interface SoapService {
	
	@WebMethod String getFlightlist();
	@WebMethod boolean bookFlight(String flightnumber,String seatclass,String seatnumber);
}
