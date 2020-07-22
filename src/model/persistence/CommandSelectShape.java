package model.persistence;

import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IDrawStrategy;
import view.interfaces.PaintCanvasBase;

public class CommandSelectShape implements ICommand {

    private Point startPoint, endPoint;
    private PaintCanvasBase paintCanvas;
    private IDrawStrategy drawStrategy;
    private IApplicationState appState;
    private int startX, startY, width, height;
    private ShapeList shapeList;

    public CommandSelectShape(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, IApplicationState appState, ShapeList shapeList){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.paintCanvas = paintCanvas;
        this.appState = appState;
        this.shapeList = shapeList;
    }

    @Override
    public void run() {

    }
}
