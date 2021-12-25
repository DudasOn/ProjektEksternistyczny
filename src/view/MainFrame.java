package view;

import view.choiceAssistant.ColorChoiceFrameHEX;
import view.choiceAssistant.ColorChoiceFrameRGB;
import view.choiceAssistant.ToolShapeChoice;
import javax.swing.*;
import java.awt.*;


public class MainFrame {

    private final int HEIGHT = 600;
    private final int WIDTH = 800;

    private final JFrame mainFrame;
    private final JMenuBar mainMenu;
    private final JMenu changeTool;
    private final JMenu fileOperation;
    private final JMenuItem changeToolType;
    private final JMenuItem changeToolColor;
    private final JMenuItem changeBackgroundColor;
    private final JMenuItem serialize;
    private final JMenuItem deserialize;
    private final JMenuItem draw;
    private final JMenuItem cover;
    private final JMenuItem deleteAll;
    private final JMenuItem deleteLast;
    private final PaintingPanel paintingPanel;
    private final ColorChoiceFrameRGB toolColor;
    private final ColorChoiceFrameHEX backgroundColor;
    private final ToolShapeChoice toolChooser;


    public MainFrame() {
        //tworzenie glownej ramki
        toolColor = new ColorChoiceFrameRGB();
        backgroundColor = new ColorChoiceFrameHEX();
        toolChooser = new ToolShapeChoice();
        paintingPanel = new PaintingPanel(WIDTH, HEIGHT, backgroundColor, toolColor, toolChooser);
        backgroundColor.registerColorGatherer(paintingPanel);
        toolColor.registerColorGatherer(paintingPanel);
        toolChooser.registerToolGatherer(paintingPanel);
        mainFrame = new JFrame("Painter");
        mainFrame.setSize(new Dimension(WIDTH, HEIGHT));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //tworzenie paska menu i glownych kategorii
        mainMenu = new JMenuBar();
        changeTool = new JMenu("Painting options");
        fileOperation = new JMenu("File");

        //tworzenie odpowiednich elementow do menu
        changeToolColor = new JMenuItem("Change tool color");
        changeToolColor.addActionListener(e -> toolColor.setVisibility());

        changeToolType = new JMenuItem("Change tool shape");
        changeToolType.addActionListener(e->toolChooser.setVisibility());

        changeBackgroundColor = new JMenuItem("Change background color");
        changeBackgroundColor.addActionListener(e -> backgroundColor.setVisibility());

        serialize = new JMenuItem("Serialize");
        serialize.addActionListener(e -> FileOperations.chooseFile());

        deserialize = new JMenuItem("Deserialize");
        deserialize.addActionListener(e -> FileOperations.saveFile());

        draw = new JMenuItem("Draw");
        draw.addActionListener(e->paintingPanel.allowCovering());
        cover = new JMenuItem("Cover");
        cover.addActionListener(e->paintingPanel.dissallowCovering());
        deleteLast = new JMenuItem("Delete last drawn shape"); // TODO: 25.12.2021 delete last drawn shape from board
        deleteAll = new JMenuItem("Delete all drawn shapes"); // TODO: 25.12.2021 clear entire board


        //dodawanie elementow do ramki glownej i odpowiednich menu
        mainFrame.setResizable(true);
        mainFrame.setJMenuBar(mainMenu);
        mainFrame.add(BorderLayout.CENTER, paintingPanel);
        fileOperation.add(serialize);
        fileOperation.add(deserialize);
        changeTool.add(draw);
        changeTool.add(cover);
        changeTool.add(deleteLast);
        changeTool.add(deleteAll);
        changeTool.add(changeToolType);
        changeTool.add(changeToolColor);
        changeTool.add(changeBackgroundColor);
        mainMenu.add(changeTool);
        mainMenu.add(fileOperation);
        mainFrame.setVisible(true);
    }

}
