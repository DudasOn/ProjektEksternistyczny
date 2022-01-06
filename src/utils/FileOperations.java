package utils;

import model.paintingModel.drawableShapes.Drawable;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public abstract class FileOperations {

    private static final FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("JAVA Serlialization files (*.ser)", "ser");

    public static ArrayList<Object> readSerFile() {

        JFileChooser reader = new JFileChooser();
        reader.setCurrentDirectory(new File("./savedSerFiles"));
        reader.setFileFilter(extensionFilter);

        int response = reader.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {

            if (reader.getSelectedFile().getAbsolutePath().endsWith(".ser")) {
                File file = new File(reader.getSelectedFile().getAbsolutePath());
                System.out.println(reader.getSelectedFile().getAbsolutePath());

                return Serializer.deserialize(file);
            } else System.out.println("Incorrect file type");
        }
        return null;
    }

    public static void saveSerFiles(ArrayList<Drawable> drawables, Color color) {

        JFileChooser saver = new JFileChooser();
        saver.setCurrentDirectory(new File("./savedSerFiles"));
        saver.setFileFilter(extensionFilter);

        int response = saver.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {

            File file = new File(saver.getSelectedFile().getAbsolutePath() + ".ser");
            System.out.println("Serialization path: " + saver.getSelectedFile().getAbsolutePath());
            Serializer.serialize(file, drawables, color);
        }
    }

    public static void saveJPEG(JPanel panel) {

        JFileChooser saver = new JFileChooser();
        saver.setCurrentDirectory(new File("./savedImages"));

        int response = saver.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {

            File file = new File(saver.getSelectedFile().getAbsolutePath() + ".jpeg");
            System.out.println("Serialization path: " + saver.getSelectedFile().getAbsolutePath());
            Serializer.saveJPEG(file, panel);

        }
    }


}
