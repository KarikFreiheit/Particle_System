import processing.core.PVector;
import processing.core.PApplet;
import processing.event.KeyEvent;

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
       this.sectionSize= 15;
       field = new FlowField(this.m);
       array = field.splitScreen(sectionSize);

    }

    void addParticle(){

        particles.add(new Particle(origin , m, array));

    }

    void removeAll(){
        for(Particle p : particles){
            particles.remove(p);
        }

    }

    void run(){
        for(Particle p : particles) {
            p.run(field, sectionSize);
        }
        //Resets FlowField
        if(m.keyPressed){
            if(m.key == 'r'){
                System.out.println("R");
                field.splitScreen(sectionSize);
            }
        }

    }
    void display(){
        field.display(sectionSize, array);

    }



}
