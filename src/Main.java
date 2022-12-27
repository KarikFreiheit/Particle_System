import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {



    // Vector field

    ParticleSystem ps;

    public void setup(){
        frameRate(10);
    }

    public void settings(){

        size(1920, 1080);
        int max = 100;
        ps = new ParticleSystem(new PVector(width / 2, height/2), this);
        for(int i = 0; i < max; i++){
            ps.addParticle();
        }


    }
    public void draw(){
        background(10);
        ps.run();

    }
    public static void main(String[] passedArgs){
        String[] appletArgs = new String[] {"Main"};
        PApplet.main(appletArgs);

    }


}