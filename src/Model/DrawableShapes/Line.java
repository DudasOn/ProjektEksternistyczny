package Model.DrawableShapes;

import Model.ColorConverter;

public class Line extends Drawable {
    private static final long serialVersionUID = -5800083897933493382L;

    int posXStart, posYStart;
    int posXStop, posYStop;


    public Line() {
        super();
        posXStart = 0;
        posYStart = 0;
        posXStop = 0;
        posYStop = 0;
    }

    public Line(int posXStart, int posYStart, int posXStop, int posYStop, ColorConverter color) {
        super(color);
        this.posXStart = posXStart;
        this.posYStart = posYStart;
        this.posXStop = posXStop;
        this.posYStop = posYStop;
    }


}
