import org.junit.Test;
import processing.core.PApplet;

import static org.junit.Assert.assertEquals;

public class MyTest {
    @Test
    public void myTestMethod() {
        // Your test code here.
        int[] palette = {100, 200, 150};
        //I doubt this is a good idea, but we need a p5 applet to create sparks, currently.
        PApplet p5 = new PApplet();

        Spark.createSparks(p5, 100, palette);

        assertEquals(4, 2 + 2);
    }

    @Test
    public void testPickFromArray() {
        final int[] arr = {10, 20};
        for (int i = 0; i < 100; i++) {
            int result = Utils.pickFromArray(arr);
            assert (result == 10 || result == 20);
        }
    }
}
