package view.commands.developerCommands;

import controller.DeveloperController;
import dto.DeveloperDto;
import dto.SkillDto;
import view.commands.Command;

import java.util.List;

public class ShowDevelopersCommand implements Command {
    DeveloperController developerController = DeveloperController.getDeveloperController();
    @Override
    public void execute() {
        List<DeveloperDto> developerDtoList = developerController.showDevelopers();
        if (developerDtoList == null) {
            System.out.println("Developer list is empty");
            return;
        }
        for (DeveloperDto developerDto: developerDtoList) {
            System.out.println("id: " + developerDto.getId() + " name: " + developerDto.getFirstName() + " " + developerDto.getLastName());
            if (developerDto.getSpecialityDto() == null) {
                System.out.println("speciality: no speciality");
            }
            else {
                System.out.println("speciality: " + developerDto.getSpecialityDto().getSpecialtyName());
            }
            System.out.println("skills: ");
            if (developerDto.getSkillDtos() != null) {
                for (SkillDto skillDto: developerDto.getSkillDtos()) {
                    System.out.println(skillDto.getSkillName());
                }
            }
            else {
                System.out.println("no skills");
            }
            System.out.println("======================================================");
        }
    }
}
