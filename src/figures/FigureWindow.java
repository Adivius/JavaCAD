import java.awt.event.KeyEvent;

public class FigureWindow extends Figure {

    public FigureWindow(Cadpen pen) {
        super(pen);
        key = KeyEvent.VK_2;
    }

    @Override
    public void draw(int dir) {
        Situation temp = pen.getSituation();
        pen.bewegeUm(pen.length / 2, true, Consts.LEFT - dir);
        pen.bewegeUm(pen.width / 2, true, Consts.UP - dir);
        pen.bewegeUm(pen.width, true, Consts.DOWN - dir);
        pen.bewegeUm(pen.length, false, Consts.RIGHT - dir);
        pen.bewegeUm(pen.width, true, Consts.UP - dir);
        pen.setSituation(temp);
        pen.bewegeUm(pen.length / 2, true, Consts.RIGHT - dir);
        pen.setSituation(temp);
    }
}
