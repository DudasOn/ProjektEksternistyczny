package view;

import javax.swing.*;
import java.awt.*;


public class MainFrame {

    private final int HEIGHT = 600;
    private final int WIDTH = 800;

    private final JFrame mainFrame;
    private final JMenuBar mainMenu;
    private final JMenu changeTool;
    private final JMenu fileOperation;
    private final JMenuItem changeToolColor;
    private final JMenuItem changeBackgroundColor;
    private final JMenuItem serialize;
    private final JMenuItem deserialize;
    private final JMenuItem draw;
    private final JMenuItem cover;
    private final JMenuItem delete;
    private final PaintingPanel paintingPanel;
    private final ChooseColorFrameRGB toolColor;
    private final ChooseColorFrameRGB backgroundColor;


    public MainFrame() {
        //tworzenie glownej ramki
        toolColor = new ChooseColorFrameRGB();
        backgroundColor = new ChooseColorFrameRGB();
        paintingPanel = new PaintingPanel(WIDTH, HEIGHT, backgroundColor);
        backgroundColor.registerObserver(paintingPanel);
        mainFrame = new JFrame("Painter");
        mainFrame.setSize(new Dimension(WIDTH, HEIGHT));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //tworzenie paska menu i glownych kategorii
        mainMenu = new JMenuBar();
        changeTool = new JMenu("Alter tool");
        fileOperation = new JMenu("File");

        //tworzenie odpowiednich elementow do menu
        changeToolColor = new JMenuItem("Change tool color");
        changeToolColor.addActionListener(e -> toolColor.setVisibility());

        changeBackgroundColor = new JMenuItem("Change background color");
        changeBackgroundColor.addActionListener(e -> backgroundColor.setVisibility());

        serialize = new JMenuItem("Serialize");
        serialize.addActionListener(e -> FileOperations.chooseFile());

        deserialize = new JMenuItem("Deserialize");
        deserialize.addActionListener(e -> FileOperations.saveFile());

        draw = new JMenuItem("Draw");
        cover = new JMenuItem("Cover");
        delete = new JMenuItem("Delete");

        //dodawanie elementow do ramki glownej i odpowiednich menu
        mainFrame.setResizable(true);
        mainFrame.setJMenuBar(mainMenu);
        mainFrame.add(BorderLayout.CENTER, paintingPanel);
        fileOperation.add(serialize);
        fileOperation.add(deserialize);
        changeTool.add(draw);
        changeTool.add(cover);
        changeTool.add(delete);
        changeTool.add(changeToolColor);
        changeTool.add(changeBackgroundColor);
        mainMenu.add(changeTool);
        mainMenu.add(fileOperation);
        mainFrame.setVisible(true);
    }

}
