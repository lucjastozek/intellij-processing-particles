import processing.core.PApplet;

import java.util.ArrayList;


public class Main extends PApplet {
    Spark[] sparks;
    ArrayList<ClickedPoint> clickedPoints;
    int clickedCount;

    public static void main(String[] args) {
        PApplet.main(new String[]{"Main"});
    }

    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void setup() {
        sparks = Spark.createSparks(this, 100);
        clickedPoints =  new ArrayList<ClickedPoint>();
        clickedCount ++;
    }


    @Override
    public void draw() {
        background(100);
        for (Spark s : sparks) {
            s.display();
        }
        for (ClickedPoint p : clickedPoints) {
            p.display();
        }
        for (Spark s : sparks) {
            s.update();
        }
    }


    @Override
    public void mousePressed() {
        ClickedPoint p = new ClickedPoint(this, mouseX, mouseY, clickedCount);
        clickedPoints.add(p);
        clickedCount++;
    }
}