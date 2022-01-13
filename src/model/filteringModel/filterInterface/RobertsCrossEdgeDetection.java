package model.filteringModel.filterInterface;

import utils.ImageUtils;

import java.awt.image.BufferedImage;

public class RobertsCrossEdgeDetection extends FilterAll {

    public RobertsCrossEdgeDetection(BufferedImage image) {
        super(image);
    }

    public RobertsCrossEdgeDetection(BufferedImage image, int xInfo, int yInfo, int filterSize, boolean ifAppliedToEntireImage) {
        super(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
    }

    @Override
    public BufferedImage filterMe() {
        int[][] convolutingMatrixX = {{1, 0}, {0, -1}};
        int[][] convolutingMatrixY = {{0, 1}, {-1, 0}};
        return ImageUtils.convolve(image, endingPointWidth, startingPointWidth, endingPointHeight, startingPointHeight, convolutingMatrixX, convolutingMatrixY, true);
    }
}

