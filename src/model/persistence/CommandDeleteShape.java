package model.persistence;

import model.interfaces.ICommand;
import view.interfaces.PaintCanvasBase;

public class CommandDeleteShape implements ICommand {

    private final ShapeList shapeList;
    private final PaintCanvasBase paintCanvas;

    public CommandDeleteShape(ShapeList shapeList, PaintCanvasBase paintCanvas){
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void run() {
        System.out.println("Delete Command");

        for (Shape shape : shapeList.getSelectShapeList()) {
            shapeList.addDeleteShape(shape);
            shapeList.removeDrawShape(shape);
        }

        ClearCanvas.clear(paintCanvas);

        for (Shape shape : shapeList.getDrawShapeList()) {
            FactorySelectShape factorySelectShape = new FactorySelectShape();
            factorySelectShape.select(paintCanvas, shape);
        }
        System.out.println("# of Shapes Deleted " + shapeList.getDeleteShapeList().size());
    }
}
