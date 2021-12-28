package model.drawableShapes.drawInterface.drawShape;

import model.drawableShapes.drawInterface.PaintAll;
import java.awt.*;

public class DrawSquare extends PaintAll {

    private static final long serialVersionUID = 3758627117775789534L;

    public DrawSquare(int x, int y, int sideLength, Color color) {
        super(x, y, sideLength, color);
    }

    @Override
    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.drawRect(x - (attribute / 2), y - (attribute / 2), attribute, attribute);
    }
}
