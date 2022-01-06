package view;

import model.paintingModel.drawableShapes.Drawable;
import observerInterface.Observer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FilteringPanel extends JPanel implements MouseListener, Observer {

    ArrayList<BufferedImage> images = new ArrayList<>();

    public FilteringPanel(int width, int height, int toolSize, int filterType){
        this.setPreferredSize(new Dimension(width, height));
        this.addMouseListener(this);

        try {
            images.add(ImageIO.read(new File("./testingPhoto.jpg")));
        } catch (IOException e) {
            System.out.println(":c");
        }

        this.setPreferredSize(getPreferredSize());
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setVisible(true);
    }

    public void changeTool(int[] toolProperties, boolean ifFilledIn) {

        //this.attributeOfChosenTool = toolProperties[0]; //tool size
        //this.typeOfChosenTool = toolProperties[1]; //tool type
        //this.ifFilledIn = ifFilledIn;

        //System.out.println("Tool attribute: " + attributeOfChosenTool + "\tTool type: " + typeOfChosenTool + "\tifFilledIn: " + ifFilledIn);
    }

    public void setImage(BufferedImage image){
        if(image!=null) {
            images.clear();
            images.add(image);
            this.setPreferredSize(getPreferredSize());
            this.repaint();
        }
    }

    public void deleteLast() {
        if (images.size() > 0) images.remove((images.size() - 1));
        this.repaint();
    }

    public void deleteAll() {
        images.clear();
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("tak");
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
    public void update(Drawable drawable) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(images.get(images.size()-1), 0, 0, this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(images.get(images.size()-1).getWidth(), images.get(images.size()-1).getHeight());
    }
}
