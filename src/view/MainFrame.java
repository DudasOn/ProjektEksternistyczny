package view;

import utils.FileOperations;
import utils.Serializer;
import view.choiceAssistant.FilteringToolPropertiesChoice;
import view.choiceAssistant.ColorChoiceFrameHEX;
import view.choiceAssistant.ColorChoiceFrameRGB;
import view.choiceAssistant.DrawingToolPropertiesChoice;

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
    private final DrawingToolPropertiesChoice toolPropertiesChooser;
    private ArrayList<Object> temporaryHelpfulArray;
    private final JButton changeFunctionalityToFiltering;

    private final JMenuBar filteringMainMenu;
    private final FilteringPanel filteringPanel;
    private final FilteringToolPropertiesChoice filteringToolPropertiesChoice;
    private final JButton filteringToolOptions;
    private final JMenu filteringFileOperationsMenu;
    private final JButton changeFunctionalityToDrawing;
    private final JMenuItem filteringDeleteLast;
    private final JMenuItem filteringDeleteAll;
    private final JMenuItem filteringGetImageFromDrawing;
    private final JMenuItem filteringSerializeTo;
    private final JMenuItem filteringDeserializeFrom;
    private final JMenuItem filteringDeserializeStationary;



    public MainFrame() {
        //tworzenie glownej ramki
        this.setTitle("Painter");
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Serializer.serialize(paintingPanel.getArrayOfDrawables(), paintingPanel.getBackground());
                Serializer.saveJPEG(filteringPanel);
                System.exit(0);
            }
        });
        filteringMainMenu = new JMenuBar();
        mainMenu = new JMenuBar();


        //tworzenie elementow do malowania
        toolColorChooser = new ColorChoiceFrameRGB();
        backgroundColorChooser = new ColorChoiceFrameHEX();
        toolPropertiesChooser = new DrawingToolPropertiesChoice();
        paintingPanel = new PaintingPanel(WIDTH, HEIGHT, backgroundColorChooser.getChosenColor(), toolColorChooser.getChosenColor(), toolPropertiesChooser.getTool(), toolPropertiesChooser.getIfFilledIn());
        backgroundColorChooser.registerColorGatherer(this);
        toolColorChooser.registerColorGatherer(this);
        toolPropertiesChooser.registerToolGatherer(this);

        //tworzenie elementow do filtrowania
        filteringPanel = new FilteringPanel(WIDTH, HEIGHT,50,0);
        filteringToolPropertiesChoice = new FilteringToolPropertiesChoice();
        filteringToolPropertiesChoice.registerToolGatherer(this);

        //tworzenie paska menu do malowania
        toolOptionsMenu = new JMenu("Painting options");
        fileOperationsMenu = new JMenu("File options");

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

        changeFunctionalityToFiltering = new JButton("To filtering mode");
        this.makeButtonLookLikeJMenuItem(changeFunctionalityToFiltering);
        changeFunctionalityToFiltering.addActionListener(e->{
            this.setContentPane(filteringPanel);
            this.setJMenuBar(filteringMainMenu);
            this.invalidate();
            this.validate();
        });

        //tworzenie paska menu do filtrowania
        filteringToolOptions = new JButton("Change filtering options");
        this.makeButtonLookLikeJMenuItem(filteringToolOptions);
        filteringToolOptions.addActionListener(e->filteringToolPropertiesChoice.setVisibility());

        filteringFileOperationsMenu = new JMenu("File options");

        filteringDeleteLast = new JMenuItem("Delete last drawn shape");
        filteringDeleteLast.addActionListener(e -> filteringPanel.deleteLast());

        filteringDeleteAll = new JMenuItem("Delete all drawn shapes");
        filteringDeleteAll.addActionListener(e -> filteringPanel.deleteAll());

        filteringGetImageFromDrawing = new JMenuItem("Get current image from drawing app");
        filteringGetImageFromDrawing.addActionListener(e->filteringPanel.setImage(paintingPanel.getPaintingPanelAsPicture()));

        filteringSerializeTo = new JMenuItem("Save filtered image");
        filteringSerializeTo.addActionListener(e -> FileOperations.saveJPEG(filteringPanel));

        filteringDeserializeFrom = new JMenuItem("Load saved image");
        filteringDeserializeFrom.addActionListener(e -> filteringPanel.setImage(FileOperations.readJPEG()));

        filteringDeserializeStationary = new JMenuItem("Get previously filtered image");
        filteringDeserializeStationary.addActionListener(e -> filteringPanel.setImage(Serializer.readJPEG()));

        changeFunctionalityToDrawing = new JButton("To drawing mode");
        this.makeButtonLookLikeJMenuItem(changeFunctionalityToDrawing);
        changeFunctionalityToDrawing.addActionListener(e->{
            this.setContentPane(paintingPanel);
            this.setJMenuBar(mainMenu);
            this.invalidate();
            this.validate();
        });


        //dodawanie elementow do ramki glownej i odpowiednich menu

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

        mainMenu.add(changeFunctionalityToFiltering);
        mainMenu.add(toolOptionsMenu);
        mainMenu.add(fileOperationsMenu);

        filteringFileOperationsMenu.add(filteringSerializeTo);
        filteringFileOperationsMenu.add(filteringDeserializeFrom);
        filteringFileOperationsMenu.add(filteringDeserializeStationary);
        filteringFileOperationsMenu.add(filteringGetImageFromDrawing);

        filteringMainMenu.add(changeFunctionalityToDrawing);
        filteringMainMenu.add(filteringToolOptions);
        filteringMainMenu.add(filteringFileOperationsMenu);

        this.setResizable(true);
        this.setJMenuBar(mainMenu);
        this.add(BorderLayout.CENTER, paintingPanel);
        this.setLocationRelativeTo(null); //opens the window in the middle of the screen, regardless of resolution
        this.setVisible(true);
    }

    private void makeButtonLookLikeJMenuItem(JButton button){
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setRolloverEnabled(true);
        button.setBorderPainted(false);
    }

    private void setBackgroundValueWhileLoading(){
        paintingPanel.loadFromFile(temporaryHelpfulArray);
        if (temporaryHelpfulArray != null) backgroundColorChooser.setChosenColor((Color) temporaryHelpfulArray.get(temporaryHelpfulArray.size() - 1));
    }

    public void changeTool() {
        paintingPanel.changeTool(toolPropertiesChooser.getTool(), toolPropertiesChooser.getIfFilledIn());
    }

    public void changeFilter(){}

    public void changeColor() {
        paintingPanel.changeColor(backgroundColorChooser.getChosenColor(), toolColorChooser.getChosenColor());
    }

    public PaintingPanel getPaintingPanel() {
        return paintingPanel;
    }
}
