package view;

import model.filteringModel.FilteredImageCreator;
import observerInterface.Observer;
import utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class FilteringPanel extends JPanel implements MouseListener, Observer {

    private boolean ifAppliedToEntireImage;
    private int filterSize;
    private int filterType;
    private ArrayList<BufferedImage> images;
    private FilteredImageCreator filteredImageCreator;


    public FilteringPanel(int width, int height, int[] filterProperties, boolean ifAppliedToEntireImage) {
        images = new ArrayList<>();

        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(true);
        this.addMouseListener(this);
        this.changeFilter(filterProperties, ifAppliedToEntireImage);
        this.requestFocusInWindow();
        this.setVisible(true);
    }

    public void changeFilter(int[] filterProperties, boolean ifAppliedToEntireImage) {
        this.filterSize = filterProperties[0];
        this.filterType = filterProperties[1];
        this.ifAppliedToEntireImage = ifAppliedToEntireImage;

        System.out.println("Filter size: " + this.filterSize + "\tFilter type: " + this.filterType + "\tifAppliedToEntireImage: " + this.ifAppliedToEntireImage);
    }

    public void setImage(BufferedImage image) {
        if (image != null) {
            images.add(image);
            this.repaint();
        }
    }

    public void deleteLast() {
        if (images.size() > 0) images.remove(images.size() - 1);
        this.repaint();
    }

    public void deleteAll() {
        images.clear();
        this.repaint();
    }

    public void setFilteredImageCreator(FilteredImageCreator filteredImageCreator) {
        this.filteredImageCreator = filteredImageCreator;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(images.size()>0) filteredImageCreator.createFilteredImage(ImageUtils.cloneBufferedImage(images.get(images.size() - 1)), e.getX(), e.getY(), filterType, filterSize, ifAppliedToEntireImage);
    }

    @Override
    public void update() {
        images.add(filteredImageCreator.getImage());
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (images.size() > 0) g.drawImage(images.get(images.size() - 1), 0, 0, this);
        this.setPreferredSize(this.getPreferredSize());
    }

    @Override
    public Dimension getPreferredSize() {
        if (images != null) {

            if (images.size() > 0)
                return new Dimension(images.get(images.size() - 1).getWidth(), images.get(images.size() - 1).getHeight());
            else return new Dimension(this.getWidth(), this.getHeight());
        }
        return new Dimension(1024, 768);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
