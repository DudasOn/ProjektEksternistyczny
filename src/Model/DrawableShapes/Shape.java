package Model.DrawableShapes;

import Model.ColorConverter;

public abstract class Shape extends Drawable {

    private static final long serialVersionUID = -205830904934342349L;

    private int posX;
    private int posY;

    public Shape() {
        super();
        posX = 0;
        posY = 0;
    }

    public Shape(int posX, int posY, ColorConverter color) {
        super(color);
        this.posX = posX;
        this.posY = posY;
    }

}
