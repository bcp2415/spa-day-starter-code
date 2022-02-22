package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
    private int id;
    private static int nextId;

    @NotBlank(message = "Username is required.")
    @Size(min = 5, max = 15, message = "Enter a username between 5 and 15 characters.")
    private String username;

    @Email(message = "Please enter a valid email.")
    private String email;

    @NotBlank(message = "Enter a password.")
    @Size(min = 6, max = 25, message = "Enter a password between 6 and 25 characters.")
    private String password;

//    @NotBlank(message = "You must verify your password.")
//    private String verify;

    public User() {
        this.id=nextId;
        nextId++;
    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
