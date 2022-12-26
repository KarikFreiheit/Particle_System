import processing.core.PApplet;
import processing.core.PVector;
public class Particle extends PApplet {
    PVector position;
    PVector velocity;
    PVector acceleration;
    Main m;

    public Particle(PVector l, Main m){

        this.velocity = new PVector(0,0);
        this.position = new PVector(random(0, m.width), random(0, m.height));
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
            float distance = mouse.sub(position).mag();

            //Realistic gravitational pull towards mouse
            //acceleration = mouse.setMag(1000 / (distance * distance));

            //Constant acceleration towards mouse not based on distance between
            acceleration = mouse.setMag(.1f);
            velocity.add(acceleration);
        }
        position.add(velocity);
        velocity.limit(10);
        System.out.println(velocity.mag());

    }
    void display(){
        //Colors based on velocity of each particle: Fast = Green, Slow = Red
        float color = velocity.mag() / 10;
        int red = (int)(255 * (1 - color));
        int green = (int)(255 * color);
        int blue = 0;
        System.out.println(color);

        m.stroke(red, green, blue);
        m.point(position.x, position.y);

    }
}
