package model.persistence;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoRedo;
import view.interfaces.PaintCanvasBase;

public class CommandCreateShape implements ICommand, IUndoRedo {

    private final PaintCanvasBase paintCanvas;
    private final ShapeList shapeList;
    private final IShape shape;

    public CommandCreateShape(IShape shape,PaintCanvasBase paintCanvas, ShapeList shapeList){
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
        this.shape = shape;
    }

    @Override
    public void run() {
        createShape();
        CommandHistory.add(this);
    }


    @Override
    public void undo() {
        shapeList.removeDrawShape(shape);
        ClearCanvasIterateShape.clearAndDraw(paintCanvas, shapeList);
    }

    @Override
    public void redo() {
        createShape();
    }

    private void createShape(){

        shapeList.addDrawShape(shape);
        System.out.println("# of shapes Drawn " + shapeList.getDrawShapeList().size());

        FactorySelectShape.select(paintCanvas, shape);
    }
}
