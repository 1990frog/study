package eunm;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 抽象数据库字段类型
 * </p>
 *
 * @author caijingquan@clinbrain.com
 * @since 2022/8/18
 */
@Getter
@AllArgsConstructor
public enum AbstractDataTypeEnum {
    STRING, NUMERIC, DATE
}
