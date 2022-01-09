package model.filteringModel.filterInterface;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sepia extends FilterAll {
    public Sepia(BufferedImage image) {
        super(image);
    }

    public Sepia(BufferedImage image, int xInfo, int yInfo, int filterSize) {
        super(image, xInfo, yInfo, filterSize);
    }

    @Override
    public BufferedImage filterMe() {

        // convert to sepia
        for (int y = startingPointHeight; y < endingPointHeight; y++) {
            for (int x = startingPointWidth; x < endingPointWidth; x++) {
                c = new Color(image.getRGB(x, y));

                // calculate newRed, newGreen, newBlue
                rValue = (int) (0.393 * c.getRed() + 0.769 * c.getGreen() + 0.189 * c.getBlue());
                gValue = (int) (0.349 * c.getRed() + 0.686 * c.getGreen() + 0.168 * c.getBlue());
                bValue = (int) (0.272 * c.getRed() + 0.534 * c.getGreen() + 0.131 * c.getBlue());

                // check condition
                if (rValue > 255) rValue = 255;

                if (gValue > 255) gValue = 255;

                if (bValue > 255) bValue = 255;

                // set new RGB value
                c = new Color(this.rValue, gValue, gValue, c.getAlpha());

                image.setRGB(x, y, c.getRGB());
            }
        }
        return image;
    }
}
