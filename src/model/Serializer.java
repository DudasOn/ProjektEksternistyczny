package model;

import model.drawableShapes.Drawable;
import java.io.*;
import java.util.ArrayList;

public abstract class Serializer {

    private final static String DRAWABLES_FILE_NAME = "LastDrawnDrawables.ser";

    public static void serialize(ArrayList<Drawable> drawables) {
        Serializer.serialize(new File(DRAWABLES_FILE_NAME), drawables);
    }

    public static void serialize(File f, ArrayList<Drawable> drawables) {

        if (f == null) f = new File(DRAWABLES_FILE_NAME);
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f))) {
            os.writeObject(drawables);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldn't serialize drawables");
        }
    }

    public static ArrayList<Drawable> deserialize() {
        return Serializer.deserialize(new File(DRAWABLES_FILE_NAME));
    }

    public static ArrayList<Drawable> deserialize(File f) {
        ArrayList<Drawable> drawables = new ArrayList<>();

        if (f == null) f = new File(DRAWABLES_FILE_NAME);

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(f))) {
            Object out = is.readObject();
            if (out instanceof ArrayList)
                drawables = (ArrayList<Drawable>) out;
            return drawables;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Couldn't deserialize drawables!");
            return null;
        }
    }
}
