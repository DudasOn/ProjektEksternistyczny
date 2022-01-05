package view.choiceAssistant;

import javax.swing.*;
import java.awt.*;

public class ColorChoiceFrameRGB extends ColorChoiceFrame {


    private final JSlider rSlider;
    private final JSlider gSlider;
    private final JSlider bSlider;

    private final JLabel rLabel;
    private final JLabel gLabel;
    private final JLabel bLabel;

    public ColorChoiceFrameRGB() {
        super();

        rLabel = new JLabel("Red: 255");
        gLabel = new JLabel("Green: 255");
        bLabel = new JLabel("Blue: 255");

        rSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 255);
        gSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 255);
        bSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 255);

        rSlider.addChangeListener(e -> {
            changeColorOfPreviewLabel();
            rLabel.setText("Red: " + rSlider.getValue());
        });
        gSlider.addChangeListener(e -> {
            changeColorOfPreviewLabel();
            gLabel.setText("Green: " + gSlider.getValue());
        });
        bSlider.addChangeListener(e -> {
            changeColorOfPreviewLabel();
            bLabel.setText("Blue: " + bSlider.getValue());
        });

        rSlider.setMajorTickSpacing(255);
        rSlider.setMinorTickSpacing(1);
        rSlider.setPaintTicks(true);
        rSlider.setPaintLabels(true);

        gSlider.setMajorTickSpacing(255);
        gSlider.setMinorTickSpacing(1);
        gSlider.setPaintTicks(true);
        gSlider.setPaintLabels(true);


        bSlider.setMajorTickSpacing(255);
        bSlider.setMinorTickSpacing(1);
        bSlider.setPaintTicks(true);
        bSlider.setPaintLabels(true);

        chooseColorPanel.add(rLabel);
        chooseColorPanel.add(rSlider);
        chooseColorPanel.add(gLabel);
        chooseColorPanel.add(gSlider);
        chooseColorPanel.add(bLabel);
        chooseColorPanel.add(bSlider);
        chooseColorPanel.add(colorPreviewLabel);
        chooseColorPanel.add(okButton);
        this.add(chooseColorPanel);
    }

    @Override
    public void informOfColorChange() {
        chosenColor = new Color(rSlider.getValue(), gSlider.getValue(), bSlider.getValue());
        colorGatherer.changeColor();
    }

    @Override
    public void setChosenColor(Color chosenColor) {
        super.setChosenColor(chosenColor);
        rSlider.setValue(chosenColor.getRed());
        gSlider.setValue(chosenColor.getGreen());
        bSlider.setValue(chosenColor.getBlue());
    }

    @Override
    protected void changeColorOfPreviewLabel() {
        colorPreviewLabel.setBackground(new Color(rSlider.getValue(), gSlider.getValue(), bSlider.getValue()));
        super.changeColorOfPreviewLabel();
    }

}
