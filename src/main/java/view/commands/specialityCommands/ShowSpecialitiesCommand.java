package view.commands.specialityCommands;

import controller.SpecialityController;
import dto.SpecialityDto;
import view.commands.Command;

import java.util.List;

public class ShowSpecialitiesCommand implements Command {
    private SpecialityController specialityController = SpecialityController.getSpecialityController();

    @Override
    public void execute() {
        List<SpecialityDto> specialityDtoList = specialityController.showSpecialities();
        if (specialityDtoList == null) {
            System.out.println("Speciality list is empty");
            return;
        }
        specialityDtoList.forEach(s -> System.out.println("id: " + s.getId() + " speciality name: " + s.getSpecialtyName() +
                " description: " + s.getDescription()));
    }
}
