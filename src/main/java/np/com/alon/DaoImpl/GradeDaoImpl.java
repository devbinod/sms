package np.com.alon.DaoImpl;

import np.com.alon.dao.GradeDao;
import np.com.alon.dbconnection.DBConnection;
import np.com.alon.model.Grade;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl implements GradeDao {
    DBConnection dbConnection = new DBConnection();
    public boolean add(Grade grade) {
        try {
            dbConnection.open();
            String query = "insert into grade (name) values (?)";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setString(1,grade.getName());
            int i = preparedStatement.executeUpdate();
            if(i> 0) return  true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(Grade grade) {

        try {
            dbConnection.open();
            String query = "update grade set name = ? where id=?";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setString(1, grade.getName());
            preparedStatement.setInt(2,grade.getId());
            int i = preparedStatement.executeUpdate();
            if(i > 0  ) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {

        try {
            dbConnection.open();
            String query = "delete from grade where id =?";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setInt(1,id);
            int i = preparedStatement.executeUpdate();
            if(i> 0) return true;

        }  catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Grade> findAll() {
        try {
            dbConnection.open();
            List<Grade> grades = new ArrayList<Grade>();
            String query = "select * from grade";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Grade grade = new Grade();
                grade.setId(resultSet.getInt("id"));
                grade.setName(resultSet.getString("name"));
                grades.add(grade);
            }
            return  grades;
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Grade findById(int id) {
        try {
            dbConnection.open();
            String query = "select * from grade where id = ?";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Grade grade = new Grade();

            while (resultSet.next()){
                grade.setId(resultSet.getInt("id"));
                grade.setName(resultSet.getString("name"));
            }
            return grade;
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
