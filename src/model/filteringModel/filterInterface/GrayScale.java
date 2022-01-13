package model.filteringModel.filterInterface;

import utils.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GrayScale extends FilterAll {
    public GrayScale(BufferedImage image) {
        super(image);
    }

    public GrayScale(BufferedImage image, int xInfo, int yInfo, int filterSize, boolean ifAppliedToEntireImage) {
        super(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
    }

    @Override
    public BufferedImage filterMe() {

        // convert to grayscale
        for (int y = startingPointHeight; y < endingPointHeight; y++) {
            for (int x = startingPointWidth; x < endingPointWidth; x++) {

                // using only rValue, as using gValue and bValue would be unnecessary
                rValue = ImageUtils.getGrayScaleLuminance(image.getRGB(x, y));

                // set new RGB value
                c = new Color(rValue, rValue, rValue);

                image.setRGB(x, y, c.getRGB());
            }
        }
        return image;
    }
}
