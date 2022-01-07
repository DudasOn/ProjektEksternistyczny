package utils;

import java.awt.image.BufferedImage;

public abstract class ImageUtils {

    public static BufferedImage closeBufferedImage(BufferedImage c) {

        BufferedImage bufferedImage = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                bufferedImage.setRGB(x, y, c.getRGB(x, y));
            }
        }
        return bufferedImage;
    }


}
