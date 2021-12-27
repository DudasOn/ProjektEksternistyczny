package model;

import model.drawableShapes.Drawable;
import java.io.*;
import java.util.ArrayList;

public abstract class Serializer {

    private final static String DRAWABLES_FILE = "LastDrawnDrawables.ser";


    public static void serializeDrawn(File f, ArrayList <Drawable> drawables){
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f))){
            os.writeObject(drawables);
        } catch (IOException e) {
			e.printStackTrace();
            System.out.println("Couldn't serialize the drawing!");
        }
    }

    public static ArrayList<Drawable> deserializeDrawn(File f){
        ArrayList<Drawable> drawables = new ArrayList<>();

        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(f))){
            Object out = is.readObject();
            if (out instanceof ArrayList)
                drawables = (ArrayList<Drawable>) out;
            return drawables;
        } catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();
            System.out.println("Couldn't deserialize the drawing!");
            return null;
        }
    }

    public static void serializeLastState(ArrayList <Drawable> drawables){
        for (int i = 0; i < drawables.size(); i++) {
            drawables.remove(drawables.get(i));
        }

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(DRAWABLES_FILE))) {
            os.writeObject(drawables);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Drawable> deserializeLastState(){
        ArrayList <Drawable> drawables = new ArrayList<>();

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(DRAWABLES_FILE))) {
            Object out = is.readObject();
            if (out instanceof ArrayList)
                drawables = (ArrayList<Drawable>) out;
            return drawables;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }

    }
}
