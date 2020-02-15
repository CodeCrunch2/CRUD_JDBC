package controller;

import dto.DeveloperDto;
import service.DeveloperService;

import java.util.List;

public class DeveloperController {
    private static DeveloperController developerController;
    private DeveloperService developerService = new DeveloperService();
    private DeveloperController(){

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
