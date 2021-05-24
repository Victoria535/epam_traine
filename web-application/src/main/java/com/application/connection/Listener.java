package com.application.connection;

import com.application.Printable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static com.application.connection.Configs.DB_HOST;
import static com.application.connection.Configs.DB_NAME;
import static com.application.connection.Configs.DB_PASSWORD;
import static com.application.connection.Configs.DB_PORT;
import static com.application.connection.Configs.DB_USER;
import static com.application.connection.ConnectionPool.getInstance;

/**
 * Listener for Connection Pool.
 * <p>
 * Date: may 15 2021
 *
 * @author Viktoria Symaniuk
 */
public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ConnectionPool pool = getInstance();
        try {
            pool.init("com.mysql.cj.jdbc.Driver",
                    "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME,
                    DB_USER,
                    DB_PASSWORD,
                    5, 100, 0);
        } catch (ConnectionPoolException exception) {
            Printable.printWarning(String.valueOf(exception));
        }
    }
}
