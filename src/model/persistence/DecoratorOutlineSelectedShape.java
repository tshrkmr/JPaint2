package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DecoratorOutlineSelectedShape implements IShape {

    private final IShape shape;
    private final PaintCanvasBase paintCanvas;
    private final int startX, startY, width, height;
    private final ShapeType shapeType;

    public DecoratorOutlineSelectedShape(IShape shape){
        this.shape = shape;
        this.paintCanvas = shape.getPaintCanvas();
        this.startX = shape.getStartX();
        this.startY = shape.getStartY();
        this.width = shape.getWidth();
        this.height = shape.getHeight();
        this.shapeType = shape.getShapeType();
    }

    @Override
    public void setProperties() {
        shape.setProperties();
        drawOutline(shape);
    }

    private void drawOutline(IShape shape){

        int x = startX-5;
        int y = startY-5;
        int w = width+10;
        int h = height+10;
        ShapeColor primaryColor = ShapeColor.BLACK;
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        ShapeShadingType shapeShadingType = ShapeShadingType.OUTLINE;

        shape.setStartX(x);
        shape.setStartY(y);
        shape.setWidth(w);
        shape.setHeight(h);
        shape.setPrimaryColor(primaryColor);
        shape.setStroke(stroke);
        shape.setShadeType(shapeShadingType);
        shape.setShapeType(shapeType);

        FactorySelectShape.select(paintCanvas, shape);

//        switch (shapeType.toString()) {
//            case "ECLIPSE":
//                graphics2d.setColor(primaryColor.getColor());
//                graphics2d.setStroke(stroke);
//                graphics2d.drawOval(x, y, width, height);
//                System.out.println("5");
//                break;
//            case "RECTANGLE":
//                //graphics2d.setColor(primaryColor.getColor());
//                graphics2d.setStroke(stroke);
//                graphics2d.drawRect(x, y, width, height);
//                break;
//            case "TRIANGLE":
//                //graphics2d.setColor(primaryColor.getColor());
//                graphics2d.setStroke(stroke);
//                graphics2d.drawPolygon(X, Y, 3);
//                break;
//        }


    }

    @Override
    public int getStartX() {
        return 0;
    }

    @Override
    public int getStartY() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setStartX(int x) {

    }

    @Override
    public void setStartY(int y) {

    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public void setStroke(Stroke stroke) {

    }

    @Override
    public void setPrimaryColor(ShapeColor primaryColor) {

    }

    @Override
    public void setShadeType(ShapeShadingType shadeType) {

    }

    @Override
    public void setShapeType(ShapeType shapeType) {

    }

    @Override
    public ShapeType getShapeType() {
        return null;
    }

    @Override
    public ShapeShadingType getShadeType() {
        return null;
    }

    @Override
    public ShapeColor getSecondaryColor() {
        return null;
    }

    @Override
    public ShapeColor getPrimaryColor() {
        return null;
    }

    @Override
    public Stroke getStroke() {
        return null;
    }

    @Override
    public Point getStartPoint() {
        return null;
    }

    @Override
    public Point getEndPoint() {
        return null;
    }

    @Override
    public IApplicationState getAppState() {
        return null;
    }

    @Override
    public PaintCanvasBase getPaintCanvas() {
        return null;
    }
}
