package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IDrawStrategy;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class StrategyCreateEllipse implements IDrawStrategy {

    private final PaintCanvasBase paintCanvas;
    private final IShape shape;

    public StrategyCreateEllipse(PaintCanvasBase paintCanvas, IShape sp){
        this.paintCanvas = paintCanvas;
        this.shape = sp;
    }

    @Override
    public void draw(int x, int y, int width, int height, Stroke stroke) {

        System.out.println(x+ " "+ y+ " "+ width+ " "+ height + " Ellipse");

        ShapeColor primaryColor = shape.getPrimaryColor();
        ShapeColor secondaryColor = shape.getSecondaryColor();
        ShapeShadingType shadeType = shape.getShadeType();

        Graphics2D graphics2d = this.paintCanvas.getGraphics2D();

        switch (shadeType.toString()) {
            case "FILLED_IN":
                graphics2d.setColor(SingletonColor.getInstance().getColor(primaryColor));
                graphics2d.fillOval(x, y, width, height);
                break;
            case "OUTLINE":
                graphics2d.setColor(SingletonColor.getInstance().getColor(primaryColor));
                graphics2d.setStroke(stroke);
                graphics2d.drawOval(x, y, width, height);
                break;
            case "OUTLINE_AND_FILLED_IN":
                graphics2d.setColor(SingletonColor.getInstance().getColor(primaryColor));
                graphics2d.fillOval(x, y, width, height);
                graphics2d.setColor(SingletonColor.getInstance().getColor(secondaryColor));
                graphics2d.setStroke(stroke);
                graphics2d.drawOval(x, y, width, height);
                break;
        }
    }
}
