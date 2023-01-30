import sum.kern.Buntstift;

public class Cadpen extends Buntstift {

    public int size;
    public int length;
    public int wight;

    public Cadpen(int size, int thickness) {
        this.size = size * Consts.LENGTH_SIZE;
        this.length = this.size;
        this.wight = length / 4;
        setzeLinienBreite(thickness);
    }

    public void draw(Figure figure) {
        figure.draw((int)winkel());
    }


    public void bewegeUm(double distance, boolean draw, int dir) {
        double penDir = winkel();
        boolean down = istUnten();
        dreheBis(dir);
        if (draw) {
            runter();
        } else {
            hoch();
        }
        super.bewegeUm(distance);
        dreheBis(penDir);
        if (down) {
            runter();
        } else {
            hoch();
        }
    }


    Situation getSituation() {
        return new Situation((int) hPosition(), (int) vPosition(), (int) winkel());
    }

    void setSituation(Situation situation) {
        bewegeBis(situation.X, situation.Y);
        dreheBis(situation.DIR);
    }
}
