package com.application.connection;

/**
 * Class for configuration variables for connecting to the database.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public final class Configs {
    public static final String DB_HOST = "localhost";
    public static final String DB_PORT = "3306";
    public static final String DB_NAME =
            "mydb?useUnicode=true&useSSL=false&serverTimezone=Europe/Moscow&allowPublicKeyRetrieval=true";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "root";

    /**
     * Constructor.
     */
    private Configs() {
    }
}
