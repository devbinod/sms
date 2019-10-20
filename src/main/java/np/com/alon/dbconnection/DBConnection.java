package np.com.alon.dbconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

    public static final String DB_URL="jdbc:mysql://localhost:3306/alon";
    public static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    public static final String DB_USERNAME="root";
    public static final String DB_PASSWORD="binod";
    Connection connection;

    public void open() throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);
        System.out.println("Driver loaded...");
        connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
    }


    public PreparedStatement getPreparedStatement(String query) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement;
    }


    public void close() throws SQLException {
        connection.close();
    }

}