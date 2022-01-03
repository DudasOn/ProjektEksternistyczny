package model.drawableShapes;

import model.drawableShapes.drawInterface.drawShape.DrawCircle;
import model.drawableShapes.drawInterface.fillShape.FillCircle;

import java.awt.*;

public class Circle extends Shape {

    private static final long serialVersionUID = -154076889492952007L;

    private final int radius;

    public Circle() {
        super();

        radius = 50;
        this.drawMe = new FillCircle(this.posX, this.posY, this.radius, this.color);
    }

    public Circle(int posX, int posY, Color color, int radius, boolean ifFilledIn, boolean ifCovering) {
        super(posX, posY, color, ifFilledIn, ifCovering);

        this.radius = radius;
        if (ifFilledIn) this.drawMe = new FillCircle(this.posX, this.posY, this.radius, this.color);
        else this.drawMe = new DrawCircle(this.posX, this.posY, this.radius, this.color);
    }
}
