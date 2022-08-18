import cn.hutool.core.util.ReflectUtil;
import entity.ColumnMetaDataBeanEntity;
import entity.TableMetaDataBeanEntity;
import eunm.ColumnMetaDataEnum;
import eunm.DbmsEnum;
import eunm.TableMetaDataEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetaDataHelper {


    public static Connection getConnection(DbmsEnum dbmsEnum) {
        try (Connection con = DriverManager.getConnection(dbmsEnum.getUrl(), dbmsEnum.getUserName(), dbmsEnum.getPassword())) {
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void getMetaData(DbmsEnum dbmsEnum) throws SQLException {
        try (Connection con = DriverManager.getConnection(dbmsEnum.getUrl(), dbmsEnum.getUserName(), dbmsEnum.getPassword())) {
            List<ColumnMetaDataBeanEntity> ret = new ArrayList<>();
            DatabaseMetaData databaseMetaData = con.getMetaData();
            String catalog = con.getCatalog();
            String schema = con.getSchema();
            ResultSet tableDataMeta = databaseMetaData.getTables(catalog, schema, null, null);
            while (tableDataMeta.next()) {
                TableMetaDataBeanEntity tableMetaDataEntity = resultSet2TableMetaDataBeanEntity(tableDataMeta);
                ResultSet columns = databaseMetaData.getColumns(catalog, schema, tableMetaDataEntity.getTABLE_NAME(), null);
                while (columns.next()) {
                    ColumnMetaDataBeanEntity columnMetaDataEntity = resultSet2ColumnMetaDataBeanEntity(columns);
                    System.out.println(columnMetaDataEntity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static TableMetaDataBeanEntity resultSet2TableMetaDataBeanEntity(ResultSet resultSet) throws SQLException {
        TableMetaDataBeanEntity ret = new TableMetaDataBeanEntity();
        for (TableMetaDataEnum k : TableMetaDataEnum.values())
            ReflectUtil.invoke(ret, "set" + k.name(), resultSet.getString(k.name()));
        return ret;
    }

    public static ColumnMetaDataBeanEntity resultSet2ColumnMetaDataBeanEntity(ResultSet resultSet) throws SQLException {
        ColumnMetaDataBeanEntity ret = new ColumnMetaDataBeanEntity();
        for (ColumnMetaDataEnum k : ColumnMetaDataEnum.values())
            ReflectUtil.invoke(ret, "set" + k.name(), resultSet.getString(k.name()));
        return ret;
    }

    public static void main(String[] args) {
        try {
//            getMetaData(DbConfig.mssql);
//            System.out.println("---------------------");
            getMetaData(DbmsEnum.mysql);
//            getMetaData(DbConfig.oracle);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        TableMetaDataBeanEntity ret = new TableMetaDataBeanEntity();
//        ReflectUtil.invoke(ret, "set" + TableMetaDataEnum.TABLE_NAME, "sss");
//        System.out.println(ret);
    }
}
