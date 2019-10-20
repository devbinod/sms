package np.com.alon.controller;

import np.com.alon.DaoImpl.GradeDaoImpl;
import np.com.alon.DaoImpl.StudentDaoImpl;
import np.com.alon.dao.GradeDao;
import np.com.alon.dao.StudentDao;
import np.com.alon.enumlist.HttpRequestList;
import np.com.alon.model.Grade;
import np.com.alon.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/students")
public class StudentController  extends HttpServlet {

    StudentDao studentDao = new StudentDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        GradeDao gradeDao= new GradeDaoImpl();
        if(action.equalsIgnoreCase(HttpRequestList.ADD.toString())){
            req.setAttribute("grades",gradeDao.findAll());
            req.getRequestDispatcher("student/addStudent.jsp").forward(req,resp);
        }else if(action.equalsIgnoreCase(HttpRequestList.UPDATE.toString())){
            Student student = studentDao.findById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("grades",gradeDao.findAll());
            req.setAttribute("student", student);
            req.getRequestDispatcher("student/updateStudent.jsp").forward(req,resp);
        }else if(action.equalsIgnoreCase(HttpRequestList.DELETE.toString())){
            studentDao.delete(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("studentList",studentDao.findAll());
            req.getRequestDispatcher("student/index.jsp").forward(req,resp);
        }else if(action.equalsIgnoreCase(HttpRequestList.ALL.toString())){
            req.setAttribute("studentList",studentDao.findAll());
            req.getRequestDispatcher("student/index.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        GradeDao gradeDao = new GradeDaoImpl();

        if(action.equalsIgnoreCase(HttpRequestList.ADD.toString())){
            Student student = new Student();
            student.setFirstName(req.getParameter("firstName"));
            student.setLastName(req.getParameter("lastName"));
            student.setRollNo(req.getParameter("rollNo"));
            student.setParentName(req.getParameter("parentName"));
            student.setParentPhoneNumber(req.getParameter("parentPhoneNumber"));
            student.setGradeId(Integer.parseInt(req.getParameter("grade")));
            studentDao.add(student);
        }else if(action.equalsIgnoreCase(HttpRequestList.UPDATE.toString())){
            Student student = new Student();
            student.setFirstName(req.getParameter("firstName"));
            student.setLastName(req.getParameter("lastName"));
            student.setRollNo(req.getParameter("rollNo"));
            student.setParentName(req.getParameter("parentName"));
            student.setParentPhoneNumber(req.getParameter("parentPhoneNumber"));
            student.setGradeId(Integer.parseInt(req.getParameter("grade")));
            student.setId(Integer.parseInt(req.getParameter("id")));
            studentDao.update(student);

        }

        req.setAttribute("studentList",studentDao.findAll());
        req.getRequestDispatcher("student/index.jsp").forward(req,resp);

    }
}
