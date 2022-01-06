package view.choiceAssistant;

import view.MainFrame;

import javax.swing.*;

public abstract class ToolChoiceFrame extends ChoiceFrame{
    protected MainFrame toolGatherer;
    protected JSlider toolAtriuteSlider;
    protected JLabel chooseToolAtributeInfo;

    protected JPanel topPanel;
    protected JPanel middlePanel;
    protected JPanel bottomPanel;

    public ToolChoiceFrame(){
        super();

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        topPanel = new JPanel();
        middlePanel = new JPanel();
        bottomPanel = new JPanel();

        chooseToolAtributeInfo = new JLabel("Tool attribute: 50");
        toolAtriuteSlider = new JSlider(JSlider.HORIZONTAL, 10, 300, 50);
        toolAtriuteSlider.setMajorTickSpacing(145);
        toolAtriuteSlider.setMinorTickSpacing(10);
        toolAtriuteSlider.setPaintTicks(true);
        toolAtriuteSlider.setPaintLabels(true);
        toolAtriuteSlider.addChangeListener(e -> chooseToolAtributeInfo.setText("Tool attribute: " + toolAtriuteSlider.getValue()));
    }

    public void registerToolGatherer(MainFrame toolGatherer) {
        this.toolGatherer = toolGatherer;
    }


}
