package np.com.alon.dao;

import np.com.alon.model.Grade;

import java.util.List;

public interface GradeDao {

    boolean add(Grade grade);
    boolean update(Grade grade);
    boolean delete(int id);
    List<Grade> findAll();
    Grade findById(int id);
}
