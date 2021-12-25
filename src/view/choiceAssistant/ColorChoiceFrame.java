package view.choiceAssistant;

import view.PaintingPanel;
import javax.swing.*;
import java.awt.*;

public abstract class ColorChoiceFrame extends ChoiceFrame {

    protected JPanel chooseColorPanel;

    protected PaintingPanel colorGatherer;

    public ColorChoiceFrame(){
        super();

        this.setTitle("Choose a color");
        chooseColorPanel = new JPanel();

        okButton.addActionListener(e -> {
            setVisibility();
            informOfColorChange();
        });
    }

    public void registerColorGatherer(PaintingPanel colorGatherer){
        this.colorGatherer=colorGatherer;
    }

    public abstract void informOfColorChange();
    public abstract Color getColor();
}
