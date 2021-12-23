package View;

import ObserverInterface.Observable;
import ObserverInterface.Observer;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChooseColorFrameRGB extends JFrame implements Observable {

    private ArrayList<Observer> observers;

    private final JPanel chooseColorPanel;
    private final JButton okButton;
    private final JSlider rSlider;
    private final JSlider gSlider;
    private final JSlider bSlider;

    private final JLabel rLabel;
    private final JLabel gLabel;
    private final JLabel bLabel;

    private final int HEIGHT = 300;
    private final int WIDTH = 250;

    public ChooseColorFrameRGB() {
        observers = new ArrayList<>();
        this.setTitle("Choose a color");
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setResizable(false);
        chooseColorPanel = new JPanel();
        okButton = new JButton("OK");
        rSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        gSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        bSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);

        rLabel = new JLabel("Red: ");
        gLabel = new JLabel("Green: ");
        bLabel = new JLabel("Blue: ");

        okButton.addActionListener(e -> {
            setColor();
            setVisibility();
            notifyObservers();
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

        chooseColorPanel.add(okButton);
        this.add(chooseColorPanel);

    }

    public void setColor() {
        System.out.println(rSlider.getValue() + " " + gSlider.getValue() + " " + bSlider.getValue());
    }

    public void setVisibility() {
        if (this.isShowing()) this.setVisible(false);
        else this.setVisible(true);
    }

    public int getRValue(){
        return rSlider.getValue();
    }

    public int getGValue(){
        return gSlider.getValue();
    }

    public int getBValue(){
        return bSlider.getValue();
    }

    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        if (observers.contains(o)){
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }
}
