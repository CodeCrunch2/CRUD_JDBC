package view.commands.mainCommands;

import view.SpecialityView;
import view.commands.Command;

public class SpecialityCommand implements Command {
    private SpecialityView specialityView = SpecialityView.getSpecialityView();
    public void execute() {
        specialityView.specialityView();
    }
}
