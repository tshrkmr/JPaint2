package model.persistence;

import model.interfaces.IShape;

import java.util.ArrayList;

public class ShapeList {
    final ArrayList<IShape> drawShapeList;
    final ArrayList<IShape> selectShapeList;
    final ArrayList<IShape> copyShapeList;
    final ArrayList<IShape> pasteShapeList;
    final ArrayList<IShape> deleteShapeList;

    public ShapeList(){
       drawShapeList = new ArrayList<>();
       selectShapeList = new ArrayList<>();
       copyShapeList = new ArrayList<>();
       deleteShapeList = new ArrayList<>();
       pasteShapeList = new ArrayList<>();
    }

    public void addDrawShape(IShape drawShape){
        drawShapeList.add(drawShape);
    }

    public void addSelectShape(IShape selShape){
        selectShapeList.add(selShape);
        Shape nShape = new Shape (selShape.getStartPoint(), selShape.getEndPoint(), selShape.getAppState(), selShape.getPaintCanvas());
        nShape.setProperties();
        nShape.setShapeType(selShape.getShapeType());
        IShape dashShape = new DecoratorOutlineSelectedShape(nShape);
        dashShape.setProperties();
    }

    public void addCopyShape(IShape copyShape){
        copyShapeList.add(copyShape);
    }

    public void addPasteShape(IShape pasteShape){
        pasteShapeList.add(pasteShape);
    }

    public void addDeleteShape(IShape deleteShape){
        deleteShapeList.add(deleteShape);
    }

    public void removeDrawShape(IShape rDrawShape) { drawShapeList.remove(rDrawShape); }

    public void removePasteShape(IShape rPasteShape) { pasteShapeList.remove(rPasteShape); }

    public ArrayList<IShape> getDrawShapeList(){
        return drawShapeList;
    }

    public ArrayList<IShape> getSelectShapeList(){
        return selectShapeList;
    }

    public ArrayList<IShape> getCopyShapeList(){
        return copyShapeList;
    }

    public ArrayList<IShape> getPasteShapeList(){
        return pasteShapeList;
    }

    public ArrayList<IShape> getDeleteShapeList(){
        return deleteShapeList;
    }
}
