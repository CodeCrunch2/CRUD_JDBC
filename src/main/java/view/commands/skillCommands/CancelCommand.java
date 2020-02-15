package view.commands.skillCommands;

import view.SkillView;
import view.commands.Command;

public class CancelCommand implements Command {
    public void execute() {
        SkillView.isICancelled = true;
    }
}
