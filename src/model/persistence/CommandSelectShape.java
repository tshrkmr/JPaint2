package model.persistence;

import model.interfaces.*;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class CommandSelectShape implements ICommand {

    private final ShapeList shapeList;
    private final IApplicationState appState;
    private final PaintCanvasBase paintCanvas;
    private Stroke stroke1, stroke2;
    private final IShape shape;

    public CommandSelectShape(IShape shape, ShapeList shapeList, IApplicationState appState, PaintCanvasBase paintCanvas) {
        this.shape = shape;
        this.shapeList = shapeList;
        this.appState = appState;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void run() {
        System.out.println("Select Command");
        shapeList.selectShapeList.clear();

        Shape selectShape = new Shape(shape.getStartPoint(), shape.getEndPoint(), appState, paintCanvas);
        selectShape.setProperties();

        for (IShape shape : shapeList.getDrawShapeList()) {
            stroke1 = new BasicStroke(0);
            if (selectShape.getStartX() < shape.getStartX() + shape.getWidth()
                    && selectShape.getStartX() + selectShape.getWidth() > shape.getStartX()
                    && selectShape.getStartY() < shape.getStartY() + shape.getHeight()
                    && selectShape.getStartY() + selectShape.getHeight() > shape.getStartY()) {

                shapeList.addSelectShape(shape);
            } else {
                System.out.println("Nothing Selected!!");
            }
        }
        System.out.println("# of shapes Selected " + shapeList.getSelectShapeList().size());
    }
}