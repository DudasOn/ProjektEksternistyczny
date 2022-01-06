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

    private final JMenuBar paintingMainMenu;
    private final JMenu paintingToolOptionsMenu;
    private final JMenu paintingFileOperationsMenu;
    private final JMenuItem paintingChangeToolType;
    private final JMenuItem paintingChangeToolColor;
    private final JMenuItem paintingChangeBackgroundColor;
    private final JMenuItem paintingSerializeTo;
    private final JMenuItem paintingDeserializeFrom;
    private final JMenuItem paintingDeserializeStationary;
    private final JMenuItem paintingSaveToJPEG;
    private final JMenuItem paintingDrawOption;
    private final JMenuItem paintingCoverOption;
    private final JMenuItem paintingDeleteAll;
    private final JMenuItem paintingDeleteLast;
    private final PaintingPanel paintingPanel;
    private final ColorChoiceFrameRGB toolColorChooser;
    private final ColorChoiceFrameHEX backgroundColorChooser;
    private final DrawingToolPropertiesChoice toolPropertiesChooser;
    private ArrayList<Object> paintingTemporaryHelpfulArray;
    private final JButton changeFunctionalityToFiltering;

    private final JMenuBar filteringMainMenu;
    private final FilteringPanel filteringPanel;
    private final FilteringToolPropertiesChoice filteringToolPropertiesChoice;
    private final JButton filteringToolOptions;
    private final JMenu filteringFileOperationsMenu;
    private final JMenuItem filteringDeleteLast;
    private final JMenuItem filteringDeleteAll;
    private final JMenuItem filteringGetImageFromDrawing;
    private final JMenuItem filteringSerializeTo;
    private final JMenuItem filteringDeserializeFrom;
    private final JMenuItem filteringDeserializeStationary;
    private final JButton changeFunctionalityToDrawing;



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
        paintingMainMenu = new JMenuBar();


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
        paintingToolOptionsMenu = new JMenu("Painting options");
        paintingFileOperationsMenu = new JMenu("File options");

        paintingChangeToolColor = new JMenuItem("Change tool color");
        paintingChangeToolColor.addActionListener(e -> toolColorChooser.setVisibility());

        paintingChangeToolType = new JMenuItem("Change tool properties");
        paintingChangeToolType.addActionListener(e -> toolPropertiesChooser.setVisibility());

        paintingChangeBackgroundColor = new JMenuItem("Change background color");
        paintingChangeBackgroundColor.addActionListener(e -> backgroundColorChooser.setVisibility());

        paintingSerializeTo = new JMenuItem("Save drawn paining");
        paintingSerializeTo.addActionListener(e -> FileOperations.saveSerFiles(paintingPanel.getArrayOfDrawables(), paintingPanel.getBackground()));

        paintingDeserializeFrom = new JMenuItem("Load serialized painting");
        paintingDeserializeFrom.addActionListener(e -> {
            paintingTemporaryHelpfulArray = FileOperations.readSerFile();
            this.setBackgroundValueWhileLoading();
        });

        paintingDeserializeStationary = new JMenuItem("Get previously drawn painting");
        paintingDeserializeStationary.addActionListener(e -> {
            paintingTemporaryHelpfulArray = Serializer.deserialize();
            this.setBackgroundValueWhileLoading();
        });

        paintingSaveToJPEG = new JMenuItem("Export entire project to JPEG");
        paintingSaveToJPEG.addActionListener(e -> FileOperations.saveJPEG(paintingPanel));

        paintingDrawOption = new JMenuItem("Draw");
        paintingDrawOption.addActionListener(e -> paintingPanel.allowCovering());

        paintingCoverOption = new JMenuItem("Cover");
        paintingCoverOption.addActionListener(e -> paintingPanel.disallowCovering());

        paintingDeleteLast = new JMenuItem("Delete last drawn shape");
        paintingDeleteLast.addActionListener(e -> paintingPanel.deleteLast());

        paintingDeleteAll = new JMenuItem("Delete all drawn shapes");
        paintingDeleteAll.addActionListener(e -> paintingPanel.deleteAll());

        changeFunctionalityToFiltering = new JButton("To filtering mode");
        this.makeButtonLookLikeJMenuItem(changeFunctionalityToFiltering);
        changeFunctionalityToFiltering.addActionListener(e->{
            this.setContentPane(filteringPanel);
            this.setJMenuBar(filteringMainMenu);
            this.invalidate();
            this.validate();
            this.pack();
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
            this.setJMenuBar(paintingMainMenu);
            this.invalidate();
            this.validate();
            this.pack();
        });


        //dodawanie elementow do ramki glownej i odpowiednich menu

        paintingFileOperationsMenu.add(paintingSerializeTo);
        paintingFileOperationsMenu.add(paintingDeserializeFrom);
        paintingFileOperationsMenu.add(paintingDeserializeStationary);
        paintingFileOperationsMenu.add(paintingSaveToJPEG);

        paintingToolOptionsMenu.add(paintingDrawOption);
        paintingToolOptionsMenu.add(paintingCoverOption);
        paintingToolOptionsMenu.add(paintingDeleteLast);
        paintingToolOptionsMenu.add(paintingDeleteAll);
        paintingToolOptionsMenu.add(paintingChangeToolType);
        paintingToolOptionsMenu.add(paintingChangeToolColor);
        paintingToolOptionsMenu.add(paintingChangeBackgroundColor);

        paintingMainMenu.add(paintingToolOptionsMenu);
        paintingMainMenu.add(paintingFileOperationsMenu);
        paintingMainMenu.add(changeFunctionalityToFiltering);

        filteringFileOperationsMenu.add(filteringSerializeTo);
        filteringFileOperationsMenu.add(filteringDeserializeFrom);
        filteringFileOperationsMenu.add(filteringDeserializeStationary);
        filteringFileOperationsMenu.add(filteringGetImageFromDrawing);

        filteringMainMenu.add(filteringToolOptions);
        filteringMainMenu.add(filteringFileOperationsMenu);
        filteringMainMenu.add(changeFunctionalityToDrawing);

        this.setResizable(true);
        this.setJMenuBar(paintingMainMenu);
        this.setContentPane(paintingPanel);
        this.setLocationRelativeTo(null); //opens the window in the middle of the screen, regardless of resolution
        this.pack();
        paintingPanel.requestFocus();
        this.setVisible(true);
    }

    private void makeButtonLookLikeJMenuItem(JButton button){
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setRolloverEnabled(true);
        button.setBorderPainted(false);
    }

    private void setBackgroundValueWhileLoading(){
        paintingPanel.loadFromFile(paintingTemporaryHelpfulArray);
        if (paintingTemporaryHelpfulArray != null) backgroundColorChooser.setChosenColor((Color) paintingTemporaryHelpfulArray.get(paintingTemporaryHelpfulArray.size() - 1));
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
