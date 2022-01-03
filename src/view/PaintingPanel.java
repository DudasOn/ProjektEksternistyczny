package view;

import model.DrawablesCreator;
import model.drawableShapes.Drawable;
import observerInterface.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


public class PaintingPanel extends JPanel implements MouseListener, MouseMotionListener, Observer {

    private static Object[] dataAboutCurrentObject;
    private Color toolColor;
    private int sizeOfChosenTool;
    private int typeOfChosenTool;
    private boolean ifCovering;
    private boolean ifFilledIn;
    private ArrayList<Drawable> drawables = new ArrayList<>();
    private DrawablesCreator drawablesCreator;

    public PaintingPanel(int width, int height, Color backgroundColor, Color foregroundColor, int[] toolProperties, boolean ifFilledIn) {
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.changeColor(backgroundColor, foregroundColor);
        this.changeTool(toolProperties, ifFilledIn);
        this.ifCovering = false;
        dataAboutCurrentObject = new Object[7];
    }


    public void changeColor(Color backgroundColor, Color foregroundColor) {
        this.setBackground(backgroundColor);
        this.toolColor = foregroundColor;
        revalidate();
        repaint();
    }

    public void changeTool(int[] toolProperties, boolean ifFilledIn) {

        this.sizeOfChosenTool = toolProperties[0]; //tool size
        this.typeOfChosenTool = toolProperties[1]; //tool type
        this.ifFilledIn = ifFilledIn;

        System.out.println("Tool size: " + sizeOfChosenTool + "\tTool type: " + typeOfChosenTool + "\tifFilledIn: " + ifFilledIn);
    }

    public void disallowCovering() {
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
    }

    public void loadFromFile(ArrayList<Object> info) {
        if (info != null) {
            this.setBackground((Color) info.get(info.size() - 1));
            this.drawables.clear();
            for (int i = 0; i < info.size()-1; i++) {
                this.drawables.add((Drawable) info.get(i));
            }
        }
        this.repaint();
    }

    public void setDrawablesManipulator(DrawablesCreator drawablesCreator) {
        this.drawablesCreator = drawablesCreator;
    }

    private void reactToMouse(MouseEvent e) {
        dataAboutCurrentObject[0] = e.getX(); //x location
        dataAboutCurrentObject[1] = e.getY(); //y location
        dataAboutCurrentObject[2] = toolColor; //tool color, giving the color instead of null when using the cover option (this would make "ifCovering" redundant) allows for easier expansion of the program
        dataAboutCurrentObject[3] = sizeOfChosenTool; //tool attribute
        dataAboutCurrentObject[4] = typeOfChosenTool; //tool shape
        dataAboutCurrentObject[5] = ifFilledIn; //if true it means that the drawn shape needs to be filled in, otherwise its just an outline
        dataAboutCurrentObject[6] = ifCovering; //if true it means that the shape needs to change color accordingly to the background

        System.out.println("X:" + dataAboutCurrentObject[0] + "\tY:" + dataAboutCurrentObject[1] + "\tColor:" + dataAboutCurrentObject[2] +
                "\tAttribute:" + dataAboutCurrentObject[3] + "\tType:" + dataAboutCurrentObject[4] + "\tifFilledIn:" + dataAboutCurrentObject[5] + "\tifCovering:" + dataAboutCurrentObject[6]);

        drawablesCreator.createShape(dataAboutCurrentObject);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        reactToMouse(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        reactToMouse(e);
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
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void update(Drawable drawable) {
        this.drawables.add(drawable);
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (drawables != null) {
            for (int i = 0; i < drawables.size(); i++) {
                //System.out.println(drawables.get(i) + " " + drawables.get(i).getColor());
                if (drawables.get(i).getIfCovering()) {
                    //drawables.get(i).setColor(this.getBackground());
                    drawables.get(i).getDrawMe().setColor(this.getBackground()); //changing the color ONLY in drawing allows us to expand our program (by for example adding "Uncover all" option)
                }
                drawables.get(i).getDrawMe().drawMe(g);
            }
        }
    }


}
