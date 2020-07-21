package model.persistence;

import model.ShapeColor;
import model.interfaces.ICalculate;
import model.interfaces.IShapeProperties;

public class ShapeCalculation implements ICalculate {

    IShapeProperties sp;

    public ShapeCalculation(IShapeProperties sp){
        this.sp = sp;
    }
    @Override
    public void Calculate(Point startPoint, Point endPoint) {
        //Point minimum = new Point(Math.min(startPoint.getX(), endPoint.getX()), Math.min(startPoint.getY(), endPoint.getY()));
        //Point maximum = new Point(Math.max(startPoint.getX(), endPoint.getX()), Math.max(startPoint.getY(), endPoint.getY()));
        //System.out.println(startPoint + "22");
        int startX = Math.min(startPoint.getX(), endPoint.getX());
        int startY = Math.min(startPoint.getY(), endPoint.getY());
        int width = Math.abs(startPoint.getX() - endPoint.getX());
        int height = Math.abs(startPoint.getY() - endPoint.getY());

        sp.setStartPoint(startPoint);
        sp.setEndPoint(endPoint);
        sp.setStartX(startX);
        sp.setStartY(startY);
        sp.setWidth(width);
        sp.setHeight(height);
    }
}
