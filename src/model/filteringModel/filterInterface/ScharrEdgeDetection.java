package model.filteringModel.filterInterface;

import utils.ImageUtils;

import java.awt.image.BufferedImage;

public class ScharrEdgeDetection extends FilterAll {

    public ScharrEdgeDetection(BufferedImage image) {
        super(image);
    }

    public ScharrEdgeDetection(BufferedImage image, int xInfo, int yInfo, int filterSize) {
        super(image, xInfo, yInfo, filterSize);
    }

    @Override
    public BufferedImage filterMe() {
        int[][] convolutingMatrixX = {{-3, 0, 3}, {-10, 0, 10}, {-3, 0, 3}};
        int[][] convolutingMatrixY = {{3, 10, 3}, {0, 0, 0}, {-3, -10, -3}};
        return ImageUtils.convolve(image, endingPointWidth, startingPointWidth, endingPointHeight, startingPointHeight, convolutingMatrixX, convolutingMatrixY);
    }
}

