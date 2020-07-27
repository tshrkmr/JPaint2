package model.persistence;

import model.interfaces.*;
public class CommandSelectShape implements ICommand {

    private final Point startPoint, endPoint;
    private final ShapeList shapeList;
    private final IApplicationState appState;

    public CommandSelectShape(Point startPoint, Point endPoint, ShapeList shapeList, IApplicationState appState) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
        this.appState = appState;
    }

    @Override
    public void run() {
        System.out.println("Select Command");
        shapeList.selectShapeList.clear();

        Shape sel = new Shape(startPoint, endPoint, appState);
        sel.setProperties();

        for (Shape s : shapeList.getDrawShapeList()) {
            if (sel.getStartX() < s.getStartX() + s.getWidth() && sel.getStartX() + sel.getWidth() > s.getStartX() &&
                    sel.getStartY() < s.getStartY() + s.getHeight() && sel.getStartY() + sel.getHeight() > s.getStartY()) {

                shapeList.addSelectShape(s);
            } else {
                System.out.println("Nothing Selected!!");
            }
        }
        System.out.println("# of shapes Selected " + shapeList.getSelectedShapeList().size());
    }
}