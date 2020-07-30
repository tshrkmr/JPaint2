package model.persistence;

import model.ShapeType;
import model.interfaces.IDrawStrategy;
import view.interfaces.PaintCanvasBase;

public class FactorySelectShape {

    public void select(PaintCanvasBase paintCanvas, Shape shape) {

        IDrawStrategy drawStrategy;

        ShapeType shapeType = shape.getShapeType();
        switch (shapeType.toString()) {
            case "ELLIPSE":
                drawStrategy = FactoryIDrawStrategy.drawStrategyEllipse(paintCanvas, shape);
                break;
            case "RECTANGLE":
                drawStrategy = FactoryIDrawStrategy.drawStrategyRectangle(paintCanvas, shape);
                break;
            case "TRIANGLE":
                drawStrategy = FactoryIDrawStrategy.drawStrategyTriangle(paintCanvas, shape);
                break;
            default:
                drawStrategy = FactoryIDrawStrategy.drawStrategyNull();
        }
        drawStrategy.draw(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight(), shape.getStroke());
    }
}
