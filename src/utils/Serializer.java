package utils;

import model.paintingModel.drawableShapes.Drawable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public abstract class Serializer {

    private final static String DRAWABLES_FILE_NAME = "LastDrawnDrawables.ser";
    private final static String IMAGE_FILE_NAME = "LastFilteredImage.jpeg";

    public static void serializeDrawables(ArrayList<Drawable> drawables, Color color) {
        Serializer.serializeDrawables(new File(DRAWABLES_FILE_NAME), drawables, color);
    }

    public static void serializeDrawables(File f, ArrayList<Drawable> drawables, Color color) {

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f))) {
            os.writeObject(drawables);
            os.writeObject(color);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldn't serialize drawables");
        }
    }

    public static ArrayList<Object> deserializeDrawables() {
        return Serializer.deserializeDrawables(new File(DRAWABLES_FILE_NAME));
    }

    public static ArrayList<Object> deserializeDrawables(File f) {
        ArrayList<Object> info;

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(f))) {
            Object out = is.readObject();
            if (out instanceof ArrayList) info = (ArrayList<Object>) out;
            else return null;
            out = is.readObject();
            if (out instanceof Color) info.add(out);
            else return null;
            return info;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Couldn't deserialize drawables!");
            return null;
        }
    }

    public static void saveJPEG(JPanel panel) {
        saveJPEG(new File(IMAGE_FILE_NAME), panel);
    }

    public static void saveJPEG(File file, JPanel panel) {
        if (panel.getWidth() > 0 || panel.getHeight() > 0) {
            BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
            panel.printAll(image.getGraphics());

            try {
                ImageIO.write(image, "jpeg", file);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Generating an image wasn't successful");
            }
        } else System.out.println("Couldn't save the image!");
    }

    public static BufferedImage readJPEG() {
        return readJPEG(new File(IMAGE_FILE_NAME));
    }

    public static BufferedImage readJPEG(File f) {
        BufferedImage image;
        try {
            image = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println("Couldn't read JPEG");
            image = null;
        }
        return image;
    }
}
