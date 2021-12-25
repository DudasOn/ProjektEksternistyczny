package model.drawableShapes;

import java.awt.*;

public class Triangle extends Shape {

    private static final long serialVersionUID = -2476412665637375549L;
    private int distanceFromCenterToApex;

    public Triangle() {
        super();
        distanceFromCenterToApex = 5;
    }

    public Triangle(int posX, int posY, Color color, int distanceFromCenterToApex) {
        super(posX, posY, color);
        this.distanceFromCenterToApex = distanceFromCenterToApex;
    }
}
