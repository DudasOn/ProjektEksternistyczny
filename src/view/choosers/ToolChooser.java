package view.choosers;

import model.drawableShapes.Drawable;
import view.PaintingPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ToolChooser extends ChooserFrame {

    private PaintingPanel toolGatherer;
    private final JSlider toolAtriuteSlider;
    private final JLabel chooseToolAtributeInfo;
    private JButton circle;
    private JButton triangle;
    private JButton square;
    private JButton line;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;

    private String CIRCLE = "circle.png";
    private String SQUARE = "square.png";
    private String TRIANGLE = "triangle.png";
    private String LINE = "line.png";
    private int BUTTONSIDE = 75;

    private int chosenTool = 1;


    public ToolChooser() {
        super();
        this.setTitle("Choose a tool");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        chooseToolAtributeInfo = new JLabel("This value alters the size of drawn object");
        toolAtriuteSlider = new JSlider(JSlider.HORIZONTAL, 1, 25, 1);


        topPanel = new JPanel();
        middlePanel = new JPanel();
        bottomPanel = new JPanel();

        circle = new JButton(CIRCLE);
        square = new JButton(SQUARE);
        triangle = new JButton(TRIANGLE);
        line = new JButton(LINE);


        circle.setPreferredSize(new Dimension(BUTTONSIDE, BUTTONSIDE));
        square.setPreferredSize(new Dimension(BUTTONSIDE, BUTTONSIDE));
        triangle.setPreferredSize(new Dimension(BUTTONSIDE, BUTTONSIDE));
        line.setPreferredSize(new Dimension(BUTTONSIDE, BUTTONSIDE));

        circle.addActionListener(e -> chosenTool = 1);
        square.addActionListener(e -> chosenTool = 2);
        triangle.addActionListener(e -> chosenTool = 3);
        line.addActionListener(e -> chosenTool = 4);

        File file = new File(CIRCLE);
        if (file.canRead()) {
            circle.setIcon(new ImageIcon(CIRCLE));
            circle.setText("");
        }

        file = new File(SQUARE);
        if (file.canRead()) {
            square.setIcon(new ImageIcon(SQUARE));
            square.setText("");
        }

        file = new File(TRIANGLE);
        if (file.canRead()) {
            triangle.setIcon(new ImageIcon(TRIANGLE));
            triangle.setText("");
        }

        file = new File(LINE);
        if (file.canRead()) {
            line.setIcon(new ImageIcon(LINE));
            line.setText("");
        }

        okButton.addActionListener(e -> {
            setVisibility();
            informOfToolChange();
        });

        topPanel.add(chooseToolAtributeInfo);
        topPanel.add(toolAtriuteSlider);
        middlePanel.add(circle);
        middlePanel.add(square);
        middlePanel.add(triangle);
        middlePanel.add(line);
        bottomPanel.add(okButton);
        this.add(topPanel);
        this.add(middlePanel);
        this.add(bottomPanel);

        this.pack();
    }

    public void registerToolGatherer(PaintingPanel toolGatherer) {
        this.toolGatherer = toolGatherer;
    }

    public void informOfToolChange() {
        toolGatherer.changeTool();
    }
    public int[] getTool(){
        int[] choice ={toolAtriuteSlider.getValue(), chosenTool};

        return choice;
    }
}
