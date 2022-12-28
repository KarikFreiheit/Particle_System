import processing.core.PApplet;
import processing.core.PVector;
public class Particle extends PApplet {
    PVector position;
    PVector velocity;
    PVector acceleration;
    Main m;
    PVector[][] vector;

    public Particle(PVector l, Main m, PVector[][] vector){

        this.velocity = new PVector(0,0);
        this.position = new PVector(random(0, m.width), random(0, m.height));
        this.acceleration = new PVector(0,0);
        this.m = m;
        this.vector = vector;

    }
    void run(FlowField field, int section){

        //update();

        follow(field, section);
        display();

    }

    void update(){

        if(m.mousePressed) {
            PVector mouse = new PVector(m.mouseX, m.mouseY);
            float distance = mouse.sub(position).mag();

            //Realistic gravitational pull towards mouse
            //acceleration = mouse.setMag(1000 / (distance * distance));

            //Constant acceleration towards mouse not based on distance between
            acceleration = mouse.setMag(.1f);
            velocity.add(acceleration);
        }

        position.add(velocity);
        velocity.limit(10);
        //System.out.println("Velocity: " + velocity.mag());

    }

    void follow(FlowField flow, int section) {
        // What is the vector at that spot in the flow field?
        PVector desired = flow.lookup(position, vector, section);

        PVector steer = PVector.sub(desired, velocity);
        position.add(steer);
    }
    void display(){
        //Colors based on velocity of each particle: Fast = Green, Slow = Red
        float color = velocity.mag() / 10;
        int red = (int)(255 * (1 - color));
        int green = (int)(255 * color);
        int blue = 0;

        m.stroke(red, green, blue);
        m.pushMatrix();
        m.point(position.x, position.y);
        m.popMatrix();
    }
}
