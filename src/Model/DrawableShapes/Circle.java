package Model.DrawableShapes;

import Model.ColorConverter;

public class Circle extends Shape {

    private static final long serialVersionUID = -154076889492952007L;
    private int radius;

    public Circle() {
        super();
        radius = 5;
    }

    public Circle(int posX, int posY, ColorConverter color, int radius) {
        super(posX, posY, color);
        this.radius = radius;
    }


}
