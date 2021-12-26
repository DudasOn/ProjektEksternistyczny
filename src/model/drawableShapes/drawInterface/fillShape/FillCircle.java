package model.drawableShapes.drawInterface.fillShape;

import model.drawableShapes.drawInterface.PaintAll;

import java.awt.*;

public class FillCircle extends PaintAll {

    public FillCircle(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    @Override
    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.fillOval(x - (atribute / 2), y - (atribute / 2), atribute, atribute);
    }


}
