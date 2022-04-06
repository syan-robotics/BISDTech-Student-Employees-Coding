package subsystems;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    // Need emails, names, items, RSI, Campuses, Time of Checkout, Time of Check In, Device Health, Duration Expected, Renewals, Overdue

    private Connection connection;
    private Statement statement;
    private final String databaseURL = "jdbc:mysql://localhost/BISDApp";
    private final String databaseUserName = "system";
    private final String databasePassword = "password";

    /**
     * Initializes the database connections
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Database() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection(databaseURL, databaseUserName, databasePassword);
        statement = connection.createStatement();

    }

    /**
     * Inserts user inputted data into the CurrentCheckouts database
     * @param email
     * @param firstName
     * @param lastName
     * @param itemModel
     * @param RSI
     * @param campus
     * @param checkoutTime
     * @param currentDeviceHealth
     * @param expectedDuration
     * @throws SQLException
     */
    public void insertCurrentCheckoutData(String email, String firstName, String lastName, String itemModel, String RSI, String campus, String checkoutTime, String currentDeviceHealth, int expectedDuration) throws SQLException {
        statement.executeUpdate("INSERT INTO CurrentCheckouts VALUES (" + email + ", " + firstName + ", " + lastName + ", " + itemModel + ", " + ", " + RSI + ", " + campus + ", " + checkoutTime
         + ", " + currentDeviceHealth + ", " + expectedDuration + ")");
    }

    /**
     * Inserts user inputted data into the PastCheckouts database
     * @param email
     * @param firstName
     * @param lastName
     * @param itemModel
     * @param RSI
     * @param campus
     * @param checkoutTime
     * @param initialDeviceHealth
     * @param endingDeviceHealth
     * @param expectedDuration
     * @param renewals
     * @param overdue
     * @throws SQLException
     */
    public void insertPastCheckoutData(String email, String firstName, String lastName, String itemModel, String RSI, String campus, String checkoutTime, String initialDeviceHealth, String endingDeviceHealth, int expectedDuration, int renewals, boolean overdue) throws SQLException {
        statement.executeUpdate("INSERT INTO PastCheckouts VALUES (" + email + ", " + firstName + ", " + lastName + ", " + itemModel + ", " + ", " + RSI + ", " + campus + ", " + checkoutTime
         + ", " + initialDeviceHealth + ", " + endingDeviceHealth + ", " + expectedDuration + ", " + renewals + ", " + overdue + ")");
    }

    /**
     * Closes the database connection
     * @throws SQLException
     */
    public void closeDatabase() throws SQLException {
        connection.close();
    }
}
