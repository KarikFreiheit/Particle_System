import processing.core.PVector;

import java.util.ArrayList;

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

        particles.add(new Particle(origin, m));

    }

    void run(){
        for(int i = particles.size()-1; i >= 0; i--){
            Particle p = particles.get(i);
            p.run();

        }
    }



}
