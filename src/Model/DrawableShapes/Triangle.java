package Model.DrawableShapes;

import Model.ColorConverter;

public class Triangle extends Shape {

    private static final long serialVersionUID = -2476412665637375549L;
    private int distanceFromCenterToApex;

    public Triangle() {
        super();
        distanceFromCenterToApex = 5;
    }

    public Triangle(int posX, int posY, ColorConverter color, int distanceFromCenterToApex) {
        super(posX, posY, color);
        this.distanceFromCenterToApex = distanceFromCenterToApex;
    }
}
