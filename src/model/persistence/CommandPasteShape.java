package model.persistence;

import model.interfaces.ICommand;
import view.interfaces.PaintCanvasBase;

public class CommandPasteShape implements ICommand {

    private final ShapeList shapeList;
    private final PaintCanvasBase paintCanvas;

    public CommandPasteShape(ShapeList shapeList, PaintCanvasBase paintCanvas){
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
            //FactorySelectShape factorySelectShape = new FactorySelectShape();
            FactorySelectShape.select(paintCanvas, shape);
        }

        System.out.println("# of Shapes Pasted " + shapeList.getDrawShapeList().size());
    }
}
