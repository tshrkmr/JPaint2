package model.persistence;

import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class ClearCanvas {

    public static void clear(PaintCanvasBase paintCanvas) {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.white);
        graphics2d.fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());
    }
}
