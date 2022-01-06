package model.filteringModel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Filter implements FilterType{

    protected BufferedImage image;
    protected int width;
    protected int height;

    protected int rValue;
    protected int gValue;
    protected int bValue;
    protected Color c;

    public Filter() {
        this.image = null;
        this.width = 0;
        this.height = 0;
    }

    public Filter(BufferedImage image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    protected int truncate(int t){
        if (t < 0) {
            t = 0;
        }
        else if (t > 255) {
            t = 255;
        }
        return t;
    }

}
