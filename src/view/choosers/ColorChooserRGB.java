package view.choosers;

import javax.swing.*;
import java.awt.*;

public class ColorChooserRGB extends ColorChooserFrame {


    private final JSlider rSlider;
    private final JSlider gSlider;
    private final JSlider bSlider;

    private final JLabel rLabel;
    private final JLabel gLabel;
    private final JLabel bLabel;

    public ColorChooserRGB() {
        super();

        rSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 255);
        gSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 255);
        bSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 255);

        rLabel = new JLabel("Red: ");
        gLabel = new JLabel("Green: ");
        bLabel = new JLabel("Blue: ");


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

        chooseColorPanel.add(okButton);
        this.add(chooseColorPanel);

    }

    public void informOfColorChange(){
        colorGatherer.changeColor();
    }

    @Override
    public Color getColor() {
        return new Color(rSlider.getValue(),gSlider.getValue(),bSlider.getValue());
    }

}
