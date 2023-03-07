import java.awt.event.KeyEvent;

public class FigureWall extends Figure {

    public FigureWall(Cadpen pen) {
        super(pen);
        key = KeyEvent.VK_1;
    }

    @Override
    public void draw(float dir) {
        Situation temp = pen.getSituation();
        pen.moveBy(pen.width / 2, false, Consts.UP - dir);
        pen.moveBy(pen.length / 2, true, Consts.LEFT - dir);
        pen.moveBy(pen.width, false, Consts.DOWN - dir);
        pen.moveBy(pen.length, true, Consts.RIGHT - dir);
        pen.moveBy(pen.width, false, Consts.UP - dir);
        pen.moveBy(pen.length / 2, true, Consts.LEFT - dir);
        pen.setSituation(temp);
    }
}
