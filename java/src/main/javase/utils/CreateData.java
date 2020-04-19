package javase.utils;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class CreateData implements Runnable  {

    static String BASE_SQL = "insert into bigtable(name, gender, type, phone, email, province, city, area, address, `desc`) values ('%s',%d,%d,'%s','%s','%s','%s','%s','%s','%s')";

    // 每个线程线程分配一个mysql连接
    ThreadLocal<MySqlPool> conn = ThreadLocal.withInitial(MySqlPool::new);

    static AtomicInteger count = new AtomicInteger();


    @Override
    public void run() {
        insert();
    }

    public void insert() {

        for (int i = 0; i < 100000; i++) {
            HashMap address = Database.getCity();
            String sql = String.format(BASE_SQL,Database.getName(),Database.getGender(),
                    Database.getType(),Database.getPhone(),Database.getEmail(),Database.getCity().get("province"),
                    address.get("provinceCode"),address.get("cityCode"),address.get("areaCode"),
                    new StringBuffer().append(address.get("provinceName")).append(address.get("cityName")).append(address.get("areaName")).append(Database.getRoad()),Database.getRoad());
            System.out.println(count.incrementAndGet()+":"+sql);
            try {
                conn.get().getJdbcTemplate().execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        try {
            conn.get().getJdbcTemplate().close();
            conn.get().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreateData createData = new CreateData();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.submit(createData);
        }
        executorService.shutdownNow();
        while (executorService.isTerminated()){
            System.out.println("end!");
        }
    }

}
