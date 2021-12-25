package model.drawableShapes;

import java.awt.*;
import java.io.Serializable;

public abstract class Drawable implements Serializable {
    private Color color;

    public Drawable() {
        color = new Color(0,0,0);
    }

    public Drawable(Color color) {
        this.color = color;
    }
}
