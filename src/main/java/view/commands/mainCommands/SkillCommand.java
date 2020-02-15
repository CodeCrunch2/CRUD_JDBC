package view.commands.mainCommands;

import view.SkillView;
import view.commands.Command;

public class SkillCommand implements Command {
    SkillView skillView = SkillView.getSkillView();
    public void execute() {
        skillView.skillView();
    }
}
