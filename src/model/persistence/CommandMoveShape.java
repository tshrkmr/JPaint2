package model.persistence;

import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IDrawStrategy;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class CommandMoveShape implements ICommand {

    private Point startPoint, endPoint;
    private ShapeList shapeList;
    private int dx, dy;
    private PaintCanvasBase paintCanvas;
    int newStartX, newStartY;
    private IApplicationState appState;

    public CommandMoveShape(Point startPoint, Point endPoint, ShapeList shapeList, PaintCanvasBase paintCanvas, IApplicationState appState){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
        this.appState = appState;
    }

    @Override
    public void run() {

        System.out.println("Select Command");

        dx = endPoint.getX() - startPoint.getX();
        dy = endPoint.getY() - startPoint.getY();

        for (Shape s : shapeList.getSelectedShapeList()) {
            shapeList.removeDrawShape(s);
            //newStartX = s.getStartX() +dx;
            //newStartY = s.getStartY() +dy;
            s.setStartX(s.getStartX() +dx);
            s.setStartY(s.getStartY() +dy);
            shapeList.addDrawShape(s);
        }

        Graphics2D graphics2d = this.paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.white);
        graphics2d.fillRect(0 ,0, paintCanvas.getWidth(), paintCanvas.getHeight());

        for (Shape shape : shapeList.getDrawShapeList()) {
            FactoryIDrawStrategy drawStrategyFactory = new FactoryIDrawStrategy();
            IDrawStrategy drawStrategy = drawStrategyFactory.drawStrategy(paintCanvas, shape);
            drawStrategy.draw(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight(), shape.getStroke());
        }

        //s.createMovedShape(newStartX, newStartY, s.getWidth(), s.getHeight(), s.getStroke());

    }
}
