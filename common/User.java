package common;

import java.io.Serializable;

public class User implements Serializable{

    private String name;
    private byte[] image;

    public User() {
    }

    public User(String name, byte[] image) {
        this.name = name;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

}
