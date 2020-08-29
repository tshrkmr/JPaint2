package model.persistence;

import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;



public class CommandSelectShape implements ICommand {

    private final ShapeList shapeList;
    private final IApplicationState appState;
    private final PaintCanvasBase paintCanvas;
    private final IShape shape;

    public CommandSelectShape(IShape shape, ShapeList shapeList, IApplicationState appState, PaintCanvasBase paintCanvas) {
        this.shape = shape;
        this.shapeList = shapeList;
        this.appState = appState;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void run() {
        System.out.println("Select Command");
        shapeList.selectShapeList.clear();

        Shape selectShape = new Shape(shape.getStartPoint(), shape.getEndPoint(), appState, paintCanvas);
        selectShape.setProperties();

        for (IShape shape : shapeList.getDrawShapeList()) {
            if (selectShape.getStartX() < shape.getStartX() + shape.getWidth()
                    && selectShape.getStartX() + selectShape.getWidth() > shape.getStartX()
                    && selectShape.getStartY() < shape.getStartY() + shape.getHeight()
                    && selectShape.getStartY() + selectShape.getHeight() > shape.getStartY()
                    && shapeList.getGroupShapeList().contains(shape)) {
                shapeList.removeGroupShape(shape);
                shapeList.addSelectShape(shape);
            } else if (selectShape.getStartX() < shape.getStartX() + shape.getWidth()
                    && selectShape.getStartX() + selectShape.getWidth() > shape.getStartX()
                    && selectShape.getStartY() < shape.getStartY() + shape.getHeight()
                    && selectShape.getStartY() + selectShape.getHeight() > shape.getStartY()) {

                shapeList.addSelectShape(shape);
                for (IShape s1 : shapeList.getGroupShapeList()) {
                    shapeList.addSelectShape(s1);
                }
            } else {

            }
            System.out.println("# of shapes Selected " + shapeList.getSelectShapeList().size());
        }
    }
}