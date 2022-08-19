import cn.hutool.core.util.ReflectUtil;
import entity.ColumnMetaDataEntity;
import entity.MetaDataResult;
import eunm.ColumnMetaDataEnum;
import eunm.DbmsEnum;
import eunm.TableMetaDataEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author caijingquan@clinbrain.com
 * @since 2022/8/19
 */
public class MetaDataHelper {

    /**
     * 尝试获取连接
     *
     * @param dbmsEnum
     * @return
     */
    public static Connection getConnection(DbmsEnum dbmsEnum) {
        try (Connection con = DriverManager.getConnection(dbmsEnum.getUrl(), dbmsEnum.getUserName(), dbmsEnum.getPassword())) {
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取目标库全部元数据信息
     *
     * @param dbmsEnum
     * @return
     * @throws SQLException
     */
    public static List<MetaDataResult> getMetaData(DbmsEnum dbmsEnum) throws SQLException {

        try (Connection con = DriverManager.getConnection(dbmsEnum.getUrl(), dbmsEnum.getUserName(), dbmsEnum.getPassword())) {

            List<MetaDataResult> ret = new ArrayList<>();
            DatabaseMetaData databaseMetaData = con.getMetaData();
            ResultSet tableDataMeta = databaseMetaData.getTables(con.getCatalog(), con.getSchema(), null, null);
            // 遍历表
            while (tableDataMeta.next()) {
                // ResultSet 转 bean
                MetaDataResult metaDataResult = new MetaDataResult();
                for (TableMetaDataEnum k : TableMetaDataEnum.values())
                    ReflectUtil.invoke(metaDataResult, "set" + k.name(), tableDataMeta.getString(k.name()) + "");
                ResultSet columns = databaseMetaData.getColumns(con.getCatalog(), con.getSchema(), metaDataResult.getTABLE_NAME(), null);
                List<ColumnMetaDataEntity> columnList = new ArrayList<>();

                // 遍历字段
                while (columns.next()) {
                    // ResultSet 转 bean
                    ColumnMetaDataEntity columnMetaDataEntity = new ColumnMetaDataEntity();
                    for (ColumnMetaDataEnum k : ColumnMetaDataEnum.values())
                        ReflectUtil.invoke(columnMetaDataEntity, "set" + k.name(), columns.getString(k.name()) + "");
                    columnList.add(columnMetaDataEntity);
                }
                metaDataResult.setColumns(columnList);
                ret.add(metaDataResult);

            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            getMetaData(DbmsEnum.mysql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
