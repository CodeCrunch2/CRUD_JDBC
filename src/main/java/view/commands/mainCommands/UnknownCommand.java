package view.commands.mainCommands;

import view.commands.Command;

public class UnknownCommand implements Command {
    public void execute() {
        System.out.println("The command was entered incorrectly. For information about the operation of the program, see the Readme file.\n");
    }
}