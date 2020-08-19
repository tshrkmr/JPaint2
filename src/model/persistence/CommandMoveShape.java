package model.persistence;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoRedo;
import view.interfaces.PaintCanvasBase;

public class CommandMoveShape implements ICommand, IUndoRedo {

    private final ShapeList shapeList;
    private final PaintCanvasBase paintCanvas;
    private int dx, dy;
    private final IShape shape;

    public CommandMoveShape(IShape shape, ShapeList shapeList, PaintCanvasBase paintCanvas){
        this.shape = shape;
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void run() {

        System.out.println("Move Command");

        dx = shape.getEndPoint().getX() - shape.getStartPoint().getX();
        dy = shape.getEndPoint().getY() - shape.getStartPoint().getY();

        moveShape();

        CommandHistory.add(this);
        System.out.println("# of Shapes Moved " + shapeList.getDrawShapeList().size());
    }

    @Override
    public void undo() {
        for (IShape shape : shapeList.getSelectShapeList()) {
            shapeList.removeDrawShape(shape);
            shape.setStartX(shape.getStartX() - dx);
            shape.setStartY(shape.getStartY() - dy);
            shapeList.addDrawShape(shape);
        }
        ClearCanvasIterateShape.clearAndDraw(paintCanvas, shapeList);
    }

    @Override
    public void redo() {
        moveShape();
    }

    private void moveShape() {
        for (IShape shape : shapeList.getSelectShapeList()) {
            shapeList.removeDrawShape(shape);
            shape.setStartX(shape.getStartX() + dx);
            shape.setStartY(shape.getStartY() + dy);
            shapeList.addDrawShape(shape);
        }
        ClearCanvasIterateShape.clearAndDraw(paintCanvas, shapeList);
    }
}
