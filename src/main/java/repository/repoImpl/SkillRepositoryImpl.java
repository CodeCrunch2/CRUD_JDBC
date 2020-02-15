package repository.repoImpl;

import model.Skill;
import repository.SkillRepository;
import repository.connectionUtil.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillRepositoryImpl implements SkillRepository {
    private static Connection connection = ConnectionUtil.getInstance().getConnection();

    @Override
    public void save(Skill skill) {
        try (Statement statement = connection.createStatement()) {
            String sql = "insert into skills (skill_name) values('" + skill.getSkillName() + "')";
            statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Skill skill) {
        try (Statement statement = connection.createStatement()) {
            String sql = "delete from skills where skill_name = '" + skill.getSkillName() + "'";
            statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Skill skill) {

    }

    @Override
    public List<Skill> getAll() {
        List<Skill> skillList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = "select * from skills";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int skillId = resultSet.getInt("id");
                String skillName = resultSet.getString("skill_name");
                Skill skill = new Skill(skillName);
                skill.setId(skillId);
                skillList.add(skill);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return skillList;
    }

    @Override
    public Skill getById(Integer id) {
        Skill skill = new Skill(null);
        try (Statement statement = connection.createStatement()) {
            String sql = "select * from skills where id = " + (int)id;
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            skill.setId(id);
            String skillName = resultSet.getString("skill_name");
            skill.setSkillName(skillName);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return skill;
    }
}
