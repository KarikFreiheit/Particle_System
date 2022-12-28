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
       this.sections = 50;
       field = new FlowField(this.m);
       array = field.splitScreen(sections);
    }

    void addParticle(){

        particles.add(new Particle(origin , m, array));

    }

    void checkSection(){

    }

    void run(){
        for(Particle p : particles){
            p.run(field, sections);

        }
        field.display(sections, array);
    }



}
