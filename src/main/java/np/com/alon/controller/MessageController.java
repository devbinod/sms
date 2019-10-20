package np.com.alon.controller;

import np.com.alon.DaoImpl.MessageTemplateDaoImpl;
import np.com.alon.dao.MessageTemplateDao;
import np.com.alon.enumlist.HttpRequestList;
import np.com.alon.model.MessageTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/addMessage","/messageList", "/updateMessage"})
public class MessageController extends HttpServlet {

    MessageTemplateDao messageTemplateDao = new MessageTemplateDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action = req.getParameter("action");

       if(action.equalsIgnoreCase(HttpRequestList.ALL.toString())){

           List<MessageTemplate> messageTemplateList = messageTemplateDao.findAll();
           req.setAttribute("messageTemplateList",messageTemplateList);
           req.getRequestDispatcher("message/index.jsp")
                   .forward(req,resp);
       }else if(action.equalsIgnoreCase(HttpRequestList.ADD.toString())){
           req.getRequestDispatcher("message/addMessage.jsp")
                   .forward(req,resp);
       }else if(action.equalsIgnoreCase(HttpRequestList.UPDATE.toString())){
        MessageTemplate messageTemplate = messageTemplateDao.findById(
                Integer.parseInt(req.getParameter("id"))
        );

        req.setAttribute("messageTemplate",messageTemplate);
        req.getRequestDispatcher("message/updateMessage.jsp")
                .forward(req,resp);

       }else if(action.equalsIgnoreCase(HttpRequestList.DELETE.toString())){
           messageTemplateDao.delete(Integer.parseInt(req.getParameter("id")));
           List<MessageTemplate> messageTemplateList = messageTemplateDao.findAll();
           req.setAttribute("messageTemplateList",messageTemplateList);
           req.getRequestDispatcher("message/index.jsp").forward(req,resp);
       }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if(action.equalsIgnoreCase(HttpRequestList.ADD.toString()))
        {
            messageTemplateDao.add(

                    new MessageTemplate(req.getParameter("title"),
                            req.getParameter("messageBody"))
            );


        }else if(action.equalsIgnoreCase(HttpRequestList.UPDATE.toString())){
            MessageTemplate messageTemplate = new MessageTemplate();
            messageTemplate.setId(Integer.parseInt(req.getParameter("id")));
            messageTemplate.setTitle(req.getParameter("title"));
            messageTemplate.setMessageBody(req.getParameter("messageBody"));

            messageTemplateDao.update(
                    messageTemplate
            );

        }
        List<MessageTemplate> messageTemplateList = messageTemplateDao.findAll();
        req.setAttribute("messageTemplateList",messageTemplateList);
        req.getRequestDispatcher("message/index.jsp")
                .forward(req,resp);

    }
}
