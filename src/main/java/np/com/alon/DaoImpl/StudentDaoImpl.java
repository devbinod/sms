package np.com.alon.DaoImpl;

import np.com.alon.dao.StudentDao;
import np.com.alon.dbconnection.DBConnection;
import np.com.alon.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    DBConnection dbConnection = new DBConnection();
    public boolean add(Student student) {
        try {
            dbConnection.open();
            String query = "insert into student( first_name,last_name,roll_no,parent_name," +
                    "parent_phone_number,grade_id) values(?,?,?,?,?,?)";

            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setString(1,student.getFirstName());
            preparedStatement.setString(2,student.getLastName());
            preparedStatement.setString(3,student.getRollNo());
            preparedStatement.setString(4,student.getParentName());
            preparedStatement.setString(5,student.getParentPhoneNumber());
            preparedStatement.setInt(6,student.getGradeId());

            int i = preparedStatement.executeUpdate();
            if(i> 0) return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(Student student) {

        try {
            dbConnection.open();
            String query = "update student set first_name=?,last_name=?,roll_no=?,parent_name=?,parent_phone_number=?," +
                    "grade_id=? where id=?";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setString(1,student.getFirstName());
            preparedStatement.setString(2,student.getLastName());
            preparedStatement.setString(3,student.getRollNo());
            preparedStatement.setString(4,student.getParentName());
            preparedStatement.setString(5,student.getParentPhoneNumber());
            preparedStatement.setInt(6,student.getGradeId());
            preparedStatement.setInt(7, student.getId());
            int i = preparedStatement.executeUpdate();
            if(i > 0 ) return true;



        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {

        try {
            dbConnection.open();

            String query = "delete from student where id = ?";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            if(i> 0 ) return  true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Student> findAll() {
        try {
            dbConnection.open();
            String query = "select * from student";
            List<Student> students = new ArrayList<Student>();
            PreparedStatement preparedStatement= dbConnection.getPreparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setRollNo(resultSet.getString("roll_no"));
                student.setParentName(resultSet.getString("parent_name"));
                student.setParentPhoneNumber(resultSet.getString("parent_phone_number"));
                student.setGradeId(resultSet.getInt("grade_id"));
                students.add(student);

            }
            return students;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student findById(int id) {
        try {
            dbConnection.open();

            String query ="select * from student where id =?";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = new Student();

            while (resultSet.next()){
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setRollNo(resultSet.getString("roll_no"));
                student.setParentName(resultSet.getString("parent_name"));
                student.setParentPhoneNumber(resultSet.getString("parent_phone_number"));
                student.setGradeId(resultSet.getInt("grade_id"));
            }
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
