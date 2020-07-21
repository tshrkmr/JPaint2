package model.persistence;

import model.interfaces.*;
import view.interfaces.PaintCanvasBase;

public class CommandCreateShape implements ICommand {

    private Point startPoint, endPoint;
    private PaintCanvasBase paintCanvas;
    private IDrawStrategy drawStrategy;
    private IShapeProperties sp;

    public CommandCreateShape(Point startPoint, Point endPoint,PaintCanvasBase paintCanvas, IShapeProperties sp){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.paintCanvas = paintCanvas;
        this.sp = sp;
    }

    @Override
    public void run() {

        ICalculate calculate = new ShapeCalculation(sp);
        calculate.Calculate(startPoint, endPoint);

        FactoryIDrawStrategy drawStrategyFactory = new FactoryIDrawStrategy();
        drawStrategy = drawStrategyFactory.drawStrategy(paintCanvas, sp);
        drawStrategy.draw(sp.getStartX(), sp.getStartY(), sp.getWidth(), sp.getHeight(), sp.getStroke());
    }
}
