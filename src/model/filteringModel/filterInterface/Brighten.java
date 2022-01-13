package model.filteringModel.filterInterface;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Brighten extends FilterAll {

    public Brighten(BufferedImage image) {
        super(image);
    }

    public Brighten(BufferedImage image, int xInfo, int yInfo, int filterSize, boolean ifAppliedToEntioreImage) {
        super(image, xInfo, yInfo, filterSize, ifAppliedToEntioreImage);
    }

    @Override
    public BufferedImage filterMe() {

        int valueOfBrightening = 20;

        //brighten each pixel
        for (int y = startingPointHeight; y < endingPointHeight; y++) {
            for (int x = startingPointWidth; x < endingPointWidth; x++) {
                c = new Color(image.getRGB(x, y));

                rValue = truncate(c.getRed() + valueOfBrightening);
                gValue = truncate(c.getGreen() + valueOfBrightening);
                bValue = truncate(c.getBlue() + valueOfBrightening);

                // set new RGB value
                c = new Color(rValue, gValue, gValue);

                image.setRGB(x, y, c.getRGB());
            }
        }
        return image;
    }
}
