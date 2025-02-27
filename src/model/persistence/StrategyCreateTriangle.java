package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IDrawStrategy;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class StrategyCreateTriangle implements IDrawStrategy {

    private final PaintCanvasBase paintCanvas;
    private final IShape shape;

    public StrategyCreateTriangle(PaintCanvasBase paintCanvas, IShape shape){
        this.paintCanvas = paintCanvas;
        this.shape = shape;
    }

    @Override
    public void draw(int x, int y, int width, int height, Stroke stroke) {

        System.out.println(x+ " "+ y+ " "+ width+ " "+ height + " Triangle");

        int[] X = {x, x + width, x};
        int[] Y = {y, y + height, y+height};

        ShapeColor primaryColor = shape.getPrimaryColor();
        ShapeColor secondaryColor = shape.getSecondaryColor();
        ShapeShadingType shadeType = shape.getShadeType();

        Graphics2D graphics2d = this.paintCanvas.getGraphics2D();

        switch (shadeType.toString()) {
            case "FILLED_IN":
                graphics2d.setColor(SingletonColor.getInstance().getColor(primaryColor));
                graphics2d.fillPolygon(X, Y, 3);
                break;
            case "OUTLINE":
                graphics2d.setColor(SingletonColor.getInstance().getColor(primaryColor));
                graphics2d.setStroke(stroke);
                graphics2d.drawPolygon(X, Y, 3);
                break;
            case "OUTLINE_AND_FILLED_IN":
                graphics2d.setColor(SingletonColor.getInstance().getColor(primaryColor));
                graphics2d.fillPolygon(X, Y, 3);
                graphics2d.setColor(SingletonColor.getInstance().getColor(secondaryColor));
                graphics2d.setStroke(stroke);
                graphics2d.drawPolygon(X, Y, 3);
                break;
        }
    }
}

