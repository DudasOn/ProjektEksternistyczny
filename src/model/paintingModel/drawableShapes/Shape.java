package model.paintingModel.drawableShapes;

import java.awt.*;

public abstract class Shape extends Drawable {

    private static final long serialVersionUID = -205830904934342349L;

    protected boolean ifFilledIn;

    public Shape() {
        super();

        this.ifFilledIn = true;
    }

    public Shape(int posX, int posY, Color color, boolean ifFilledIn, boolean ifCovering) {
        super(posX, posY, color, ifCovering);

        this.ifFilledIn = ifFilledIn;
    }
}
