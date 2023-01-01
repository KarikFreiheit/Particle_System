import processing.core.PVector;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;

public class ParticleSystem extends PApplet {

    ArrayList<Particle> particles;
    PVector origin;

    FlowField field;
    int sectionSize;
    PVector[][] array;
    Main m;
    ParticleSystem(PVector position, Main m){
       this.origin = position.copy();
       this.particles = new ArrayList<Particle>();
       this.m = m;
       //50 is a good in between for approximation and size of each section
       this.sectionSize= 30;
       field = new FlowField(this.m);
       array = field.splitScreen(sectionSize);

    }

    void addParticle(int group){

        particles.add(new Particle(origin , m, array, group));

    }

    void run(int j){
        System.out.println("Running: " + j);
        particles.get(j).run(field, sectionSize);

    }
    void display(){
        field.display(sectionSize, array);
        for(Particle p : particles){
            m.blendMode(ADD);
            p.display();
            m.blendMode(BLEND);
        }
    }



}
