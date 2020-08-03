package model.persistence;

import model.interfaces.ICommand;

public class CommandUndo implements ICommand {
    @Override
    public void run() {
        CommandHistory.undo();
    }
}
