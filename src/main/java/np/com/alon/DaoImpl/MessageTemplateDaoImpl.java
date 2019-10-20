package np.com.alon.DaoImpl;

import np.com.alon.dao.MessageTemplateDao;
import np.com.alon.dbconnection.DBConnection;
import np.com.alon.model.MessageTemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageTemplateDaoImpl implements MessageTemplateDao {
    DBConnection dbConnection = new DBConnection();
    ResultSet resultSet = null;
    public boolean add(MessageTemplate messageTemplate) {
        try {
            dbConnection.open();
            String query = "insert into message_type (title,message_body) values (?,?)";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setString(1,messageTemplate.getTitle());
            preparedStatement.setString(2,messageTemplate.getMessageBody());
            int i = preparedStatement.executeUpdate();
            if(i> 0 ) return true;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(MessageTemplate messageTemplate) {

        try {
            dbConnection.open();
            String query = "update message_type set title=?, message_body=? where id=?";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setString(1,messageTemplate.getTitle());
            preparedStatement.setString(2,messageTemplate.getMessageBody());
            preparedStatement.setInt(3,messageTemplate.getId());
            int i = preparedStatement.executeUpdate();
            if(i> 0 ) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {

        String query = "delete from message_type where id =?";
        try {
            dbConnection.open();
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setInt(1,id);
            int i = preparedStatement.executeUpdate();
            if(i>0) return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<MessageTemplate> findAll() {
        try {
            dbConnection.open();
            List<MessageTemplate> messageTemplateList = new ArrayList<MessageTemplate>();

            String query = "select * from message_type";
            PreparedStatement preparedStatement= dbConnection.getPreparedStatement(query);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                MessageTemplate messageTemplate = new MessageTemplate( );
                messageTemplate.setId(resultSet.getInt("id"));
                messageTemplate.setTitle(resultSet.getString("title"));
                messageTemplate.setMessageBody(resultSet.getString("message_body"));
                messageTemplateList.add(messageTemplate);

            }
            return messageTemplateList;
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public MessageTemplate findById(int id) {
        try {
            dbConnection.open();
            MessageTemplate messageTemplate = new MessageTemplate();
            String query = "select * from message_type where id =?";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                messageTemplate.setId(resultSet.getInt("id"));
                messageTemplate.setTitle(resultSet.getString("title"));
                messageTemplate.setMessageBody(resultSet.getString("message_body"));
            }
            return messageTemplate;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
