package model.drawableShapes.drawInterface;

import java.awt.*;

public class FillCircle extends PaintAll {

    public FillCircle(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.atribute = radius;
    }

    @Override
    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.fillOval(x - (atribute / 2), y - (atribute / 2), atribute, atribute);
    }


}
