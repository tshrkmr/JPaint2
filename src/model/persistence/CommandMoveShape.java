package model.persistence;

import model.interfaces.ICommand;
import view.interfaces.PaintCanvasBase;

public class CommandMoveShape implements ICommand {

    private final Point startPoint, endPoint;
    private final ShapeList shapeList;
    private final PaintCanvasBase paintCanvas;

    public CommandMoveShape(Point startPoint, Point endPoint, ShapeList shapeList, PaintCanvasBase paintCanvas){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void run() {

        System.out.println("Move Command");

        int dx = endPoint.getX() - startPoint.getX();
        int dy = endPoint.getY() - startPoint.getY();

        for (Shape shape : shapeList.getSelectShapeList()) {
            shapeList.removeDrawShape(shape);
            shape.setStartX(shape.getStartX() + dx);
            shape.setStartY(shape.getStartY() + dy);
            shapeList.addDrawShape(shape);
        }

        ClearCanvas.clear(paintCanvas);

        for (Shape shape : shapeList.getDrawShapeList()) {
            //FactorySelectShape factorySelectShape = new FactorySelectShape();
            FactorySelectShape.select(paintCanvas, shape);
        }
        System.out.println("# of Shapes Moved " + shapeList.getDrawShapeList().size());
    }
}
