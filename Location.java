package bergerson.PARTICLE;

public class Location {
	
	//Data fields
	private String name;
	private int X;
	private int Y;
	
	//Constructor (no args)
	public Location() {
	
	}
	
	//Constructor
	public Location(String name, int x, int y) {
		this.name = name;
		this.X = x;
		this.Y = y;
	}

	//Accessors and mutators
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	
	//Behaviors: instance methods
	
	//name: euclideanDistance
	//function: calculates the Euclidean distance between two points
	//input: Location
	//output: double (distance)
	public double euclideanDistance(Location l1) {
		//calculate euclidean distance
		double distance = Math.sqrt((this.Y - l1.Y) * (this.Y - l1.Y) 
				+ (this.X - l1.X) * (this.X - l1.X));
		//return distance
		return distance;
	}
	
	//name: toString
	//function: creates String summary of location
	//input: none
	//output: String
	public String toString() {
		//create string version of location information
		String location = "Name: "+this.name+"\nAt coordinates: ("+String.valueOf(this.X)
				+", "+String.valueOf(this.Y)+")";
		return location;
	}
}
