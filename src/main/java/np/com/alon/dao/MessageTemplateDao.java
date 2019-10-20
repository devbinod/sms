package np.com.alon.dao;

import np.com.alon.model.MessageTemplate;

import java.util.List;

public interface MessageTemplateDao {
    boolean add(MessageTemplate messageTemplate);
    boolean update(MessageTemplate messageTemplate);
    boolean delete(int id);
    List<MessageTemplate> findAll();
    MessageTemplate findById(int id);

}
