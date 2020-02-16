package service;

import dto.SpecialityDto;
import mapper.SpecialityMapper;
import model.Specialty;
import repository.SpecialityRepository;


import java.util.List;
import java.util.stream.Collectors;

public class SpecialityService {
    private final static int MINIMUM_NAME_SIZE = 3;
    private final static int MAXIMUM_NAME_SIZE = 30;
    private final static int MAXIMUM_DESCRIPTION_SIZE = 50;
    private SpecialityRepository specialityRepository;
    private SpecialityMapper specialityMapper;

    public SpecialityService(SpecialityRepository specialityRepository, SpecialityMapper specialityMapper) {
        this.specialityRepository = specialityRepository;
        this.specialityMapper = specialityMapper;
    }

    public SpecialityDto createSpeciality(String specialityName) {
        SpecialityDto specialityDto;
        if (!validateSpecialityName(specialityName)) {
            specialityDto = specialityMapper.exceptionMessageToSpecialityDto("Name must be between 3 and 30 characters");
            return specialityDto;
        }
        if (isExist(specialityName)) {
            specialityDto = specialityMapper.exceptionMessageToSpecialityDto("A specialty with that name exists");
            return specialityDto;
        }
        Specialty specialty = new Specialty(specialityName, null);
        specialityRepository.save(specialty);
        return specialityMapper.specialityToDto(specialty);


    }


    public List<SpecialityDto> showSpecialities(){
        List<SpecialityDto> specialityDtoList;
        List<Specialty> specialtyList = specialityRepository.getAll();
        if (specialtyList.isEmpty()) {
            return null;
        }
        specialityDtoList = specialtyList.stream().map(s -> specialityMapper.specialityToDto(s)).collect(Collectors.toList());
        return specialityDtoList;
    }

    public SpecialityDto deleteSpeciality(String specialityName){
        SpecialityDto specialityDto;
        if (!isExist(specialityName)) {
            specialityDto = specialityMapper.exceptionMessageToSpecialityDto("There is no specialty with the same name");
            return specialityDto;
        }
        Specialty specialty = new Specialty(specialityName, null);
        specialityRepository.delete(specialty);
        return specialityMapper.specialityToDto(specialty);
    }

    public SpecialityDto changeDescription(String specialityName, String specialityDescription) {
        SpecialityDto specialityDto;
        if (!isExist(specialityName)) {
            specialityDto = specialityMapper.exceptionMessageToSpecialityDto("There is no specialty with the same name");
            return specialityDto;
        }
        if (!validateSpecialityDescription(specialityDescription)) {
            specialityDto = specialityMapper.exceptionMessageToSpecialityDto("Description must be between 3 and 50 characters");
            return specialityDto;
        }

        Specialty specialty = new Specialty(specialityName, specialityDescription);
        specialityRepository.update(specialty);
        return specialityMapper.specialityToDto(specialty);
    }

    public  boolean validateSpecialityName(String specialityName) {
        return specialityName != null && specialityName.length() >= MINIMUM_NAME_SIZE && specialityName.length() <= MAXIMUM_NAME_SIZE;
    }
    public  boolean validateSpecialityDescription(String specialityDescription) {
        return specialityDescription != null && specialityDescription.length() >= MINIMUM_NAME_SIZE && specialityDescription.length() <= MAXIMUM_DESCRIPTION_SIZE;
    }

    public boolean isExist(String specialityName) {
        List<Specialty> specialtyList = specialityRepository.getAll();
        if (!specialtyList.isEmpty()) {
            for (Specialty specialty : specialtyList) {
                if (specialty.getSpecialtyName().equalsIgnoreCase(specialityName)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isExist(int id) {
        List<Specialty> specialtyList = specialityRepository.getAll();
        if (!specialtyList.isEmpty()) {
            for (Specialty specialty : specialtyList) {
                if (specialty.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

}
