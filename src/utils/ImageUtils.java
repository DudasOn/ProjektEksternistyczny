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

    public static BufferedImage convolve(BufferedImage image, int endingPointWidth, int startingPointWidth, int endingPointHeight, int startingPointHeight, int[][] convolutingMatrix, boolean ifUsingMaxGradient) {
        int[][] convolutingMatrixY = new int[convolutingMatrix.length][];

        for (int i = 0; i < convolutingMatrix.length; i++) {
            convolutingMatrixY[i] = new int[convolutingMatrix[i].length];
        }

        for (int i = 0; i < convolutingMatrix.length; i++) {
            for (int j = 0; j < convolutingMatrix[i].length; j++) {
                convolutingMatrixY[i][j] = 0;
            }
        }

        return convolve(image, endingPointWidth, startingPointWidth, endingPointHeight, startingPointHeight, convolutingMatrix, convolutingMatrixY, ifUsingMaxGradient);
    }

    public static BufferedImage convolve(BufferedImage image, int endingPointWidth, int startingPointWidth, int endingPointHeight, int startingPointHeight, int[][] convolutingMatrixX, int[][] convolutingMatrixY, boolean ifUsingMaxGradient) {
        int gx, gy;
        int bx, by;
        int g;
        int maxGradient = -1;

        //checking if array is a matrix
        for (int i = 1; i < convolutingMatrixX.length; i++) {
            if(convolutingMatrixX[0].length!= convolutingMatrixX[i].length) return  image;
        }

        //checking if the 2d arrays are identically sized matrices, this also determines whether the second, unchecked array is a matrix. 
        for (int i = 0; i < convolutingMatrixX.length; i++) {
            if (convolutingMatrixX.length != convolutingMatrixY.length || convolutingMatrixX[i].length != convolutingMatrixY[i].length) return image;
        }

        // divider is the amount of elements in the matrix
        int divider = convolutingMatrixX.length*convolutingMatrixX[0].length;

        //these are used to prevent for loops from going out of bounds
        bx = (convolutingMatrixX.length - (convolutingMatrixX.length % 2)) / 2;
        by = (convolutingMatrixX[0].length - (convolutingMatrixX[0].length % 2)) / 2;

        int[][] edgeColors = new int[endingPointWidth - startingPointWidth][endingPointHeight - startingPointHeight];

        for (int i = startingPointWidth; i < endingPointWidth; i++) {
            for (int j = startingPointHeight; j < endingPointHeight; j++) {

                gx = 0;
                gy = 0;

                for (int k = 0; k < convolutingMatrixX.length; k++) {

                    if ((i - bx < startingPointWidth) || (i + bx >= endingPointWidth)) {
                        break;
                    }
                    if ((j - by < startingPointHeight) || (j + by >= endingPointHeight)) {
                        break;
                    }

                    for (int l = 0; l < convolutingMatrixX[0].length; l++) {
                        gx += convolutingMatrixX[k][l] * ImageUtils.getGrayScaleLuminance(image.getRGB((i - bx + k), (j - by + l)));
                        gy += convolutingMatrixY[k][l] * ImageUtils.getGrayScaleLuminance(image.getRGB((i - bx + k), (j - by + l)));
                    }
                }
                g = (int) Math.sqrt((gx * gx) + (gy * gy));

                if (maxGradient < g) {
                    maxGradient = g;
                }

                edgeColors[i - startingPointWidth][j - startingPointHeight] = g;
            }
        }

        for (int i = startingPointWidth; i < endingPointWidth; i++) {
            for (int j = startingPointHeight; j < endingPointHeight; j++) {
                int edgeColor = edgeColors[i - startingPointWidth][j - startingPointHeight];
                if (ifUsingMaxGradient) edgeColor = (int) (edgeColor * (255.0 / maxGradient));
                else edgeColor = edgeColor / divider;
                edgeColor = 0xff000000 | (edgeColor << 16) | (edgeColor << 8) | edgeColor;

                image.setRGB(i, j, edgeColor);
            }
        }
        return image;
    }
}
