package model.filteringModel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Darken extends Filter{
    @Override
    public BufferedImage filterMe(BufferedImage image) {

        int valueOfDarkening = 15;

        //darken each pixel
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
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
