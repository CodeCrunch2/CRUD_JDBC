package service;

import dto.SkillDto;
import mapper.SkillMapper;
import model.Skill;
import repository.SkillRepository;
import repository.repoImpl.SkillRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class SkillService {
    private final static int MINIMUM_NAME_SIZE = 3;
    private final static int MAXIMUM_NAME_SIZE = 30;
    private SkillRepository skillRepository = new SkillRepositoryImpl();
    private SkillMapper skillMapper = new SkillMapper();

    public SkillDto createSkill(String skillName) {
        SkillDto skillDto;
        if (!validateSkillName(skillName)) {
            skillDto = skillMapper.exceptionMessageToSkillDto("Name must be between 3 and 30 characters");
            return skillDto;
        }
        if (isExist(skillName)) {
            skillDto = skillMapper.exceptionMessageToSkillDto("Skill with this name exists");
            return skillDto;
        }
        Skill skill = new Skill(skillName);
        skillRepository.save(skill);
        return skillMapper.skillToDto(skill);

    }

    public List<SkillDto> showSkills(){
        List<SkillDto> skillDtoList;
        List<Skill> skillList = skillRepository.getAll();
        if(skillList.isEmpty()) {
            return null;
        }
        skillDtoList = skillList.stream().map(s -> skillMapper.skillToDto(s)).collect(Collectors.toList());
        return skillDtoList;
    }

    public SkillDto deleteSkill(String skillName){
        SkillDto skillDto;
        if (!isExist(skillName)) {
            skillDto = skillMapper.exceptionMessageToSkillDto("Skill with this name does not exist");
            return skillDto;
        }
        Skill skill = new Skill(skillName);
        skillRepository.delete(skill);
        return skillMapper.skillToDto(skill);
    }

    public  boolean validateSkillName(String skillName) {
        return skillName != null && skillName.length() >= MINIMUM_NAME_SIZE && skillName.length() <= MAXIMUM_NAME_SIZE;
    }
    public boolean isExist(String skillName) {
        List<Skill> skillList = skillRepository.getAll();
        if (!skillList.isEmpty()) {
            for (Skill skill : skillList) {
                if (skill.getSkillName().equalsIgnoreCase(skillName)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isExist(int id) {
        List<Skill> skillList = skillRepository.getAll();
        if (!skillList.isEmpty()) {
            for (Skill skill : skillList) {
                if (skill.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }


}
