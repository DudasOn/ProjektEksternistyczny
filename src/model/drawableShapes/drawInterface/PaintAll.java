package model.drawableShapes.drawInterface;

import model.drawableShapes.Drawable;
import java.awt.*;

public abstract class PaintAll implements PaintInteface {
    protected int x;
    protected int y;
    protected int atribute;
    protected Drawable drawable;

    public PaintAll(int x, int y, int atribute, Drawable drawable) {
        this.x = x;
        this.y = y;
        this.atribute = atribute;
        this.drawable = drawable;
    }

    protected Graphics2D setGraphicsProperties(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        g2d.setColor(drawable.getColor());

        return g2d;
    }
}
