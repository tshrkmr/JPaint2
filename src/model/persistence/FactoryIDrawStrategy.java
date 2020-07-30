package model.persistence;

import model.interfaces.IDrawStrategy;
import view.interfaces.PaintCanvasBase;

public class FactoryIDrawStrategy {

    public static IDrawStrategy drawStrategyEllipse(PaintCanvasBase paintCanvas, Shape sp){
        return new StrategyCreateEllipse(paintCanvas, sp);
    }

    public static IDrawStrategy drawStrategyTriangle(PaintCanvasBase paintCanvas, Shape sp){
        return new StrategyCreateTriangle(paintCanvas, sp);
    }

    public static IDrawStrategy drawStrategyRectangle(PaintCanvasBase paintCanvas, Shape sp){
        return new StrategyCreateRectangle(paintCanvas, sp);
    }
}
