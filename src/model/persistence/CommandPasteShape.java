package model.persistence;

import model.interfaces.ICommand;
import model.interfaces.IUndoRedo;
import view.interfaces.PaintCanvasBase;

public class CommandPasteShape implements ICommand, IUndoRedo {

    private final ShapeList shapeList;
    private final PaintCanvasBase paintCanvas;

    public CommandPasteShape(ShapeList shapeList, PaintCanvasBase paintCanvas){
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void run() {
        System.out.println("Paste Command");
        shapeList.pasteShapeList.clear();
        Paste();
        CommandHistory.add(this);
        System.out.println("# of Shapes Pasted " + shapeList.getPasteShapeList().size());
    }

    @Override
    public void undo() {
        System.out.println("Undo Paste");
        for(Shape shape: shapeList.getPasteShapeList()){
            System.out.println("# of Shapes in paste list " + shapeList.getPasteShapeList().size());
            //shapeList.removePasteShape(shape);
            shapeList.removeDrawShape(shape);
            System.out.println("Reached here");
        }
        ClearCanvasIterateShape.clearAndDraw(paintCanvas, shapeList);

    }

    @Override
    public void redo() {
        Paste();
    }

    private void Paste(){
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
            shapeList.addPasteShape(pasteShape);
            shapeList.addDrawShape(pasteShape);
        }
        ClearCanvasIterateShape.clearAndDraw(paintCanvas, shapeList);
    }
}
