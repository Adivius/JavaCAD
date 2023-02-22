import java.awt.event.KeyEvent;

public class FigureDoor extends Figure {

    public FigureDoor(Cadpen pen) {
        super(pen);
        key = KeyEvent.VK_3;
    }

    @Override
    public void draw(float dir) {
        Situation temp = pen.getSituation();
        pen.bewegeUm(pen.length / 2, false, Consts.LEFT - dir);
        Situation mid = pen.getSituation();
        pen.bewegeUm(pen.width / 2, true, Consts.DOWN - dir);
        pen.bewegeUm(pen.width, true, Consts.UP - dir);
        pen.bewegeUm(pen.length, false, Consts.RIGHT - dir);
        pen.bewegeUm(pen.width, true, Consts.DOWN - dir);
        pen.bewegeUm(pen.width / 2, false, Consts.LEFT - dir);
        pen.down();
        pen.setSituation(mid);
        pen.up();
        pen.setSituation(temp);
    }
}
