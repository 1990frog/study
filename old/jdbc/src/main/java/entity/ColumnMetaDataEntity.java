package entity;

import lombok.Data;

/**
 * <p>
 * JDBC 列元数据信息
 * </p>
 *
 * @author cai
 * @since 2022/8/18
 */
@Data
public class ColumnMetaDataEntity {
    private String TABLE_CAT;
    private String TABLE_SCHEM;
    private String TABLE_NAME;
    private String COLUMN_NAME;
    private String DATA_TYPE;
    private String TYPE_NAME;
    private String COLUMN_SIZE;
    private String BUFFER_LENGTH;
    private String DECIMAL_DIGITS;
    private String NUM_PREC_RADIX;
    private String NULLABLE;
    private String REMARKS;
    private String COLUMN_DEF;
    private String SQL_DATA_TYPE;
    private String SQL_DATETIME_SUB;
    private String CHAR_OCTET_LENGTH;
    private String ORDINAL_POSITION;
    private String IS_NULLABLE;
    private String SCOPE_CATALOG;
    private String SCOPE_SCHEMA;
    private String SCOPE_TABLE;
    private String SOURCE_DATA_TYPE;
    private String IS_AUTOINCREMENT;
    private String IS_GENERATEDCOLUMN;
}
