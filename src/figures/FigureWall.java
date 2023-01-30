public class FigureWall extends Figure{

    public FigureWall(Cadpen pen) {
        super(pen);
        key = '1';
    }

    @Override
    public void draw(int dir) {
        Situation temp = pen.getSituation();
        pen.bewegeUm(pen.wight / 2, false, Consts.UP - dir);
        pen.bewegeUm(pen.length / 2, true, Consts.LEFT - dir);
        pen.bewegeUm(pen.wight, false, Consts.DOWN - dir);
        pen.bewegeUm(pen.length, true, Consts.RIGHT - dir);
        pen.bewegeUm(pen.wight, false, Consts.UP - dir);
        pen.bewegeUm(pen.length / 2, true, Consts.LEFT - dir);
        pen.setSituation(temp);
    }
}
