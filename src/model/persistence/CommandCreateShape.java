package model.persistence;

import model.interfaces.*;
import view.interfaces.PaintCanvasBase;

public class CommandCreateShape implements ICommand {

    private PaintCanvasBase paintCanvas;
    private IDrawStrategy drawStrategy;
    private Shape shape;
    private ShapeList shapeList;
    private FactoryIDrawStrategy drawStrategyFactory;

    public CommandCreateShape(PaintCanvasBase paintCanvas, Shape shape, ShapeList shapeList){
        this.paintCanvas = paintCanvas;
        this.shape = shape;
        this.shapeList = shapeList;
    }

    @Override
    public void run() {

        shapeList.addDrawShape(shape);
        System.out.println("# of shapes Drawn " + shapeList.getDrawShapeList().size());
        drawStrategyFactory = new FactoryIDrawStrategy();
        drawStrategy = drawStrategyFactory.drawStrategy(paintCanvas, shape);
        drawStrategy.draw(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight(), shape.getStroke());
    }
}
