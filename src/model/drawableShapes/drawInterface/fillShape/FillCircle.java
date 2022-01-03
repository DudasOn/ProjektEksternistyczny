package model.drawableShapes.drawInterface.fillShape;

import model.drawableShapes.drawInterface.PaintAll;

import java.awt.*;

public class FillCircle extends PaintAll {

    private static final long serialVersionUID = -3987766223137884832L;

    public FillCircle(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    @Override
    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.fillOval(x - (attribute / 2), y - (attribute / 2), attribute, attribute);
    }
}
