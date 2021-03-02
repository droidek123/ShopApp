package entity;

public class User {
    private static final String USER_SEPARATOR = "#";
    private Long id;
    private String login;
    private String password;

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "U" + USER_SEPARATOR + id + USER_SEPARATOR + login + USER_SEPARATOR + password;
    }
}
