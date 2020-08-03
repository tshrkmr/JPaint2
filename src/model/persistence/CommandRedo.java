package model.persistence;

import model.interfaces.ICommand;

public class CommandRedo implements ICommand {
    @Override
    public void run() {
        CommandHistory.redo();
    }
}
