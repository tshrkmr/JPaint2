package model.persistence;

import model.interfaces.*;
public class CommandSelectShape implements ICommand {

    private final Point startPoint, endPoint;
    private final ShapeList shapeList;

    public CommandSelectShape(Point startPoint, Point endPoint, ShapeList shapeList) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
    }

    @Override
    public void run() {
        System.out.println("Select Command");

        int startX = Math.min(startPoint.getX(), endPoint.getX());
        int startY = Math.min(startPoint.getY(), endPoint.getY());
        int width = Math.abs(startPoint.getX() - endPoint.getX());
        int height = Math.abs(startPoint.getY() - endPoint.getY());

        for (Shape s : shapeList.getDrawShapeList()) {
            //System.out.println(s.getStartX() + " " + s.getStartY() + " " + s.getWidth() + " " + s.getHeight());
            if (startX < s.getStartX() + s.getWidth() && startX + width > s.getStartX() &&
                    startY < s.getStartY() + s.getHeight() && startY + height > s.getStartY()) {
                shapeList.selectShapeList.clear();
                shapeList.addSelectShape(s);
                System.out.println("# of shapes Selected " + shapeList.getSelectedShapeList().size());
            } else {
                System.out.println("Nothing Selected!!");
            }
        }
    }
}