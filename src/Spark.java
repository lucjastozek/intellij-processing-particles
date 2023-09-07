import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

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

    private String shape;

    private ArrayList<Follower> followers = new ArrayList<Follower>();

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
        this.shape = Utils.pickFromArrayOfStrings(new String[]{"square", "circle"});

        followers.add(new Follower(p5, x, y, size/2, colour));
        followers.add(new Follower(p5, x, y, size/2, colour));
        followers.add(new Follower(p5, x, y, size/2, colour));
    }

    public void display() {
        if (p5.random(0, 1) < 0.9){
            p5.noStroke();
        } else {
            p5.stroke(0, 100);
        }
        p5.fill(myColour);

        if (shape.equals("circle")) {
            p5.circle(pos.x, pos.y, size);
        } else {
            p5.square(pos.x, pos.y, size);
        }

        for (Follower f : followers) {
            f.display();
        }
    }

    public void update() {
        pos.add(vel);
        final float angleChange = p5.random(-0.2f, 0.2f);
        vel.rotate(angleChange); //steer left or right
        size = PApplet.constrain(size + p5.random(-5, -1), 0, 100);

        if (size < 1) {
            size = 50;
        }

        for (Follower f : followers) {
            f.update(vel);
        }
    }


    //Static methods - these don't operate on a specific existing instance of the class,
    //but are still related to the class.
    public static Spark[] createSparks(PApplet p5, int numToCreate, int[] palette) {
        Spark[] sparks = new Spark[numToCreate];//a fixed size array
        for (int i = 0; i < numToCreate; i++) {
            sparks[i] = createRandomSpark(p5, palette);
        }
        return sparks;
    }

    private static Spark createRandomSpark(PApplet p5, int[] palette) {
        float x = p5.random(0f, p5.width);
        float y = p5.random(0f, p5.height);
        float size = p5.random(10, 50);

        int colour = Utils.pickFromArrayOfInts(palette);
        return new Spark(p5, x, y, size, colour);
    }

    public void reactToClick(int x, int y) {
        pos.x = x;
        pos.y = y;

    }
}
