package model.drawableShapes;

import model.drawableShapes.drawInterface.PaintInterface;

import java.awt.*;
import java.io.Serializable;

public abstract class Drawable implements Serializable {

    private static final long serialVersionUID = 152179614998769691L;

    protected Color color;
    protected PaintInterface drawMe;
    protected int posX;
    protected int posY;
    protected boolean ifCovering;

    public Drawable() {
        color = new Color(0, 0, 0);
        this.ifCovering = false;
        this.posX = 100;
        this.posY = 100;
    }

    public Drawable(int posX, int posY, Color color, boolean ifCovering) {
        this.color = color;
        this.ifCovering = ifCovering;
        this.posX = posX;
        this.posY = posY;
    }

    public PaintInterface getDrawMe() {
        return this.drawMe;
    }

    public Color getColor() {
        return this.color;
    }

    public boolean getIfCovering() {
        return this.ifCovering;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
