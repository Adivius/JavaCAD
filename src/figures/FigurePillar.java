public class FigurePillar extends Figure{

    public FigurePillar(Cadpen pen) {
        super(pen);
        key = '5';
    }

    @Override
    public void draw(int dir) {
        pen.zeichneKreis(pen.wight * 2);
    }
}
