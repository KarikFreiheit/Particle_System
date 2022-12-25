import processing.core.PApplet;
import processing.core.PVector;
public class Particle extends PApplet {
    PVector position;
    PVector velocity;
    PVector acceleration;
    Main m;

    public Particle(PVector l, Main m){

        this.velocity = new PVector(0,0);
        this.position = l.copy();
        this.acceleration = new PVector(0,0);
        this.m = m;
    }
    void run(){
        update();
        display();

    }

    void update(){
        if(m.mousePressed) {
            PVector mouse = new PVector(m.mouseX, m.mouseY);
            println(m.mouseX + " : " + m.mouseY);

            mouse.sub(position);
            mouse.setMag(.05f);
            acceleration = mouse;
            velocity.add(acceleration);
        }
        position.add(velocity);
        velocity.limit(25);


    }
    void display(){
        m.stroke(255, 255);
        m.fill(255, 255);
        m.ellipse(position.x, position.y, 1, 1);

    }
}
