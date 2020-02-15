package mapper;

import dto.DeveloperDto;
import dto.SkillDto;
import model.Developer;
import model.Skill;

import java.util.ArrayList;
import java.util.List;

public class DeveloperMapper {
    private SkillMapper skillMapper = new SkillMapper();
    private SpecialityMapper specialityMapper = new SpecialityMapper();
    public DeveloperDto developerToDto(Developer developer){
        if (developer == null) {
            return null;
        }
        DeveloperDto developerDto = new DeveloperDto();
        developerDto.setId(developer.getId());
        developerDto.setFirstName(developer.getFirstName());
        developerDto.setLastName(developer.getLastName());
        if (developer.getSpecialty() != null) {
            developerDto.setSpecialityDto(specialityMapper.specialityToDto(developer.getSpecialty()));
        }
        if (developer.getSkills() != null) {
            List<SkillDto> skillDtoList = new ArrayList<>();
            for (Skill skill: developer.getSkills()) {
                skillDtoList.add(skillMapper.skillToDto(skill));
            }
            developerDto.setSkillDtos(skillDtoList);
        }
        return developerDto;
    }
    public DeveloperDto exceptionMessageToDeveloperDto(String message) {
        if(message == null){
            return null;
        }
        DeveloperDto developerDto = new DeveloperDto();
        developerDto.setErrorMessage(message);
        return developerDto;
    }
}
