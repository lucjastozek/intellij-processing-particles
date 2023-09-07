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
        this.vel = randomVelocity(p5);
        this.size =randomSize(p5);
        this.myColour = colour;
    }

    private static PVector randomVelocity(PApplet p5) {
        float angle = -90 + p5.random(-45, 45);
        float speed = p5.random(1, 8);
        return PVector.fromAngle(angle).mult(speed);
    }

    public void display() {
        if (p5.random(0, 1) < 0.9){
            p5.noStroke();
        } else {
            p5.stroke(0, 100);
        }
        p5.fill(myColour);
        p5.square(pos.x, pos.y, size);
    }

    public void update() {
        PVector gravityAccel = new PVector(0, 0.09f);
        vel.add(gravityAccel);
        pos.add(vel);

        size = Math.max(0.1f, size - 0.1f);
    }


    public void reactToClick(int x, int y) {
        pos = new PVector(x, y);
        vel = randomVelocity(p5);
        size = randomSize(p5);

    }
    //Static methods - these don't operate on a specific existing instance of the class,
    //but are still related to the class.
    public static Spark[] createSparks(PApplet p5, int numToCreate, int[] palette) {
        Spark[] sparks = new Spark[numToCreate];
        PVector screenCenter = new PVector(p5.width/2f, p5.height/2f);
        for (int i = 0; i < numToCreate; i++) {
            sparks[i] = createRandomSpark(p5, screenCenter, palette);
        }
        return sparks;
    }

    private static PVector randomScreenPosition(PApplet p5) {
        float x = p5.random(0, p5.width);
        float y = p5.random(0, p5.height);

        return new PVector(x, y);
    }

    private static Spark createRandomSpark(PApplet p5, PVector pos, int[] palette) {
        float size = randomSize(p5);
        int colour = Utils.pickFromArray(palette);
        return new Spark(p5, pos.x, pos.y, size, colour);
    }

    private static float randomSize(PApplet p5) {
        return p5.random(10, 50);
    }

}
