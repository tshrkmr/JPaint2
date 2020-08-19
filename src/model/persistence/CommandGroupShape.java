package model.persistence;

import model.interfaces.ICommand;
import model.interfaces.IShape;

public class CommandGroupShape implements ICommand {

    private final ShapeList shapeList;

    public CommandGroupShape(ShapeList shapeList){
        this.shapeList = shapeList;
    }
    @Override
    public void run() {
        System.out.println("Group Command");
        shapeList.groupShapeList.clear();
        groupShape();
    }

    private void groupShape(){
        for(IShape shape: shapeList.getSelectShapeList()){
            shapeList.addGroupShape(shape);
        }
        System.out.println("# of shapes Grouped " + shapeList.getGroupShapeList().size());
    }
}
