import processing.core.PApplet;
import processing.core.PVector;

public class ClickedPoint {
    private PVector pos;
    private int myNum;
    private final PApplet p5;

    /**
     * Constructor for Spark objects.
     * @param p5 PApplet instance. Provides functions like random and variables like width and mouseX.
     */
    public ClickedPoint(PApplet p5, int x, int y, int myNum) {
        this.p5 = p5;
        this.pos = new PVector(x,y);
        this.myNum = myNum;

    }

    public void display() {
        p5.fill(255);
        p5.circle(pos.x, pos.y, 50);
        p5.textSize(40);
        p5.fill(0);
        p5.text(myNum, pos.x, pos.y);
    }
}
