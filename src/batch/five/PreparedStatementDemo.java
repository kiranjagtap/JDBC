package batch.five;

import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) {

        String driver = "com.mysql.cj.jdbc.Driver";
        Connection connection = null;
        try {
            //1. Load Drivers
            Class.forName(driver).newInstance();

            //2. Create connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false", "root", "root");

            //3. create Preparedstatement

            String query = "SELECT id, name from employee where id=? and name=?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, 2);
            pstmt.setString(2, "Mahesh");

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID" + "  " + "Name");
                System.out.println(resultSet.getInt("id") + "  " + resultSet.getString("name"));
            }

            connection.close();

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

