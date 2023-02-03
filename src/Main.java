import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Main {

    public Screen screen;
    public Cadpen pen;
    public HashMap<Integer, Figure> figures;
    public FigureWall defaultFigure;
    public Figure currentFigure;

    public Main() {
        screen = new Screen(1600, 900, "CAD");
        pen = new Cadpen(screen, Consts.SIZE, 2);
        figures = new HashMap<>();
        defaultFigure = new FigureWall(pen);
        currentFigure = defaultFigure;
        initialFigures();

        while (true) {
            screen.sleep(10);
            tickPen();
            tickMouse();
            tickKeyboard();
        }
    }

    public static void main(String[] args) {
        try {
            Main main = new Main();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    private void initialFigures() {
        FigureWall figureWall = new FigureWall(pen);
        figures.put(figureWall.getKey(), figureWall);
        FigureWindow figureWindow = new FigureWindow(pen);
        figures.put(figureWindow.getKey(), figureWindow);
        FigureDoor figureDoor = new FigureDoor(pen);
        figures.put(figureDoor.getKey(), figureDoor);
        FigureCorner figureCorner = new FigureCorner(pen);
        figures.put(figureCorner.getKey(), figureCorner);
        FigurePillar figurePillar = new FigurePillar(pen);
        figures.put(figurePillar.getKey(), figurePillar);
    }

    public void tickMouse() {
        if (screen.cMousePressed) {
            pen.draw(currentFigure);
            while (screen.cMousePressed) {
                screen.sleep(10);
            }
        }
    }

    public void tickPen() {
        int x = screen.cMouseXPos - screen.cMouseXPos % (20 * Consts.SIZE);
        int y = screen.cMouseYPos - screen.cMouseYPos % (20 * Consts.SIZE);
        pen.moveTo(x, y);
        pen.setModeSwitch();
        pen.draw(currentFigure);
        screen.sleep(100);
        pen.draw(currentFigure);
        pen.setModeNormal();
    }

    public void tickKeyboard() {
        if (!screen.cKeyboardPressed) {
            return;
        }
        switch (screen.cKeyId) {
            case KeyEvent.VK_Y:
                screen.clear();
                break;
            case KeyEvent.VK_X:
                screen.release();
                break;
            case KeyEvent.VK_SPACE:
                pen.rotateBy(Consts.ROTATION);
                break;
            default:
                if (figures.containsKey(screen.cKeyId)) {
                    currentFigure = figures.getOrDefault(screen.cKeyId, defaultFigure);
                }
                break;
        }
        while (screen.cKeyboardPressed) {
            screen.sleep(10);
        }
    }
}