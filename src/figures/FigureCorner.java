import java.awt.event.KeyEvent;

public class FigureCorner extends Figure {
    public FigureCorner(Cadpen pen) {
        super(pen);
        key = KeyEvent.VK_4;
    }

    @Override
    public void draw(float dir) {
        Situation temp = pen.getSituation();
        pen.moveBy(pen.width * 2, false, Consts.LEFT - dir);
        pen.moveBy(pen.width * 0.5, false, Consts.UP - dir);
        pen.moveBy(pen.width * 1.5, true, Consts.RIGHT - dir);
        pen.moveBy(pen.width * 1.5, true, Consts.UP - dir);
        pen.moveBy(pen.width, false, Consts.RIGHT - dir);
        pen.moveBy(pen.width * 2.5, true, Consts.DOWN - dir);
        pen.moveBy(pen.width * 2.5, true, Consts.LEFT - dir);
        pen.setSituation(temp);
    }
}
