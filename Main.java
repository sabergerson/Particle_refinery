package bergerson.MAIN;

//import necessary modules
import java.util.Random;
import bergerson.COLLECTOR.ParticleCollector;
import bergerson.EXTRACTOR.ParticleExtractor;
import bergerson.GENERATOR.ParticleGenerator;
import bergerson.PARTICLE.Location;
import bergerson.PARTICLE.Particle;
import bergerson.REFINER.ParticleRefiner;

public class BergersonHW4 {
	
	public static void main(String[] args) {
		ParticleGenerator PGen = new ParticleGenerator("PGEN-1", new Location("L1", 10, 10));
		ParticleCollector PCol = new ParticleCollector("PCOL-1", new Location("L2", 12, 12));
		ParticleExtractor PExt = new ParticleExtractor("PEXT-1", new Location("L3", 14, 14));
		ParticleRefiner PRef = new ParticleRefiner("PREF-1", "Refinery A", new Location("L4", 16, 16));
		
		//Generate and Collect Particles
		for(int i = 0; i < 100; i++) {
			Random R1 = new Random();
			String[] M = {"Vibranium", "Unobtanium", "Lockanium", "Learacite"};
			Random R2 = new Random();
			Particle P = PGen.generateParticle(R1.nextInt(10) + 1, M[R2.nextInt(4)]);
			PCol.collectParticle(P);
		
		}
		
		//Verify Particles Generated and Collected
		System.out.println(ParticleGenerator.GENERATED_COUNT + " particles have been generated");
		System.out.println(PCol.getCollectorPool().size() + " particles have been collected");
		System.out.println();
		//Extract Particles and Verify Extraction
		PExt.extractParticles(PCol);
		System.out.println(PExt.getExtractorPool().size() + " have been extracted");
		System.out.println(PCol.getCollectorPool().size() + " particles remain in Collector");
		System.out.println();
		//Refine particles
		PRef.emptyExtractor(PExt);
		System.out.println(PRef.getpStorage().size() + " particles are being refined");
		for(Particle P: PRef.getRefined_Storage()) {
			PRef.refineParticle(P);
		}
		System.out.println();
		//Sample Refined Particles
		PRef.sampleParticles(3);
	}
}
