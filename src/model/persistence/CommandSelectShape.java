package model.persistence;

import model.interfaces.*;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class CommandSelectShape implements ICommand {

    private Point startPoint, endPoint;
    private PaintCanvasBase paintCanvas;
    private IDrawStrategy drawStrategy;
    private IApplicationState appState;
    private int startX, startY, width, height;
    private ShapeList shapeList;
    private ICalculate calculate;
    private IShapeProperties sp;
    private FactoryIDrawStrategy drawStrategyFactory;
    //private PaintCanvasBase paintCanvas;

    public CommandSelectShape(Point startPoint, Point endPoint, IShapeProperties sp, ShapeList shapeList, PaintCanvasBase paintCanvas){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.paintCanvas = paintCanvas;
        //this.appState = appState;
        this.shapeList = shapeList;
        this.sp = sp;
    }

    @Override
    public void run() {
        System.out.println("Select Command");
        //calculate = new ShapeCalculation(sp);
        startX = Math.min(startPoint.getX(), endPoint.getX());
        startY = Math.min(startPoint.getY(), endPoint.getY());
        width = Math.abs(startPoint.getX() - endPoint.getX());
        height = Math.abs(startPoint.getY() - endPoint.getY());
        Rectangle r1 = new Rectangle(startX, startY, width, height);

        Rectangle r2 = new Rectangle(sp.getStartX(), sp.getStartY(), sp.getWidth(), sp.getHeight());
        System.out.println("Select Command2");

        drawStrategyFactory = new FactoryIDrawStrategy();
        drawStrategy = drawStrategyFactory.drawStrategy(paintCanvas, sp);
        drawStrategy.draw(sp.getStartX(), sp.getStartY(), sp.getWidth(), sp.getHeight(), sp.getStroke());
//        for(IDrawStrategy shape: shapeList.getDrawShapeList()){
//            if(this.calculate.isOverlapping(startX, startY, width, height)){
//                shapeList.addSelectShape(shape);
//                System.out.println("# of shapes Selected" + shapeList.getDrawShapeList().size());
//            }
//        }
        if (r1.intersects(r2)) System.out.println("Collision Detected!");

    }


}
