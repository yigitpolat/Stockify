package Model;

import java.sql.*;

public class Database {
    private Connection connection = null;

    public Database() {
    }

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Trying to connect database");
            String url = "jdbc:mysql://185.111.233.70/hriubare_stckfy";
            String user = "hriubare_admin";
            String pass = ""; // Ask for password
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
