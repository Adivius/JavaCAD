import java.awt.event.KeyEvent;

public class FigureCorner extends Figure {
    public FigureCorner(Cadpen pen) {
        super(pen);
        key = KeyEvent.VK_4;
    }

    @Override
    public void draw(int dir) {
        Situation temp = pen.getSituation();
        pen.bewegeUm(pen.width * 2, false, Consts.LEFT - dir);
        pen.bewegeUm(pen.width * 0.5, false, Consts.UP - dir);
        pen.bewegeUm(pen.width * 1.5, true, Consts.RIGHT - dir);
        pen.bewegeUm(pen.width * 1.5, true, Consts.UP - dir);
        pen.bewegeUm(pen.width, false, Consts.RIGHT - dir);
        pen.bewegeUm(pen.width * 2.5, true, Consts.DOWN - dir);
        pen.bewegeUm(pen.width * 2.5, true, Consts.LEFT - dir);
        pen.setSituation(temp);
    }
}
