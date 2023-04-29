package batch.five;

import java.sql.*;

public class CallabeStatementDemo {

    public static void main(String[] args) {

        String driver = "com.mysql.cj.jdbc.Driver";
        Connection connection = null;
        try {
            //1. Load Drivers
            Class.forName(driver).newInstance();

            //2. Create connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false", "root", "root");

            //3. create Callablestatement
            CallableStatement callabeStatement = connection.prepareCall("{CALL get_employee(?)}");
            callabeStatement.setInt(1, 2);

            ResultSet resultSet = callabeStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Name");
                System.out.println(resultSet.getString("name"));
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
