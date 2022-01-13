package model.filteringModel.filterInterface;

import utils.ImageUtils;

import java.awt.image.BufferedImage;

public class LaplacianEdgeDetection extends FilterAll {

    public LaplacianEdgeDetection(BufferedImage image) {
        super(image);
    }

    public LaplacianEdgeDetection(BufferedImage image, int xInfo, int yInfo, int filterSize, boolean ifAppliedToEntireImage) {
        super(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
    }

    @Override
    public BufferedImage filterMe() {
        int[][] convolutingMatrix = {{-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}, {-1, -1, 24, -1, -1}, {-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}};
        return ImageUtils.convolve(this.image, this.endingPointWidth, this.startingPointWidth, this.endingPointHeight, this.startingPointHeight, convolutingMatrix, true);
    }
}

