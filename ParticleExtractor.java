package bergerson.EXTRACTOR;

//import necessary modules
import java.util.ArrayList;
import bergerson.COLLECTOR.ParticleCollector;
import bergerson.PARTICLE.Location;
import bergerson.PARTICLE.Particle;

public class ParticleExtractor {
	
	//Data Fields
	private String extractorID;
	private Location extractorPOS;
	private ArrayList<Particle> extractorPool;
	public static int EXTRACTOR_CAPACITY = 500;
	
	//Constructor (no args)
	public ParticleExtractor() {
	
	}
	
	//Constructor
	public ParticleExtractor(String extractorID, Location extractorPOS) {
		this.extractorID = extractorID;
		this.extractorPOS = extractorPOS;
	}

	//Accessors and mutators
	public String getExtractorID() {
		return extractorID;
	}
	public void setExtractorID(String extractorID) {
		this.extractorID = extractorID;
	}
	public Location getExtractorPOS() {
		return extractorPOS;
	}
	public void setExtractorPOS(Location extractorPOS) {
		this.extractorPOS = extractorPOS;
	}
	public ArrayList<Particle> getExtractorPool() {
		return extractorPool;
	}
	public void setExtractorPool(ArrayList<Particle> extractorPool) {
		this.extractorPool = extractorPool;
	}
	public static int getEXTRACTOR_CAPACITY() {
		return EXTRACTOR_CAPACITY;
	}
	public static void setEXTRACTOR_CAPACITY(int eXTRACTOR_CAPACITY) {
		EXTRACTOR_CAPACITY = eXTRACTOR_CAPACITY;
	}
	
	//Behaviors: instance methods
	
	//name: extract particles
	//function: moves particles into extractor pool, clears collector pool
	//input: Particle Collector
	//output: boolean (true if successful)
	public boolean extractParticles(ParticleCollector p) {
		//initialize completed to false
		boolean complete = false;
		//initialize new extractor pool
		this.extractorPool = new ArrayList<Particle>();
		//add new particles if it will not exceed capacity
		if ((this.extractorPool.size() + p.getCollectorPool().size()) < EXTRACTOR_CAPACITY ) {
			for (Particle particle: p.getCollectorPool()) {
				this.extractorPool.add(particle);
			}
			//clear collector pool	
			p.getCollectorPool().clear();
		}
		//notify user if adding elements will exceed capacity
		else {
			System.out.println("Extractor Pool does not have sufficient capacity");
		}
		//return whether mission was completed or not
		return complete;
	}
}
