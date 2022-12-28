import processing.core.PApplet;
import processing.core.PVector;

import java.util.Random;

public class FlowField extends PApplet {

    //Split Screen into sections
    //Give each section a velocity vector
    //Display velocity vector with arrows with different colors for velocity strength
    //Look for every particle in each "Section"
    //Add velocity to that particle

    //Additions

    Main m;
    int cols, rows;

    FlowField(Main m){
        this.m = m;
    }
    PVector[][] splitScreen(int sections){
        cols = m.width / sections;
        rows = m.height / sections;
        PVector[][] array = new PVector[cols][rows];

        for(int x = 0; x < cols; x++){
            for(int y = 0; y < rows; y++){
                float theta = random(-PI /4, random(PI/4));
                //System.out.println("Theta: " +theta);
                array[x][y] = PVector.fromAngle(theta);
            }
        }
        return array;


    }

    void display(int sections, PVector[][] vectors){
        int i = 0;
        for(int x = 0; x < cols; x++){
            for(int y = 0; y < rows; y++){
               drawVector(vectors[x][y], x*sections, y*sections, sections-2);
               i++;
               System.out.println("X: " + x + "Y: " + y + "Vector: " + vectors[x][y] + "Total: " + i);
            }

        }


    }
    //Displays the Vector
    void drawVector(PVector v, float x, float y, float scayl) {
        float len = v.mag()*scayl;
        m.stroke(255);
        m.line(x, y, x + len, y + len);
        m.rotate(v.heading());

    }

    PVector lookup(PVector lookup, PVector[][] vector, int section){
        int column = (constrain((int)lookup.x/section,0,cols-1));
        int row = (constrain((int) lookup.y/section,0,rows-1));
        return vector[column][row];
    }



}
