public abstract class User {
    int userId;
    String name;
    String email;
    public User(int userId, String name, String email) {
        setValues(userId, name, email);
    }
    public void setValues(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
    public abstract void displayDetails();
    public String getEmail() {
        return email;
    }
}
