package shopper.models;

import java.util.Date;

/**
 * A placeholder class to demonstrate the target
 * architecture of an actual simple shopping cart
 * but out of scope for this exercise
 */
public class User {
    //The id of the user
    private String Id;

    //The name of the user
    //By choice it's a full name and not cut into
    //First and last name
    private String name;

    //The email of the user
    private String email;

    //User password
    //This should be a password hash and a password salt
    //and should be encrypted using bcrypt and not stored
    //as clear text
    private String password;

    //When the user was created (joined)
    private Date createdAt;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
