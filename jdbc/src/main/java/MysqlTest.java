import cn.hutool.core.bean.BeanUtil;
import entity.MetaData;
import entity.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlTest {

    @Getter
    @AllArgsConstructor
    enum DbConfig {

        mysql("jdbc:mysql://localhost:13306/data_quality", "root", "P@ssw0rd"),
        mssql("jdbc:sqlserver://localhost:1433;database=master", "sa", "P@ssw0rd"),
        greenplum("jdbc:postgresql://localhost:5432/cdr_db", "gpadmin", "pivotal"),
        oracle("jdbc:oracle://localhost:1521/ORCLCDB", "c##cjq", "123456"),
        sybase("jdbc:sybase://localhost:5000/hello", "sa", "password"),
        presto("jdbc:presto://localhost:8080/greenplum/public", "root", "");

        private final String url;
        private final String userName;
        private final String password;

    }

    public static Connection getConnection(DbConfig dbConfig) {
        try (Connection con = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUserName(), dbConfig.getPassword())) {
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void getMetaData(DbConfig dbConfig) throws SQLException {
        try (Connection con = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUserName(), dbConfig.getPassword())) {
            List<MetaData> ret = new ArrayList<>();
            DatabaseMetaData databaseMetaData = con.getMetaData();
            String catalog = con.getCatalog();
            ResultSet tableDataMeta = databaseMetaData.getTables(catalog, null, null, null);
            while (tableDataMeta.next()) {
                Table table = getTableMetaData(tableDataMeta);
                ResultSet columns = databaseMetaData.getColumns(catalog, null, table.getTableName(), null);
                while (columns.next()) {
                    MetaData metaData = getColumnMetaData(columns);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param resultSet
     * @return
     * @throws SQLException
     */
    public static Table getTableMetaData(ResultSet resultSet) throws SQLException {

        String catalog = resultSet.getString(1);
        String schema = resultSet.getString(2);
        String tableName = resultSet.getString(3);
        String tableType = resultSet.getString(4);
        String remarks = resultSet.getString(5);

        return Table.builder()
                .catalog(catalog)
                .schema(schema)
                .tableName(tableName)
                .tableType(tableType)
                .remarks(remarks)
                .build();
    }

    private static MetaData getColumnMetaData(ResultSet resultSet) throws SQLException {
        // Table_catalog 编目
        String TABLE_CAT = resultSet.getString(1);
        // Table_schema 模式
        String TABLE_SCHEM = resultSet.getString(2);
        // 表名
        String TABLE_NAME = resultSet.getString(3);
        // 列名
        String COLUMN_NAME = resultSet.getString(4);
        // 数据类型 java.sql.types
        String DATA_TYPE = resultSet.getString(5);
        // 数据类型名称
        String TYPE_NAME = resultSet.getString(6);
        // 列的大小
        String COLUMN_SIZE = resultSet.getString(7);
        //
        String BUFFER_LENGTH = resultSet.getString(8);
        // 小数部分的位数。对于 decimal_digits 不适用的数据类型，则返回 null
        String DECIMAL_DIGITS = resultSet.getString(9);
        // 基数（通常为 10 或 2）
        String NUM_PREC_RADIX = resultSet.getString(10);
        // 读取时可以为null
        String NULLABLE = resultSet.getString(11);
        // 描述列的注释（可为 null）
        String REMARKS = resultSet.getString(12);
        // 该列的默认值，当值在单引号内时应被解释为一个字符串（可为 null）
        String COLUMN_DEF = resultSet.getString(13);
        String SQL_DATA_TYPE = resultSet.getString(14);
        String SQL_DATETIME_SUB = resultSet.getString(15);
        // 对于 char 类型，该长度是列中的最大字节数
        String CHAR_OCTET_LENGTH = resultSet.getString(16);
        // 表中的列的索引（从 1 开始）
        String ORDINAL_POSITION = resultSet.getString(17);
        // 写入时可以为null
        String IS_NULLABLE = resultSet.getString(18);
        // 表的类别，它是引用属性的作用域（如果 data_type 不是 ref，则为 null）
        String SCOPE_CATALOG = resultSet.getString(19);
        // 表的模式，它是引用属性的作用域（如果 data_type 不是 ref，则为 null）
        String SCOPE_SCHEMA = resultSet.getString(20);
        // 表名称，它是引用属性的作用域（如果 data_type 不是 ref，则为 null）
        String SCOPE_TABLE = resultSet.getString(21);
        // 不同类型或用户生成 ref 类型、来自 java.sql.types 的 sql 类型的源类型（如果 data_type 不是 distinct 或用户生成的 ref，则为 null）
        String SOURCE_DATA_TYPE = resultSet.getString(22);
        // 指示此列是否自动增加yes --- 如果该列自动增加no --- 如果该列不自动增加空字符串 --- 如果不能确定该列是否是自动增加参数
        String IS_AUTOINCREMENT = resultSet.getString(23);
        // 计算列
        String IS_GENERATEDCOLUMN = resultSet.getString(24);
        return MetaData.builder().build();
    }

    public static void main(String[] args) {
        try {
//            getMetaData(DbConfig.mssql);
//            System.out.println("---------------------");
//            getMetaData(DbConfig.mysql);
            getMetaData(DbConfig.greenplum);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
