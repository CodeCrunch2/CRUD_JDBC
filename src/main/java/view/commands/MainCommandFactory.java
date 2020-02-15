package view.commands;

import view.commands.mainCommands.*;

public class MainCommandFactory implements CommandFactory {
    public Command getCommand(String command) {
        if (command.equalsIgnoreCase("skill")) {
            return new SkillCommand();
        }
        else if(command.equalsIgnoreCase("speciality")) {
            return new SpecialityCommand();
        }
        else if(command.equalsIgnoreCase("developer")) {
            return new DeveloperCommand();
        }
        else if (command.equalsIgnoreCase("exit")) {
            return new ExitCommand();
        }

        else return new UnknownCommand();
    }
}
