import processing.core.PVector;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;

public class ParticleSystem {

    ArrayList<Particle> particles;
    PVector origin;
    Main m;
    ParticleSystem(PVector position, Main m){
       this.origin = position.copy();
       this.particles = new ArrayList<Particle>();
       this.m = m;
    }

    void addParticle(){

        particles.add(new Particle(origin , m));

    }

    void run(){
        for(int i = 0; i < particles.size(); i++){
            Particle p = particles.get(i);
            p.run();

        }
    }



}
