package model.persistence;

import model.interfaces.ICommand;

public class CommandCopyShape implements ICommand {

    private final ShapeList shapeList;

    public CommandCopyShape(ShapeList shapeList){
        this.shapeList = shapeList;
    }
    @Override
    public void run() {
        System.out.println("Copy Command");
        shapeList.copyShapeList.clear();

        for(Shape shape: shapeList.getSelectShapeList()){
            shapeList.addCopyShape(shape);
        }
        System.out.println("# of shapes Copied " + shapeList.getCopyShapeList().size());
    }
}
