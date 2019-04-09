package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Feedback {
    private int id;
    private int userId;
    private String title;
    private String content;
    private int status;
    private HashMap<String, ArrayList<String>> errors;

    public Feedback() {
        this.title = "";
        this.content = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return this.errors;
    }

    public boolean isValid() {
        validate();
        return this.errors.size() == 0;
    }

    public void validate() {
        if (this.errors == null) {
            this.errors = new HashMap<>();
        }
        ArrayList<String> titleError = this.errors.get("title");
        if (titleError == null) {
            titleError = new ArrayList<>();
        }
        if (this.title == null || this.title.length() == 0) {
            titleError.add("Title is required!");
        }
        if (this.title.length() < 6 || this.title.length() > 100) {
            titleError.add("Title must be between 6 and 100 characters!");
        }
        if (titleError.size() > 0) {
            this.errors.put("title", titleError);
        }

        ArrayList<String> contentError = this.errors.get("content");
        if (contentError == null) {
            contentError = new ArrayList<>();
        }
        if (this.content.length() < 20) {
            contentError.add("Content must be more than 20 character!");
        }
        if (contentError.size() > 0) {
            this.errors.put("title", contentError);
        }
    }
}
