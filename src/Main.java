import processing.core.PApplet;


public class Main extends PApplet {
    Spark[] sparks;
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
    }


    @Override
    public void draw() {
    background(100);
        for (Spark s : sparks){
            s.display();
        }

        for (Spark s : sparks){
            s.update();
        }
    }
}