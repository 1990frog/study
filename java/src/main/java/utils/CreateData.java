package utils;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CreateData implements Runnable {

    // 每个线程线程分配一个mysql连接
    ThreadLocal<MysqlPool> conn = ThreadLocal.withInitial(MysqlPool::new);
    // 循环次数
    private int count;
    // key
    private String key;

    @Getter
    final class MysqlPool {
        private String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        private String DB_URL = "jdbc:mysql://localhost:3306/bigtable";
        private String USER = "root";
        private String PASS = "123456";

        private Statement jdbcTemplate;
        private Connection connection;

        {
            try {
                Class.forName(JDBC_DRIVER);
                this.connection = DriverManager.getConnection(DB_URL, USER, PASS);
                this.jdbcTemplate = this.connection.createStatement();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public CreateData(String key, int count) {
        this.count = count;
        this.key = key;
    }

    @Override
    public void run() {
        insert();
    }

    public void insert() {
        Database.getSynchronized(key).forEach(n -> {
            try {
                String sql = String.format(Database.getSql(key), n);
                conn.get().getJdbcTemplate().execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        try {
            conn.get().getJdbcTemplate().close();
            conn.get().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreateData create = new CreateData("level", 1000);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1; i++) {
            executorService.submit(create);
        }
        executorService.shutdownNow();
        while (executorService.isTerminated()){
            System.out.println("end!");
        }
    }

}
