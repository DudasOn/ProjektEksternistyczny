package model.drawableShapes.drawInterface.drawShape;

import model.drawableShapes.drawInterface.PaintAll;

import java.awt.*;

public class DrawCircle extends PaintAll {

    public DrawCircle(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    @Override
    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.drawOval(x - (atribute / 2), y - (atribute / 2), atribute, atribute);
    }


}
