package model.filteringModel;

import model.filteringModel.filterInterface.*;
import observerInterface.Observer;
import observerInterface.Subject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class FilteredImageCreator implements Subject {

    private FilterTypeInterface filterTypeInterface;
    private ArrayList<Observer> observers;
    private BufferedImage image;

    public FilteredImageCreator() {
        observers = new ArrayList<>();
    }

    public void createFilteredImage(BufferedImage image, int xInfo, int yInfo, int filterType, int filterSize, boolean ifAppliedToEntireImage) {

        if (ifAppliedToEntireImage) {
            switch (filterType) {
                case 1:
                    filterTypeInterface = new Brighten(image);
                    break;
                case 2:
                    filterTypeInterface = new Darken(image);
                    break;
                case 3:
                    filterTypeInterface = new GrayScale(image);
                    break;
                case 4:
                    filterTypeInterface = new InvertedColors(image);
                    break;
                case 5:
                    filterTypeInterface = new Sepia(image);
                    break;
                case 6:
                    filterTypeInterface = new OnlyRed(image);
                    break;
                case 7:
                    filterTypeInterface = new OnlyGreen(image);
                    break;
                case 8:
                    filterTypeInterface = new OnlyBlue(image);
                    break;
                case 9:
                    filterTypeInterface = new BoxBlur(image);
                    break;
                default:
                    filterTypeInterface = new Brighten(image);
                    break;
            }
        } else
            switch (filterType) {
                case 1:
                    filterTypeInterface = new Brighten(image, xInfo, yInfo, filterSize);
                    break;
                case 2:
                    filterTypeInterface = new Darken(image, xInfo, yInfo, filterSize);
                    break;
                case 3:
                    filterTypeInterface = new GrayScale(image, xInfo, yInfo, filterSize);
                    break;
                case 4:
                    filterTypeInterface = new InvertedColors(image, xInfo, yInfo, filterSize);
                    break;
                case 5:
                    filterTypeInterface = new Sepia(image, xInfo, yInfo, filterSize);
                    break;
                case 6:
                    filterTypeInterface = new OnlyRed(image, xInfo, yInfo, filterSize);
                    break;
                case 7:
                    filterTypeInterface = new OnlyGreen(image, xInfo, yInfo, filterSize);
                    break;
                case 8:
                    filterTypeInterface = new OnlyBlue(image, xInfo, yInfo, filterSize);
                    break;
                case 9:
                    filterTypeInterface = new BoxBlur(image, xInfo, yInfo, filterSize);
                    break;
                default:
                    filterTypeInterface = new Brighten(image, xInfo, yInfo, filterSize);
                    break;
            }

        this.image = filterTypeInterface.filterMe();

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
