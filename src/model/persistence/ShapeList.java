package model.persistence;

import java.util.ArrayList;

public class ShapeList {
    ArrayList<Shape> drawShapeList;
    ArrayList<Shape> selectShapeList;
    ArrayList<Shape> copyShapeList;

    public ShapeList(){
       drawShapeList = new ArrayList<>();
       selectShapeList = new ArrayList<>();
       copyShapeList = new ArrayList<>();
    }

    public void addDrawShape(Shape ids){
        drawShapeList.add(ids);
    }

    public void addSelectShape(Shape ids1){
        selectShapeList.add(ids1);
    }

    public void addCopyShape(Shape ids2){
        copyShapeList.add(ids2);
    }

    public void removeDrawShape(Shape ids3) { drawShapeList.remove(ids3); }

    public ArrayList<Shape> getDrawShapeList(){
        return drawShapeList;
    }

    public ArrayList<Shape> getSelectShapeList(){
        return selectShapeList;
    }

    public ArrayList<Shape> getCopyShapeList(){
        return copyShapeList;
    }
}
