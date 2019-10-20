package np.com.alon.controller;

import np.com.alon.DaoImpl.GradeDaoImpl;
import np.com.alon.dao.GradeDao;
import np.com.alon.enumlist.HttpRequestList;
import np.com.alon.model.Grade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/grades")
public class GradeController extends HttpServlet {
    GradeDao gradeDao = new GradeDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" = caledd");
        String action = req.getParameter("action");
        System.out.println("action = " + action);
        if(action.equalsIgnoreCase(HttpRequestList.ADD.toString())){
            req.getRequestDispatcher("grade/addGrade.jsp")
                    .forward(req,resp);
        }else if(action.equalsIgnoreCase(HttpRequestList.UPDATE.toString())){

            Grade grade = gradeDao.findById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("grade",grade);
            req.getRequestDispatcher("grade/updateGrade.jsp").forward(req,resp);
        }else if(action.equalsIgnoreCase(HttpRequestList.DELETE.toString())){
            gradeDao.delete(Integer.parseInt(req.getParameter("id")));
            List<Grade> gradeList = gradeDao.findAll();
            req.setAttribute("gradeList", gradeList);
            req.getRequestDispatcher("grade/index.jsp").forward(req,resp);

        }else if(action.equalsIgnoreCase(HttpRequestList.ALL.toString())){
            List<Grade> gradeList = gradeDao.findAll();
            req.setAttribute("gradeList", gradeList);
            req.getRequestDispatcher("grade/index.jsp").forward(req,resp);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if(action.equalsIgnoreCase(HttpRequestList.ADD.toString())){
            Grade grade = new Grade(
                    req.getParameter("name")
            );
            gradeDao.add(grade);

        }else if(action.equalsIgnoreCase(HttpRequestList.UPDATE.toString())){
            Grade grade = new Grade(Integer.parseInt(req.getParameter("id")),
                    req.getParameter("name"));
            gradeDao.update(grade);
        }

        List<Grade> gradeList = gradeDao.findAll();
        req.setAttribute("gradeList", gradeList);
        req.getRequestDispatcher("grade/index.jsp").forward(req,resp);

    }
}
