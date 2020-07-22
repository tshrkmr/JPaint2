package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IDrawStrategy;
import model.interfaces.IShapeProperties;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class StrategyCreateRectangle implements IDrawStrategy {

    private ShapeColor primaryColor, secondaryColor;
    private PaintCanvasBase paintCanvas;
    private ShapeShadingType shadeType;
    private IShapeProperties sp;
    private Graphics2D graphics2d;

    public StrategyCreateRectangle(PaintCanvasBase paintCanvas, IShapeProperties sp){
        this.paintCanvas = paintCanvas;
        this.sp = sp;
    }

    @Override
    public void draw(int x, int y, int width, int height, Stroke stroke) {

        primaryColor = sp.getPrimaryColor();
        secondaryColor = sp.getSecondaryColor();
        shadeType = sp.getShadeType();

        graphics2d = this.paintCanvas.getGraphics2D();

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

