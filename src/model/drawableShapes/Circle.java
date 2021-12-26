package model.drawableShapes;

import model.drawableShapes.drawInterface.FillCircle;

import java.awt.*;

public class Circle extends Shape {

    private static final long serialVersionUID = -154076889492952007L;
    private int radius;

    public Circle() {
        super();
        radius = 50;
        this.drawMe = new FillCircle(this.posX,this.posY,this.radius,this.color);
    }

    public Circle(int posX, int posY, Color color, int radius) {
        super(posX, posY, color);
        this.radius = radius;
        this.drawMe = new FillCircle(this.posX,this.posY,this.radius,this.color);
    }


}
