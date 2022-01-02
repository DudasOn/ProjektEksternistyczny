package view;

import model.Serializer;
import view.choiceAssistant.ColorChoiceFrameHEX;
import view.choiceAssistant.ColorChoiceFrameRGB;
import view.choiceAssistant.ToolPropertiesChoice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainFrame extends JFrame{

    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private final JMenuBar mainMenu;
    private final JMenu changeTool;
    private final JMenu fileOperation;
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
    private final ToolPropertiesChoice toolChooser;


    public MainFrame() {
        //tworzenie glownej ramki
        toolColorChooser = new ColorChoiceFrameRGB();
        backgroundColorChooser = new ColorChoiceFrameHEX();
        toolChooser = new ToolPropertiesChoice();
        paintingPanel = new PaintingPanel(WIDTH, HEIGHT, backgroundColorChooser.getColor(), toolColorChooser.getColor(), toolChooser.getTool(), toolChooser.getIfFilledIn());
        backgroundColorChooser.registerColorGatherer(this);
        toolColorChooser.registerColorGatherer(this);
        toolChooser.registerToolGatherer(this);
        this.setTitle("Painter");
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
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
        changeToolColor.addActionListener(e -> toolColorChooser.setVisibility());

        changeToolType = new JMenuItem("Change tool properties");
        changeToolType.addActionListener(e->toolChooser.setVisibility());

        changeBackgroundColor = new JMenuItem("Change background color");
        changeBackgroundColor.addActionListener(e -> backgroundColorChooser.setVisibility());

        serializeTo = new JMenuItem("Save drawn shapes");
        serializeTo.addActionListener(e -> FileOperations.saveSerFiles(paintingPanel.getArrayOfDrawables()));

        deserializeFrom = new JMenuItem("Load drawn shapes");
        deserializeFrom.addActionListener(e -> paintingPanel.setArrayOfDrawables(FileOperations.readSerFile()));

        deserializeStationary = new JMenuItem("Get previously drawn shapes");
        deserializeStationary.addActionListener(e-> paintingPanel.setArrayOfDrawables(Serializer.deserialize()));

        saveToJPEG = new JMenuItem("Export entire project to JPEG");
        saveToJPEG.addActionListener(e->FileOperations.saveJPEG(paintingPanel));

        draw = new JMenuItem("Draw");
        draw.addActionListener(e->paintingPanel.allowCovering());

        cover = new JMenuItem("Cover");
        cover.addActionListener(e->paintingPanel.disallowCovering());

        deleteLast = new JMenuItem("Delete last drawn shape");
        deleteLast.addActionListener(e -> paintingPanel.deleteLast());

        deleteAll = new JMenuItem("Delete all drawn shapes");
        deleteAll.addActionListener(e -> paintingPanel.deleteAll());


        //dodawanie elementow do ramki glownej i odpowiednich menu
        this.setResizable(true);
        this.setJMenuBar(mainMenu);
        this.add(BorderLayout.CENTER, paintingPanel);

        fileOperation.add(serializeTo);
        fileOperation.add(deserializeFrom);
        fileOperation.add(deserializeStationary);
        fileOperation.add(saveToJPEG);

        changeTool.add(draw);
        changeTool.add(cover);
        changeTool.add(deleteLast);
        changeTool.add(deleteAll);
        changeTool.add(changeToolType);
        changeTool.add(changeToolColor);
        changeTool.add(changeBackgroundColor);

        mainMenu.add(changeTool);
        mainMenu.add(fileOperation);

        this.setVisible(true);
    }

    public void changeTool(){
        paintingPanel.changeTool(toolChooser.getTool(), toolChooser.getIfFilledIn());
    }

    public void changeColor(){
        paintingPanel.changeColor(backgroundColorChooser.getColor(), toolColorChooser.getColor());
    }

    public PaintingPanel getPaintingPanel() {
        return paintingPanel;
    }

    public void saveAndClose(){
        Serializer.serialize(paintingPanel.getArrayOfDrawables());
        System.exit(0);
    }
}
