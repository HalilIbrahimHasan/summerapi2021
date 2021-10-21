package dummypojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Todos {

    private int userID;
    private int id;
    private String title;
    private boolean completed;

    public Todos(int userID, int id, String title, boolean completed) {
        this.userID = userID;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
    public Todos(){

    }

    public int getUserID() {
        return userID;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
