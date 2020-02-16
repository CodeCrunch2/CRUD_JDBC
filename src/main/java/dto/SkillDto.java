package dto;

import java.util.Objects;

public class SkillDto extends BaseDto {
    private String skillName;

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillDto)) return false;
        SkillDto skillDto = (SkillDto) o;
        return Objects.equals(skillName, skillDto.skillName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillName);
    }
}
