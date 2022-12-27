import processing.core.PApplet;
import processing.core.PVector;

public class FlowField extends PApplet {

    //Split Screen into sections
    //Give each section a velocity vector
    //Display velocity vector with arrows with different colors for velocity strength
    //Look for every particle in each "Section"
    //Add velocity to that particle

    //Additions

    Main m;


    FlowField(Main m){
        this.m = m;
    }
    PVector[][] splitScreen(int sections){

        PVector[][] array = new PVector[sections][sections];

        for(int x = 0; x < sections; x++){
            for(int y = 0; y < sections; y++){

               array[x][y] = new PVector(10, 10);
            }
        }
        return array;


    }

    void apply(Particle p, int sections, PVector[][] vectors){
        p.velocity.add(vectors[(int) (p.position.x / m.width)][(int) (p.position.y / m.height)]);
    }
    // Creates an arrow shape
    //https://gist.github.com/takahashilabo/81b7f22b4ecee1fa5d84393ab670ef99

    void drawArrow(float x1, float y1, float x2, float y2) {
        float a = dist(x1, y1, x2, y2) / 50;
        pushMatrix();
        translate(x2, y2);
        rotate(atan2(y2 - y1, x2 - x1));
        triangle(- a * 2 , - a, 0, 0, - a * 2, a);
        popMatrix();
        line(x1, y1, x2, y2);
    }



}
