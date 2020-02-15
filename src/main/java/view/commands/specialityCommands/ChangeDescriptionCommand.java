package view.commands.specialityCommands;

import controller.SpecialityController;
import dto.SpecialityDto;
import view.commands.Command;
import view.console.ConsoleUtils;

public class ChangeDescriptionCommand implements Command {
    private SpecialityController specialityController = SpecialityController.getSpecialityController();
    private ConsoleUtils consoleUtils = ConsoleUtils.getConsoleUtils();
    public void execute() {
        System.out.println("Enter a speciality name:");
        String specialityName = consoleUtils.getStringFromConsole();
        if (specialityName.equalsIgnoreCase("cancel")) {
            System.out.println("Operation canceled");
            return;
        }
        System.out.println("Enter a description:");
        String specialityDescription = consoleUtils.getStringFromConsole();
        if (specialityDescription.equalsIgnoreCase("cancel")) {
            System.out.println("Operation canceled");
            return;
        }
        SpecialityDto specialityDto = specialityController.changeDescription(specialityName, specialityDescription);
        if (specialityDto.getErrorMessage() != null) {
            System.out.println(specialityDto.getErrorMessage());
        }


    }
}
