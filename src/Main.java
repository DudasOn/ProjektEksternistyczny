import model.DrawablesManipulator;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        DrawablesManipulator drawablesCreator = new DrawablesManipulator();
        mainFrame.getPaintingPanel().setDrawablesManipulator(drawablesCreator);
        drawablesCreator.registerObserver(mainFrame.getPaintingPanel());
    }
}
