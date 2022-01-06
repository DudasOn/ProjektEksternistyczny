package model.filteringModel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GrayScale extends Filter{
    @Override
    public BufferedImage filterMe(BufferedImage image) {

        // convert to greyscale
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                c = new Color(image.getRGB(x, y));

                // calculate new RGB values
                rValue = (int)(c.getRed() * 0.299);
                gValue = (int)(c.getGreen() * 0.587);
                bValue = (int)(c.getBlue() *0.114);

                // set new RGB value
                c = new Color(rValue, gValue,gValue);

                image.setRGB(x, y, c.getRGB());
            }
        }
        return image;
    }
}
