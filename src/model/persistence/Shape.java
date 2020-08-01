package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;

import java.awt.*;

public class Shape implements IShape {

    private int startX, startY, width, height;
    private ShapeType shapeType;
    private ShapeShadingType shadeType;
    private ShapeColor primaryColor, secondaryColor;
    public IApplicationState appState;
    private Stroke stroke;
    private final Point startPoint, endPoint;

    public Shape(Point startPoint, Point endPoint, IApplicationState appState){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.appState = appState;
    }

    public void setProperties() {

        setShapeType(appState.getActiveShapeType());
        setShadeType(appState.getActiveShapeShadingType());
        setPrimaryColor(appState.getActivePrimaryColor());
        setSecondaryColor(appState.getActiveSecondaryColor());
        stroke = new BasicStroke(4);
        setStroke(stroke);
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

    public void setShapeType(ShapeType shapeType){
        this.shapeType = shapeType;
    }

    public void setShadeType(ShapeShadingType shadeType){
        this.shadeType = shadeType;
    }

    public void setPrimaryColor(ShapeColor primaryColor){
        this.primaryColor = primaryColor;
    }

    public void setSecondaryColor(ShapeColor secondaryColor){
        this.secondaryColor = secondaryColor;
    }

    public void setStroke(Stroke stroke) {this.stroke = stroke;}

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

    public Point getStartPoint(){return startPoint;}

    public Point getEndPoint(){return endPoint;}
}
