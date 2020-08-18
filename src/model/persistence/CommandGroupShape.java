package model.persistence;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoRedo;

public class CommandGroupShape implements ICommand, IUndoRedo {

    private final ShapeList shapeList;

    public CommandGroupShape(ShapeList shapeList){
        this.shapeList = shapeList;
    }
    @Override
    public void run() {
        System.out.println("Group Command");
        shapeList.groupShapeList.clear();

        for(IShape shape: shapeList.getSelectShapeList()){
            shapeList.addGroupShape(shape);
        }
        System.out.println("# of shapes Grouped " + shapeList.getGroupShapeList().size());
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
