package eunm;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * ResultSet 域
 * </p>
 *
 * @author cai
 * @since 2022/8/18
 */
@Getter
@AllArgsConstructor
public enum ColumnMetaDataEnum {

    // catalog 编目
    TABLE_CAT,
    // schema 组织结构
    TABLE_SCHEM,
    // 表名
    TABLE_NAME,
    // 列名
    COLUMN_NAME,
    // 数据类型 java.sql.types
    DATA_TYPE,
    // 数据类型名称
    TYPE_NAME,
    // 列的大小
    COLUMN_SIZE,
    //
    BUFFER_LENGTH,
    // 小数部分的位数。对于 decimal_digits 不适用的数据类型，则返回 null
    DECIMAL_DIGITS,
    // 基数（通常为 10 或 2）
    NUM_PREC_RADIX,
    // 读取时可以为null
    NULLABLE,
    // 描述列的注释（可为 null）
    REMARKS,
    // 该列的默认值，当值在单引号内时应被解释为一个字符串（可为 null）
    COLUMN_DEF,
    //
    SQL_DATA_TYPE,
    //
    SQL_DATETIME_SUB,
    // 对于 char 类型，该长度是列中的最大字节数
    CHAR_OCTET_LENGTH,
    // 表中的列的索引（从 1 开始）
    ORDINAL_POSITION,
    // 写入时可以为null
    IS_NULLABLE,
    // 表的类别，它是引用属性的作用域（如果 data_type 不是 ref，则为 null）
    SCOPE_CATALOG,
    // 表的模式，它是引用属性的作用域（如果 data_type 不是 ref，则为 null）
    SCOPE_SCHEMA,
    // 表名称，它是引用属性的作用域（如果 data_type 不是 ref，则为 null）
    SCOPE_TABLE,
    // 不同类型或用户生成 ref 类型、来自 java.sql.types 的 sql 类型的源类型（如果 data_type 不是 distinct 或用户生成的
    SOURCE_DATA_TYPE,
    // 指示此列是否自动增加yes --- 如果该列自动增加no --- 如果该列不自动增加空字符串 --- 如果不能确定该列是否是自动增加参数
    IS_AUTOINCREMENT,
    // 计算列
    IS_GENERATEDCOLUMN
}
