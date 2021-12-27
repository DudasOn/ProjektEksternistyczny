package view;

import model.Serializer;
import view.choiceAssistant.ColorChoiceFrameHEX;
import view.choiceAssistant.ColorChoiceFrameRGB;
import view.choiceAssistant.ToolShapeChoice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


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
    private final JMenuItem serializeTo;
    private final JMenuItem deserializeFrom;
    private final JMenuItem deserializeStationary;
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
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                saveAndClose();
            }
        });


        //tworzenie paska menu i glownych kategorii
        mainMenu = new JMenuBar();
        changeTool = new JMenu("Painting options");
        fileOperation = new JMenu("File");

        //tworzenie odpowiednich elementow do menu
        changeToolColor = new JMenuItem("Change tool color");
        changeToolColor.addActionListener(e -> toolColor.setVisibility());

        changeToolType = new JMenuItem("Change tool properties");
        changeToolType.addActionListener(e->toolChooser.setVisibility());

        changeBackgroundColor = new JMenuItem("Change background color");
        changeBackgroundColor.addActionListener(e -> backgroundColor.setVisibility());

        serializeTo = new JMenuItem("Save drawn shapes");
        serializeTo.addActionListener(e -> FileOperations.saveFile(paintingPanel.getArrayOfDrawables()));

        deserializeFrom = new JMenuItem("Load drawn shapes");
        deserializeFrom.addActionListener(e -> paintingPanel.setArrayOfDrawables(FileOperations.chooseFile()));

        deserializeStationary = new JMenuItem("Get previously drawn shapes");
        deserializeStationary.addActionListener(e-> paintingPanel.setArrayOfDrawables(Serializer.deserialize()));

        draw = new JMenuItem("Draw");
        draw.addActionListener(e->paintingPanel.allowCovering());

        cover = new JMenuItem("Cover");
        cover.addActionListener(e->paintingPanel.disallowCovering());

        deleteLast = new JMenuItem("Delete last drawn shape");
        deleteLast.addActionListener(e -> paintingPanel.deleteLast());

        deleteAll = new JMenuItem("Delete all drawn shapes");
        deleteAll.addActionListener(e -> paintingPanel.deleteAll());


        //dodawanie elementow do ramki glownej i odpowiednich menu
        mainFrame.setResizable(true);
        mainFrame.setJMenuBar(mainMenu);
        mainFrame.add(BorderLayout.CENTER, paintingPanel);

        fileOperation.add(serializeTo);
        fileOperation.add(deserializeFrom);
        fileOperation.add(deserializeStationary);

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

    public PaintingPanel getPaintingPanel() {
        return paintingPanel;
    }

    public void saveAndClose(){
        Serializer.serialize(paintingPanel.getArrayOfDrawables());
        System.exit(0);
    }
}
