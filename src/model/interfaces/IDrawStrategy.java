package model.interfaces;

import view.interfaces.PaintCanvasBase;

import java.awt.*;

public interface IDrawStrategy {
    void draw(int x, int y, int width, int height, Stroke stroke);
}
