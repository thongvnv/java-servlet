package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private int id;
    private String username;
    private String password;
    private int role;
    private int status;
    private HashMap<String, ArrayList<String>> errors;

    public User() {
        this.username = "";
        this.password = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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
        ArrayList<String> userNameError = this.errors.get("username");
        if (userNameError == null) {
            userNameError = new ArrayList<>();
        }
        if (this.username == null || this.username.length() == 0) {
            userNameError.add("Username is required!");
        }
        if (this.username.length() < 2 || this.username.length() > 30) {
            userNameError.add("Username must be between 2 and 30 characters!");
        }
        if (userNameError.size() > 0) {
            this.errors.put("username", userNameError);
        }

        ArrayList<String> passError = this.errors.get("password");
        if (passError == null) {
            passError = new ArrayList<>();
        }
        if (this.password == null || this.password.length() == 0) {
            passError.add("Password is required!");
        }
        if (this.password.length() < 6 || this.password.length() > 30) {
            passError.add("Password must be between 6 and 30 characters!");
        }
        if (passError.size() > 0) {
            this.errors.put("password", passError);
        }
    }
}
