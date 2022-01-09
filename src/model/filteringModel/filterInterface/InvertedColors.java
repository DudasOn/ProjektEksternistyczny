package model.filteringModel.filterInterface;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InvertedColors extends FilterAll {

    public InvertedColors(BufferedImage image) {
        super(image);
    }

    public InvertedColors(BufferedImage image, int xInfo, int yInfo, int filterSize) {
        super(image, xInfo, yInfo, filterSize);
    }

    @Override
    public BufferedImage filterMe() {

        // convert to inverted colors
        for (int y = startingPointHeight; y < endingPointHeight; y++) {
            for (int x = startingPointWidth; x < endingPointWidth; x++) {
                c = new Color(image.getRGB(x, y));

                // calculate new RGB values
                c = new Color(rValue = 255 - c.getRed(),
                        gValue = 255 - c.getGreen(),
                        bValue = 255 - c.getBlue());

                image.setRGB(x, y, c.getRGB());
            }
        }
        return image;
    }
}
