import processing.core.PApplet;

public class Main extends PApplet {
    Spark[] sparks;
    public static void main(String[] args) {
        PApplet.main(new String[]{"Main"});

    }
    @Override
    public void settings() {
        size(800, 600);
        fullScreen();
    }

    @Override
    public void setup() {
        int[] palette = createPalette();
        sparks = Spark.createSparks(this, 100, palette);
    }

    @Override
    public void draw() {
        background(90);
        showBigMessage("Press escape to exit");
        //background(100);
        for (Spark s : sparks){
            s.display();
        }
        for (Spark s : sparks){
            s.update();
        }
    }

    @Override
    public void mousePressed() {
        for(Spark s:sparks){
            s.reactToClick(mouseX, mouseY);
        }
    }

    private void showBigMessage(String msg) {
        textSize(80);
        fill(60);
        textAlign(CENTER, CENTER);
        text(msg, width/2f, height/2f);
    }

    private int[] createPalette(){
        return new int[]{
                color(141, 204, 173),
                color(152, 136, 100),
                color(254, 166, 162),
                color(249, 214, 172),
                color(255, 233, 175)
        };
    }
}
