import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        Circle circle = null;
        Connection conn = null;
        String driver = "org.apache.derby.jdbc.ClientDriver";

        try {
            //    1. Load the Drivers
            Class.forName(driver).newInstance();

           // 2. Establish the Connection with DB using URL, username, password
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
            // 3. Prepare the statements
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM circle where id=?");

            stmt.setInt(1, 3);

            // 4. execute the statement
            ResultSet rs = stmt.executeQuery();

            //5. Extract data from result sets
            if (rs.next()) {
                circle = new Circle(1, rs.getString("name"));

                System.out.println(rs.getString("name"));
            }

            //  6. Close the connection.
            rs.close();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }
}
