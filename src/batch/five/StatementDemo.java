package batch.five;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {

    public static void main(String[] args) {

        String driver = "com.mysql.cj.jdbc.Driver";
        Connection connection = null;
        try {
            //1. Load Drivers
            Class.forName(driver).newInstance();

            //2. Create connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false","root","root");

            //3. create statement
            Statement statement = connection.createStatement();

            String query = "INSERT INTO EMPLOYEE(NAME) VALUE('Mahesh')";

            //4. execute sql
            boolean result = statement.execute(query);
            System.out.println("Is query successfully executed ?....."+result);

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
