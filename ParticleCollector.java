package bergerson.COLLECTOR;

//import necessary modules
import java.util.ArrayList;
import bergerson.PARTICLE.Location;
import bergerson.PARTICLE.Particle;

public class ParticleCollector {
	
	//Data Fields
	private String collectorID;
	private Location collectorPOS;
	private ArrayList<Particle> collectorPool;
	public static final int COLLECTOR_CAPACITY = 500;
	
	//Constructor (no args)
	public ParticleCollector() {

	}
	
	//Constructor
	public ParticleCollector(String collectorID, Location collectorPOS) {
		this.collectorID = collectorID;
		this.collectorPOS = collectorPOS;
	}
	
	//Accessors and mutators
	public String getCollectorID() {
		return collectorID;
	}
	public void setCollectorID(String collectorID) {
		this.collectorID = collectorID;
	}
	public Location getCollectorPOS() {
		return collectorPOS;
	}
	public void setCollectorPOS(Location collectorPOS) {
		this.collectorPOS = collectorPOS;
	}
	public ArrayList<Particle> getCollectorPool() {
		return collectorPool;
	}
	public void setCollectorPool(ArrayList<Particle> collectorPool) {
		this.collectorPool = collectorPool;
	}
	public static int getCollectorCapacity() {
		return COLLECTOR_CAPACITY;
	}
	
	//Behaviors: instance methods
	
	//name: collectParticle
	//function: adds particle to collector pool
	//input: Particle
	//output: boolean (true if successful)
	public boolean collectParticle(Particle particle) {
		//initialize complete to false
		boolean complete = false;
		//establish new collector pool, add first particle
		if (this.collectorPool == null) {
			this.collectorPool = new ArrayList<Particle>();
			this.collectorPool.add(0, particle);
			complete = true;
		}
		//add new particles if there is space
		else if (this.collectorPool.size() < COLLECTOR_CAPACITY) {
			this.collectorPool.add(particle);
			complete = true;
		}
		//if there is not space, do not add particles
		else {
			complete = false;
		}
		//return whether operation was successful or not
		return complete;
	}
}
