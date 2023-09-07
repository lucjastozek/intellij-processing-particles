import processing.core.PApplet;

public class Utils {
    static int pickFromArray(int[] myArray) {
        return myArray[(int) (Math.random() * myArray.length)];
    }
}

