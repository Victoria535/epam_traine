package com.application.entity;

/**
 * Mark.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public class User extends Entity {
    private String login;
    private String password;
    private String name;
    private Role role;

    /**
     * Constructor.
     */
    public User() {
    }

    /**
     * Constructor with parameters.
     *
     * @param login    String login of user
     * @param password String password of user
     * @param name     String name of user
     * @param role     Role role of user
     * @see Role
     */
    public User(String login, String password, String name, Role role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    /**
     * @return String field login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Method for setting field login.
     *
     * @param login String login of user
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return String field password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method for setting field password.
     *
     * @param password String password of user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String field name
     */
    public String getName() {
        return name;
    }

    /**
     * Method for setting field name.
     *
     * @param name String name of user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Role field role
     * @see Role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Method for setting field role.
     *
     * @param role Role role of user
     * @see Role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User: "
                + "id: " + getId()
                + ", login: " + getLogin()
                + ", password: " + getPassword()
                + ", name: " + getName()
                + ", role: " + getRole();
    }
}
