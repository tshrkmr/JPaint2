package model.persistence;

import model.ShapeType;
import model.interfaces.IDrawStrategy;
import view.interfaces.PaintCanvasBase;

public class FactoryIDrawStrategy {

    private ShapeType shapeType;

    public IDrawStrategy drawStrategy(PaintCanvasBase paintCanvas, Shape sp){

        IDrawStrategy drawStrategy = null;

        shapeType = sp.getShapeType();
            switch (shapeType.toString()) {
                case "ELLIPSE":
                    drawStrategy = new StrategyCreateEllipse(paintCanvas, sp);
                    break;
                case "RECTANGLE":
                    drawStrategy = new StrategyCreateRectangle(paintCanvas, sp);
                    break;
                case "TRIANGLE":
                    drawStrategy = new StrategyCreateTriangle(paintCanvas, sp);
                    break;
        }
        return drawStrategy;
    }
}
