package view.choiceAssistant;

import javax.swing.*;
import java.awt.*;

public abstract class ChoiceFrame extends JFrame {

    protected JButton okButton;

    protected final int HEIGHT = 300;
    protected final int WIDTH = 250;

    public ChoiceFrame() {
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setResizable(false);
        this.setAlwaysOnTop(true);

        okButton = new JButton("OK");
    }

    public void setVisibility() {
        if (this.isShowing()) this.setVisible(false);
        else this.setVisible(true);
    }
}
