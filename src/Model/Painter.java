package Model;

import Model.DrawableShapes.Drawable;
import Model.ObserverPattern.Observable;
import Model.ObserverPattern.Observer;
import java.io.*;
import java.util.ArrayList;

public class Painter implements Observable {
    private ArrayList<Observer> observers;
    private ArrayList<Drawable> drawables;

    public Painter(){
        observers = new ArrayList<>();
        drawables = new ArrayList<>();
    }


    public void serializeDrawn(File f){
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f))){
            os.writeObject(drawables);
        } catch (IOException e) {
//			e.printStackTrace();
            System.out.println("Couldn't serialize the drawing!");
        }
    }

    public void deserializeDrawn(File f){
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(f))){
            Object out = is.readObject();
            if (out instanceof ArrayList)
                drawables = (ArrayList<Drawable>) out;
        } catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();
            System.out.println("Couldn't deserialize the drawing!");
        }
    }

    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        if (observers.contains(o)){
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
