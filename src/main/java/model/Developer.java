package model;

import java.util.List;
import java.util.Objects;

public class Developer extends BaseEntity {
    private String firstName;
    private String lastName;
    private Specialty specialty;
    private List<Skill> skills;

    public Developer(String firstName, String lastName, Specialty specialty, List<Skill> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.skills = skills;
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

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Developer)) return false;
        Developer developer = (Developer) o;
        return Objects.equals(firstName, developer.firstName) &&
                Objects.equals(lastName, developer.lastName) &&
                Objects.equals(specialty, developer.specialty) &&
                Objects.equals(skills, developer.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, specialty, skills);
    }
}
