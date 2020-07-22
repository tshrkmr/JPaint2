package model.interfaces;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public interface IShapeProperties {
    void setProperties();
    int getStartX();
    int getStartY();
    int getWidth();
    int getHeight();
    void setStartX(int x);
    void setStartY(int y);
    void setWidth(int width);
    void setHeight(int height);
    ShapeType getShapeType();
    ShapeShadingType getShadeType();
    ShapeColor getSecondaryColor();
    ShapeColor getPrimaryColor();
    Stroke getStroke();
}
