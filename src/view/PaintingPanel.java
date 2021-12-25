package view;

import observerInterface.Observer;
import view.choosers.ColorChooserFrame;
import view.choosers.ToolChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PaintingPanel extends JPanel implements MouseListener, Observer {

    private final ColorChooserFrame backgroundColorChanger;
    private final ColorChooserFrame toolsColorChanger;
    private final ToolChooser toolChooser;
    private static Object[] dataAboutCurrentObject;

    public PaintingPanel(int width, int height, ColorChooserFrame backgroundColorChanger, ColorChooserFrame objectsColor, ToolChooser toolChooser) {
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(true);
        this.addMouseListener(this);
        this.backgroundColorChanger = backgroundColorChanger;
        this.toolsColorChanger = objectsColor;
        this.toolChooser=toolChooser;
        this.changeColor();
        dataAboutCurrentObject = new Object[4];
    }


    public void changeColor() {
        this.setBackground(backgroundColorChanger.getColor());
        revalidate();
        repaint();
    }

    public void changeTool(){

        for(int i=0;i<toolChooser.getTool().length;i++)
            System.out.println(toolChooser.getTool()[i]);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        dataAboutCurrentObject[0] = MouseInfo.getPointerInfo().getLocation().x;
        dataAboutCurrentObject[1] = MouseInfo.getPointerInfo().getLocation().y;
        dataAboutCurrentObject[2] = toolsColorChanger.getColor();
        dataAboutCurrentObject[3] = 0; // TODO: 25.12.2021 add chosen shape selection

        this.repaint();
    }

    public static Object[] getDataAboutCurrentObject() {
        return dataAboutCurrentObject;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void update() {

    }
}
