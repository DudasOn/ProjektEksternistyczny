package utils;

import model.drawableShapes.Drawable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public abstract class Serializer {

    private final static String DRAWABLES_FILE_NAME = "LastDrawnDrawables.ser";

    public static void serialize(ArrayList<Drawable> drawables, Color color) {
        Serializer.serialize(new File(DRAWABLES_FILE_NAME), drawables, color);
    }

    public static void serialize(File f, ArrayList<Drawable> drawables, Color color) {

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f))) {
            os.writeObject(drawables);
            os.writeObject(color);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldn't serialize drawables");
        }
    }

    public static ArrayList<Object> deserialize() {
        return Serializer.deserialize(new File(DRAWABLES_FILE_NAME));
    }

    public static ArrayList<Object> deserialize(File f) {
        ArrayList<Object> info = new ArrayList<>();

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(f))) {
            Object out = is.readObject();
            if (out instanceof ArrayList) info = (ArrayList<Object>) out;
            out = is.readObject();
            if (out instanceof Color) info.add(out);
            return info;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Couldn't deserialize drawables!");
            return null;
        }
    }

    public static void saveJPEG(File file, JPanel panel) {

        BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        panel.printAll(image.getGraphics());

        try {
            ImageIO.write(image, "jpeg", file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Generating an image wasn't successful");
        }

    }
}
