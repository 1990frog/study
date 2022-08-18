package eunm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MysqlDataType {

    // 1个字节 范围(-128~127)
    TINYINT(AbstractDataType.NUMERIC),
    // 2个字节 范围(-32768~32767)
    SMALLINT(AbstractDataType.NUMERIC),
    // 3个字节 范围(-8388608~8388607)
    MEDIUMIN(AbstractDataType.NUMERIC),
    // 4个字节 范围(-2147483648~2147483647)
    INT(AbstractDataType.NUMERIC),
    // 8个字节 范围(+-9.22*10的18次方)
    BIGINT(AbstractDataType.NUMERIC),
    // 单精度浮点型 8位精度(4字节) m总个数，d小数位
    FLOAT(AbstractDataType.NUMERIC),
    // 双精度浮点型 16位精度(8字节) m总个数，d小数位
    DOUBLE(AbstractDataType.NUMERIC),
    // 浮点型 decimal(m,d) 参数m<65 是总个数，d<30且 d<m 是小数位
    DECIMAL(AbstractDataType.NUMERIC),
    BIT(AbstractDataType.NUMERIC),

    // 日期 '2008-12-2'
    DATE(AbstractDataType.DATE),
    // 时间 '12:25:36'
    TIME(AbstractDataType.DATE),
    // 日期时间 '2008-12-2 22:06:44'
    DATETIME(AbstractDataType.DATE),
    // 自动存储记录修改时间
    TIMESTAMP(AbstractDataType.DATE),
    // 年
    YEAR(AbstractDataType.DATE),

    // 固定长度，最多255个字符
    CHAR(AbstractDataType.STRING),
    // 固定长度，最多65535个字符
    VARCHAR(AbstractDataType.STRING),
    // 可变长度，最多255个字符
    TINYTEXT(AbstractDataType.STRING),
    // 可变长度，最多65535个字符
    TEXT(AbstractDataType.STRING),
    // 可变长度，最多2的24次方-1个字符
    MEDIUMTEXT(AbstractDataType.STRING),
    // 可变长度，最多2的32次方-1个字符
    LONGTEXT(AbstractDataType.STRING),
    TINYBLOB(AbstractDataType.STRING),
    BLOB(AbstractDataType.STRING),
    MEDIUMBLOB(AbstractDataType.STRING),
    LONGBLOB(AbstractDataType.STRING);

    /*TODO other 其他数据类型*/

    private final AbstractDataType type;
}
