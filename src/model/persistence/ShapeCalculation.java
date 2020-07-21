//package model.persistence;
//
//import model.ShapeColor;
//import model.interfaces.ICalculate;
//import model.interfaces.IShapeProperties;
//
//public class ShapeCalculation implements ICalculate {
//
//    Point startPoint, endPoint;
//    int startX, startY, width, height;
//    ShapeProperties sp;
//
//    public ShapeCalculation(Point startPoint, Point endPoint, ShapeProperties sp){
//        this.startPoint = startPoint;
//        this.endPoint = endPoint;
//        this.sp = sp;
//    }
//    @Override
//    public void Calculate() {
//        Point minimum = new Point(Math.min(startPoint.getX(), endPoint.getX()), Math.min(startPoint.getY(), endPoint.getY()));
//        Point maximum = new Point(Math.max(startPoint.getX(), endPoint.getX()), Math.max(startPoint.getY(), endPoint.getY()));
//        startX = Math.min(startPoint.getX(), endPoint.getX());
//        startY = Math.min(startPoint.getY(), endPoint.getY());
//        width = Math.abs(startPoint.getX() - endPoint.getX());
//        height = Math.abs(startPoint.getY() - endPoint.getY());
//    }
//        sp.setX(startX);
//        sp.setY(startY);
//        sp.setWidth(width);
//        sp.setHeight(height);

//        public void setX(int startX){
//            this.startX = x;
//        }
//
//        public void setY(int y){
//            this.startY = y;
//        }
//
//        public void setWidth(int w){
//            this.width = w;
//        }
//
//        public void setHeight(int h){
//            this.height = h;
//        }

//        public int getStartX(){
//            return startX;
//        }
//
//        public int getStartY(){
//            return startY;
//        }
//
//        public int getWidth(){
//            return width;
//        }
//
//        public int getHeight(){
//            return height;
//        }
//}
