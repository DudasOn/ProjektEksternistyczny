package view.chooseColorFrame;

import view.ColorConverter;

import javax.swing.*;
import java.awt.*;

public class ChooseColorHEX extends ChooseColorFrame{

    private final JTextField colorValueArea;
    private final JLabel initialInfo;
    private final JLabel adequateInfo;
    private final JButton checkButton;
    private final JPanel middlePanel;
    private final JPanel bottomPanel;

    public ChooseColorHEX() {

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        bottomPanel = new JPanel();
        middlePanel = new JPanel();
        colorValueArea = new JTextField(6);
        colorValueArea.setFont(new Font("Arial",1,30));
        initialInfo = new JLabel("Enter value of desired HEX color");
        adequateInfo = new JLabel();
        checkButton = new JButton("Check");
        okButton.setVisible(false);
        checkButton.addActionListener(e->{

            if(colorValueArea.getText().length()==6) {
                if(checkIfValueIsCorrect(colorValueArea.getText().toUpperCase())) {
                    okButton.setVisible(true);
                    adequateInfo.setText("<html>Value is correct!<br>Press OK to set the color<html>");
                }
                else adequateInfo.setText("<html>Incorrect input value!<br>Please try again!<html>");
            }
                else adequateInfo.setText("<html>Incorrect number of characters!<br>Please try again<html>");
        });

        chooseColorPanel.add(initialInfo);
        chooseColorPanel.add(colorValueArea);
        chooseColorPanel.add(checkButton);
        middlePanel.add(adequateInfo);
        bottomPanel.add(okButton);

        this.add(chooseColorPanel);
        this.add(middlePanel);
        this.add(bottomPanel);
    }

    public boolean checkIfValueIsCorrect(String string){
        int checker=0;
        char[] charOfString = string.toCharArray();

        char[] possibleValues = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        for(int i=0;i<charOfString.length;i++){
            for(int j=0;j<possibleValues.length;j++){
                if(charOfString[i]==possibleValues[j]) checker++;
            }
        }

        if(checker==string.length()) return true;
        else return false;
    }

    public void informOfColorChange(){
        colorGatherer.changeColor(ColorConverter.getColor("#"+colorValueArea.getText().toUpperCase()));
        okButton.setVisible(false);
        colorValueArea.setText("");
        adequateInfo.setText("");
    }
}
