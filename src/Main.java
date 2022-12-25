import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {

    //Todo Keypress toggles for different acceleration
    //Destroy particles on  offscreen
    //Vector field

    ParticleSystem ps;
    public void settings(){
        size(2560, 1440);
            int max = 10000;
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