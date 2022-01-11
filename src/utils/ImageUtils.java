package utils;

import java.awt.image.BufferedImage;

public abstract class ImageUtils {

    public static BufferedImage cloneBufferedImage(BufferedImage c) {

        BufferedImage bufferedImage = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                bufferedImage.setRGB(x, y, c.getRGB(x, y));
            }
        }
        return bufferedImage;
    }

    public static int getGrayScaleLuminance(int color) {
        int r = (color >> 16) & 0xff;
        int g = (color >> 8) & 0xff;
        int b = (color) & 0xff;

        return (int) (0.2126 * r + 0.7152 * g + 0.0722 * b);
    }

    public static BufferedImage convolve(BufferedImage image, int endingPointWidth, int startingPointWidth, int endingPointHeight, int startingPointHeight, int[][] convolutingMatrix) {
        int[][] edgeColors = new int[endingPointWidth - startingPointWidth][endingPointHeight - startingPointHeight];
        int bx;
        int by;
        int g;
        int divider = 0;

        if (convolutingMatrix.length % 2 == 1) bx = (convolutingMatrix.length - 1) / 2;
        else bx = (convolutingMatrix.length) / 2;

        if (convolutingMatrix[0].length % 2 == 1) by = (convolutingMatrix[0].length - 1) / 2;
        else by = (convolutingMatrix[0].length) / 2;

        for (int i = 0; i < convolutingMatrix.length; i++) {
            for (int j = 0; j < convolutingMatrix[i].length; j++) {
                divider++;
            }
        }

        for (int i = startingPointWidth + bx; i < endingPointWidth - bx; i++) {
            for (int j = startingPointHeight + by; j < endingPointHeight - by; j++) {

                g = 0;

                for (int k = 0; k < convolutingMatrix.length; k++) {
                    for (int l = 0; l < convolutingMatrix[0].length; l++) {
                        g += convolutingMatrix[k][l] * ImageUtils.getGrayScaleLuminance(image.getRGB((i - bx + k), (j - by + l)));
                    }
                }
                edgeColors[i - startingPointWidth - bx][j - startingPointHeight - by] = g / divider;
            }
        }


        for (int i = startingPointWidth + bx; i < endingPointWidth - bx; i++) {
            for (int j = startingPointHeight + by; j < endingPointHeight - by; j++) {
                int edgeColor = edgeColors[i - startingPointWidth - bx][j - startingPointHeight - by];
                edgeColor = 0xff000000 | (edgeColor << 16) | (edgeColor << 8) | edgeColor;

                image.setRGB(i, j, edgeColor);
            }
        }
        return image;
    }

    public static BufferedImage convolve(BufferedImage image, int endingPointWidth, int startingPointWidth, int endingPointHeight, int startingPointHeight, int[][] convolutingMatrixX, int[][] convolutingMatrixY) {
        int[][] edgeColors = new int[endingPointWidth - startingPointWidth][endingPointHeight - startingPointHeight];
        int gx, gy;
        int bx, by;
        int g;
        int maxGradient = -1;

        for (int i = 0; i < convolutingMatrixX.length; i++) {
            if (convolutingMatrixX.length != convolutingMatrixY.length || convolutingMatrixX[i].length != convolutingMatrixX[i].length)
                return image;
        }

        if (convolutingMatrixX.length % 2 == 1) bx = (convolutingMatrixX.length - 1) / 2;
        else bx = (convolutingMatrixX.length) / 2;

        if (convolutingMatrixX[0].length % 2 == 1) by = (convolutingMatrixX[0].length - 1) / 2;
        else by = (convolutingMatrixX[0].length) / 2;

        for (int i = startingPointWidth + bx; i < endingPointWidth - bx; i++) {
            for (int j = startingPointHeight + by; j < endingPointHeight - by; j++) {

                gx = 0;
                gy = 0;

                for (int k = 0; k < convolutingMatrixX.length; k++) {
                    for (int l = 0; l < convolutingMatrixX[0].length; l++) {
                        gx += convolutingMatrixX[k][l] * ImageUtils.getGrayScaleLuminance(image.getRGB((i - bx + k), (j - by + l)));
                        gy += convolutingMatrixY[k][l] * ImageUtils.getGrayScaleLuminance(image.getRGB((i - bx + k), (j - by + l)));
                    }
                }
                g = (int) Math.sqrt((gx * gx) + (gy * gy));

                if (maxGradient < g) {
                    maxGradient = g;
                }

                edgeColors[i - startingPointWidth - bx][j - startingPointHeight - by] = g;
            }
        }

        double scale = 255.0 / maxGradient;

        for (int i = startingPointWidth + bx; i < endingPointWidth - bx; i++) {
            for (int j = startingPointHeight + by; j < endingPointHeight - by; j++) {
                int edgeColor = edgeColors[i - startingPointWidth - bx][j - startingPointHeight - by];
                edgeColor = (int) (edgeColor * scale);
                edgeColor = 0xff000000 | (edgeColor << 16) | (edgeColor << 8) | edgeColor;

                image.setRGB(i, j, edgeColor);
            }
        }
        return image;
    }
}
