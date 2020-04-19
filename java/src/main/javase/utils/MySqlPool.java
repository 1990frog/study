package javase.utils;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Data
public class MySqlPool {
    private String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private String DB_URL = "jdbc:mysql://localhost:3306/test";
    private String USER = "root";
    private String PASS = "123456";

    private Statement jdbcTemplate;
    private Connection connection;

    public MySqlPool(){
        try {
            Class.forName(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USER, PASS);
            this.jdbcTemplate = this.connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
