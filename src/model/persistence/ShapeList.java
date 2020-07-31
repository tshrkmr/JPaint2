package model.persistence;

import java.util.ArrayList;

public class ShapeList {
    final ArrayList<Shape> drawShapeList;
    final ArrayList<Shape> selectShapeList;
    final ArrayList<Shape> copyShapeList;

    public ShapeList(){
       drawShapeList = new ArrayList<>();
       selectShapeList = new ArrayList<>();
       copyShapeList = new ArrayList<>();
    }

    public void addDrawShape(Shape drawShape){
        drawShapeList.add(drawShape);
    }

    public void addSelectShape(Shape selectShape){
        selectShapeList.add(selectShape);
    }

    public void addCopyShape(Shape copyShape){
        copyShapeList.add(copyShape);
    }

    public void removeDrawShape(Shape rDrawShape) { drawShapeList.remove(rDrawShape); }

    //public void removeCopyShape(Shape rCopyShape) { copyShapeList.remove(rCopyShape); }

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
