package model.persistence;

import model.ShapeType;
import model.interfaces.IDrawStrategy;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class FactoryIDrawStrategy {

    public IDrawStrategy drawStrategy(PaintCanvasBase paintCanvas, Shape sp){

        model.interfaces.IDrawStrategy drawStrategy = null;

        ShapeType shapeType = sp.getShapeType();
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

//        public IDrawStrategy drawStrategy(PaintCanvasBase paintCanvas, Shape sp){
//    }

}
