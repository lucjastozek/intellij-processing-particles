import processing.core.PApplet;
import processing.core.PVector;

public class Follower {
    private PVector pos;
    private float size;
    private int colour;
    private final PApplet p5;

    /**
     * Constructor for Spark objects.
     * @param p5 PApplet instance. Provides functions like random and variables like width and mouseX.
     */
    public Follower(PApplet p5, float x, float y, float size, int colour) {
        this.p5 = p5;
        this.pos = new PVector(x + p5.random(30),y + p5.random(30));
        this.size = size;
        this.colour = colour;
    }

    public void display() {
        if (p5.random(0, 1) < 0.9){
            p5.noStroke();
        } else {
            p5.stroke(0, 100);
        }
        p5.fill(colour);
        p5.circle(pos.x, pos.y, size);
    }

    public void update(PVector vel) {
        pos.add(vel);
    }
}
