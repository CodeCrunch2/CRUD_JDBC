package repository.repoImpl;

import model.Developer;
import model.Skill;
import model.Specialty;
import repository.DeveloperRepository;
import repository.SkillRepository;
import repository.SpecialityRepository;
import repository.connectionUtil.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepositoryImpl implements DeveloperRepository {
    private static Connection connection = ConnectionUtil.getInstance().getConnection();
    private SkillRepository skillRepository = new SkillRepositoryImpl();
    private SpecialityRepository specialityRepository = new SpecialityRepositoryImpl();
    @Override
    public void save(Developer developer) {
        String sql = "insert into developers (first_name, last_name) values (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
           preparedStatement.setString(1, developer.getFirstName());
           preparedStatement.setString(2, developer.getLastName());
           preparedStatement.executeUpdate();
       }
       catch (SQLException e) {
           e.printStackTrace();
       }
    }

    @Override
    public void delete(Developer developer) {
        try (Statement statement = connection.createStatement()) {
            String sql = "delete from developers where id = '" + developer.getId() + "'";
            statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Developer developer) {

    }

    public void updateSpeciality(Developer developer) {
        String sql = "update developers set speciality_id = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, developer.getSpecialty().getId());
            preparedStatement.setInt(2, developer.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addSkill(Developer developer, Skill skill) {
        String sql = "insert into developers_skills values (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, developer.getId());
            preparedStatement.setInt(2, skill.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteSkill(Developer developer, Skill skill) {
        String sql = "delete from developers_skills where developer_id = ? and skill_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, developer.getId());
            preparedStatement.setInt(2, skill.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean haveSkill(int developerId, int skillId) {
        String sql = "select skill_id from developers_skills where developer_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, developerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("skill_id") == skillId) return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public List<Developer> getAll() {
        List<Developer> developerList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = "select * from developers";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int developerId = resultSet.getInt("id");
                String developerFirstName = resultSet.getString("first_name");
                String developerLastName = resultSet.getString("last_name");
                int specialityId = resultSet.getInt("speciality_id");
                Developer developer = new Developer(developerFirstName, developerLastName, null, null);
                developer.setId(developerId);
                if (specialityId != 0) {
                    Specialty specialty = specialityRepository.getById(specialityId);
                    developer.setSpecialty(specialty);
                }
                List<Skill> skillList = getSkillListByDeveloperId(developerId);
                if(!skillList.isEmpty()) {
                    developer.setSkills(skillList);
                }
                developerList.add(developer);

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return developerList;
    }

    @Override
    public Developer getById(Integer id) {
        List<Developer> developerList = getAll();
        for (Developer developer : developerList) {
            if (developer.getId() == (int) id) {
                return developer;
            }
        }
        return null;
    }

    private List<Skill> getSkillListByDeveloperId(int id) {
        List<Skill> skillList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = "select skill_id from developers_skills where developer_id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Skill skill = skillRepository.getById(resultSet.getInt("skill_id"));
                skillList.add(skill);

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return skillList;

    }
}
