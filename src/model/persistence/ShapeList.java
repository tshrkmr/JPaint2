package model.persistence;

import java.util.ArrayList;

public class ShapeList {
    ArrayList<Shape> drawShapeList;
    ArrayList<Shape> selectShapeList;

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

    public ArrayList<Shape> getDrawShapeList(){
        return drawShapeList;
    }

    public ArrayList<Shape> getSelectedShapeList(){
        return selectShapeList;
    }

}
