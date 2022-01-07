package model.filteringModel.filterInterface;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Filter implements FilterTypeInterface {

    protected BufferedImage image;
    protected int width;
    protected int height;
    protected int startingPointWidth;
    protected int startingPointHeight;
    protected int endingPointWidth;
    protected int endingPointHeight;

    protected int rValue;
    protected int gValue;
    protected int bValue;
    protected Color c;

    public Filter() {
        this.image = null;
        this.startingPointWidth = 0;
        this.startingPointHeight = 0;
        this.endingPointWidth = 0;
        this.endingPointHeight = 0;
    }

    public Filter(BufferedImage image) {
        this.image = image;
        this.endingPointWidth = image.getWidth();
        this.endingPointHeight = image.getHeight();
        this.startingPointHeight = 0;
        this.startingPointWidth = 0;
    }

    public Filter(BufferedImage image, int xInfo, int yInfo, int filterSize) {
        this.image = image;
        if (xInfo - filterSize / 2 < 0) startingPointWidth = 0;
        else startingPointWidth = xInfo - filterSize / 2;

        if (yInfo - filterSize / 2 < 0) startingPointHeight = 0;
        else startingPointHeight = yInfo - filterSize / 2;

        if (xInfo + filterSize / 2 > image.getWidth()) endingPointWidth = image.getWidth();
        else endingPointWidth = xInfo + filterSize / 2;

        if (yInfo + filterSize / 2 > image.getHeight()) endingPointHeight = image.getHeight();
        else endingPointHeight = yInfo + filterSize / 2;
    }

    protected int truncate(int t) {
        if (t < 0) {
            t = 0;
        } else if (t > 255) {
            t = 255;
        }
        return t;
    }

}
