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

        if (ifAppliedToEntireImage) {
            switch (filterType) {
                case 1:
                    filterInterface = new Brighten(image);
                    break;
                case 2:
                    filterInterface = new Darken(image);
                    break;
                case 3:
                    filterInterface = new GrayScale(image);
                    break;
                case 4:
                    filterInterface = new InvertedColors(image);
                    break;
                case 5:
                    filterInterface = new Sepia(image);
                    break;
                case 6:
                    filterInterface = new OnlyRed(image);
                    break;
                case 7:
                    filterInterface = new OnlyGreen(image);
                    break;
                case 8:
                    filterInterface = new OnlyBlue(image);
                    break;
                case 9:
                    filterInterface = new BoxBlur(image);
                    break;
                default:
                    filterInterface = new Brighten(image);
                    break;
            }
        } else
            switch (filterType) {
                case 1:
                    filterInterface = new Brighten(image, xInfo, yInfo, filterSize);
                    break;
                case 2:
                    filterInterface = new Darken(image, xInfo, yInfo, filterSize);
                    break;
                case 3:
                    filterInterface = new GrayScale(image, xInfo, yInfo, filterSize);
                    break;
                case 4:
                    filterInterface = new InvertedColors(image, xInfo, yInfo, filterSize);
                    break;
                case 5:
                    filterInterface = new Sepia(image, xInfo, yInfo, filterSize);
                    break;
                case 6:
                    filterInterface = new OnlyRed(image, xInfo, yInfo, filterSize);
                    break;
                case 7:
                    filterInterface = new OnlyGreen(image, xInfo, yInfo, filterSize);
                    break;
                case 8:
                    filterInterface = new OnlyBlue(image, xInfo, yInfo, filterSize);
                    break;
                case 9:
                    filterInterface = new BoxBlur(image, xInfo, yInfo, filterSize);
                    break;
                default:
                    filterInterface = new Brighten(image, xInfo, yInfo, filterSize);
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
