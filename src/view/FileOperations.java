package view;

import model.Serializer;
import model.drawableShapes.Drawable;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;

public abstract class FileOperations {

    private static final FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("JAVA Serlialization files","ser");

    public static ArrayList<Drawable> chooseFile() {

            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("./savedImages"));
            chooser.setFileFilter(extensionFilter);

            int response = chooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {

                if((chooser.getSelectedFile().getAbsolutePath().substring(chooser.getSelectedFile().getAbsolutePath().length()-4)).equals(".ser")) {
                    File file = new File(chooser.getSelectedFile().getAbsolutePath());
                    System.out.println(chooser.getSelectedFile().getAbsolutePath());

                    return Serializer.deserialize(file);
                } else System.out.println("Incorrect file type");
            }
            return null;
    }

    public static void saveFile(ArrayList<Drawable> drawables) {

        JFileChooser saver = new JFileChooser();
        saver.setCurrentDirectory(new File("./savedImages"));
        saver.setFileFilter(extensionFilter);

        int response = saver.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {

            if((saver.getSelectedFile().getAbsolutePath().substring(saver.getSelectedFile().getAbsolutePath().length()-4)).equals(".ser")) {
                File file = new File(saver.getSelectedFile().getAbsolutePath());
                System.out.println("Serialization path: " + saver.getSelectedFile().getAbsolutePath());
                Serializer.serialize(file, drawables);
            } else System.out.println("Incorrect file type");
        }
    }
    }
