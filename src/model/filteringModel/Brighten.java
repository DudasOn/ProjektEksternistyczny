package model.filteringModel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Brighten extends Filter{

    private int valueOfBrightening = 20;

    @Override
    public BufferedImage filterMe(BufferedImage image) {

        //brighten each pixel
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                c = new Color(image.getRGB(x, y));

                rValue = truncate(c.getRed()+valueOfBrightening);
                gValue = truncate(c.getGreen()+valueOfBrightening);
                bValue = truncate(c.getBlue()+valueOfBrightening);

                // set new RGB value
                c = new Color(rValue, gValue,gValue);

                image.setRGB(x, y, c.getRGB());
            }
        }
        return image;
    }
}
