package users;

public class User {
    public String login;
    public String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static User createUser() {
        User user = new User("nikolaj_test_samoxin@mail.ru", "9339992acd");
        return user;
    }

}