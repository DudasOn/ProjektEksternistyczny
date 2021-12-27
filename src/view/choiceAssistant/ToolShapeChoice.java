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
    private final JRadioButton filledIn;
    private final JRadioButton notFilledIn;
    private final JPanel topPanel;
    private final JPanel middlePanel;
    private final JPanel bottomPanel;

    private final String CIRCLE = "circle.png";
    private final String SQUARE = "square.png";
    private final String TRIANGLE = "triangle.png";
    private final int BUTTONSIDE = 75;

    private int chosenTool = 1;
    private boolean ifFilledIn = true;


    public ToolShapeChoice() {
        super();

        this.setTitle("Choose a tool");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        chooseToolAtributeInfo = new JLabel("This value alters the size of drawn object");
        toolAtriuteSlider = new JSlider(JSlider.HORIZONTAL, 10, 300, 50);
        toolAtriuteSlider.setMajorTickSpacing(145);
        toolAtriuteSlider.setMinorTickSpacing(10);
        toolAtriuteSlider.setPaintTicks(true);
        toolAtriuteSlider.setPaintLabels(true);


        topPanel = new JPanel();
        middlePanel = new JPanel();
        bottomPanel = new JPanel();

        circle = new JButton(CIRCLE);
        square = new JButton(SQUARE);
        triangle = new JButton(TRIANGLE);
        filledIn = new JRadioButton("Filled in", true);
        notFilledIn = new JRadioButton("Only outline", false);

        circle.setPreferredSize(new Dimension(BUTTONSIDE, BUTTONSIDE));
        square.setPreferredSize(new Dimension(BUTTONSIDE, BUTTONSIDE));
        triangle.setPreferredSize(new Dimension(BUTTONSIDE, BUTTONSIDE));

        circle.addActionListener(e -> chosenTool = 1);
        square.addActionListener(e -> chosenTool = 2);
        triangle.addActionListener(e -> chosenTool = 3);

        filledIn.addActionListener(e -> {
            ifFilledIn = true;
            filledIn.setSelected(true);
            notFilledIn.setSelected(false);
        });

        notFilledIn.addActionListener(e -> {
            ifFilledIn = false;
            filledIn.setSelected(false);
            notFilledIn.setSelected(true);
        });

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


        okButton.addActionListener(e -> {
            setVisibility();
            informOfToolChange();
        });

        topPanel.add(chooseToolAtributeInfo);
        topPanel.add(toolAtriuteSlider);
        middlePanel.add(filledIn);
        middlePanel.add(notFilledIn);
        middlePanel.add(circle);
        middlePanel.add(square);
        middlePanel.add(triangle);
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

    public int[] getTool() {
        int[] choice = {toolAtriuteSlider.getValue(), chosenTool};
        return choice;
    }

    public boolean getIfFilledIn(){
        return ifFilledIn;
    }
}
