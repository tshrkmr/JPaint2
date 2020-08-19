package model.persistence;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoRedo;

import java.util.ArrayList;

public class CommandGroupShape implements ICommand, IUndoRedo {

    private final ShapeList shapeList;
    ArrayList<IShape> undoGroup;

    public CommandGroupShape(ShapeList shapeList){
        this.shapeList = shapeList;
        undoGroup = new ArrayList<>();
    }
    @Override
    public void run() {
        System.out.println("Group Command");
        shapeList.groupShapeList.clear();
        groupShape();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for(IShape shape: undoGroup){
            shapeList.removeGroupShape(shape);
            undoGroup.remove(shape);
        }
    }

    @Override
    public void redo() {
        groupShape();
    }

    private void groupShape(){
        for(IShape shape: shapeList.getSelectShapeList()){
            shapeList.addGroupShape(shape);
            undoGroup.add(shape);
        }
        System.out.println("# of shapes Grouped " + shapeList.getGroupShapeList().size());
    }
}
