package model;

public class Specialty extends BaseEntity {
    private String specialtyName;
    private String description;

    public Specialty(String specialtyName, String description) {
        this.specialtyName = specialtyName;
        this.description = description;
    }

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
}
