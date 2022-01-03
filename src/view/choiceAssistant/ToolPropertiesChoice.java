package view.choiceAssistant;

import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ToolPropertiesChoice extends ChoiceFrame {

    private MainFrame toolGatherer;
    private final JSlider toolAtriuteSlider;
    private final JLabel chooseToolAtributeInfo;
    private final JButton circleChoiceButton;
    private final JButton triangleChoiceButton;
    private final JButton squareChoiceButton;
    private final JRadioButton filledIn;
    private final JRadioButton notFilledIn;
    private final JPanel topPanel;
    private final JPanel middlePanel;
    private final JPanel bottomPanel;

    private final String CIRCLE = "./iconImages/circle.png";
    private final String SQUARE = "./iconImages/square.png";
    private final String TRIANGLE = "./iconImages/triangle.png";
    private final int BUTTONSIDE = 75;

    private int chosenTool = 1;
    private boolean ifFilledIn = true;


    public ToolPropertiesChoice() {
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

        circleChoiceButton = new JButton(CIRCLE);
        squareChoiceButton = new JButton(SQUARE);
        triangleChoiceButton = new JButton(TRIANGLE);
        filledIn = new JRadioButton("Filled in", true);
        notFilledIn = new JRadioButton("Only outline", false);

        circleChoiceButton.setPreferredSize(new Dimension(BUTTONSIDE, BUTTONSIDE));
        squareChoiceButton.setPreferredSize(new Dimension(BUTTONSIDE, BUTTONSIDE));
        triangleChoiceButton.setPreferredSize(new Dimension(BUTTONSIDE, BUTTONSIDE));

        circleChoiceButton.addActionListener(e -> chosenTool = 1);
        squareChoiceButton.addActionListener(e -> chosenTool = 2);
        triangleChoiceButton.addActionListener(e -> chosenTool = 3);

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
            circleChoiceButton.setIcon(new ImageIcon(CIRCLE));
            circleChoiceButton.setText("");
        }

        file = new File(SQUARE);
        if (file.canRead()) {
            squareChoiceButton.setIcon(new ImageIcon(SQUARE));
            squareChoiceButton.setText("");
        }

        file = new File(TRIANGLE);
        if (file.canRead()) {
            triangleChoiceButton.setIcon(new ImageIcon(TRIANGLE));
            triangleChoiceButton.setText("");
        }

        okButton.addActionListener(e -> {
            setVisibility();
            informOfToolChange();
        });

        topPanel.add(chooseToolAtributeInfo);
        topPanel.add(toolAtriuteSlider);

        middlePanel.add(filledIn);
        middlePanel.add(notFilledIn);
        middlePanel.add(circleChoiceButton);
        middlePanel.add(squareChoiceButton);
        middlePanel.add(triangleChoiceButton);

        bottomPanel.add(okButton);

        this.add(topPanel);
        this.add(middlePanel);
        this.add(bottomPanel);
        this.pack();
    }

    public void registerToolGatherer(MainFrame toolGatherer) {
        this.toolGatherer = toolGatherer;
    }

    public void informOfToolChange() {
        toolGatherer.changeTool();
    }

    public int[] getTool() {
        return new int[]{toolAtriuteSlider.getValue(), chosenTool};
    }

    public boolean getIfFilledIn() {
        return ifFilledIn;
    }
}
