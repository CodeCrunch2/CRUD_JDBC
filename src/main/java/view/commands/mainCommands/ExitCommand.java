package view.commands.mainCommands;

import view.MainView;
import view.commands.Command;

public class ExitCommand implements Command {
    public void execute() {
        MainView.isInterrupted = true;
    }
}
