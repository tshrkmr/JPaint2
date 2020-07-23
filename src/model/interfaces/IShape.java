package model.interfaces;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;

public interface IShape {
    void setProperties();
    int getStartX();
    int getStartY();
    int getWidth();
    int getHeight();
    void setMoveX(int x);
    void setMoveY(int y);
    int getMoveX();
    int getMoveY();
    void setStartX(int x);
    void setStartY(int y);
    void setWidth(int width);
    void setHeight(int height);
    ShapeType getShapeType();
    ShapeShadingType getShadeType();
    ShapeColor getSecondaryColor();
    ShapeColor getPrimaryColor();
    Stroke getStroke();
    void createMovedShape(int newStartX, int newStartY, int newWidth, int newHeight, Stroke newStroke);
}
