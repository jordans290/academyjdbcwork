import java.sql.*;

public class JDBC {
    private static final String USERNAME = "testuser";
    private static final String PASSWORD = "password";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/persons";
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try  {
            connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected successfully");

            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * from persons");

            rs.last();
            System.out.println("number of rows" +" " + rs.getRow());
        }
        catch (SQLException e)
        {
            //e.printStackTrace();
            System.err.println(e);
        } finally {
            if(rs != null)
            {
                rs.close();
            }
            if(stmt != null)
            {
                stmt.close();
            }
            if(connection != null)
            {
                connection.close();
            }
        }




        System.out.println("Hello World!");
    }
}
