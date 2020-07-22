package model.persistence;

import model.interfaces.*;
import org.w3c.dom.UserDataHandler;
import view.interfaces.PaintCanvasBase;

public class CommandCreateShape implements ICommand {

    private Point startPoint, endPoint;
    private PaintCanvasBase paintCanvas;
    private IDrawStrategy drawStrategy;
    private IShapeProperties sp;
    private ShapeList shapeList;

    public CommandCreateShape(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, IShapeProperties sp, ShapeList shapeList){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.paintCanvas = paintCanvas;
        this.sp = sp;
        this.shapeList = shapeList;
    }

    @Override
    public void run() {

        ICalculate calculate = new ShapeCalculation(sp);
        calculate.Calculate(startPoint, endPoint);

        FactoryIDrawStrategy drawStrategyFactory = new FactoryIDrawStrategy();
        drawStrategy = drawStrategyFactory.drawStrategy(paintCanvas, sp);
        shapeList.addDrawShape(drawStrategy);
        System.out.println("# of shapes Drawn" + shapeList.getDrawShapeList().size());
        drawStrategy.draw(sp.getStartX(), sp.getStartY(), sp.getWidth(), sp.getHeight(), sp.getStroke());
    }
}
