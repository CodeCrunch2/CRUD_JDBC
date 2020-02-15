package view.commands.developerCommands;

import controller.DeveloperController;
import dto.DeveloperDto;
import view.commands.Command;
import view.console.ConsoleUtils;

public class CreateDeveloperCommand implements Command {
    private ConsoleUtils consoleUtils = ConsoleUtils.getConsoleUtils();
    private DeveloperController developerController = DeveloperController.getDeveloperController();
    public void execute() {
        System.out.println("Enter first name: ");
        String firstName = consoleUtils.getStringFromConsole();
        if (firstName.equalsIgnoreCase("cancel")) {
            System.out.println("Operation canceled");
            return;
        }
        System.out.println("Enter last name: ");
        String lastName = consoleUtils.getStringFromConsole();
        if (lastName.equalsIgnoreCase("cancel")) {
            System.out.println("Operation canceled");
            return;
        }
        DeveloperDto developerDto = developerController.createDeveloper(firstName, lastName);
        if(developerDto.getErrorMessage() != null){
            System.out.println(developerDto.getErrorMessage());
        }
    }
}
