package model.persistence;

import model.interfaces.*;
import view.interfaces.PaintCanvasBase;

public class CommandCreateShape implements ICommand, IUndoRedo {

    private final PaintCanvasBase paintCanvas;
    private final ShapeList shapeList;
    private final Point startPoint, endPoint;
    private final IApplicationState appState;
    private Shape shape;

    public CommandCreateShape(Point startPoint, Point endPoint,PaintCanvasBase paintCanvas, ShapeList shapeList, IApplicationState appState){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
        this.appState = appState;
    }

    @Override
    public void run() {
//        Shape shape = new Shape(startPoint, endPoint, appState);
//        shape.setProperties();
//
//        shapeList.addDrawShape(shape);
//        System.out.println("# of shapes Drawn " + shapeList.getDrawShapeList().size());
//
//        //FactorySelectShape factorySelectShape = new FactorySelectShape();
//        //FactorySelectShape.select(paintCanvas, shape);
//        ClearCanvasIterateShape.clearAndDraw(paintCanvas, shapeList);
        createShape();
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
        shape = new Shape(startPoint, endPoint, appState);
        shape.setProperties();

        shapeList.addDrawShape(shape);
        System.out.println("# of shapes Drawn " + shapeList.getDrawShapeList().size());

        FactorySelectShape.select(paintCanvas, shape);
    }
}
