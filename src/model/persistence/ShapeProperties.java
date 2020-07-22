package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeProperties;
import java.awt.*;

public class ShapeProperties implements IShapeProperties {

    int startX, startY, width, height;
    private ShapeType shapeType;
    private ShapeShadingType shadeType;
    private ShapeColor primaryColor, secondaryColor;
    public IApplicationState appState;
    private Stroke stroke;
    private Point startPoint, endPoint;
    private ShapeList shapeList;


    public ShapeProperties(Point startPoint, Point endPoint,IApplicationState appState, ShapeList shapeList){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.appState = appState;
        this.shapeList = shapeList;
    }

    public void setProperties() {
        this.shapeType = appState.getActiveShapeType();
        this.shadeType = appState.getActiveShapeShadingType();
        this.primaryColor = appState.getActivePrimaryColor();
        this.secondaryColor = appState.getActiveSecondaryColor();
        //stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        stroke = new BasicStroke(4);

        startX = Math.min(startPoint.getX(), endPoint.getX());
        startY = Math.min(startPoint.getY(), endPoint.getY());
        width = Math.abs(startPoint.getX() - endPoint.getX());
        height = Math.abs(startPoint.getY() - endPoint.getY());

        setStartX(startX);
        setStartY(startY);
        setWidth(width);
        setHeight(height);
    }

    public void setStartX(int x){
        this.startX = x;
    }

    public void setStartY(int y){
        this.startY = y;
    }

    public void setWidth(int w){
        this.width = w;
    }

    public void setHeight(int h){
        this.height = h;
    }

    public int getStartX(){
        return startX;
    }

    public int getStartY(){
        return startY;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public ShapeType getShapeType(){
        return shapeType;
    }

    public ShapeShadingType getShadeType(){
        return shadeType;
    }

    public ShapeColor getPrimaryColor(){
        return primaryColor;
    }

    public ShapeColor getSecondaryColor(){
        return secondaryColor;
    }

    public Stroke getStroke(){
        return stroke;
    }

}
