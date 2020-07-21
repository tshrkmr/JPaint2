package controller;

import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.persistence.*;
import model.persistence.Point;
import view.interfaces.PaintCanvasBase;
import model.persistence.ApplicationState;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter {
    private Point startPoint, endPoint;
    private PaintCanvasBase paintCanvas;
    private ICommand command;
    private IApplicationState appState;


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
        //Graphics2D graphics2d = paintCanvas.getGraphics2D();
        //sp = new ShapeProperties(graphics2d, appState, paintCanvas);
        //sp.setProperties();
        command = new CommandCreateShape(startPoint, endPoint, paintCanvas, appState);
        command.run();
    }
}
