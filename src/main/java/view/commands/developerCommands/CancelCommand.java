package view.commands.developerCommands;

import view.DeveloperView;
import view.commands.Command;

public class CancelCommand implements Command {
    public void execute() {
        DeveloperView.isICancelled = true;
    }
}
