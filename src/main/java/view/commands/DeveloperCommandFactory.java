package view.commands;

import view.commands.developerCommands.*;
import view.commands.mainCommands.UnknownCommand;


public class DeveloperCommandFactory implements CommandFactory {
    public Command getCommand(String command) {
        if (command.equalsIgnoreCase("create developer")) {
            return new CreateDeveloperCommand();
        }
        else if (command.equalsIgnoreCase("delete developer")) {
            return new DeleteDeveloperCommand();
        }
        else if (command.equalsIgnoreCase("change speciality")) {
            return new ChangeSpecialityCommand();
        }
        else if (command.equalsIgnoreCase("add skill")) {
            return new AddSkillCommand();
        }
        else if (command.equalsIgnoreCase("delete skill")) {
            return new DeleteSkillCommand();
        }
        else if (command.equalsIgnoreCase("show developers")) {
            return new ShowDevelopersCommand();
        }
        else if (command.equalsIgnoreCase("cancel")) {
            return new CancelCommand();
        }
        else return new UnknownCommand();
    }
}
