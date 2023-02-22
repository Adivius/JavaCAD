public abstract class Figure {

    protected Cadpen pen;

    protected int key;

    public Figure(Cadpen pen) {
        this.pen = pen;
    }

    public abstract void draw(float dir);

    public int getKey() {
        return key;
    }
}
