package view.commands.developerCommands;

import controller.DeveloperController;
import dto.DeveloperDto;
import view.commands.Command;
import view.console.ConsoleUtils;

public class DeleteDeveloperCommand implements Command {
    private DeveloperController developerController = DeveloperController.getDeveloperController();
    ConsoleUtils consoleUtils = ConsoleUtils.getConsoleUtils();
    public void execute() {
        System.out.println("Enter developer id:");
        String developerIdString = consoleUtils.getStringFromConsole();
        if (developerIdString.equalsIgnoreCase("cancel")) {
            System.out.println("Operation canceled");
            return;
        }
        try {
            Integer.parseInt(developerIdString);
        }
        catch (NumberFormatException e) {
            System.out.println("id must be a number");
        }
        DeveloperDto developerDto = developerController.deleteDeveloper(Integer.parseInt(developerIdString));
        if (developerDto.getErrorMessage() != null) {
            System.out.println(developerDto.getErrorMessage());
        }


    }
}
