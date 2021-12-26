package model.drawableShapes.drawInterface;

import java.awt.*;

public abstract class PaintAll implements PaintInteface {
    protected int x;
    protected int y;
    protected int atribute;
    protected Color color;

    public PaintAll(int x, int y, int atribute, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
        this.atribute = atribute;
    }

    protected Graphics2D setGraphicsProperties(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        g2d.setColor(color);

        return g2d;
    }
}
