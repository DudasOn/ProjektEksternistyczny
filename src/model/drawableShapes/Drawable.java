package model.drawableShapes;

import model.drawableShapes.drawInterface.DrawInterface;
import java.awt.*;
import java.io.Serializable;

public abstract class Drawable implements Serializable {
    private Color color;
    protected DrawInterface drawMe;

    public Drawable() {
        color = new Color(0,0,0);
    }

    public Drawable(Color color) {
        this.color = color;
    }
}
