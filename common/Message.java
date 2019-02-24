package common;

import java.io.Serializable;

public class Message  implements Serializable{

    private String messageString;
    User user;

    public Message() {
    }

    public Message(String messageString, User user) {
        this.messageString = messageString;
        this.user = user;
    }

    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }

    public String getMessageString() {
        return messageString;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
