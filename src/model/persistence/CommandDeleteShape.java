package model.persistence;

import model.interfaces.ICommand;
import model.interfaces.IUndoRedo;
import view.interfaces.PaintCanvasBase;

public class CommandDeleteShape implements ICommand, IUndoRedo {

    private final ShapeList shapeList;
    private final PaintCanvasBase paintCanvas;

    public CommandDeleteShape(ShapeList shapeList, PaintCanvasBase paintCanvas){
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void run() {
        System.out.println("Delete Command");

        Delete();
        CommandHistory.add(this);

        System.out.println("# of Shapes Deleted " + shapeList.getDeleteShapeList().size());
    }

    @Override
    public void undo() {
        for (Shape shape : shapeList.getSelectShapeList()) {
            shapeList.addDrawShape(shape);
        }
        ClearCanvasIterateShape.clearAndDraw(paintCanvas, shapeList);
    }

    @Override
    public void redo() {
        Delete();
    }

    private void Delete(){
        for (Shape shape : shapeList.getSelectShapeList()) {
            shapeList.removeDrawShape(shape);
        }
        ClearCanvasIterateShape.clearAndDraw(paintCanvas, shapeList);
    }
}
