package model;

import model.drawableShapes.Drawable;
import java.io.*;
import java.util.ArrayList;

public abstract class Serializer {


    public static void serializeDrawn(File f, ArrayList<Drawable> drawables){
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f))){
            os.writeObject(drawables);
        } catch (IOException e) {
//			e.printStackTrace();
            System.out.println("Couldn't serialize the drawing!");
        }
    }

    public static void deserializeDrawn(File f, ArrayList<Drawable> drawables){
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
