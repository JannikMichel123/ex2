import java.util.ArrayList;

public class Flight {
	String flightNumber;
	String type;
	String destination;
	String departureDate;
	ArrayList<Seat> UFSeats = new ArrayList<Seat>();
	ArrayList<Seat> EPSeats = new ArrayList<Seat>();
	ArrayList<Seat> ESeats = new ArrayList<Seat>();

	public Flight(String flightNumber, String type, String destination, String departureDate) {
		super();
		this.flightNumber = flightNumber;
		this.type = type;
		this.destination = destination;
		this.departureDate = departureDate;

		if (type.equals("Airbus 319")) {
			char c[] = {'A','B','E','F'};
			for (int j = 0; j < c.length; j++) {
				for (int i = 0; i < 2; i++) {
					UFSeats.add(new Seat(c[j]+"", "0" + i + 1));
				}
			}
			char s[]  = {'A','B','C','D','E','F'};
			for (int j = 0; j < s.length; j++) {
				for (int i = 0; i < 7; i++) {
					UFSeats.add(new Seat(s[j]+"", "0" + i + 1));
				}
			}
		}
	}

}
