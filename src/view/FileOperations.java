package view;

import model.Serializer;
import model.drawableShapes.Drawable;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public abstract class FileOperations {

    public static ArrayList<Drawable> chooseFile() {

            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));
            int response = chooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(chooser.getSelectedFile().getAbsolutePath());
                System.out.println(chooser.getSelectedFile().getAbsolutePath());
                return Serializer.deserializeDrawn(file);
            }
            else return null;
    }

    public static void saveFile(ArrayList<Drawable> drawables) {

        JFileChooser saver = new JFileChooser();
        saver.setCurrentDirectory(new File("."));
        int response = saver.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = new File(saver.getSelectedFile().getAbsolutePath());
            System.out.println("Serialization path: "+saver.getSelectedFile().getAbsolutePath());
            Serializer.serializeDrawn(file, drawables);
        }
    }
    }
