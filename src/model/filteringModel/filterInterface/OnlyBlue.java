package model.filteringModel.filterInterface;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OnlyBlue extends FilterAll {

    public OnlyBlue(BufferedImage image) {
        super(image);
    }

    public OnlyBlue(BufferedImage image, int xInfo, int yInfo, int filterSize, boolean ifAppliedToEntireImage) {
        super(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
    }

    @Override
    public BufferedImage filterMe() {

        // convert to onlyblue
        for (int y = startingPointHeight; y < endingPointHeight; y++) {
            for (int x = startingPointWidth; x < endingPointWidth; x++) {
                c = new Color(image.getRGB(x, y));

                // set new RGB value
                c = new Color(0, 0, c.getBlue());

                image.setRGB(x, y, c.getRGB());
            }
        }
        return image;
    }
}
