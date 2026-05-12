package my.library.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = "USER";
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}