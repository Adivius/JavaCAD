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
        figure.draw(getRotation());
    }


    public void bewegeUm(double distance, boolean draw, float dir) {
        float penDir = getRotation();
        boolean down = isDrawing();
        setRotation(dir);
        if (draw) {
            down();
        } else {
            up();
        }
        super.moveBy((int) distance);
        setRotation(penDir);
        if (down) {
            down();
        } else {
            up();
        }
    }


    Situation getSituation() {
        return new Situation(getXPos(), getYPos(), getRotation());
    }

    void setSituation(Situation situation) {
        moveTo(situation.X, situation.Y);
        setRotation(situation.DIR);
    }
}
