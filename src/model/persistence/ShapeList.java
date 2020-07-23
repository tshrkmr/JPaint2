package model.persistence;

import java.util.ArrayList;

public class ShapeList {
    ArrayList<Shape> drawShapeList;
    ArrayList<Shape> selectShapeList;
    ArrayList<Shape> moveShapeList;
    public ShapeList(){
       drawShapeList = new ArrayList<>();
       selectShapeList = new ArrayList<>();
    }

    public void addDrawShape(Shape ids){
        drawShapeList.add(ids);
    }

    public void addSelectShape(Shape ids1){
        selectShapeList.add(ids1);
    }

    public void removeDrawShape(Shape ids2){
        drawShapeList.remove(ids2);
    }
//    public void addMoveShape(Shape ids2){
//        moveShapeList.add(ids2);
//    }

    public ArrayList<Shape> getDrawShapeList(){
        return drawShapeList;
    }

    public ArrayList<Shape> getSelectedShapeList(){
        return selectShapeList;
    }

//    public ArrayList<Shape> getMoveShapeList(){
//        return moveShapeList;
//    }

}
