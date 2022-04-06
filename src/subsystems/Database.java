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

    public Database() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection(databaseURL, databaseUserName, databasePassword);
        statement = connection.createStatement();

    }

    public void insertData(String email, String firstName, String lastName, String itemModel, String RSI, String campus, String checkoutTime, String currentDeviceHealth, int expectedDuration) throws SQLException {
        statement.executeUpdate("INSERT INTO Checkouts VALUES (" + email + ", " + firstName + ", " + lastName + ", " + itemModel + ", " + ", " + RSI + ", " + campus + ", " + checkoutTime
         + ", " + currentDeviceHealth + ", " + expectedDuration + ")");
    }

    public void closeDatabase() throws SQLException {
        connection.close();
    }
}
