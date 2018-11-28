
public class Seat {
	String row;
	String number;
	boolean isFree = true;
	public Seat(String row, String number ) {
		super();
		this.row = row;
		this.number = number;
		
	}
	public String toPlace() {
		String s = this.row+this.number;
		return s;
	}
	
	public boolean getisFree() {
		return isFree;
	}
	
	public void setisFree(boolean set) {
		this.isFree = set;
	}
	
}
