import processing.core.PApplet;

public class ClickedPoint {
    private final int x;
    private final int y;
    private final int myNum;

    private final PApplet p5;
    public ClickedPoint(PApplet p5, int x, int y, int idNum) {
        this.x = x;
        this.y = y;
        this.myNum = idNum;
        this.p5 = p5;
    }
    public void display(){
        p5.fill(255);
        p5.circle(x, y, 100);
        p5.fill(0, 0, 0);
        p5.textSize(30);
        p5.textAlign(p5.CENTER, p5.CENTER);
        p5.text(myNum+"", x, y);
    }
}
