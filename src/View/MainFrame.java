package View;

import javax.swing.*;
import java.awt.*;


public class MainFrame {

    private JFrame mainFrame;
    private JMenuBar mainMenu;
    private JMenu changeTool;
    private JMenu fileOperation;
    private JMenuItem changeColor;
    private JMenuItem serialize;
    private JMenuItem deserialize;
    private PaintingPanel paintingPanel;
    private int HEIGHT = 600;
    private int WIDTH=800;
    private ChooseColorFrame colorChooser;


    public MainFrame() {
        colorChooser=new ChooseColorFrame();
        mainFrame = new JFrame("Painter");
        mainFrame.setSize(new Dimension(WIDTH, HEIGHT));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        paintingPanel = new PaintingPanel(WIDTH, HEIGHT);
        changeColor = new JMenuItem("Change color");
        changeColor.addActionListener(e->colorChooser.setVisibility());

        mainMenu = new JMenuBar();
        changeTool = new JMenu("Change tool");
        fileOperation = new JMenu("File");
        serialize = new JMenuItem("Serialize");
        deserialize = new JMenuItem("Deserialize");

        mainFrame.setResizable(true);
        mainFrame.setJMenuBar(mainMenu);
        mainFrame.add(BorderLayout.CENTER, paintingPanel);
        fileOperation.add(serialize);
        fileOperation.add(deserialize);
        changeTool.add(changeColor);
        mainMenu.add(changeTool);
        mainMenu.add(fileOperation);
        mainFrame.setVisible(true);
    }


}
