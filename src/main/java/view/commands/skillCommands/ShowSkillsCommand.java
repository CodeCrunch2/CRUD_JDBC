package view.commands.skillCommands;

import controller.SkillController;
import dto.SkillDto;
import view.commands.Command;

import java.util.List;

public class ShowSkillsCommand implements Command {
    private SkillController skillController = SkillController.getSkillController();
    public void execute() {
        List<SkillDto> skillDtoList = skillController.showSkills();
        if (skillDtoList == null) {
            System.out.println("Skill list is empty");
            return;
        }
        skillDtoList.forEach(s -> System.out.println("id: " + s.getId() + " skill name: " + s.getSkillName()));
    }
}
