package model.persistence;

import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IDrawStrategy;
import view.interfaces.PaintCanvasBase;

public class IDrawStrategyFactory {

    private ShapeType shapeType;

    public IDrawStrategy drawStrategy(IApplicationState appState, PaintCanvasBase painCanvas){
        IDrawStrategy drawStrategy = null;
        shapeType = appState.getActiveShapeType();
            switch (shapeType.toString()) {
                case "ELLIPSE":
                    drawStrategy = new StrategyCreateEllipse(appState, painCanvas);
                    break;
                case "RECTANGLE":
                    drawStrategy = new StrategyCreateRectangle(appState, painCanvas);
                    break;
                case "TRIANGLE":
                    drawStrategy = new StrategyCreateTriangle(appState, painCanvas);
                    break;
        }
        return drawStrategy;
    }
}
