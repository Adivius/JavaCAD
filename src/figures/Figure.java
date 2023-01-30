public abstract class Figure {

    protected Cadpen pen;

    protected char key;

    public Figure(Cadpen pen){
        this.pen = pen;
    }

    public abstract void draw(int dir);

    public char getKey() {
        return key;
    }
}
