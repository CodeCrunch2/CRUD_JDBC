package view;

import view.commands.CommandFactory;
import view.commands.DeveloperCommandFactory;
import view.console.ConsoleUtils;

public class DeveloperView {
    private static DeveloperView developerView;
    public static boolean isICancelled = false;
    private CommandFactory developerCommandFactory = new DeveloperCommandFactory();
    private ConsoleUtils consoleUtils = ConsoleUtils.getConsoleUtils();
    private DeveloperView(){

    }
    public static DeveloperView getDeveloperView(){
        if (developerView == null) {
            developerView = new DeveloperView();
        }
        return developerView;
    }
    public void developerView(){
        isICancelled = false;
        while(!isICancelled) {
            System.out.println("Choose one of the available actions:");
            System.out.println("create developer, delete developer, show developers, " +
                    "change speciality, add skill, delete skill");
            developerCommandFactory.getCommand(consoleUtils.getStringFromConsole()).execute();
        }
    }
}
