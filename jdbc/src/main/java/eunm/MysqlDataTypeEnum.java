package eunm;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * mysql 数据类型
 * </p>
 *
 * @author caijingquan@clinbrain.com
 * @since 2022/8/19
 */
@Getter
@AllArgsConstructor
public enum MysqlDataTypeEnum {

    // 1个字节 范围(-128~127)
    TINYINT(AbstractDataTypeEnum.NUMERIC),
    // 2个字节 范围(-32768~32767)
    SMALLINT(AbstractDataTypeEnum.NUMERIC),
    // 3个字节 范围(-8388608~8388607)
    MEDIUMIN(AbstractDataTypeEnum.NUMERIC),
    // 4个字节 范围(-2147483648~2147483647)
    INT(AbstractDataTypeEnum.NUMERIC),
    // 8个字节 范围(+-9.22*10的18次方)
    BIGINT(AbstractDataTypeEnum.NUMERIC),
    // 单精度浮点型 8位精度(4字节) m总个数，d小数位
    FLOAT(AbstractDataTypeEnum.NUMERIC),
    // 双精度浮点型 16位精度(8字节) m总个数，d小数位
    DOUBLE(AbstractDataTypeEnum.NUMERIC),
    // 浮点型 decimal(m,d) 参数m<65 是总个数，d<30且 d<m 是小数位
    DECIMAL(AbstractDataTypeEnum.NUMERIC),
    BIT(AbstractDataTypeEnum.NUMERIC),

    // 日期 '2008-12-2'
    DATE(AbstractDataTypeEnum.DATE),
    // 时间 '12:25:36'
    TIME(AbstractDataTypeEnum.DATE),
    // 日期时间 '2008-12-2 22:06:44'
    DATETIME(AbstractDataTypeEnum.DATE),
    // 自动存储记录修改时间
    TIMESTAMP(AbstractDataTypeEnum.DATE),
    // 年
    YEAR(AbstractDataTypeEnum.DATE),

    // 固定长度，最多255个字符
    CHAR(AbstractDataTypeEnum.STRING),
    // 固定长度，最多65535个字符
    VARCHAR(AbstractDataTypeEnum.STRING),
    // 可变长度，最多255个字符
    TINYTEXT(AbstractDataTypeEnum.STRING),
    // 可变长度，最多65535个字符
    TEXT(AbstractDataTypeEnum.STRING),
    // 可变长度，最多2的24次方-1个字符
    MEDIUMTEXT(AbstractDataTypeEnum.STRING),
    // 可变长度，最多2的32次方-1个字符
    LONGTEXT(AbstractDataTypeEnum.STRING),
    TINYBLOB(AbstractDataTypeEnum.STRING),
    BLOB(AbstractDataTypeEnum.STRING),
    MEDIUMBLOB(AbstractDataTypeEnum.STRING),
    LONGBLOB(AbstractDataTypeEnum.STRING);

    /*TODO other 其他数据类型*/

    private final AbstractDataTypeEnum type;
}
