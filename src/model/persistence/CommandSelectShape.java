package model.persistence;

import model.interfaces.*;
import view.interfaces.PaintCanvasBase;

public class CommandSelectShape implements ICommand {

    private final Point startPoint, endPoint;
    private final ShapeList shapeList;
    private final IApplicationState appState;
    private PaintCanvasBase paintCanvas;

    public CommandSelectShape(Point startPoint, Point endPoint, ShapeList shapeList, IApplicationState appState, PaintCanvasBase paintCanvas) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
        this.appState = appState;
        this.paintCanvas = paintCanvas;
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
                OutlineSelectedShape outlineSelectedShape = new OutlineSelectedShape(shape, paintCanvas);
                outlineSelectedShape.drawDash();
            } else {
                System.out.println("Nothing Selected!!");
            }
        }
        System.out.println("# of shapes Selected " + shapeList.getSelectShapeList().size());
    }
}