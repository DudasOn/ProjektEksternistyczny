import model.filteringModel.FilteredImageCreator;
import model.paintingModel.DrawablesCreator;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        DrawablesCreator drawablesCreator = new DrawablesCreator();
        mainFrame.getPaintingPanel().setDrawablesManipulator(drawablesCreator);
        drawablesCreator.registerObserver(mainFrame.getPaintingPanel());
        FilteredImageCreator filteredImageCreator = new FilteredImageCreator();
        mainFrame.getFilteringPanel().setFilteredImageCreator(filteredImageCreator);
        filteredImageCreator.registerObserver(mainFrame.getFilteringPanel());
    }
}
