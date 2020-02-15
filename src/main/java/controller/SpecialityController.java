package controller;

import dto.SpecialityDto;
import service.SpecialityService;

import java.util.List;

public class SpecialityController {
    private static SpecialityController specialityController;
    private SpecialityService specialityService = new SpecialityService();

    private SpecialityController(){

    }

    public static SpecialityController getSpecialityController(){
        if (specialityController == null) {
            specialityController = new SpecialityController();
        }
        return specialityController;
    }

    public SpecialityDto createSpeciality(String specialityName) {
        return specialityService.createSpeciality(specialityName);
    }
    public List<SpecialityDto> showSpecialities() {
        return specialityService.showSpecialities();
    }
    public SpecialityDto deleteSpeciality(String specialityName) {
        return specialityService.deleteSpeciality(specialityName);
    }
    public SpecialityDto changeDescription(String specialityName, String specialityDescription) {
        return specialityService.changeDescription(specialityName, specialityDescription);
    }
}
