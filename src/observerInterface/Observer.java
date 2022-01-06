package observerInterface;

import model.paintingModel.drawableShapes.Drawable;

public interface Observer {
    void update(Drawable drawable);
}
