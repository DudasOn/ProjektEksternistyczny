package model.filteringModel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GrayScale extends Filter{
    public GrayScale(BufferedImage image) {
        super(image);
    }

    public GrayScale(BufferedImage image, int xInfo, int yInfo, int filterSize) {
        super(image, xInfo, yInfo, filterSize);
    }

    @Override
    public BufferedImage filterMe() {

        // convert to greyscale
        for (int y = startingPointHeight; y < endingPointHeight; y++) {
            for (int x = startingPointWidth; x < endingPointWidth; x++) {
                c = new Color(image.getRGB(x, y));

                // calculate new RGB values
                rValue = (int)(c.getRed() * 0.299);
                gValue = (int)(c.getGreen() * 0.587);
                bValue = (int)(c.getBlue() *0.114);

                // set new RGB value
                c = new Color(rValue+gValue+bValue, rValue+gValue+bValue,rValue+gValue+bValue);

                image.setRGB(x, y, c.getRGB());
            }
        }
        return image;
    }
}
