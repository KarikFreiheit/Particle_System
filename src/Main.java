import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet {



    // Vector field
    //Create Vector fields from equation

    ParticleSystem ps;

    Thread[] threads;

    //Thread count, set to number of CPU cores available
    int threadCount = 8;
    //Particle Count
    int max = 100000;
    int size = max / threadCount;

    public void setup(){
        frameRate(30);


    }

    public void settings(){

        size(1920, 1080);
        threads = new Thread[threadCount];

        //Not recommended to have over 10,000 particles unless you have killer single core processing
        ps = new ParticleSystem(new PVector(width / 2, height/2), this);
        for(int i = 0; i < max; i++){
            int group = i / size;
            ps.addParticle(group);

        }




    }
    public void draw(){
        background(10);
        if(frameCount == 1) {
            for(int i =0; i < threadCount; i ++){
                final int group = i;
                threads[i] = new Thread(() -> {
                    for(int j = size * group; j < (group + 1) * size; j++){
                        ps.run(j);
                    }
                });
            }

            for (Thread t : threads) {
                t.start();
            }
        }else{
            for (Thread t : threads) {
                t.run();
            }
        }
        ps.display();

    }
    public static void main(String[] passedArgs){
        String[] appletArgs = new String[] {"Main"};
        PApplet.main(appletArgs);

    }


}