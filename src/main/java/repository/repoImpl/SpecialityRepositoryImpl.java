package repository.repoImpl;

import model.Specialty;
import repository.SpecialityRepository;
import repository.connectionUtil.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SpecialityRepositoryImpl implements SpecialityRepository {
    private static Connection connection = ConnectionUtil.getInstance().getConnection();
    @Override
    public void save(Specialty specialty) {
        try (Statement statement = connection.createStatement()) {
            String sql = "insert into specialities (speciality_name) values('" + specialty.getSpecialtyName() + "')";
            statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Specialty specialty) {
        try (Statement statement = connection.createStatement()) {
            String sql = "delete from specialities where speciality_name = '" + specialty.getSpecialtyName() + "'";
            statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Specialty specialty) {
        try (Statement statement = connection.createStatement()) {
            String sql = "update specialities set description = '" + specialty.getDescription() + "' where speciality_name = '" +
                    specialty.getSpecialtyName() + "'";
            statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Specialty> getAll() {
        List<Specialty> specialtyList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = "select * from specialities";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int specialityId = resultSet.getInt("id");
                String specialityName = resultSet.getString("speciality_name");
                String specialityDescription = resultSet.getString("description");
                Specialty specialty = new Specialty(specialityName, specialityDescription);
                specialty.setId(specialityId);
                specialtyList.add(specialty);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return specialtyList;
    }

    @Override
    public Specialty getById(Integer id) {
        Specialty specialty = new Specialty(null, null);
        try (Statement statement = connection.createStatement()) {
            String sql = "select * from specialities where id = " + (int)id;
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            String specialityName = resultSet.getString("speciality_name");
            String description = resultSet.getString("description");
            specialty.setId(id);
            specialty.setSpecialtyName(specialityName);
            specialty.setDescription(description);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return specialty;
    }
}
