package view;

import view.commands.CommandFactory;
import view.commands.SkillCommandFactory;
import view.console.ConsoleUtils;

public class SkillView {
    private static SkillView skillView;
    public static boolean isICancelled = false;
    private CommandFactory skillCommandFactory = new SkillCommandFactory();
    private ConsoleUtils consoleUtils = ConsoleUtils.getConsoleUtils();
    private SkillView(){

    }
    public static SkillView getSkillView() {
        if (skillView == null) {
            skillView = new SkillView();
        }
        return skillView;
    }
    public void skillView() {
        isICancelled = false;
        while (!isICancelled) {
            System.out.println("Choose one of the available actions:");
            System.out.println("create skill, delete skill, show skills");
            skillCommandFactory.getCommand(consoleUtils.getStringFromConsole()).execute();
        }
    }

}
