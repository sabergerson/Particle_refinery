package bergerson.PARTICLE;

//import necessary modules
import java.text.DecimalFormat;

public class Particle {
	
	//Data Fields
	private String retrievalCode;
	private double pDiameter;
	private double pVolume;
	private double pSurfaceArea;
	private String pComposition;
	private boolean isRefined;
	public static int particleCount = 0;
	
	//Constructor (no args)
	public Particle() {

	}
	
	//Constructor 
	public Particle(double pDiameter, String pComposition) {
		//instantiate diameter and composition with arguments
		this.pDiameter = pDiameter;
		this.pComposition = pComposition;
		this.retrievalCode = "P"+this.particleCount;
		//increment particle count and assign retrieval code
		this.particleCount += 1;
		//particle is not refined when instantiated
		this.isRefined = false;
		//calculate and instantiate volume and surface area
		this.pVolume = Math.PI*Math.pow((this.pDiameter/2), 3)*4/3;
		this.pSurfaceArea = 4*Math.PI*Math.pow((this.pDiameter/2), 2);
		
	}

	//Accessors and mutators
	public String getRetrievalCode() {
		return retrievalCode;
	}
	public void setRetrievalCode(String retrievalCode) {
		this.retrievalCode = retrievalCode;
	}
	public double getpDiameter() {
		return pDiameter;
	}
	public void setpDiameter(double pDiameter) {
		this.pDiameter = pDiameter;
	}
	public double getpVolume() {
		return pVolume;
	}
	public void setpVolume(double pVolume) {
		this.pVolume = pVolume;
	}
	public double getpSurfaceArea() {
		return pSurfaceArea;
	}
	public void setpSurfaceArea(double pSurfaceArea) {
		this.pSurfaceArea = pSurfaceArea;
	}
	public String getpComposition() {
		return pComposition;
	}
	public void setpComposition(String pComposition) {
		this.pComposition = pComposition;
	}
	public boolean isRefined() {
		return isRefined;
	}
	public void setRefined(boolean isRefined) {
		this.isRefined = isRefined;
	}
	public static int getParticleCount() {
		return particleCount;
	}
	public static void setParticleCount(int particleCount) {
		Particle.particleCount = particleCount;
	}
	
	//Behaviors: instance methods
	
	//name: displayParticle
	//function: displays particle information
	//input: none
	//output: void
	public void displayParticleInfo() {
		//create format
		DecimalFormat df = new DecimalFormat("###.00");
		//display particle information to user
		System.out.println("Particle "+this.retrievalCode);
		System.out.println("Diameter: "+(int)this.pDiameter+" microns");
		System.out.println("Volume: "+df.format(this.pVolume)+" cubic microns");
		System.out.println("Surface Area: "+df.format(this.pSurfaceArea)+" squared microns");
		System.out.println("Composition: "+this.pComposition);
		//determine and display if particle has been refined
		if (this.isRefined == true) {
			System.out.println("Refined:  has been Refined");
		}
		else {
			System.out.println("Refined:  has not been Refined");
		}
		System.out.println("********************");	
	}
}
