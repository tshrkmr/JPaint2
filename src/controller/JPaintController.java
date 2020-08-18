package controller;

import model.interfaces.IApplicationState;
import model.persistence.*;
import view.EventName;
import view.interfaces.IUiModule;
import view.interfaces.PaintCanvasBase;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final ShapeList shapeList;
    private final PaintCanvasBase paintCanvas;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeList shapeList, PaintCanvasBase paintCanvas) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.COPY, () -> new CommandCopyShape(shapeList).run());
        uiModule.addEvent(EventName.PASTE, () -> new CommandPasteShape(shapeList, paintCanvas).run());
        uiModule.addEvent(EventName.DELETE, () -> new CommandDeleteShape(shapeList, paintCanvas).run());
        uiModule.addEvent(EventName.REDO, () -> new CommandRedo().run());
        uiModule.addEvent(EventName.UNDO, () -> new CommandUndo().run());
        uiModule.addEvent(EventName.GROUP, () -> new CommandGroupShape(shapeList).run());
        uiModule.addEvent(EventName.UNGROUP, () -> new CommandUnGroupShape().run());
    }
}
