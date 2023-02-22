import java.awt.event.KeyEvent;

public class FigurePillar extends Figure {

    public FigurePillar(Cadpen pen) {
        super(pen);
        key = KeyEvent.VK_5;
    }

    @Override
    public void draw(float dir) {
        pen.drawCircle(pen.width * 2);
    }
}
