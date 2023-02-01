import processing.core.PApplet;
import processing.core.PVector;

import java.io.IOException;

public class Main extends PApplet {



    // Vector field
    //TRY TO USE REAL WORLD DATA
    //HOW TO
    //Scatter a number of points all over the US
    //Create Vector fields from equation

    ParticleSystem ps;
    //Particle Count, not recommended to have over 10,000 particles unless you have killer single core processing
    int max = 10000;

    public void setup(){
        frameRate(30);
    }

    public void settings(){

        size(1920, 1080);
        fullScreen();
        try {
            ps = new ParticleSystem(new PVector(width / 2, height/2), this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < max; i++){
            ps.addParticle();
        }




    }
    public void draw(){
        background(10);
        try {
            ps.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ps.display();


    }
    public static void main(String[] passedArgs){
        String[] appletArgs = new String[] {"Main"};
        PApplet.main(appletArgs);

    }


}