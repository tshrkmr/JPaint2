package controller;

import model.StartAndEndPointMode;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IShapeProperties;
import model.persistence.*;
import model.persistence.Point;
import view.interfaces.PaintCanvasBase;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter {
    private Point startPoint, endPoint;
    private PaintCanvasBase paintCanvas;
    private ICommand command;
    private IApplicationState appState;
    private StartAndEndPointMode startAndEndPointMode;
    IShapeProperties sp;


    public MyMouseListener(PaintCanvasBase paintCanvas, IApplicationState appState) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;
    }

    @Override
    public void mousePressed(MouseEvent e){
        startPoint = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e){

        endPoint = new Point(e.getX(), e.getY());
        sp = new ShapeProperties(appState, paintCanvas);
        sp.setProperties();
        startAndEndPointMode = appState.getActiveStartAndEndPointMode();

        switch (startAndEndPointMode.toString()) {
            case "DRAW":
                command = new CommandCreateShape(startPoint, endPoint, paintCanvas, sp);
                break;
            case "SELECT":
                command = new CommandSelectShape(startPoint, endPoint, paintCanvas, appState);
                break;
            case "MOVE":
                command = new CommandMoveShape();
                break;
        }
        command.run();
    }
}
