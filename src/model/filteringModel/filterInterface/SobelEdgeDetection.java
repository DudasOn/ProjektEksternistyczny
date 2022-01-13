package model.filteringModel.filterInterface;

import utils.ImageUtils;

import java.awt.image.BufferedImage;

public class SobelEdgeDetection extends FilterAll {

    public SobelEdgeDetection(BufferedImage image) {
        super(image);
    }

    public SobelEdgeDetection(BufferedImage image, int xInfo, int yInfo, int filterSize, boolean ifAppliedToEntireImage) {
        super(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
    }

    @Override
    public BufferedImage filterMe() {
        int[][] convolutingMatrixX = {{1, 0, -1}, {2, 0, -2}, {1, 0, -1}};
        int[][] convolutingMatrixY = {{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};
        return ImageUtils.convolve(image, endingPointWidth, startingPointWidth, endingPointHeight, startingPointHeight, convolutingMatrixX, convolutingMatrixY, true);
    }
}

