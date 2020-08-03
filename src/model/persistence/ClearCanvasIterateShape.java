package model.persistence;

import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class ClearCanvasIterateShape {

    public static void clearAndDraw(PaintCanvasBase paintCanvas, ShapeList shapeList){

        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.white);
        graphics2d.fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());

        for (Shape shape : shapeList.getDrawShapeList()) {
            FactorySelectShape.select(paintCanvas, shape);
        }
    }
}
