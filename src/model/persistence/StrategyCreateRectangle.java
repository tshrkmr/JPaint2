package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IDrawStrategy;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class StrategyCreateRectangle implements IDrawStrategy {

    private final PaintCanvasBase paintCanvas;
    private final IShape shape;

    public StrategyCreateRectangle(PaintCanvasBase paintCanvas, IShape shape){
        this.paintCanvas = paintCanvas;
        this.shape = shape;
    }

    @Override
    public void draw(int x, int y, int width, int height, Stroke stroke) {

        System.out.println(x+ " "+ y+ " "+ width+ " "+ height + " Rectangle");

        ShapeColor primaryColor = shape.getPrimaryColor();
        ShapeColor secondaryColor = shape.getSecondaryColor();
        ShapeShadingType shadeType = shape.getShadeType();

        Graphics2D graphics2d = this.paintCanvas.getGraphics2D();

        switch (shadeType.toString()) {
            case "FILLED_IN":
                graphics2d.setColor(primaryColor.getColor());
                graphics2d.fillRect(x, y, width, height);
                break;
            case "OUTLINE":
                graphics2d.setColor(primaryColor.getColor());
                graphics2d.setStroke(stroke);
                graphics2d.drawRect(x, y, width, height);
                break;
            case "OUTLINE_AND_FILLED_IN":
                graphics2d.setColor(primaryColor.getColor());
                graphics2d.fillRect(x, y, width, height);
                graphics2d.setColor(secondaryColor.getColor());
                graphics2d.setStroke(stroke);
                graphics2d.drawRect(x, y, width, height);
                break;
        }
    }
}

