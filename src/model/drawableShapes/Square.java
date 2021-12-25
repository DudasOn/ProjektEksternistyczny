package model.drawableShapes;

import java.awt.*;

public class Square extends Shape {

    private static final long serialVersionUID = -6548560327968536545L;
    private int sideLength;

    public Square() {
        super();
        sideLength = 5;
    }

    public Square(int posX, int posY, Color color, int sideLength) {
        super(posX, posY, color);
        this.sideLength = sideLength;
    }
}
