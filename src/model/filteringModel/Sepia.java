package model.filteringModel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sepia extends Filter{
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

                rValue = c.getRed();
                gValue = c.getGreen();
                bValue = c.getBlue();

                // calculate newRed, newGreen, newBlue
                int newRed = (int)(0.393 * rValue + 0.769 * gValue + 0.189 * bValue);
                int newGreen = (int)(0.349 * rValue + 0.686 * gValue + 0.168 * bValue);
                int newBlue = (int)(0.272 * rValue + 0.534 * gValue + 0.131 * bValue);

                // check condition
                if (newRed > 255)
                    rValue = 255;
                else
                    rValue = newRed;

                if (newGreen > 255)
                    gValue = 255;
                else
                    gValue = newGreen;

                if (newBlue > 255)
                    bValue = 255;
                else
                    bValue = newBlue;

                // set new RGB value
                c = new Color(rValue, gValue,gValue);

                image.setRGB(x, y, c.getRGB());
            }
        }
        return image;
    }
}
