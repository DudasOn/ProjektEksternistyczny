package view.choiceAssistant;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DrawingToolPropertiesChoice extends ToolChoiceFrame {


    private final JButton circleChoiceButton;
    private final JButton triangleChoiceButton;
    private final JButton squareChoiceButton;
    private final JRadioButton filledIn;
    private final JRadioButton notFilledIn;

    private final String CIRCLE = "./iconImages/circle.png";
    private final String SQUARE = "./iconImages/square.png";
    private final String TRIANGLE = "./iconImages/triangle.png";
    private final int BUTTONSIDE = 75;

    private int chosenTool = 1;
    private boolean ifFilledIn = true;


    public DrawingToolPropertiesChoice() {
        super();

        this.setTitle("Choose a drawing tool");

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
            this.setVisibility();
            this.informOfToolChange();
        });

        topPanel.add(chooseToolAttributeInfo);
        topPanel.add(toolAttriuteSlider);

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


    public void informOfToolChange() {
        toolGatherer.changeTool();
    }

    public int[] getTool() {
        return new int[]{toolAttriuteSlider.getValue(), chosenTool};
    }

    public boolean getIfFilledIn() {
        return ifFilledIn;
    }
}
