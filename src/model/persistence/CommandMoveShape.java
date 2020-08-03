package model.persistence;

import model.interfaces.ICommand;
import model.interfaces.IUndoRedo;
import view.interfaces.PaintCanvasBase;

public class CommandMoveShape implements ICommand, IUndoRedo {

    private final Point startPoint, endPoint;
    private final ShapeList shapeList;
    private final PaintCanvasBase paintCanvas;
    private int dx, dy;

    public CommandMoveShape(Point startPoint, Point endPoint, ShapeList shapeList, PaintCanvasBase paintCanvas){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void run() {

        System.out.println("Move Command");

        dx = endPoint.getX() - startPoint.getX();
        dy = endPoint.getY() - startPoint.getY();

        Move();

        CommandHistory.add(this);
        System.out.println("# of Shapes Moved " + shapeList.getDrawShapeList().size());
    }

    @Override
    public void undo() {
        for (Shape shape : shapeList.getSelectShapeList()) {
            shapeList.removeDrawShape(shape);
            shape.setStartX(shape.getStartX() - dx);
            shape.setStartY(shape.getStartY() - dy);
            shapeList.addDrawShape(shape);
        }
        ClearCanvasIterateShape.clearAndDraw(paintCanvas, shapeList);
    }

    @Override
    public void redo() {
        Move();
    }

    private void Move() {
        for (Shape shape : shapeList.getSelectShapeList()) {
            shapeList.removeDrawShape(shape);
            shape.setStartX(shape.getStartX() + dx);
            shape.setStartY(shape.getStartY() + dy);
            shapeList.addDrawShape(shape);
        }
        ClearCanvasIterateShape.clearAndDraw(paintCanvas, shapeList);
    }
}
