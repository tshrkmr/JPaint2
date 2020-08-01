package model.persistence;

import java.util.ArrayList;

public class ShapeList {
    final ArrayList<Shape> drawShapeList;
    final ArrayList<Shape> selectShapeList;
    final ArrayList<Shape> copyShapeList;
    final ArrayList<Shape> pasteShapeList;
    final ArrayList<Shape> deleteShapeList;

    public ShapeList(){
       drawShapeList = new ArrayList<>();
       selectShapeList = new ArrayList<>();
       copyShapeList = new ArrayList<>();
       deleteShapeList = new ArrayList<>();
       pasteShapeList = new ArrayList<>();
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

    public void addPasteShape(Shape pasteShape){
        pasteShapeList.add(pasteShape);
    }

    public void addDeleteShape(Shape deleteShape){
        deleteShapeList.add(deleteShape);
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

    public ArrayList<Shape> getPasteShapeList(){
        return pasteShapeList;
    }

    public ArrayList<Shape> getDeleteShapeList(){
        return deleteShapeList;
    }
}
