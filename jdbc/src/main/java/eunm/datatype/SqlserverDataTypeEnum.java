package eunm.datatype;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 基于 SQL Server 2019 整理
 * 官方文档：https://docs.microsoft.com/zh-cn/sql/t-sql/data-types/data-types-transact-sql?view=sql-server-ver15
 * </p>
 *
 * @author cai
 * @since 2022/8/19
 */
@Getter
@AllArgsConstructor
public enum SqlserverDataTypeEnum {

    // 精确数字
    BIGINT(AbstractDataTypeEnum.NUMERIC),
    NUMERIC(AbstractDataTypeEnum.NUMERIC),
    BIT(AbstractDataTypeEnum.NUMERIC),
    SMALLINT(AbstractDataTypeEnum.NUMERIC),
    DECIMAL(AbstractDataTypeEnum.NUMERIC),
    SMALLMONEY(AbstractDataTypeEnum.NUMERIC),
    INT(AbstractDataTypeEnum.NUMERIC),
    TINYINT(AbstractDataTypeEnum.NUMERIC),
    MONEY(AbstractDataTypeEnum.NUMERIC),
    // 近似数字
    FLOAT(AbstractDataTypeEnum.NUMERIC),
    REAL(AbstractDataTypeEnum.NUMERIC),
    // 日期和时间
    DATE(AbstractDataTypeEnum.DATE),
    DATETIMEOFFSET(AbstractDataTypeEnum.DATE),
    DATETIME2(AbstractDataTypeEnum.DATE),
    SMALLDATETIME(AbstractDataTypeEnum.DATE),
    DATETIME(AbstractDataTypeEnum.DATE),
    TIME(AbstractDataTypeEnum.DATE),
    // 字符串
    CHAR(AbstractDataTypeEnum.STRING),
    VARCHAR(AbstractDataTypeEnum.STRING),
    TEXT(AbstractDataTypeEnum.STRING),
    // Unicode 字符串
    NCHAR(AbstractDataTypeEnum.STRING),
    NVARCHAR(AbstractDataTypeEnum.STRING),
    NTEXT(AbstractDataTypeEnum.STRING),
    // 二进制字符串
    BINARY(AbstractDataTypeEnum.STRING),
    VARBINARY(AbstractDataTypeEnum.STRING),
    IMAGE(AbstractDataTypeEnum.STRING),
    // 其他数据类型
    CURSOR(AbstractDataTypeEnum.OTHER),
    ROWVERSION(AbstractDataTypeEnum.OTHER),
    HIERARCHYID(AbstractDataTypeEnum.OTHER),
    UNIQUEIDENTIFIER(AbstractDataTypeEnum.OTHER),
    SQL_VARIANT(AbstractDataTypeEnum.OTHER),
    XML(AbstractDataTypeEnum.OTHER),
    GEOMETRY(AbstractDataTypeEnum.OTHER),
    GEOGRAPHY(AbstractDataTypeEnum.OTHER),
    TABLE(AbstractDataTypeEnum.OTHER);

    private final AbstractDataTypeEnum type;

}
