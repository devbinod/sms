package np.com.alon.dao;

import np.com.alon.model.Student;

import java.util.List;

public interface StudentDao {

    boolean add(Student student);
    boolean update(Student student);
    boolean delete(int id);
    List<Student> findAll();
    Student findById(int id);
}
