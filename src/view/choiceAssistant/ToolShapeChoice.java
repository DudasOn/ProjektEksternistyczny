package view.choiceAssistant;

import view.PaintingPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ToolShapeChoice extends ChoiceFrame {

    private PaintingPanel toolGatherer;
    private final JSlider toolAtriuteSlider;
    private final JLabel chooseToolAtributeInfo;
    private final JButton circle;
    private final JButton triangle;
    private final JButton square;
    private final JButton line;
    private final JPanel topPanel;
    private final JPanel middlePanel;
    private final JPanel bottomPanel;

    private final String CIRCLE = "circle.png";
    private final String SQUARE = "square.png";
    private final String TRIANGLE = "triangle.png";
    private final String LINE = "line.png";
    private final int BUTTONSIDE = 75;

    private int chosenTool = 1;


    public ToolShapeChoice() {
        super();
        this.setTitle("Choose a tool");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        chooseToolAtributeInfo = new JLabel("This value alters the size of drawn object");
        toolAtriuteSlider = new JSlider(JSlider.HORIZONTAL, 20, 200, 50);
        toolAtriuteSlider.setMajorTickSpacing(180);
        toolAtriuteSlider.setMinorTickSpacing(20);
        toolAtriuteSlider.setPaintTicks(true);
        toolAtriuteSlider.setPaintLabels(true);


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
