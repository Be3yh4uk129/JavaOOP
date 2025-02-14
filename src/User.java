public abstract class User {
    int userId;
    String password;
    String email;
    public User(int userId, String password, String email) {
        setValues(userId, password, email);
    }
    public void setValues(int userId, String password, String email) {
        this.userId = userId;
        this.password = password;
        this.email = email;
    }
    public abstract void displayDetails();
    public int getId() {
        return userId;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
}
