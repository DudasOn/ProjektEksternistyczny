package model.drawableShapes.drawInterface.drawShape;

import model.drawableShapes.drawInterface.PaintAll;

import java.awt.*;

public class DrawTriangle extends PaintAll {

    public DrawTriangle(int x, int y, int sideLength, Color color) {
        super(x, y, sideLength, color);
    }

    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.drawPolygon(new int[]{x, x - atribute / 2, x + atribute / 2}, new int[]{y - atribute / 2, y + atribute / 2, y + atribute / 2}, 3);
    }
}
