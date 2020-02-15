package dto;

import java.util.List;

public class DeveloperDto extends BaseDto {
    private String firstName;
    private String lastName;
    private SpecialityDto specialityDto;
    private List<SkillDto> skillDtos;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SpecialityDto getSpecialityDto() {
        return specialityDto;
    }

    public void setSpecialityDto(SpecialityDto specialityDto) {
        this.specialityDto = specialityDto;
    }

    public List<SkillDto> getSkillDtos() {
        return skillDtos;
    }

    public void setSkillDtos(List<SkillDto> skillDtos) {
        this.skillDtos = skillDtos;
    }
}
