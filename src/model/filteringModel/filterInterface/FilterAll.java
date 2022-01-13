package model.filteringModel.filterInterface;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class FilterAll implements FilterInterface {

    protected BufferedImage image;
    protected int startingPointWidth;
    protected int startingPointHeight;
    protected int endingPointWidth;
    protected int endingPointHeight;

    protected int rValue;
    protected int gValue;
    protected int bValue;
    protected Color c;

    public FilterAll(BufferedImage image) {
        this.image = image;
        this.endingPointWidth = image.getWidth();
        this.endingPointHeight = image.getHeight();
        this.startingPointHeight = 0;
        this.startingPointWidth = 0;
    }

    public FilterAll(BufferedImage image, int xInfo, int yInfo, int filterSize, boolean ifAppliedToEntireImage) {
        this.image = image;
        if (ifAppliedToEntireImage) {
            this.endingPointWidth = image.getWidth();
            this.endingPointHeight = image.getHeight();
            this.startingPointHeight = 0;
            this.startingPointWidth = 0;
        } else {
            startingPointWidth = Math.max(xInfo - filterSize / 2, 0);
            startingPointHeight = Math.max(yInfo - filterSize / 2, 0);
            endingPointWidth = Math.min(xInfo + filterSize / 2, image.getWidth());
            endingPointHeight = Math.min(yInfo + filterSize / 2, image.getHeight());
        }
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
