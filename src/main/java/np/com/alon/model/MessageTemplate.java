package np.com.alon.model;

import np.com.alon.enumlist.StatusList;

public class MessageTemplate {
    private int id;
    private String title;
    private String messageBody;
    private String status = StatusList.DRAFT.toString();

    public MessageTemplate(String title, String messageBody) {
        this.title = title;
        this.messageBody = messageBody;
    }


    public MessageTemplate() {
    }

    public MessageTemplate(int id, String title, String messageBody, String status) {
        this.id = id;
        this.title = title;
        this.messageBody = messageBody;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
