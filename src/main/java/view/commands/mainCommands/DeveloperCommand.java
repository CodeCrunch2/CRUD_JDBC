package view.commands.mainCommands;

import view.DeveloperView;
import view.commands.Command;

public class DeveloperCommand implements Command {
    private DeveloperView developerView = DeveloperView.getDeveloperView();
    public void execute() {
        developerView.developerView();
    }
}
