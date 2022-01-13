package model.filteringModel;

import model.filteringModel.filterInterface.*;
import observerInterface.Observer;
import observerInterface.Subject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class FilteredImageCreator implements Subject {

    private FilterInterface filterInterface;
    private ArrayList<Observer> observers;
    private BufferedImage image;

    public FilteredImageCreator() {
        observers = new ArrayList<>();
    }

    public void createFilteredImage(BufferedImage image, int xInfo, int yInfo, int filterType, int filterSize, boolean ifAppliedToEntireImage) {

        switch (filterType) {

            case 2:
                filterInterface = new Darken(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
                break;
            case 3:
                filterInterface = new GrayScale(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
                break;
            case 4:
                filterInterface = new InvertedColors(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
                break;
            case 5:
                filterInterface = new Sepia(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
                break;
            case 6:
                filterInterface = new OnlyRed(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
                break;
            case 7:
                filterInterface = new OnlyGreen(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
                break;
            case 8:
                filterInterface = new OnlyBlue(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
                break;
            case 9:
                filterInterface = new BoxBlur(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
                break;
            case 10:
                filterInterface = new SobelEdgeDetection(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
                break;
            case 11:
                filterInterface = new RobertsCrossEdgeDetection(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
                break;
            case 12:
                filterInterface = new LaplacianEdgeDetection(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
                break;
            case 13:
                filterInterface = new ScharrEdgeDetection(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage);
                break;
            default:
                filterInterface = new Brighten(image, xInfo, yInfo, filterSize, ifAppliedToEntireImage); // 1st case also used as the default
                break;
        }

        this.image = filterInterface.filterMe();

        notifyObservers();
    }

    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }
}
