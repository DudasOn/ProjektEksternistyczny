package model;

import model.drawableShapes.*;
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

    public void createDrawable(Object[] dataAboutCurrentObject) {

        switch ((int) dataAboutCurrentObject[4]) {
            case 1:
                drawn = new Circle((int) dataAboutCurrentObject[0], (int) dataAboutCurrentObject[1], (Color) dataAboutCurrentObject[2], (int) dataAboutCurrentObject[3], (boolean) dataAboutCurrentObject[5], (boolean) dataAboutCurrentObject[6]);
                break;
            case 2:
                drawn = new Square((int) dataAboutCurrentObject[0], (int) dataAboutCurrentObject[1], (Color) dataAboutCurrentObject[2], (int) dataAboutCurrentObject[3], (boolean) dataAboutCurrentObject[5], (boolean) dataAboutCurrentObject[6]);
                break;
            case 3:
                drawn = new Triangle((int) dataAboutCurrentObject[0], (int) dataAboutCurrentObject[1], (Color) dataAboutCurrentObject[2], (int) dataAboutCurrentObject[3], (boolean) dataAboutCurrentObject[5], (boolean) dataAboutCurrentObject[6]);
                break;
            default:
                drawn = new Circle();
                break;
        }
        notifyObservers();
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
            observers.get(i).update(drawn);
        }
    }
}
