package model.drawableShapes;

import model.drawableShapes.drawInterface.PaintInteface;
import java.awt.*;
import java.io.Serializable;

public abstract class Drawable implements Serializable {
    protected Color color;
    protected PaintInteface drawMe;
    protected int posX;
    protected int posY;
    protected boolean ifCovering;

    public Drawable() {
        color = new Color(0,0,0);
        this.ifCovering = false;
        this.posX = 100;
        this.posY = 100;
    }

    public Drawable(int posX, int posY,Color color, boolean ifCovering) {
        this.color = color;
        this.ifCovering = ifCovering;
        this.posX = posX;
        this.posY = posY;
    }

    public PaintInteface getDrawMe(){
        return this.drawMe;
    }

    public Color getColor(){
        return this.color;
    }

    public boolean getIfCovering(){
        return this.ifCovering;
    }

    public void setColor(Color color){
        this.color=color;
    }
}
