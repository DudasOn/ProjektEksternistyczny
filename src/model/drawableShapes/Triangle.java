package model.drawableShapes;

import model.drawableShapes.drawInterface.drawShape.DrawTriangle;
import model.drawableShapes.drawInterface.fillShape.FillTriangle;
import java.awt.*;

public class Triangle extends Shape {

    private static final long serialVersionUID = -2476412665637375549L;
    
    private int sideLength;

    public Triangle() {
        super();

        sideLength = 50;
        drawMe = new FillTriangle(this.posX, this.posY, this.sideLength, this.color);
    }

    public Triangle(int posX, int posY, Color color, int sideLength, boolean ifFilledIn, boolean ifCovering) {
        super(posX, posY, color, ifFilledIn, ifCovering);

        this.sideLength = sideLength;
        if (ifFilledIn) drawMe = new FillTriangle(this.posX, this.posY, this.sideLength, this.color);
        else drawMe = new DrawTriangle(this.posX, this.posY, this.sideLength, this.color);
    }
}
