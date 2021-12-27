package model.drawableShapes.drawInterface.fillShape;

import model.drawableShapes.Drawable;
import model.drawableShapes.drawInterface.PaintAll;
import java.awt.*;

public class FillCircle extends PaintAll {

    public FillCircle(int x, int y, int radius, Drawable drawable) {
        super(x, y, radius, drawable);
    }

    @Override
    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.fillOval(x - (atribute / 2), y - (atribute / 2), atribute, atribute);
    }
}
