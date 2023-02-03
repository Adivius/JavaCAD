public class Cadpen extends Pen {

    public int size;
    public int length;
    public int width;

    public Cadpen(Screen screen, int size, int thickness) {
        super(screen);
        this.size = size * Consts.LENGTH_SIZE;
        this.length = this.size / 2;
        this.width = length / 4;
        this.setThickness(thickness);
    }

    public void draw(Figure figure) {
        figure.draw(getAngle());
    }


    public void bewegeUm(double distance, boolean draw, int dir) {
        int penDir = getAngle();
        boolean down = cDrawing;
        setAngle(dir);
        if (draw) {
            down();
        } else {
            up();
        }
        super.moveBy((int) distance);
        setAngle(penDir);
        if (down) {
            down();
        } else {
            up();
        }
    }


    Situation getSituation() {
        return new Situation(getXPos(), getYPos(), getAngle());
    }

    void setSituation(Situation situation) {
        moveTo(situation.X, situation.Y);
        setAngle(situation.DIR);
    }
}
