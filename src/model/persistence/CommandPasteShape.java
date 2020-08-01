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
            Shape pasteShape = new Shape(shape.getStartPoint(), shape.getEndPoint(), shape.appState);
            pasteShape.setShapeType(shape.getShapeType());
            pasteShape.setShadeType(shape.getShadeType());
            pasteShape.setPrimaryColor(shape.getPrimaryColor());
            pasteShape.setSecondaryColor(shape.getSecondaryColor());
            pasteShape.setStartX(shape.getStartX() + offset);
            pasteShape.setStartY(shape.getStartY() + offset);
            pasteShape.setWidth(shape.getWidth());
            pasteShape.setHeight(shape.getHeight());
            pasteShape.setStroke(shape.getStroke());
            shapeList.addDrawShape(pasteShape);
        }

        ClearCanvas.clear(paintCanvas);

        for (Shape shape : shapeList.getDrawShapeList()) {
            System.out.println("Hello1");
            FactorySelectShape factorySelectShape = new FactorySelectShape();
            factorySelectShape.select(paintCanvas, shape);
        }

        System.out.println("# of Shapes Pasted " + shapeList.getDrawShapeList().size());
    }
}
