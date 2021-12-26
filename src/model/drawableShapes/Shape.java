package model.drawableShapes;

import java.awt.*;

public abstract class Shape extends Drawable {

    private static final long serialVersionUID = -205830904934342349L;

    protected int posX;
    protected int posY;

    public Shape() {
        super();
        this.posX = 100;
        this.posY = 100;
    }

    public Shape(int posX, int posY, Color color) {
        super(color);
        this.posX = posX;
        this.posY = posY;
    }

}
