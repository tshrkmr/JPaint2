package model.persistence;

import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IDrawStrategy;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class CommandSelectShape implements ICommand {

    private Point startPoint, endPoint;
    private PaintCanvasBase paintCanvas;
    private IDrawStrategy drawStrategy;
    private IApplicationState appState;
    private int startX, startY, width, height;

    public CommandSelectShape(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, IApplicationState appState){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.paintCanvas = paintCanvas;
        this.appState = appState;
    }

    @Override
    public void run() {

    }
}
