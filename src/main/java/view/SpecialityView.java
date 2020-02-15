package view;

import view.commands.CommandFactory;

import view.commands.SpecialityCommandFactory;
import view.console.ConsoleUtils;

public class SpecialityView {
    private static SpecialityView specialityView;
    public static boolean isICancelled = false;
    private CommandFactory specialityCommandFactory = new SpecialityCommandFactory();
    private ConsoleUtils consoleUtils = ConsoleUtils.getConsoleUtils();
    private SpecialityView(){

    }
    public static SpecialityView getSpecialityView() {
        if (specialityView == null) {
            specialityView = new SpecialityView();
        }
        return specialityView;
    }
    public void specialityView() {
        isICancelled = false;
        while (!isICancelled) {
            System.out.println("Choose one of the available actions:");
            System.out.println("show specialities, create speciality, delete speciality, change description");
            specialityCommandFactory.getCommand(consoleUtils.getStringFromConsole()).execute();

        }
    }
}
