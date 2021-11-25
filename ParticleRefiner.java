package bergerson.REFINER;

//import necessary modules
import java.util.ArrayList;
import java.util.Collections;

import bergerson.EXTRACTOR.ParticleExtractor;
import bergerson.PARTICLE.Location;
import bergerson.PARTICLE.Particle;

public class ParticleRefiner {
	
	//Data Fields
	private String refinerID;
	private String refinerName;
	private Location refinerPos;
	private ArrayList<Particle> pStorage;
	private ArrayList<Particle> refined_Storage;
	
	//Constructor (no args)
	public ParticleRefiner() {
		
	}
	
	//Constructor
	public ParticleRefiner(String refinerID, String refinerName, Location refinerPos) {
		this.refinerID = refinerID;
		this.refinerName = refinerName;
		this.refinerPos = refinerPos;
	}
	
	//Accessors and mutators
	public String getRefinerID() {
		return refinerID;
	}
	public void setRefinerID(String refinerID) {
		this.refinerID = refinerID;
	}
	public String getRefinerName() {
		return refinerName;
	}
	public void setRefinerName(String refinerName) {
		this.refinerName = refinerName;
	}
	public Location getRefinerPos() {
		return refinerPos;
	}
	public void setRefinerPos(Location refinerPos) {
		this.refinerPos = refinerPos;
	}
	public ArrayList<Particle> getpStorage() {
		return pStorage;
	}
	public void setpStorage(ArrayList<Particle> pStorage) {
		this.pStorage = pStorage;
	}
	public ArrayList<Particle> getRefined_Storage() {
		return refined_Storage;
	}
	public void setRefined_Storage(ArrayList<Particle> refined_Storage) {
		this.refined_Storage = refined_Storage;
	}
	
	//Behaviors: instance methods
	
	//name: refineParticle
	//function: updates refined status
	//input: Particle
	//output: Particle
	public Particle refineParticle(Particle p) {
		//update refined status to true
		p.setRefined(true);
		return p;
	}
	
	//name: emptyExtractor
	//function: transfer particles to storage from extractor pool, refine particles,
		//transfer to refined storage
	//input: Particle Extractor
	//output: boolean (true if successful)
	public boolean emptyExtractor(ParticleExtractor pe) {
		//initialize completion to false
		boolean complete = false;
		//create new array list to hold particles
		pStorage = new ArrayList<Particle>();
		//transfer particles to storage
		for (Particle p: pe.getExtractorPool()) {
			pStorage.add(p);
		}
		//create new array list of empty particles which storage can be copied into
		Particle p = new Particle();
		refined_Storage = new ArrayList<Particle>(pStorage.size());
		for (int i = 0; i < pStorage.size(); i++) {
			refined_Storage.add(p);
		}
		//copy storage to refined storage
		Collections.copy(refined_Storage, pStorage);
		//if successful, update completion status
		if(refined_Storage.size() == pStorage.size()) {
			complete = true;
		}
		//return whether operation was successful
		return complete;
	}
	
	//name: sampleParticles
	//function: displays info for select particles
	//input: int (number to display)
	//output: void
	public void sampleParticles(int count) {
		//initialize particle count to zero
		int particles = 0;
		//display particle info for defined number of particles
		while (particles < count) {
			this.refined_Storage.get(particles).displayParticleInfo();
			particles++;
		}
	}
	
	//name: displayRefinerInfo
	//function: displays refiner information
	//input: none
	//output: void
	public void displayRefinerInfo() {
		//display refiner information
		System.out.println("Refiner ID: "+this.refinerID);
		System.out.println("Refiner Name: "+this.refinerName);
		System.out.print("Refiner Location: \n"+this.refinerPos.toString());		
	}
}
