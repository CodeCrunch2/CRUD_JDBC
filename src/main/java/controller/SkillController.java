package controller;

import dto.SkillDto;
import service.SkillService;

import java.util.List;

public class SkillController {
    private static SkillController skillController;
    private SkillService skillService = new SkillService();
    private SkillController() {

    }

    public static SkillController getSkillController() {
        if (skillController == null) {
            skillController = new SkillController();
        }
        return skillController;
    }

    public SkillDto createSkill(String skillName) {
        return skillService.createSkill(skillName);
    }

    public List<SkillDto> showSkills(){
        return skillService.showSkills();
    }

    public SkillDto deleteSkill(String skillName) {
        return skillService.deleteSkill(skillName);
    }
}
