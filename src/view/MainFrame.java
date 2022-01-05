package view;

import utils.FileOperations;
import utils.Serializer;
import view.choiceAssistant.ColorChoiceFrameHEX;
import view.choiceAssistant.ColorChoiceFrameRGB;
import view.choiceAssistant.ToolPropertiesChoice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class MainFrame extends JFrame {

    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private final JMenuBar mainMenu;
    private final JMenu toolOptionsMenu;
    private final JMenu fileOperationsMenu;
    private final JMenuItem changeToolType;
    private final JMenuItem changeToolColor;
    private final JMenuItem changeBackgroundColor;
    private final JMenuItem serializeTo;
    private final JMenuItem deserializeFrom;
    private final JMenuItem deserializeStationary;
    private final JMenuItem saveToJPEG;
    private final JMenuItem draw;
    private final JMenuItem cover;
    private final JMenuItem deleteAll;
    private final JMenuItem deleteLast;
    private final PaintingPanel paintingPanel;
    private final ColorChoiceFrameRGB toolColorChooser;
    private final ColorChoiceFrameHEX backgroundColorChooser;
    private final ToolPropertiesChoice toolPropertiesChooser;
    private ArrayList<Object> temporaryHelpfulArray;


    public MainFrame() {
        //tworzenie glownej ramki
        toolColorChooser = new ColorChoiceFrameRGB();
        backgroundColorChooser = new ColorChoiceFrameHEX();
        toolPropertiesChooser = new ToolPropertiesChoice();
        paintingPanel = new PaintingPanel(WIDTH, HEIGHT, backgroundColorChooser.getChosenColor(), toolColorChooser.getChosenColor(), toolPropertiesChooser.getTool(), toolPropertiesChooser.getIfFilledIn());
        backgroundColorChooser.registerColorGatherer(this);
        toolColorChooser.registerColorGatherer(this);
        toolPropertiesChooser.registerToolGatherer(this);
        this.setTitle("Painter");
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Serializer.serialize(paintingPanel.getArrayOfDrawables(), paintingPanel.getBackground());
                System.exit(0);
            }
        });


        //tworzenie paska menu i glownych kategorii
        mainMenu = new JMenuBar();
        toolOptionsMenu = new JMenu("Painting options");
        fileOperationsMenu = new JMenu("File");

        //tworzenie odpowiednich elementow do menu
        changeToolColor = new JMenuItem("Change tool color");
        changeToolColor.addActionListener(e -> toolColorChooser.setVisibility());

        changeToolType = new JMenuItem("Change tool properties");
        changeToolType.addActionListener(e -> toolPropertiesChooser.setVisibility());

        changeBackgroundColor = new JMenuItem("Change background color");
        changeBackgroundColor.addActionListener(e -> backgroundColorChooser.setVisibility());

        serializeTo = new JMenuItem("Save drawn paining");
        serializeTo.addActionListener(e -> FileOperations.saveSerFiles(paintingPanel.getArrayOfDrawables(), paintingPanel.getBackground()));

        deserializeFrom = new JMenuItem("Load serialized painting");
        deserializeFrom.addActionListener(e -> {
            temporaryHelpfulArray = FileOperations.readSerFile();
            this.setBackgroundValueWhileLoading();
        });

        deserializeStationary = new JMenuItem("Get previously drawn painting");
        deserializeStationary.addActionListener(e -> {
            temporaryHelpfulArray = Serializer.deserialize();
            this.setBackgroundValueWhileLoading();
        });

        saveToJPEG = new JMenuItem("Export entire project to JPEG");
        saveToJPEG.addActionListener(e -> FileOperations.saveJPEG(paintingPanel));

        draw = new JMenuItem("Draw");
        draw.addActionListener(e -> paintingPanel.allowCovering());

        cover = new JMenuItem("Cover");
        cover.addActionListener(e -> paintingPanel.disallowCovering());

        deleteLast = new JMenuItem("Delete last drawn shape");
        deleteLast.addActionListener(e -> paintingPanel.deleteLast());

        deleteAll = new JMenuItem("Delete all drawn shapes");
        deleteAll.addActionListener(e -> paintingPanel.deleteAll());


        //dodawanie elementow do ramki glownej i odpowiednich menu
        this.setResizable(true);
        this.setJMenuBar(mainMenu);
        this.add(BorderLayout.CENTER, paintingPanel);

        fileOperationsMenu.add(serializeTo);
        fileOperationsMenu.add(deserializeFrom);
        fileOperationsMenu.add(deserializeStationary);
        fileOperationsMenu.add(saveToJPEG);

        toolOptionsMenu.add(draw);
        toolOptionsMenu.add(cover);
        toolOptionsMenu.add(deleteLast);
        toolOptionsMenu.add(deleteAll);
        toolOptionsMenu.add(changeToolType);
        toolOptionsMenu.add(changeToolColor);
        toolOptionsMenu.add(changeBackgroundColor);

        mainMenu.add(toolOptionsMenu);
        mainMenu.add(fileOperationsMenu);

        this.setLocationRelativeTo(null); //opens the window in the middle of the screen, regardless of resolution
        this.setVisible(true);
    }

    private void setBackgroundValueWhileLoading(){
        paintingPanel.loadFromFile(temporaryHelpfulArray);
        if (temporaryHelpfulArray != null) backgroundColorChooser.setChosenColor((Color) temporaryHelpfulArray.get(temporaryHelpfulArray.size() - 1));
    }

    public void changeTool() {
        paintingPanel.changeTool(toolPropertiesChooser.getTool(), toolPropertiesChooser.getIfFilledIn());
    }

    public void changeColor() {
        paintingPanel.changeColor(backgroundColorChooser.getChosenColor(), toolColorChooser.getChosenColor());
    }

    public PaintingPanel getPaintingPanel() {
        return paintingPanel;
    }
}
