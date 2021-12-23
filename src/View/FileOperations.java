package View;

import javax.swing.*;
import java.io.File;

public abstract class FileOperations {

    public static void chooseFile() {

            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));
            int response = chooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(chooser.getSelectedFile().getAbsolutePath());
                System.out.println(chooser.getSelectedFile().getAbsolutePath());
            }
    }

    public static void saveFile() {

        JFileChooser saver = new JFileChooser();
        saver.setCurrentDirectory(new File("."));
        int response = saver.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = new File(saver.getSelectedFile().getAbsolutePath());
            System.out.println(saver.getSelectedFile().getAbsolutePath());
        }
    }
    }
