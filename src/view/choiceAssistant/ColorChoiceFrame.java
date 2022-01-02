package view.choiceAssistant;

import view.PaintingPanel;

import javax.swing.*;
import java.awt.*;

public abstract class ColorChoiceFrame extends ChoiceFrame {

    protected JPanel chooseColorPanel;
    protected JLabel colorPreviewLabel;
    protected PaintingPanel colorGatherer;

    protected final int COLORPREVIEWLABELHEIGHT = 50;
    protected final int COLORPREVIEWLABELWIDTH = 50;


    public ColorChoiceFrame() {
        super();

        this.setTitle("Choose a color");
        chooseColorPanel = new JPanel();
        colorPreviewLabel = new JLabel("   Color");
        colorPreviewLabel.setPreferredSize(new Dimension(COLORPREVIEWLABELWIDTH, COLORPREVIEWLABELHEIGHT));
        colorPreviewLabel.setBackground(Color.WHITE);
        colorPreviewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        colorPreviewLabel.setOpaque(true);

        okButton.addActionListener(e -> {
            setVisibility();
            informOfColorChange();
        });
    }

    public void registerColorGatherer(PaintingPanel colorGatherer) {
        this.colorGatherer = colorGatherer;
    }

    public abstract void informOfColorChange();

    public abstract Color getColor();

    protected void changeColorOfPreviewLabel() {
        colorPreviewLabel.setForeground(new Color(255 - colorPreviewLabel.getBackground().getRed(), 255 - colorPreviewLabel.getBackground().getGreen(), 255 - colorPreviewLabel.getBackground().getBlue()));
    }
}
