package model.drawableShapes.drawInterface.drawShape;

import model.drawableShapes.drawInterface.PaintAll;
import java.awt.*;

public class DrawTriangle extends PaintAll {

    public DrawTriangle(int x, int y, int sideLength, Color color) {
        super(x, y, sideLength, color);
    }

    @Override
    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.drawPolygon(new int[]{x, x - attribute / 2, x + attribute / 2}, new int[]{y - attribute / 2, y + attribute / 2, y + attribute / 2}, 3);
    }
}
