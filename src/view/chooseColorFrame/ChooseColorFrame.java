package view.chooseColorFrame;

import view.PaintingPanel;
import javax.swing.*;
import java.awt.*;

public abstract class ChooseColorFrame extends JFrame {

    protected final int HEIGHT = 300;
    protected final int WIDTH = 250;

    protected JPanel chooseColorPanel;
    protected JButton okButton;


    protected PaintingPanel colorGatherer;

    public ChooseColorFrame(){
        this.setTitle("Choose a color");
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setSize(new Dimension(WIDTH, HEIGHT));

        chooseColorPanel = new JPanel();
        okButton = new JButton("OK");
        this.setResizable(false);
        this.setAlwaysOnTop(true);

        okButton.addActionListener(e -> {
            setVisibility();
            informOfColorChange();
        });
    }

    public void setVisibility() {
        if (this.isShowing()) this.setVisible(false);
        else this.setVisible(true);
    }

    public void registerColorGatherer(PaintingPanel colorGatherer){
        this.colorGatherer=colorGatherer;
    }

    public abstract void informOfColorChange();
}
