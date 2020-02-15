package view.commands;

import view.commands.mainCommands.UnknownCommand;
import view.commands.skillCommands.CancelCommand;
import view.commands.skillCommands.CreateSkillCommand;
import view.commands.skillCommands.DeleteSkillCommand;
import view.commands.skillCommands.ShowSkillsCommand;

public class SkillCommandFactory implements CommandFactory {
    public Command getCommand(String command) {
        if (command.equalsIgnoreCase("create skill")) {
            return new CreateSkillCommand();
        }
        else if (command.equalsIgnoreCase("delete skill")) {
            return new DeleteSkillCommand();
        }
        else if (command.equalsIgnoreCase("cancel")) {
            return new CancelCommand();
        }
        else if(command.equalsIgnoreCase("show skills")) {
            return new ShowSkillsCommand();
        }
        else return new UnknownCommand();
    }
}
