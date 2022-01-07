package model.filteringModel.filterInterface;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OnlyRed extends Filter {

    public OnlyRed(BufferedImage image) {
        super(image);
    }

    public OnlyRed(BufferedImage image, int xInfo, int yInfo, int filterSize) {
        super(image, xInfo, yInfo, filterSize);
    }

    @Override
    public BufferedImage filterMe() {

        // convert to onlyred
        for (int y = startingPointHeight; y < endingPointHeight; y++) {
            for (int x = startingPointWidth; x < endingPointWidth; x++) {
                c = new Color(image.getRGB(x, y));

                // set new RGB value
                c = new Color(c.getRed(), 0, 0);

                image.setRGB(x, y, c.getRGB());
            }
        }
        return image;
    }
}
