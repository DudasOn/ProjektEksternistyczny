package model;

import model.drawableShapes.Drawable;

import java.io.*;
import java.util.ArrayList;

public class Serializer {

    ArrayList<Drawable> drawables;

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
}
