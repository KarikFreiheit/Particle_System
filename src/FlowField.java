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
        int middleX = cols / 2;
        int middleY = rows / 2;
        PVector[][] array = new PVector[cols][rows];

        for(int x = 0; x < cols; x++){
            for(int y = 0; y < rows; y++){
                //This attempts to make it so the center of the vectorfield is the center of the screen
                //YES IT'S SUPPOSED TO LOOK LIKE THIS
                float dx = (y -middleY);
                float dy = (x -middleX);

                float distance = sqrt(dx * dx + dy * dy);
                //The equation used to build the vector field goes here. Use dy and dx to approximately center the vector field
                //Will only work with large scale vector fields, something in the bounds of -2 and 2 won't be visible.
                float theta = atan2(-dy, dx);
                //Dividing the 1 by distance will lessen the magnitude of each velocity as you move further away from the origin.
                array[x][y] = PVector.fromAngle(theta).setMag(10 / distance);
            }
        }
        return array;


    }

    void display(int sections, PVector[][] vectors){
        boolean on = false;
        if(m.mousePressed){
            on = true;
        }
        if(on == true) {
            for (int x = 0; x < cols; x++) {
                for (int y = 0; y < rows; y++) {
                    drawVector(vectors[x][y], x * sections, y * sections, sections / 2, sections);
                    System.out.println("X: " + x + "Y: " + y + "Vector: " + vectors[x][y]);
                }

            }
        }


    }
    //Displays the Vector
    //https://github.com/nature-of-code/noc-examples-processing/blob/master/chp06_agents/NOC_6_04_Flowfield/FlowField.pde
    void drawVector(PVector v, float x, float y, float scayl, float sections) {
        m.pushMatrix();
        float arrowsize = 4;
        // Translate to position to render vector
        m.translate(x, y);
        m.stroke(255);
        // Call vector heading function to get direction (note that pointing to the right is a heading of 0) and rotate
        m.rotate(v.heading());
        // Calculate length of vector & scale it to be bigger or smaller if necessary
        float len = v.mag()*scayl;
        // Draw three lines to make an arrow (draw pointing up since we've rotate to the proper direction)
        m.line(0,0,len,0);
        m.line(len,0,len-arrowsize,+arrowsize/2);
        m.line(len,0,len-arrowsize,-arrowsize/2);
        m.popMatrix();

    }

    PVector lookup(PVector lookup, PVector[][] vector, int section){
        int column = (constrain((int)lookup.x/section,0,cols-1));
        int row = (constrain((int) lookup.y/section,0,rows-1));
        return vector[column][row];
    }



}
