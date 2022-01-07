package model.filteringModel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Darken extends Filter{
    public Darken(BufferedImage image) {
        super(image);
    }

    public Darken(BufferedImage image, int xInfo, int yInfo, int filterSize) {
        super(image, xInfo, yInfo, filterSize);
    }

    @Override
    public BufferedImage filterMe() {

        int valueOfDarkening = 15;

        //darken each pixel
        for (int y = startingPointHeight; y < endingPointHeight; y++) {
            for (int x = startingPointWidth; x < endingPointWidth; x++) {
                c = new Color(image.getRGB(x, y));

                rValue = truncate(c.getRed()-valueOfDarkening);
                gValue = truncate(c.getGreen()-valueOfDarkening);
                bValue = truncate(c.getBlue()-valueOfDarkening);

                // set new RGB value
                c = new Color(rValue, gValue,gValue);

                image.setRGB(x, y, c.getRGB());
            }
        }
        return image;
    }
}
