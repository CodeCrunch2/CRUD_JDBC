package mapper;

import dto.SkillDto;
import model.Skill;

public class SkillMapper {
    public SkillDto skillToDto(Skill skill) {
        if (skill == null) {
            return null;
        }
        final SkillDto skillDto = new SkillDto();

        skillDto.setSkillName(skill.getSkillName());
        skillDto.setId(skill.getId());

        return skillDto;
    }

    public SkillDto exceptionMessageToSkillDto(String message) {
        if(message == null){
            return null;
        }
        SkillDto skillDto = new SkillDto();
        skillDto.setErrorMessage(message);
        return skillDto;
    }
}
