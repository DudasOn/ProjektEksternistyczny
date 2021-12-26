package model.drawableShapes.drawInterface.drawShape;

import model.drawableShapes.drawInterface.PaintAll;

import java.awt.*;

public class DrawSquare extends PaintAll {

    public DrawSquare(int x, int y, int sideLength, Color color) {
        super(x, y, sideLength, color);
    }

    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.drawRect(x - (atribute / 2), y - (atribute / 2), atribute, atribute);
    }
}
