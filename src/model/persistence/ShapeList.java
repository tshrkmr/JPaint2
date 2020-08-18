package model.persistence;

import model.interfaces.IShape;

import java.util.ArrayList;

public class ShapeList {
    final ArrayList<IShape> drawShapeList;
    final ArrayList<IShape> selectShapeList;
    final ArrayList<IShape> copyShapeList;
    final ArrayList<IShape> pasteShapeList;
    final ArrayList<IShape> deleteShapeList;
    final ArrayList<IShape> groupShapeList;

    public ShapeList(){
       drawShapeList = new ArrayList<>();
       selectShapeList = new ArrayList<>();
       copyShapeList = new ArrayList<>();
       deleteShapeList = new ArrayList<>();
       pasteShapeList = new ArrayList<>();
       groupShapeList = new ArrayList<>();
    }

    public void addDrawShape(IShape drawShape){
        drawShapeList.add(drawShape);
    }

    public void addSelectShape(IShape selShape){
        selectShapeList.add(selShape);
        drawDash(selShape);
    }

    public void drawDash(IShape shape) {
            Shape nShape = new Shape (shape.getStartPoint(), shape.getEndPoint(), shape.getAppState(), shape.getPaintCanvas());
            nShape.setProperties();
            nShape.setStartX(shape.getStartX());
            nShape.setStartY(shape.getStartY());
            nShape.setWidth(shape.getWidth());
            nShape.setHeight(shape.getHeight());
            nShape.setShapeType(shape.getShapeType());
            IShape dashShape = new DecoratorOutlineSelectedShape(nShape);
            dashShape.setProperties();
    }

    public void addCopyShape(IShape copyShape){
        copyShapeList.add(copyShape);
    }

    public void addGroupShape(IShape groupShape){
        groupShapeList.add(groupShape);
    }

    public void addPasteShape(IShape groupShape){
        pasteShapeList.add(groupShape);
    }

    public void addDeleteShape(IShape deleteShape){
        deleteShapeList.add(deleteShape);
    }

    public void removeDrawShape(IShape rDrawShape) { drawShapeList.remove(rDrawShape); }

    public void removePasteShape(IShape rPasteShape) { pasteShapeList.remove(rPasteShape); }

    public void removeGroupShape(IShape rGroupShape) { groupShapeList.remove(rGroupShape); }

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

    public ArrayList<IShape> getGroupShapeList(){
        return groupShapeList;
    }
}
