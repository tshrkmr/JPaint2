package model.interfaces;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public interface IShape {
    void setProperties();
    int getStartX();
    int getStartY();
    int getWidth();
    int getHeight();
    void setStartX(int x);
    void setStartY(int y);
    void setWidth(int width);
    void setHeight(int height);
    void setStroke(Stroke stroke);
    void setPrimaryColor(ShapeColor primaryColor);
    void setShadeType(ShapeShadingType shadeType);
    void setShapeType(ShapeType shapeType);
    ShapeType getShapeType();
    ShapeShadingType getShadeType();
    ShapeColor getSecondaryColor();
    ShapeColor getPrimaryColor();
    Stroke getStroke();
    model.persistence.Point getStartPoint();
    Point getEndPoint();
    IApplicationState getAppState();
    PaintCanvasBase getPaintCanvas();
}
