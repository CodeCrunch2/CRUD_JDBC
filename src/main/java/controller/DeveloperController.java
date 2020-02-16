package controller;

import dto.DeveloperDto;
import mapper.DeveloperMapper;
import mapper.SkillMapper;
import mapper.SpecialityMapper;
import repository.DeveloperRepository;
import repository.SkillRepository;
import repository.SpecialityRepository;
import repository.repoImpl.DeveloperRepositoryImpl;
import repository.repoImpl.SkillRepositoryImpl;
import repository.repoImpl.SpecialityRepositoryImpl;
import service.DeveloperService;
import service.SkillService;
import service.SpecialityService;

import java.util.List;

public class DeveloperController {
    private static DeveloperController developerController;
    private DeveloperService developerService;
    private DeveloperController(){
        DeveloperRepository developerRepository = new DeveloperRepositoryImpl();
        DeveloperMapper developerMapper= new DeveloperMapper();
        SpecialityService specialityService = new SpecialityService(new SpecialityRepositoryImpl(), new SpecialityMapper());
        SpecialityRepository specialityRepository = new SpecialityRepositoryImpl();
        SkillService skillService = new SkillService(new SkillMapper(), new SkillRepositoryImpl());
        SkillRepository skillRepository = new SkillRepositoryImpl();
        developerService = new DeveloperService(developerRepository, developerMapper, specialityService, specialityRepository,
                skillService, skillRepository);
    }
    public static DeveloperController getDeveloperController(){
        if (developerController == null) {
            developerController = new DeveloperController();
        }
        return developerController;
    }
    public DeveloperDto createDeveloper(String firstName, String lastName) {
        return developerService.createDeveloper(firstName, lastName);
    }

    public List<DeveloperDto> showDevelopers() {
        return developerService.showDevelopers();
    }

    public  DeveloperDto deleteDeveloper(int id) {
        return developerService.deleteDeveloper(id);
    }

    public DeveloperDto updateSpeciality(int developerId, int specialityId) {
        return developerService.changeSpeciality(developerId, specialityId);
    }

    public DeveloperDto addSkill(int developerId, int skillId) {
        return developerService.addSkill(developerId, skillId);
    }

    public DeveloperDto deleteSkill(int developerId, int skillId) {
        return developerService.deleteSkill(developerId, skillId);
    }
}
