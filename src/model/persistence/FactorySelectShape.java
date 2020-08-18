package model.persistence;

import model.ShapeType;
import model.interfaces.IDrawStrategy;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class FactorySelectShape {

    public static void select(PaintCanvasBase paintCanvas, IShape shape) {

        IDrawStrategy drawStrategy;

        ShapeType shapeType = shape.getShapeType();
        switch (shapeType.toString()) {
            case "ELLIPSE":
                drawStrategy = FactoryStaticIDrawStrategy.drawStrategyEllipse(paintCanvas, shape);
                break;
            case "RECTANGLE":
                drawStrategy = FactoryStaticIDrawStrategy.drawStrategyRectangle(paintCanvas, shape);
                break;
            case "TRIANGLE":
                drawStrategy = FactoryStaticIDrawStrategy.drawStrategyTriangle(paintCanvas, shape);
                break;
            default:
                drawStrategy = FactoryStaticIDrawStrategy.drawStrategyNull();
        }
        drawStrategy.draw(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight(), shape.getStroke());
    }
}
