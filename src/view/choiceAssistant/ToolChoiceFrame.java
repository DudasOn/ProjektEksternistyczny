package view.choiceAssistant;

import view.MainFrame;

import javax.swing.*;

public abstract class ToolChoiceFrame extends ChoiceFrame {
    protected MainFrame toolGatherer;
    protected JSlider toolAttriuteSlider;
    protected JLabel chooseToolAttributeInfo;

    protected JPanel topPanel;
    protected JPanel middlePanel;
    protected JPanel bottomPanel;

    public ToolChoiceFrame() {
        super();

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        topPanel = new JPanel();
        middlePanel = new JPanel();
        bottomPanel = new JPanel();

        chooseToolAttributeInfo = new JLabel("Tool attribute: 50");
        toolAttriuteSlider = new JSlider(JSlider.HORIZONTAL, 10, 300, 50);
        toolAttriuteSlider.setMajorTickSpacing(145);
        toolAttriuteSlider.setMinorTickSpacing(10);
        toolAttriuteSlider.setPaintTicks(true);
        toolAttriuteSlider.setPaintLabels(true);
        toolAttriuteSlider.addChangeListener(e -> chooseToolAttributeInfo.setText("Tool attribute: " + toolAttriuteSlider.getValue()));
    }

    public void registerToolGatherer(MainFrame toolGatherer) {
        this.toolGatherer = toolGatherer;
    }
}
