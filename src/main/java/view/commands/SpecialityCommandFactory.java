package view.commands;

import view.commands.mainCommands.UnknownCommand;
import view.commands.specialityCommands.*;


public class SpecialityCommandFactory implements CommandFactory {
    public Command getCommand(String command) {
        if (command.equalsIgnoreCase("create speciality")) {
            return new CreateSpecialityCommand();
        }
        else if (command.equalsIgnoreCase("delete speciality")) {
            return new DeleteSpecialityCommand();
        }
        else if (command.equalsIgnoreCase("show specialities")) {
            return new ShowSpecialitiesCommand();
        }
        else if (command.equalsIgnoreCase("change description")) {
            return new ChangeDescriptionCommand();
        }
        else if (command.equalsIgnoreCase("cancel")) {
            return new CancelCommand();
        }
        else return new UnknownCommand();
    }
}
