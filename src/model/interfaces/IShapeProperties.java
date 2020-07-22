package model.interfaces;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

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
    //boolean isOverlapping(int startX, int startY, int width, int height);
    //boolean isOverlapping(int x, int y, int width, int height);
}
