package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;
import model.interfaces.IDrawStrategy;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class StrategyCreateRectangle implements IDrawStrategy {

    private ShapeColor primaryColor, secondaryColor;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;
    private ShapeShadingType shadeType;


    public StrategyCreateRectangle(IApplicationState appState, PaintCanvasBase paintCanvas){
        this.paintCanvas = paintCanvas;
        this.appState = appState;
    }

    @Override
    public void draw(int x, int y, int width, int height, Stroke stroke) {
        primaryColor = appState.getActivePrimaryColor();
        secondaryColor = appState.getActiveSecondaryColor();
        shadeType = appState.getActiveShapeShadingType();
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

