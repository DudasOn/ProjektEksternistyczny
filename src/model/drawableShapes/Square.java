package model.drawableShapes;

import model.drawableShapes.drawInterface.drawShape.DrawSquare;
import model.drawableShapes.drawInterface.fillShape.FillSquare;

import java.awt.*;

public class Square extends Shape {

    private static final long serialVersionUID = -6548560327968536545L;

    private final int sideLength;

    public Square() {
        super();

        sideLength = 50;
        this.drawMe = new FillSquare(this.posX, this.posY, this.sideLength, this.color);
    }

    public Square(int posX, int posY, Color color, int sideLength, boolean ifFilledIn, boolean ifCovering) {
        super(posX, posY, color, ifFilledIn, ifCovering);

        this.sideLength = sideLength;
        if (ifFilledIn) this.drawMe = new FillSquare(this.posX, this.posY, this.sideLength, this.color);
        else this.drawMe = new DrawSquare(this.posX, this.posY, this.sideLength, this.color);
    }
}
