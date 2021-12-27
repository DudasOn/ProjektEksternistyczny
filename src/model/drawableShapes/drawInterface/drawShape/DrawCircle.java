package model.drawableShapes.drawInterface.drawShape;

import model.drawableShapes.Drawable;
import model.drawableShapes.drawInterface.PaintAll;

import java.awt.*;

public class DrawCircle extends PaintAll {

    public DrawCircle(int x, int y, int radius,Drawable drawable) {
        super(x, y, radius, drawable);
    }

    @Override
    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.drawOval(x - (atribute / 2), y - (atribute / 2), atribute, atribute);
    }


}
