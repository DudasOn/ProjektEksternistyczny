package view.choiceAssistant;

import view.MainFrame;

import javax.swing.*;
import java.awt.*;

public abstract class ColorChoiceFrame extends ChoiceFrame {

    protected JPanel chooseColorPanel;
    protected JLabel colorPreviewLabel;
    protected MainFrame colorGatherer;

    protected final int COLORPREVIEWLABELHEIGHT = 50;
    protected final int COLORPREVIEWLABELWIDTH = 50;
    protected Color chosenColor;


    public ColorChoiceFrame() {
        super();

        this.setTitle("Choose a color");
        chooseColorPanel = new JPanel();
        colorPreviewLabel = new JLabel("Color", SwingConstants.CENTER);
        colorPreviewLabel.setPreferredSize(new Dimension(COLORPREVIEWLABELWIDTH, COLORPREVIEWLABELHEIGHT));
        colorPreviewLabel.setBackground(Color.WHITE);
        colorPreviewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        colorPreviewLabel.setOpaque(true);

        okButton.addActionListener(e -> {
            setVisibility();
            informOfColorChange();

        });

        chosenColor = new Color(255, 255, 255);
    }

    public void registerColorGatherer(MainFrame colorGatherer) {
        this.colorGatherer = colorGatherer;
    }

    public abstract void informOfColorChange();

    public Color getChosenColor() {
        return chosenColor;
    }

    protected void changeColorOfPreviewLabel() {
        colorPreviewLabel.setForeground(new Color(255 - colorPreviewLabel.getBackground().getRed(), 255 - colorPreviewLabel.getBackground().getGreen(), 255 - colorPreviewLabel.getBackground().getBlue()));
    }
}
