package model.drawableShapes.drawInterface;

import java.awt.*;

public class FillSquare extends PaintAll {

    public FillSquare(int x, int y, int sideLength, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.atribute = sideLength;
    }

    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.fillRect(x - (atribute / 2), y - (atribute / 2), atribute, atribute);
    }
}
