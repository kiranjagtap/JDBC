package Mysql;

import java.sql.*;

public class StatementDemo {


    public static void main(String[] args) {
        Connection conn = null;
        String driver = "org.apache.derby.jdbc.ClientDriver";

        try {
            //1. Load the Drivers
            Class.forName(driver).newInstance();

           //2. Establish the Connection with DB using URL, username, password
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");

            //3. Prepare the statements
            Statement stmt = conn.createStatement();


            // 4. execute the statement

            String insert = "INSERT INTO Emp(Name, Salary, Location) VALUES ('Rahul', 60000, 'Mumbai')";
            int result = stmt.executeUpdate(insert);


            ResultSet rs = stmt.executeQuery("SELECT * FROM Emp");

            //5. Extract data from result sets
            while (rs.next()) {

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
