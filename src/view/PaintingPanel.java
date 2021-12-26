package view;

import model.DrawablesCreator;
import model.drawableShapes.Circle;
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
    private DrawablesCreator drawablesCreator;

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
        this.ifFilledIn=toolShapeChooser.getIfFilledIn();
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

    @Override
    public void mouseClicked(MouseEvent e) {
        dataAboutCurrentObject[0] = e.getX(); //x location
        dataAboutCurrentObject[1] = e.getY(); //y location
        dataAboutCurrentObject[2] = toolColor; //tool color
        dataAboutCurrentObject[3] = sizeOfChosenTool; //tool atribute
        dataAboutCurrentObject[4] = typeOfChosenTool; //tool shape
        dataAboutCurrentObject[5] = ifCovering; //if true it means that the shape needs to change color accordingly to the background
        dataAboutCurrentObject[6] = ifFilledIn; //if true it means that the drawn shape needs to be filled in, otherwise its just an outline

        System.out.println("X:" + dataAboutCurrentObject[0] + "/Y: " + dataAboutCurrentObject[1] + "/Color: " + dataAboutCurrentObject[2] +
                "/Atribute: " + dataAboutCurrentObject[3] + "/Type: " + dataAboutCurrentObject[4] + "/ifCovering: " + dataAboutCurrentObject[5]+ "/ifFilledIn: "+dataAboutCurrentObject[6]);

        drawablesCreator.createShape(dataAboutCurrentObject);
    }

    public void setDrawablesCreator(DrawablesCreator drawablesCreator) {
        this.drawablesCreator = drawablesCreator;
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
        this.drawables.add(drawablesCreator.getDrawn());
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (drawables == null) ;
        else {
            for (int i = 0; i < drawables.size(); i++) {
                //System.out.println(drawables.get(i) + " " + drawables.get(i).getColor());
                drawables.get(i).getDrawMe().drawMe(g);
            }
        }

    }
}
