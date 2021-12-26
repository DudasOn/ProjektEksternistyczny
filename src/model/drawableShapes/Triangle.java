package model.drawableShapes;

import model.drawableShapes.drawInterface.FillTriangle;

import java.awt.*;

public class Triangle extends Shape {

    private static final long serialVersionUID = -2476412665637375549L;
    private int sideLength;

    public Triangle() {
        super();
        sideLength = 50;
        drawMe = new FillTriangle(this.posX,this.posY,this.sideLength,this.color);
    }

    public Triangle(int posX, int posY, Color color, int sideLength) {
        super(posX, posY, color);
        this.sideLength = sideLength;
        drawMe = new FillTriangle(this.posX,this.posY,this.sideLength,this.color);
    }
}
