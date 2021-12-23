package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaintingPanel extends JPanel implements MouseListener {

    public PaintingPanel(int width, int height){
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.setBackground(Color.RED);
        this.repaint();
        System.out.println("X: " + MouseInfo.getPointerInfo().getLocation().getX());
        System.out.println("Y: "+MouseInfo.getPointerInfo().getLocation().getY());
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
}
