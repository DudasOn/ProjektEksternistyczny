package View;

import Model.ColorConverter;
import ObserverInterface.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PaintingPanel extends JPanel implements MouseListener, Observer {

    ChooseColorFrameRGB backgroundColor;

    public PaintingPanel(int width, int height, ChooseColorFrameRGB backgroundColor) {
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(true);
        this.addMouseListener(this);
        this.backgroundColor=backgroundColor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.repaint();
        System.out.println("X: " + MouseInfo.getPointerInfo().getLocation().getX());
        System.out.println("Y: " + MouseInfo.getPointerInfo().getLocation().getY());
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
        this.setBackground(new ColorConverter(backgroundColor.getRValue(), backgroundColor.getGValue(), backgroundColor.getBValue()).getColor());
        revalidate();
        repaint();
    }

}
