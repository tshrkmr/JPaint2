package controller;

import model.StartAndEndPointMode;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.persistence.*;
import view.interfaces.PaintCanvasBase;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter {

    private Point startPoint;
    private final PaintCanvasBase paintCanvas;
    private ICommand command;
    private final IApplicationState appState;
    private final ShapeList shapeList;

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

        Point endPoint = new Point(e.getX(), e.getY());

        IShape shape = new Shape(startPoint, endPoint, appState, paintCanvas);
        shape.setProperties();

        StartAndEndPointMode startAndEndPointMode = appState.getActiveStartAndEndPointMode();

        switch (startAndEndPointMode.toString()) {
            case "DRAW":
                command = new CommandCreateShape(shape, paintCanvas, shapeList);
                break;
            case "SELECT":
                //command = new OutlineSelectedShape(new CommandSelectShape(shape, shapeList, appState, paintCanvas), shape);
                command = new CommandSelectShape(shape, shapeList, appState, paintCanvas);
                break;
            case "MOVE":
                command = new CommandMoveShape(shape, shapeList, paintCanvas);
                break;
        }
        command.run();
    }
}
