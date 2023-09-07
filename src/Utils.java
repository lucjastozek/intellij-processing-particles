public class Utils {
    public static int pickFromArrayOfInts(int[] myArray) {
        return myArray[(int) (Math.random() * myArray.length)];
    }
    public static <T> T pickFromArrayOfObjects(T[] myArray) {
        return myArray[(int) (Math.random() * myArray.length)];
    }

}

