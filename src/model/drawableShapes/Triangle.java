package model.drawableShapes;

import model.drawableShapes.drawInterface.DrawTriangle;
import java.awt.*;

public class Triangle extends Shape {

    private static final long serialVersionUID = -2476412665637375549L;
    private int sideLength;

    public Triangle() {
        super();
        sideLength = 5;
        this.drawMe = new DrawTriangle();
    }

    public Triangle(int posX, int posY, Color color, int sideLength) {
        super(posX, posY, color);
        this.sideLength = sideLength;
        this.drawMe = new DrawTriangle();
    }
}
