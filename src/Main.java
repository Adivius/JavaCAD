import sum.kern.Fenster;
import sum.kern.Maus;
import sum.kern.Tastatur;

import java.util.HashMap;

public class Main {

    public Fenster screen;
    public Cadpen pen;
    public Maus mouse;
    public Tastatur keyboard;
    public HashMap<Character, Figure> figures;
    public FigureWall defaultFigure;
    public Figure currentFigure;

    private void initialFigures(){
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

    public Main(){
        screen = new Fenster(1600, 900, "CAD");
        mouse = new Maus();
        keyboard = new Tastatur();
        pen = new Cadpen(Consts.SIZE, 2);
        figures = new HashMap<>();
        defaultFigure = new FigureWall(pen);
        currentFigure = defaultFigure;
        initialFigures();
        for (;!!true;){
            tickPen();
            tickMouse();
            tickKeyboard();
        }
    }


    public void tickMouse(){
        if (mouse.istGedrueckt()){
            pen.draw(currentFigure);
            while (mouse.istGedrueckt());
        }


    }

    public void tickPen(){
        int x = mouse.hPosition() - mouse.hPosition() % (10 * Consts.SIZE);
        int y = mouse.vPosition() - mouse.vPosition() % (10 * Consts.SIZE);
        pen.bewegeBis(x, y);
        pen.wechsle();
        pen.draw(currentFigure);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pen.draw(currentFigure);
        pen.normal();

    }

    public void tickKeyboard(){
        if (!keyboard.wurdeGedrueckt()){
            return;
        }
        switch(keyboard.zeichen()){
            case 'x':
                screen.gibFrei();
                break;
            case 'y':
                screen.loescheAlles();
                break;
            case ' ':
                pen.dreheUm(Consts.ROTATION);
                break;
            default:
                if (figures.containsKey(keyboard.zeichen())){
                    currentFigure = figures.getOrDefault(keyboard.zeichen(), defaultFigure);
                }
                break;
        }

        keyboard.weiter();
    }

    public static void main(String[] args) {
        Main D = new Main();
    }
}