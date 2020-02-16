package dto;

import java.util.Objects;

public class SpecialityDto extends BaseDto {
    private String specialtyName;
    private String description;

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecialityDto)) return false;
        SpecialityDto that = (SpecialityDto) o;
        return Objects.equals(specialtyName, that.specialtyName) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialtyName, description);
    }
}
