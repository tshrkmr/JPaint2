package model.persistence;

import model.interfaces.*;
public class CommandSelectShape implements ICommand {

    private Point startPoint, endPoint;

    private int startX, startY, width, height;
    private ShapeList shapeList;
    private ShapeProperties sp;


    public CommandSelectShape(Point startPoint, Point endPoint, ShapeProperties sp, ShapeList shapeList) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
        this.sp = sp;
    }

    @Override
    public void run() {
        System.out.println("Select Command");

        startX = Math.min(startPoint.getX(), endPoint.getX());
        startY = Math.min(startPoint.getY(), endPoint.getY());
        width = Math.abs(startPoint.getX() - endPoint.getX());
        height = Math.abs(startPoint.getY() - endPoint.getY());

        for (ShapeProperties s : shapeList.getDrawShapeList()) {
            //System.out.println(s.getStartX() + " " + s.getStartY() + " " + s.getWidth() + " " + s.getHeight());
            if (startX < s.getStartX() + s.getWidth() && startX + width > s.getStartX() &&
                    startY < s.getStartY() + s.getHeight() && startY + height > s.getStartY()) {
                shapeList.addSelectShape(s);
                System.out.println("# of shapes Selected" + shapeList.getSelectedShapeList().size());
            } else {
                System.out.println("No Match!!");
            }
        }
    }
}