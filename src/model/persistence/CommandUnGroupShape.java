package model.persistence;

import model.interfaces.ICommand;
import model.interfaces.IShape;

public class CommandUnGroupShape implements ICommand {

    private final ShapeList shapeList;

    public CommandUnGroupShape(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void run(){
        System.out.println("UnGroup Command");
        unGroupShape();
        System.out.println("# of shapes ungrouped: " + shapeList.getGroupShapeList().size());
    }

    private void unGroupShape(){
        for (IShape shape: shapeList.getSelectShapeList()) {
            if (shapeList.getGroupShapeList().contains(shape)) {
                shapeList.removeGroupShape(shape);
            }
        }
    }
}
