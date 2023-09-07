import processing.core.PApplet;
import processing.core.PVector;

/**
 * A Spark object is an object which can move and display itself.  Each spark maintains its own position and velocity.
 */
public class Spark {

    //Instance variables: Here are declarations of all properties that every Spark object will have.
    //We will typically give these values later, in the constructor function, when the object is constructed!
    private int[] palette;

    private float size;
    /**
     * The position of the spark.  Uses PVector class - an object containing  x, y, AND functionality.
     */
    private PVector pos;
    /**
     * The velocity of the spark - its speed and direction.
     */
    private PVector vel;
    private int myColour; //there's no real color type, it's just stored as an int
    private final PApplet p5;

    /**
     * Constructor for Spark objects.
     * @param p5 PApplet instance. Provides functions like random and variables like width and mouseX.
     */
    public Spark(PApplet p5, float x, float y, float size, int colour) {
        this.p5 = p5;
        this.pos = new PVector(x,y);
        this.vel = PVector.random2D().mult(p5.random(0.1f, 2));
        this.size = size;
        this.myColour = colour;
    }

    public void display() {
        if (p5.random(0, 1) < 0.9){
            p5.noStroke();
        } else {
            p5.stroke(0, 100);
        }
        p5.fill(myColour);
        p5.circle(pos.x, pos.y, size);
    }

    public void update() {
        pos.add(vel);
        final float angleChange = p5.random(-0.2f, 0.2f);
        vel.rotate(angleChange);
        size = PApplet.constrain(size + p5.random(-1, 1), 5, 100);
    }


    //Static methods - these don't operate on a specific existing instance of the class,
    //but are still related to the class.
    public static Spark[] createSparks(PApplet p5, int numToCreate, int[] palette) {
        Spark[] sparks = new Spark[numToCreate];
        for (int i = 0; i < numToCreate; i++) {
            sparks[i] = createRandomSpark(p5, palette);
        }
        return sparks;
    }

    private static Spark createRandomSpark(PApplet p5, int[] palette) {
        float x = p5.random(0f, p5.width);
        float y = p5.random(0f, p5.height);
        float size = p5.random(10, 50);
;
        int colour = Utils.pickFromArray(palette);
        return new Spark(p5, x, y, size, colour);
    }

    public void reactToClick(int x, int y) {
        pos.x = x;
        pos.y = y;

    }
}
