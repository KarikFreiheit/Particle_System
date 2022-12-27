import processing.core.PVector;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;

public class ParticleSystem {

    ArrayList<Particle> particles;
    PVector origin;

    FlowField field;
    int sections;
    PVector[][] array;
    Main m;
    ParticleSystem(PVector position, Main m){
       this.origin = position.copy();
       this.particles = new ArrayList<Particle>();
       this.m = m;

       field = new FlowField(this.m);
       array = field.splitScreen(20);
    }

    void addParticle(){

        particles.add(new Particle(origin , m));

    }

    void checkSection(){

    }

    void run(){
        for(int i = 0; i < particles.size(); i++){
            Particle p = particles.get(i);
            p.run();
            field.apply(p, sections, array);
        }
    }



}
