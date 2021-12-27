package view;

import model.DrawablesManipulator;
import model.drawableShapes.Drawable;
import observerInterface.Observer;
import view.choiceAssistant.ColorChoiceFrame;
import view.choiceAssistant.ToolShapeChoice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class PaintingPanel extends JPanel implements MouseListener, Observer {

    private final ColorChoiceFrame backgroundColorChanger;
    private final ColorChoiceFrame toolsColorChanger;
    private final ToolShapeChoice toolShapeChooser;
    private static Object[] dataAboutCurrentObject;
    private Color toolColor;
    private int sizeOfChosenTool;
    private int typeOfChosenTool;
    private boolean ifCovering;
    private boolean ifFilledIn;
    private ArrayList<Drawable> drawables = new ArrayList<>();
    private DrawablesManipulator drawablesManipulator;

    public PaintingPanel(int width, int height, ColorChoiceFrame backgroundColorChanger, ColorChoiceFrame objectsColor, ToolShapeChoice toolShapeChooser) {
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(true);
        this.addMouseListener(this);
        this.backgroundColorChanger = backgroundColorChanger;
        this.toolsColorChanger = objectsColor;
        this.toolShapeChooser = toolShapeChooser;
        this.changeColor();
        this.sizeOfChosenTool = toolShapeChooser.getTool()[0];
        this.typeOfChosenTool = toolShapeChooser.getTool()[1];
        this.ifCovering = false;
        this.ifFilledIn = toolShapeChooser.getIfFilledIn();
        dataAboutCurrentObject = new Object[7];
    }


    public void changeColor() {
        this.setBackground(backgroundColorChanger.getColor());
        this.toolColor = toolsColorChanger.getColor();
        revalidate();
        repaint();
    }

    public void changeTool() {

        this.sizeOfChosenTool = toolShapeChooser.getTool()[0];
        this.typeOfChosenTool = toolShapeChooser.getTool()[1];
        this.ifFilledIn = toolShapeChooser.getIfFilledIn();

        for (int i = 0; i < toolShapeChooser.getTool().length; i++)
            System.out.println(toolShapeChooser.getTool()[i]);
    }

    public void dissallowCovering() {
        ifCovering = true;
    }

    public void allowCovering() {
        ifCovering = false;
    }

    public void deleteLast() {
        if (drawables.size() > 0) drawables.remove((drawables.size() - 1));
        this.repaint();
    }

    public void deleteAll() {
        drawables.clear();
        this.repaint();
    }

    public ArrayList<Drawable> getArrayOfDrawables() {
        return drawables;
    }

    public void setArrayOfDrawables(ArrayList<Drawable> drawables) {
        this.drawables = drawables;
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        dataAboutCurrentObject[0] = e.getX(); //x location
        dataAboutCurrentObject[1] = e.getY(); //y location
        dataAboutCurrentObject[2] = toolColor; //tool color, giving the color instead of null when using the cover option (this would make "ifCovering: redundant) allows for easier expansion of the program
        dataAboutCurrentObject[3] = sizeOfChosenTool; //tool attribute
        dataAboutCurrentObject[4] = typeOfChosenTool; //tool shape
        dataAboutCurrentObject[5] = ifFilledIn; //if true it means that the drawn shape needs to be filled in, otherwise its just an outline
        dataAboutCurrentObject[6] = ifCovering; //if true it means that the shape needs to change color accordingly to the background

        System.out.println("X:" + dataAboutCurrentObject[0] + "\tY:" + dataAboutCurrentObject[1] + "\tColor:" + dataAboutCurrentObject[2] +
                "\tAttribute:" + dataAboutCurrentObject[3] + "\tType:" + dataAboutCurrentObject[4] + "\tifFilledIn:" + dataAboutCurrentObject[5] + "\tifCovering:" + dataAboutCurrentObject[6]);

        drawablesManipulator.createShape(dataAboutCurrentObject);
    }

    public void setDrawablesManipulator(DrawablesManipulator drawablesManipulator) {
        this.drawablesManipulator = drawablesManipulator;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void update() {
        this.drawables.add(drawablesManipulator.getDrawn());
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < drawables.size(); i++) {
            //System.out.println(drawables.get(i) + " " + drawables.get(i).getColor());
            if(drawables.get(i).getIfCovering()) {
                //drawables.get(i).setColor(this.getBackground());
                drawables.get(i).getDrawMe().setColor(this.getBackground()); //changing the color ONLY in drawing allows us to expand our program (by for example adding "Uncover all" option)
            }
            drawables.get(i).getDrawMe().drawMe(g);
        }
    }
}
