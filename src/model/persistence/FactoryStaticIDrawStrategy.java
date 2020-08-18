package model.persistence;

import model.interfaces.IDrawStrategy;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class FactoryStaticIDrawStrategy {

    public static IDrawStrategy drawStrategyEllipse(PaintCanvasBase paintCanvas, IShape sp){
        return new StrategyCreateEllipse(paintCanvas, sp);
    }

    public static IDrawStrategy drawStrategyTriangle(PaintCanvasBase paintCanvas, IShape sp){
        return new StrategyCreateTriangle(paintCanvas, sp);
    }

    public static IDrawStrategy drawStrategyRectangle(PaintCanvasBase paintCanvas, IShape sp){
        return new StrategyCreateRectangle(paintCanvas, sp);
    }

    public static IDrawStrategy drawStrategyNull(){
        return new NullDropDownSelect();
    }
}
