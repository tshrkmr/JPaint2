package model.persistence;

import model.interfaces.IDrawStrategy;

import java.awt.*;

public class NullDropDownSelect implements IDrawStrategy {

    @Override
    public void draw(int x, int y, int width, int height, Stroke stroke) {
        System.out.println("Please select drop down option only");
    }
}
