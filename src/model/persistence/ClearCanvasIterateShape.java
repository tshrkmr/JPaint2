package model.persistence;

import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class ClearCanvasIterateShape {

    public static void clearAndDraw(PaintCanvasBase paintCanvas, ShapeList shapeList){

        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.white);
        graphics2d.fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());

        for (IShape shape : shapeList.getDrawShapeList()) {
            FactorySelectShape.select(paintCanvas, shape);
        }
    }
}
