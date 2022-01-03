package model.drawableShapes.drawInterface.drawShape;

import model.drawableShapes.drawInterface.PaintAll;

import java.awt.*;

public class DrawCircle extends PaintAll {

    private static final long serialVersionUID = 3257391477273444991L;

    public DrawCircle(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    @Override
    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.drawOval(x - (attribute / 2), y - (attribute / 2), attribute, attribute);
    }
}
