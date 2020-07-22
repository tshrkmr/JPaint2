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
    private ShapeProperties sp;
    private ShapeList shapeList;
    private ShapeProperties sp1;

    public MyMouseListener(PaintCanvasBase paintCanvas, IApplicationState appState, ShapeList shapeList) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;
        this.shapeList = shapeList;
    }

    @Override
    public void mousePressed(MouseEvent e){
        startPoint = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e){

        endPoint = new Point(e.getX(), e.getY());
        sp = new ShapeProperties(startPoint, endPoint, appState, shapeList);
        sp.setProperties();

        startAndEndPointMode = appState.getActiveStartAndEndPointMode();

        switch (startAndEndPointMode.toString()) {
            case "DRAW":
                command = new CommandCreateShape(startPoint, endPoint, paintCanvas, sp, shapeList);
                break;
            case "SELECT":
                command = new CommandSelectShape(startPoint, endPoint, sp1, shapeList);
                break;
            case "MOVE":
                command = new CommandMoveShape();
                break;
        }
        command.run();
    }
}
