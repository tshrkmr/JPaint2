//package model.persistence;
//
//import model.ShapeColor;
//import model.ShapeShadingType;
//import model.ShapeType;
//import model.interfaces.IShapeProperties;
//import view.interfaces.PaintCanvasBase;
//import java.awt.Graphics2D;
//import java.awt.*;
//
//public class ShapeProperties implements IShapeProperties {
//
//    int startX, startY, width, height;
//    private Graphics2D graphics2d;
//    private ShapeType shapeType;
//    private ShapeShadingType shadeType;
//    private ShapeColor primaryColor, secondaryColor;
//    private PaintCanvasBase paintCanvas;
//    public ApplicationState appState;
//    private Stroke stroke;
//
//    public ShapeProperties(Graphics2D graphics2d, ApplicationState appState, PaintCanvasBase paintCanvas){
//        this.appState = appState;
//        this.graphics2d = graphics2d;
//        this.paintCanvas = paintCanvas;
//    }
//
//
//    public void setProperties() {
//        this.shapeType = appState.getActiveShapeType();
//        //System.out.println(appState.getActiveShapeType()+ "Hello1");
//        this.shadeType = appState.getActiveShapeShadingType();
//        this.primaryColor = appState.getActivePrimaryColor();
//        this.secondaryColor = appState.getActiveSecondaryColor();
//        //System.out.println(this.secondaryColor+ "Hello1");
//        //stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
//        stroke = new BasicStroke(4);
//    }
//
//    public void setX(int x){
//        this.startX = x;
//    }
//
//    public void setY(int y){
//        this.startY = y;
//    }
//
//    public void setWidth(int w){
//        this.width = w;
//    }
//
//    public void setHeight(int h){
//        this.height = h;
//    }
//
//    public int getStartX(){
//        return startX;
//    }
//
//    public int getStartY(){
//        return startY;
//    }
//
//    public int getWidth(){
//        return width;
//    }
//
//    public int getHeight(){
//        return height;
//    }
//
//    public ShapeType getShapeType(){
//        return shapeType;
//    }
//
//    public ShapeShadingType getShadeType(){
//        return shadeType;
//    }
//
//    public ShapeColor getPrimaryColor(){
//        return primaryColor;
//    }
//
//    public ShapeColor getSecondaryColor(){
//        return secondaryColor;
//    }
//
//    public Stroke getStroke(){
//        return stroke;
//    }
//}
