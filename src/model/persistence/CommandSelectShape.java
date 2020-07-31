package model.persistence;

import model.interfaces.*;
public class CommandSelectShape implements ICommand {

    private final Point startPoint, endPoint;
    private final ShapeList shapeList;
    private final IApplicationState appState;

    public CommandSelectShape(Point startPoint, Point endPoint, ShapeList shapeList, IApplicationState appState) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
        this.appState = appState;
    }

    @Override
    public void run() {
        System.out.println("Select Command");
        shapeList.selectShapeList.clear();

        Shape selectShape = new Shape(startPoint, endPoint, appState);
        selectShape.setProperties();

        for (Shape shape : shapeList.getDrawShapeList()) {
            if (selectShape.getStartX() < shape.getStartX() + shape.getWidth()
                    && selectShape.getStartX() + selectShape.getWidth() > shape.getStartX()
                    && selectShape.getStartY() < shape.getStartY() + shape.getHeight()
                    && selectShape.getStartY() + selectShape.getHeight() > shape.getStartY()) {

                shapeList.addSelectShape(shape);
            } else {
                System.out.println("Nothing Selected!!");
            }
        }
        System.out.println("# of shapes Selected " + shapeList.getSelectShapeList().size());
    }
}