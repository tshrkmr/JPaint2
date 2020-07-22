package model.persistence;

import model.interfaces.*;
import view.interfaces.PaintCanvasBase;

public class CommandCreateShape implements ICommand {

    private Point startPoint, endPoint;
    private PaintCanvasBase paintCanvas;
    private IDrawStrategy drawStrategy;
    private ShapeProperties sp;
    private ShapeList shapeList;
    private ICalculate calculate;
    private FactoryIDrawStrategy drawStrategyFactory;

    public CommandCreateShape(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, ShapeProperties sp, ShapeList shapeList){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.paintCanvas = paintCanvas;
        this.sp = sp;
        this.shapeList = shapeList;
    }

    @Override
    public void run() {

        shapeList.addDrawShape(sp);
        System.out.println("# of shapes Drawn " + shapeList.getDrawShapeList().size());
        drawStrategyFactory = new FactoryIDrawStrategy();
        drawStrategy = drawStrategyFactory.drawStrategy(paintCanvas, sp);
        drawStrategy.draw(sp.getStartX(), sp.getStartY(), sp.getWidth(), sp.getHeight(), sp.getStroke());
    }
}
