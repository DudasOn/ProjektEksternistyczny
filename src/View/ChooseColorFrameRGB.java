package View;

import javax.swing.*;
import java.awt.*;

public class ChooseColorFrameRGB{

    private final JFrame chooseColorFrame;
    private final JPanel chooseColorPanel;
    private final JButton okButton;
    private final JSlider rSlider;
    private final JSlider gSlider;
    private final JSlider bSlider;

    private final JLabel rLabel;
    private final JLabel gLabel;
    private final JLabel bLabel;

    private final int HEIGHT=300;
    private final int WIDTH = 250;


    public ChooseColorFrameRGB(){

        chooseColorFrame = new JFrame("Choose desired color");
        chooseColorFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        chooseColorFrame.setSize(new Dimension(WIDTH, HEIGHT));
        chooseColorFrame.setResizable(false);
        chooseColorPanel = new JPanel();
        okButton = new JButton("OK");
        rSlider =new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        gSlider =new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        bSlider =new JSlider(JSlider.HORIZONTAL, 0, 255, 0);

        rLabel= new JLabel("Red: ");
        gLabel= new JLabel("Green: ");
        bLabel= new JLabel("Blue: ");

        okButton.addActionListener(e->{
            setColor();
            setVisibility();
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
        chooseColorFrame.add(chooseColorPanel);

    }

    public void setColor(){
        System.out.println(rSlider.getValue()+" "+ gSlider.getValue()+" "+ bSlider.getValue());
    }

    public void setVisibility(){
        if(chooseColorFrame.isShowing()) chooseColorFrame.setVisible(false);
        else chooseColorFrame.setVisible(true);
    }

}
