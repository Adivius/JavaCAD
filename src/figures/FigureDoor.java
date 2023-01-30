public class FigureDoor extends Figure{

    public FigureDoor(Cadpen pen) {
        super(pen);
        key = '3';
    }

    @Override
    public void draw(int dir) {
        Situation temp = pen.getSituation();
        pen.bewegeUm(pen.length / 2, false, Consts.LEFT - dir);
        Situation mid = pen.getSituation();
        pen.bewegeUm(pen.wight / 2, true, Consts.DOWN - dir);
        pen.bewegeUm(pen.wight, true, Consts.UP - dir);
        pen.bewegeUm(pen.length, false, Consts.RIGHT - dir);
        pen.bewegeUm(pen.wight, true, Consts.DOWN - dir);
        pen.bewegeUm(pen.wight / 2, false, Consts.LEFT - dir);
        pen.runter();
        pen.setSituation(mid);
        pen.hoch();
        pen.setSituation(temp);
    }
}
