import java.awt.event.KeyEvent;

public class FigureWindow extends Figure {

    public FigureWindow(Cadpen pen) {
        super(pen);
        key = KeyEvent.VK_2;
    }

    @Override
    public void draw(float dir) {
        Situation temp = pen.getSituation();
        pen.moveBy(pen.length / 2f, true, Consts.LEFT - dir);
        pen.moveBy(pen.width / 2f, true, Consts.UP - dir);
        pen.moveBy(pen.width, true, Consts.DOWN - dir);
        pen.moveBy(pen.length, false, Consts.RIGHT - dir);
        pen.moveBy(pen.width, true, Consts.UP - dir);
        pen.setSituation(temp);
        pen.moveBy(pen.length / 2f, true, Consts.RIGHT - dir);
        pen.setSituation(temp);
    }
}
