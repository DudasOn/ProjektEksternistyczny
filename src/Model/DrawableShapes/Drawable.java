package Model.DrawableShapes;

import Model.ColorConverter;

import java.io.Serializable;

public abstract class Drawable implements Serializable {
    private ColorConverter color;

    public Drawable() {
        color = new ColorConverter();
    }

    public Drawable(ColorConverter color) {
        this.color = color;
    }
}
