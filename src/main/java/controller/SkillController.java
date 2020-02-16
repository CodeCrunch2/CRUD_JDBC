package controller;

import dto.SkillDto;
import mapper.SkillMapper;
import repository.repoImpl.SkillRepositoryImpl;
import service.SkillService;

import java.util.List;

public class SkillController {
    private static SkillController skillController;
    private SkillService skillService;

    private SkillController() {
        skillService = new SkillService(new SkillMapper(), new SkillRepositoryImpl());
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
