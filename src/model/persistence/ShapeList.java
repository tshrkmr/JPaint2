package model.persistence;

import model.interfaces.IDrawStrategy;
import model.interfaces.IShapeProperties;

import java.util.ArrayList;

public class ShapeList {
    ArrayList<ShapeProperties> drawShapeList;
    ArrayList<ShapeProperties> selectShapeList;

    public ShapeList(){
       drawShapeList = new ArrayList<>();
       selectShapeList = new ArrayList<>();
    }

    public void addDrawShape(ShapeProperties ids){
        this.drawShapeList.add(ids);
    }

    public void addSelectShape(ShapeProperties ids1){
        this.selectShapeList.add(ids1);
    }

    public ArrayList<ShapeProperties> getDrawShapeList(){
        return drawShapeList;
    }

    public ArrayList<ShapeProperties> getSelectedShapeList(){
        return drawShapeList;
    }

}
