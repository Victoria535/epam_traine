package com.application.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.application.Printable.printWarning;

/**
 * Connection Pool.
 * <p>
 * Date: may 15 2021
 *
 * @author Viktoria Symaniuk
 */
public final class ConnectionPool {
    private static final ConnectionPool instance = new ConnectionPool();
    private static final ExecutorService closer = Executors.newSingleThreadExecutor();
    private final Queue<Connection> freeConnections = new ConcurrentLinkedQueue<>();
    private final Set<Connection> usedConnections = new ConcurrentSkipListSet<>(Comparator.comparingInt(Object::hashCode));
    private String jdbcUrl;
    private String jdbcUser;
    private String jdbcPassword;
    private int maxSize;
    private int validationTimout;

    /**
     * Constructor.
     */
    private ConnectionPool() {
    }

    /**
     * Method for return instance.
     *
     * @return ConnectionPool instance
     */
    public static ConnectionPool getInstance() {
        return instance;
    }

    /**
     * Method for initialization database connection.
     *
     * @param jdbcDriver        String driver for database
     * @param jdbcUrl           String url for database
     * @param jdbcUser          String user for database
     * @param jdbcPassword      String password for database
     * @param minSize           int min size for connection pool
     * @param maxSize           int max size for connection pool
     * @param validationTimeout int
     * @throws ConnectionPoolException exception for connection pool
     */
    public void init(String jdbcDriver, String jdbcUrl, String jdbcUser,
                     String jdbcPassword, int minSize, int maxSize, int validationTimeout)
            throws ConnectionPoolException {
        try {
            if (minSize <= maxSize) {
                Class.forName(jdbcDriver);
                this.jdbcUrl = jdbcUrl;
                this.jdbcUser = jdbcUser;
                this.jdbcPassword = jdbcPassword;
                for (int i = 0; i < minSize; i++) {
                    freeConnections.add(establishConnection());
                }
                this.maxSize = maxSize;
                this.validationTimout = validationTimeout;
            } else {
                throw new ConnectionPoolException();
            }
        } catch (ClassNotFoundException | SQLException exception) {
            throw new ConnectionPoolException(exception);
        }
    }

    /**
     * Method for getting connection for database.
     *
     * @return Connection connection for database
     * @throws ConnectionPoolException exception for connection pool
     */
    public Connection getConnection() throws ConnectionPoolException {
        Connection connection = null;
        while (connection == null) {
            try {
                connection = freeConnections.poll();
                if (connection != null) {
                    if (!connection.isValid(validationTimout)) {
                        close(connection);
                        connection = null;
                    }
                } else if (maxSize == 0 || usedConnections.size() < maxSize) {
                    connection = establishConnection();
                } else {
                    throw new ConnectionPoolException();
                }
            } catch (SQLException exception) {
                throw new ConnectionPoolException(exception);
            }
        }
        usedConnections.add(connection);
        return connection;
    }

    /**
     * Method for added connection.
     *
     * @param connection Connection
     * @throws SQLException exception sql
     */
    void freeConnection(Connection connection) throws SQLException {
        try {
            usedConnections.remove(connection);
            connection.clearWarnings();
            connection.setAutoCommit(true);
            freeConnections.add(connection);
        } catch (SQLException exception) {
            close(connection);
            throw exception;
        }
    }

    /**
     * Method for getting connection from connectionWrapper.
     *
     * @return Connection getting connection from connectionWrapper
     * @throws SQLException exception sql
     */
    private Connection establishConnection() throws SQLException {
        return new ConnectionWrapper(DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword));
    }

    /**
     * Method fro close connection.
     *
     * @param connection Connection connection to close
     */
    private void close(Connection connection) {
        closer.execute(() -> {
            try {
                connection.rollback();
                ((ConnectionWrapper) connection).getConnection().close();
            } catch (SQLException exception) {
                printWarning(String.valueOf(exception));
            }
        });
    }
}
