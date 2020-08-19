package model.persistence;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoRedo;

import java.util.ArrayList;

public class CommandUnGroupShape implements ICommand, IUndoRedo {

    private final ShapeList shapeList;
    ArrayList<IShape> undoUngroup;

    public CommandUnGroupShape(ShapeList shapeList) {
        this.shapeList = shapeList;
        undoUngroup = new ArrayList<>();
    }

    @Override
    public void run(){
        System.out.println("UnGroup Command");
        unGroupShape();
        System.out.println("# of shapes ungrouped: " + shapeList.getGroupShapeList().size());
    }

    @Override
    public void undo() {
        for (IShape shape: undoUngroup) {
                shapeList.addSelectShape(shape);
                undoUngroup.remove(shape);
            }
    }

    @Override
    public void redo() {
        unGroupShape();
    }

    private void unGroupShape(){
        for (IShape shape: shapeList.getSelectShapeList()) {
            if (shapeList.getGroupShapeList().contains(shape)) {
                shapeList.removeGroupShape(shape);
                undoUngroup.add(shape);
            }
        }
    }
}
