package model.persistence;

import model.interfaces.IDrawStrategy;
import model.interfaces.IShapeProperties;

import java.util.ArrayList;

public class ShapeList {
    ArrayList<IDrawStrategy> drawShapeList;
    ArrayList<IDrawStrategy> selectShapeList;

    public ShapeList(){
       drawShapeList = new ArrayList<>();
       selectShapeList = new ArrayList<>();
    }

    public void addDrawShape(IDrawStrategy ids){
        this.drawShapeList.add(ids);
    }

    public void addSelectShape(IDrawStrategy ids1){
        this.selectShapeList.add(ids1);
    }

    public ArrayList<IDrawStrategy> getDrawShapeList() {
        return drawShapeList;
    }

}
