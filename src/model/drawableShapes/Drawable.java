package model.drawableShapes;

import model.drawableShapes.drawInterface.PaintInteface;
import java.awt.*;
import java.io.Serializable;

public abstract class Drawable implements Serializable {
    protected Color color;
    protected PaintInteface drawMe;

    public Drawable() {
        color = new Color(0,0,0);
    }

    public Drawable(Color color) {
        this.color = color;
    }

    public PaintInteface getDrawMe(){
        return this.drawMe;
    }

    public Color getColor(){
        return color;
    }
}
