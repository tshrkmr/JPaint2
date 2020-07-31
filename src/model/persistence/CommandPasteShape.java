package model.persistence;

import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import view.interfaces.PaintCanvasBase;

public class CommandPasteShape implements ICommand {

    private final ShapeList shapeList;
    private final PaintCanvasBase paintCanvas;
    private final IApplicationState appState;

    public CommandPasteShape(ShapeList shapeList, PaintCanvasBase paintCanvas, IApplicationState appState){
        this.appState = appState;
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
    }
    @Override
    public void run() {
        System.out.println("Paste Command");

        int offset = 100;
        for (Shape shape : shapeList.getCopyShapeList()) {
            Shape pasteShape = new Shape(shape.getStartPoint(), shape.getEndPoint(), appState);
            pasteShape.setProperties();
            pasteShape.setStartX(shape.getStartX() + offset);
            pasteShape.setStartY(shape.getStartY() + offset);
            shapeList.addDrawShape(pasteShape);
        }

        ClearCanvas clearCanvas= new ClearCanvas();
        clearCanvas.clear(paintCanvas);

        for (Shape shape1 : shapeList.getDrawShapeList()) {
            FactorySelectShape factorySelectShape = new FactorySelectShape();
            factorySelectShape.select(paintCanvas, shape1);
        }
        System.out.println("# of Shapes Pasted " + shapeList.getDrawShapeList().size());
    }
}
