package view;

import view.commands.CommandFactory;
import view.commands.MainCommandFactory;
import view.console.ConsoleUtils;

public class MainView {
    public static boolean isInterrupted = false;
    private ConsoleUtils consoleUtils = ConsoleUtils.getConsoleUtils();
    private CommandFactory mainCommandFactory = new MainCommandFactory();

    public void execute() {
        mainView();
    }
    private void mainView() {
        while (!isInterrupted) {
            System.out.println("Select an entity to work: skill, speciality, developer");
            System.out.println("To exit the program, enter 'exit'");
            mainCommandFactory.getCommand(consoleUtils.getStringFromConsole()).execute();
        }
    }

}
