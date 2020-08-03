package model.persistence;

import model.ShapeType;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class OutlineSelectedShape {

    private Shape shape;
    private PaintCanvasBase paintCanvas;

    public OutlineSelectedShape(Shape shape, PaintCanvasBase paintCanvas) {
        this.shape = shape;
        this.paintCanvas = paintCanvas;
    }

    public void drawDash(){
        int x = shape.getStartX()-5;
        int y = shape.getStartY()-5;
        int w = shape.getWidth()+10;
        int h = shape.getHeight()+10;
        int[] X = {x, x + w, x};
        int[] Y = {y, y + h, y+h};
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        Graphics2D graphics2d = this.paintCanvas.getGraphics2D();

        ShapeType shapeType = shape.getShapeType();

        switch (shapeType.toString()) {
            case "ELLIPSE":
                graphics2d.setStroke(stroke);
                graphics2d.drawOval(x, y, w, h);
                break;
            case "RECTANGLE":
                graphics2d.setStroke(stroke);
                graphics2d.drawRect(x, y, w, h);
                break;
            case "TRIANGLE":
                graphics2d.setStroke(stroke);
                graphics2d.drawPolygon(X, Y, 3);
                break;
        }
    }

}
