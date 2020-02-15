package view.commands.specialityCommands;

import view.SpecialityView;
import view.commands.Command;

public class CancelCommand implements Command {
    public void execute() {
        SpecialityView.isICancelled = true;
    }
}
