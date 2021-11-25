package bergerson.GENERATOR;

//import necessary modules
import bergerson.PARTICLE.Location;
import bergerson.PARTICLE.Particle;

public class ParticleGenerator {
	
	//Data Fields
	private String pGeneratorID;
	private Location pGeneratorPos;
	public static int GENERATED_COUNT = 0;

	//Constructor(no args)
	public ParticleGenerator() {
		
	}
	
	//Constructor
	public ParticleGenerator(String pGeneratorID, Location pGeneratorPos) {
		this.pGeneratorID = pGeneratorID;
		this.pGeneratorPos = pGeneratorPos;
	}

	//Accessors and mutators
	public String getpGeneratorID() {
		return pGeneratorID;
	}
	public void setpGeneratorID(String pGeneratorID) {
		this.pGeneratorID = pGeneratorID;
	}
	public Location getpGeneratorPos() {
		return pGeneratorPos;
	}
	public void setpGeneratorPos(Location pGeneratorPos) {
		this.pGeneratorPos = pGeneratorPos;
	}
	public static int getGENERATED_COUNT() {
		return GENERATED_COUNT;
	}
	public static void setGENERATED_COUNT(int gENERATED_COUNT) {
		GENERATED_COUNT = gENERATED_COUNT;
	}
	
	//Behaviors: instance methods
	
	//name: generateParticle
	//function: generates new particle
	//input: double (diameter), String (composition)
	//output: Particle
	public Particle generateParticle(double pDiameter, String pComposition) {
		//generate new particle
		Particle particle = new Particle(pDiameter, pComposition);
		//increment particle count
		GENERATED_COUNT += 1;
		return particle;
	}
}
