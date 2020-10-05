package JDBC;

import java.sql.Connection;

public interface Driver {

    Connection getConnection(String url, String user, String password);
}


