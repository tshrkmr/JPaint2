package model.persistence;

import model.ShapeColor;

import java.awt.*;
import java.util.EnumMap;

public class SingletonColor {

        private static EnumMap<ShapeColor, Color> colorMap;
        private static SingletonColor instance = new SingletonColor();

        private SingletonColor() {
            colorMap = new EnumMap<>(ShapeColor.class);
            colorMap.put(ShapeColor.BLACK, Color.BLACK);
            colorMap.put(ShapeColor.BLUE,  Color.BLUE);
            colorMap.put(ShapeColor.CYAN, Color.CYAN);
            colorMap.put(ShapeColor.DARK_GRAY,  Color.DARK_GRAY);
            colorMap.put(ShapeColor.GRAY, Color.GRAY);
            colorMap.put(ShapeColor.GREEN,  Color.GREEN);
            colorMap.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
            colorMap.put(ShapeColor.MAGENTA,  Color.MAGENTA);
            colorMap.put(ShapeColor.ORANGE,  Color.ORANGE);
            colorMap.put(ShapeColor.PINK, Color.PINK);
            colorMap.put(ShapeColor.RED,  Color.RED);
            colorMap.put(ShapeColor.WHITE, Color.WHITE);
            colorMap.put(ShapeColor.YELLOW,  Color.YELLOW);
        }

        public Color getColor(ShapeColor color) {
            return colorMap.get(color);
        }

    public static SingletonColor getInstance() {
        return instance;
    }
}
