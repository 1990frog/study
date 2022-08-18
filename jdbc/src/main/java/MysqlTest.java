import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MysqlTest {
    private final static String url = "jdbc:mysql://localhost:3306/data_quality";
    private final static String userName = "root";
    private final static String password = "root";

    @Test
    public void test() {
        try (Connection con = DriverManager.getConnection(url, userName, password)) {
            DatabaseMetaData databaseMetaData = con.getMetaData();
            String catalog = con.getCatalog();
            System.out.println("数据库catalog："+catalog);

            ResultSet metaDataTables = databaseMetaData.getTables(catalog, null, null, null);
            while (metaDataTables.next()) {
                String tableName = metaDataTables.getString(3);
                System.out.println("表名："+tableName);
                System.out.println("表备注："+metaDataTables.getString(5));

                ResultSet columns = databaseMetaData.getColumns(catalog, null, tableName, null);
                while (columns.next()) {
                    System.out.println("列名："+columns.getString(4));
                    System.out.println("数据类型："+columns.getString(6));
                    System.out.println("字段备注："+columns.getString(12));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
