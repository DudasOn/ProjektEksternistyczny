package model.drawableShapes.drawInterface;

import java.awt.*;

public abstract class PaintAll implements PaintInteface {
    protected int x;
    protected int y;
    protected int attribute;
    protected Color color;

    public PaintAll(int x, int y, int attribute, Color color) {
        this.x = x;
        this.y = y;
        this.attribute = attribute;
        this.color = color;
    }

    protected Graphics2D setGraphicsProperties(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        g2d.setColor(this.color);

        return g2d;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
