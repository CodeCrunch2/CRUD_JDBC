package mapper;

import dto.SpecialityDto;
import model.Specialty;

public class SpecialityMapper {
    public SpecialityDto specialityToDto(Specialty specialty){
        if (specialty == null) {
            return null;
        }
        final SpecialityDto specialityDto = new SpecialityDto();
        specialityDto.setSpecialtyName(specialty.getSpecialtyName());
        specialityDto.setDescription(specialty.getDescription());
        specialityDto.setId(specialty.getId());
        return specialityDto;
    }
    public SpecialityDto exceptionMessageToSpecialityDto(String message) {
        if(message == null){
            return null;
        }
        SpecialityDto specialityDto = new SpecialityDto();
        specialityDto.setErrorMessage(message);
        return specialityDto;
    }
}

