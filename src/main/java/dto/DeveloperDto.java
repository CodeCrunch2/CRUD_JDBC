package dto;

import java.util.List;
import java.util.Objects;

public class DeveloperDto extends BaseDto {
    private String firstName;
    private String lastName;
    private SpecialityDto specialityDto;
    private List<SkillDto> skillDtos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeveloperDto)) return false;
        DeveloperDto that = (DeveloperDto) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(specialityDto, that.specialityDto) &&
                Objects.equals(skillDtos, that.skillDtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, specialityDto, skillDtos);
    }

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
