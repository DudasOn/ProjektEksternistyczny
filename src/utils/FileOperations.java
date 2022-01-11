package utils;

import model.paintingModel.drawableShapes.Drawable;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public abstract class FileOperations {

    private static final FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("JAVA Serlialization files (*.ser)", "ser");

    public static ArrayList<Object> readDrawablesSerFile() {

        JFileChooser reader = new JFileChooser();
        reader.setCurrentDirectory(new File("./savedSerFiles"));
        reader.setFileFilter(extensionFilter);

        int response = reader.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {

            if (reader.getSelectedFile().getAbsolutePath().endsWith(".ser")) {
                File file = new File(reader.getSelectedFile().getAbsolutePath());
                System.out.println("Deserialization path: " + reader.getSelectedFile().getAbsolutePath());

                return Serializer.deserializeDrawables(file);
            } else System.out.println("Incorrect file type");
        }
        return null;
    }

    public static void saveDrawablesSerFiles(ArrayList<Drawable> drawables, Color color) {

        JFileChooser saver = new JFileChooser();
        saver.setCurrentDirectory(new File("./savedSerFiles"));
        saver.setFileFilter(extensionFilter);

        int response = saver.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {

            File file = new File(saver.getSelectedFile().getAbsolutePath() + ".ser");
            System.out.println("Serialization path: " + saver.getSelectedFile().getAbsolutePath());
            Serializer.serializeDrawables(file, drawables, color);
        }
    }

    public static void saveJPEG(JPanel panel) {

        JFileChooser saver = new JFileChooser();
        saver.setCurrentDirectory(new File("./savedImages"));

        int response = saver.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {

            File file = new File(saver.getSelectedFile().getAbsolutePath() + ".jpeg");
            System.out.println("Saving path: " + saver.getSelectedFile().getAbsolutePath());
            Serializer.saveJPEG(file, panel);

        }
    }

    public static BufferedImage readJPEG() {
        JFileChooser reader = new JFileChooser();
        reader.setCurrentDirectory(new File("./savedImages"));

        int response = reader.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            if (reader.getSelectedFile().getAbsolutePath().endsWith(".jpeg") || reader.getSelectedFile().getAbsolutePath().endsWith(".jpg")) {
                File file = new File(reader.getSelectedFile().getAbsolutePath());
                System.out.println("Loading path: " + reader.getSelectedFile().getAbsolutePath());
                return Serializer.readJPEG(file);
            } else System.out.println("Incorrect file type");
        }
        return null;
    }
}
