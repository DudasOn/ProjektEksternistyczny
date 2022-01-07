package model.paintingModel;

import model.paintingModel.drawableShapes.*;
import observerInterface.Subject;
import observerInterface.Observer;

import java.awt.*;
import java.util.ArrayList;

public class DrawablesCreator implements Subject {
    private ArrayList<Observer> observers;
    private Drawable drawn;

    public DrawablesCreator() {
        observers = new ArrayList<>();
    }

    public void createDrawable(int xInfo, int yInfo, Color toolColor, int attributeOfChosenTool, int typeOfChosenTool, boolean ifFilledIn, boolean ifCovering) {

        switch (typeOfChosenTool) {
            case 1:
                drawn = new Circle(xInfo, yInfo, toolColor, attributeOfChosenTool, ifFilledIn, ifCovering);
                break;
            case 2:
                drawn = new Square(xInfo, yInfo, toolColor, attributeOfChosenTool, ifFilledIn, ifCovering);
                break;
            case 3:
                drawn = new Triangle(xInfo, yInfo, toolColor, attributeOfChosenTool, ifFilledIn, ifCovering);
                break;
            default:
                drawn = new Circle();
                break;
        }
        notifyObservers();
    }

    public Drawable getDrawn() {
        return drawn;
    }


    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }
}
