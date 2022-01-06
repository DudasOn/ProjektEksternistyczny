package model.paintingModel.drawableShapes;

import model.paintingModel.drawableShapes.drawInterface.drawShape.DrawCircle;
import model.paintingModel.drawableShapes.drawInterface.fillShape.FillCircle;

import java.awt.*;

public class Circle extends Shape {

    private static final long serialVersionUID = -154076889492952007L;

    private final int diameter;

    public Circle() {
        super();

        diameter = 50;
        this.drawMe = new FillCircle(this.posX, this.posY, this.diameter, this.color);
    }

    public Circle(int posX, int posY, Color color, int diameter, boolean ifFilledIn, boolean ifCovering) {
        super(posX, posY, color, ifFilledIn, ifCovering);

        this.diameter = diameter;
        if (ifFilledIn) this.drawMe = new FillCircle(this.posX, this.posY, this.diameter, this.color);
        else this.drawMe = new DrawCircle(this.posX, this.posY, this.diameter, this.color);
    }
}
