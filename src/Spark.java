import processing.core.PApplet;

public class Spark {
    private final PApplet p5;
    private float size;
    private float x;
    private float y;

    //there's no real color type, it's just stored as an int
    private int myColour;


    public static Spark[] createSparks(PApplet p5, int numToCreate) {
        Spark[] sparks = new Spark[numToCreate];
        for (int i = 0; i < numToCreate; i++) {

            sparks[i] = createRandomSpark(p5);
        }
        return sparks;
    }

    private static Spark createRandomSpark(PApplet p5) {
        float x = p5.random(0f, 800f);
        float y = p5.random(0f, 600f);
        float size = p5.random(10, 50);
        return new Spark(p5, x, y, size);
    }

    public Spark(PApplet p5, float x, float y, float size) {
        this.p5 = p5;
        this.x = x;
        this.y = y;
        this.size = size;
        this.myColour = p5.color(p5.random(0, 255), p5.random(0, 255), p5.random(0, 255));
    }

    public void display() {
        p5.fill(myColour);
        p5.circle(x, y, size);
    }
    public void update() {
        final int stepSize = 5;
        x+= p5.random(-stepSize, stepSize);
        y+= p5.random(-stepSize, stepSize);
        size = PApplet.constrain(size + p5.random(-1, 1), 5, 100);
    }
}
