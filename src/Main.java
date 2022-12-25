import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {


    ParticleSystem ps;
    public void settings(){
        size(2560, 1440);

        ps = new ParticleSystem(new PVector(width / 2, height/2), this);
        for(int i = 0; i < 10000; i++){
            ps.addParticle();
        }
    }
    public void draw(){
        background(64);

        ps.addParticle();
        ps.run();
    }
    public static void main(String[] passedArgs){
        String[] appletArgs = new String[] {"Main"};
        PApplet.main(appletArgs);

    }


}