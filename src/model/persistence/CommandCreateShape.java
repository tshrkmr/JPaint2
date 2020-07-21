package model.persistence;

import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IDrawStrategy;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class CommandCreateShape implements ICommand {

    private Point startPoint, endPoint;
    private PaintCanvasBase paintCanvas;
    private IDrawStrategy drawStrategy;
    private IApplicationState appState;
    private int startX, startY, width, height;
    private Stroke stroke;

    public CommandCreateShape(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, IApplicationState appState){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.paintCanvas = paintCanvas;
        this.appState = appState;
    }

    @Override
    public void run() {

        startX = Math.min(startPoint.getX(), endPoint.getX());
        startY = Math.min(startPoint.getY(), endPoint.getY());
        width = Math.abs(startPoint.getX() - endPoint.getX());
        height = Math.abs(startPoint.getY() - endPoint.getY());
        stroke = new BasicStroke(4);
        IDrawStrategyFactory drawStrategyFactory = new IDrawStrategyFactory();
        drawStrategy = drawStrategyFactory.drawStrategy(appState, paintCanvas);
        drawStrategy.draw(startX, startY, width, height, stroke);
    }
}
