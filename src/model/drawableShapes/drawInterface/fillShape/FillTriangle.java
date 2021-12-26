package model.drawableShapes.drawInterface.fillShape;

import model.drawableShapes.drawInterface.PaintAll;

import java.awt.*;

public class FillTriangle extends PaintAll {

    public FillTriangle(int x, int y, int sideLength, Color color) {
        super(x, y, sideLength, color);
    }

    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.fillPolygon(new int[]{x, x - atribute / 2, x + atribute / 2}, new int[]{y - atribute / 2, y + atribute / 2, y + atribute / 2}, 3);
    }
}
