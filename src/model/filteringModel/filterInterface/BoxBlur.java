package model.filteringModel.filterInterface;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BoxBlur extends FilterAll {

    public BoxBlur(BufferedImage image) {
        super(image);
    }

    public BoxBlur(BufferedImage image, int xInfo, int yInfo, int filterSize) {
        super(image, xInfo, yInfo, filterSize);
    }

    @Override
    public BufferedImage filterMe() {

        // convert to boxblur
        for (int y = startingPointHeight + 1; y < endingPointHeight - 1; y++) {
            for (int x = startingPointWidth + 1; x < endingPointWidth - 1; x++) {

                rValue = (new Color(image.getRGB(x - 1, y - 1)).getRed() + new Color(image.getRGB(x - 1, y)).getRed()
                        + new Color(image.getRGB(x - 1, y + 1)).getRed() + new Color(image.getRGB(x, y - 1)).getRed()
                        + new Color(image.getRGB(x, y)).getRed() + new Color(image.getRGB(x, y + 1)).getRed()
                        + new Color(image.getRGB(x + 1, y - 1)).getRed() + new Color(image.getRGB(x + 1, y)).getRed()
                        + new Color(image.getRGB(x + 1, y + 1)).getRed()) / 9;

                gValue = (new Color(image.getRGB(x - 1, y - 1)).getGreen() + new Color(image.getRGB(x - 1, y)).getGreen()
                        + new Color(image.getRGB(x - 1, y + 1)).getGreen() + new Color(image.getRGB(x, y - 1)).getGreen()
                        + new Color(image.getRGB(x, y)).getGreen() + new Color(image.getRGB(x, y + 1)).getGreen()
                        + new Color(image.getRGB(x + 1, y - 1)).getGreen() + new Color(image.getRGB(x + 1, y)).getGreen()
                        + new Color(image.getRGB(x + 1, y + 1)).getGreen()) / 9;

                bValue = (new Color(image.getRGB(x - 1, y - 1)).getBlue() + new Color(image.getRGB(x - 1, y)).getBlue()
                        + new Color(image.getRGB(x - 1, y + 1)).getBlue() + new Color(image.getRGB(x, y - 1)).getBlue()
                        + new Color(image.getRGB(x, y)).getBlue() + new Color(image.getRGB(x, y + 1)).getBlue()
                        + new Color(image.getRGB(x + 1, y - 1)).getBlue() + new Color(image.getRGB(x + 1, y)).getBlue()
                        + new Color(image.getRGB(x + 1, y + 1)).getBlue()) / 9;

                // set new RGB value
                c = new Color(rValue, gValue, bValue);

                image.setRGB(x, y, c.getRGB());
            }
        }
        return image;
    }
}
