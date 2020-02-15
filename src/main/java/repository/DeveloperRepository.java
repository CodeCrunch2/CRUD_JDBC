package repository;

import model.Developer;
import model.Skill;

public interface DeveloperRepository extends GenericRepository<Developer, Integer> {
    void updateSpeciality(Developer developer);
    void addSkill(Developer developer, Skill skill);
    void deleteSkill(Developer developer, Skill skill);
    boolean haveSkill(int developerId, int skillId);
}
