package model.DrawableShapes;

import model.ColorConverter;

public class Square extends Shape {

    private static final long serialVersionUID = -6548560327968536545L;
    private int sideLength;

    public Square() {
        super();
        sideLength = 5;
    }

    public Square(int posX, int posY, ColorConverter color, int sideLength) {
        super(posX, posY, color);
        this.sideLength = sideLength;
    }
}
