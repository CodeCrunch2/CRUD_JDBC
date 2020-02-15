package service;

import dto.DeveloperDto;
import mapper.DeveloperMapper;
import model.Developer;
import model.Skill;
import model.Specialty;
import repository.DeveloperRepository;
import repository.SkillRepository;
import repository.SpecialityRepository;
import repository.repoImpl.DeveloperRepositoryImpl;
import repository.repoImpl.SkillRepositoryImpl;
import repository.repoImpl.SpecialityRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class DeveloperService {
    private final static int MINIMUM_NAME_SIZE = 3;
    private final static int MAXIMUM_NAME_SIZE = 30;
    private DeveloperRepository developerRepository = new DeveloperRepositoryImpl();
    private DeveloperMapper developerMapper = new DeveloperMapper();
    private SpecialityService specialityService = new SpecialityService();
    private SpecialityRepository specialityRepository = new SpecialityRepositoryImpl();
    private SkillService skillService = new SkillService();
    private SkillRepository skillRepository = new SkillRepositoryImpl();

    public DeveloperDto createDeveloper(String firstName, String lastName) {
        DeveloperDto developerDto;
        if (!validateDeveloperName(firstName)) {
            developerDto = developerMapper.exceptionMessageToDeveloperDto("First name must be between 3 and 30 character");
            return developerDto;
        }
        if (!validateDeveloperName(lastName)) {
            developerDto = developerMapper.exceptionMessageToDeveloperDto("Last name must be between 3 and 30 character");
            return developerDto;
        }
        Developer developer = new Developer(firstName, lastName, null, null);
        developerRepository.save(developer);
        return developerMapper.developerToDto(developer);
    }
    public List<DeveloperDto> showDevelopers(){
        List<DeveloperDto> developerDtoList;
        List<Developer> developerList = developerRepository.getAll();
        if (developerList.isEmpty()){
            return null;
        }
        developerDtoList = developerList.stream().map(d -> developerMapper.developerToDto(d)).collect(Collectors.toList());
        return developerDtoList;
    }
    public DeveloperDto deleteDeveloper(int id) {
        DeveloperDto developerDto;
        if (!isExist(id)) {
            developerDto = developerMapper.exceptionMessageToDeveloperDto("There is no developer with such id");
            return developerDto;
        }
        Developer developer = new Developer(null, null, null, null);
        developer.setId(id);
        developerRepository.delete(developer);
        return developerMapper.developerToDto(developer);
    }
    public DeveloperDto changeSpeciality(int developerId, int specialityId) {
        DeveloperDto developerDto;
        if (!isExist(developerId)) {
            developerDto = developerMapper.exceptionMessageToDeveloperDto("There is no developer with such id");
            return developerDto;
        }
        if(!specialityService.isExist(specialityId)) {
            developerDto = developerMapper.exceptionMessageToDeveloperDto("There is no specialty with such id");
            return developerDto;
        }
        Specialty specialty = specialityRepository.getById(specialityId);
        Developer developer = new Developer(null, null, specialty, null);
        developer.setId(developerId);
        developerRepository.updateSpeciality(developer);
        return developerMapper.developerToDto(developer);

    }
    public DeveloperDto addSkill(int developerId, int skillId) {
        DeveloperDto developerDto;
        if (!isExist(developerId)) {
            developerDto = developerMapper.exceptionMessageToDeveloperDto("There is no developer with such id");
            return developerDto;
        }
        if (!skillService.isExist(skillId)) {
            developerDto = developerMapper.exceptionMessageToDeveloperDto("There is no skill with such id");
            return developerDto;
        }
        if (developerRepository.haveSkill(developerId, skillId)) {
            developerDto = developerMapper.exceptionMessageToDeveloperDto("The developer already has the skill");
            return developerDto;
        }
        Skill skill = skillRepository.getById(skillId);
        Developer developer = new Developer(null, null, null, null);
        developer.setId(developerId);
        developerRepository.addSkill(developer, skill);
        return developerMapper.developerToDto(developer);
    }
    public DeveloperDto deleteSkill(int developerId, int skillId) {
        DeveloperDto developerDto;
        if (!isExist(developerId)) {
            developerDto = developerMapper.exceptionMessageToDeveloperDto("There is no developer with such id");
            return developerDto;
        }
        if (!skillService.isExist(skillId)) {
            developerDto = developerMapper.exceptionMessageToDeveloperDto("There is no skill with such id");
            return developerDto;
        }
        if (!developerRepository.haveSkill(developerId, skillId)) {
            developerDto = developerMapper.exceptionMessageToDeveloperDto("The developer does not have the skill");
            return developerDto;
        }
        Skill skill = skillRepository.getById(skillId);
        Developer developer = new Developer(null, null, null, null);
        developer.setId(developerId);
        developerRepository.deleteSkill(developer, skill);
        return developerMapper.developerToDto(developer);
    }


    public  boolean validateDeveloperName(String developerName) {
        return developerName != null && developerName.length() >= MINIMUM_NAME_SIZE && developerName.length() <= MAXIMUM_NAME_SIZE;
    }
    public boolean isExist(int id) {
        List<Developer> developerList = developerRepository.getAll();
        if (!developerList.isEmpty()) {
            for (Developer developer : developerList) {
                if (developer.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }


}
