package eunm;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 *
 * </p>
 *
 * @author caijingquan@clinbrain.com
 * @since 2022/8/18
 */
@Getter
@AllArgsConstructor
public enum TableMetaDataEnum {

    // 所在的编目
    TABLE_CAT,
    // 表所在的模式
    TABLE_SCHEM,
    // 表名
    TABLE_NAME,
    // 表类型
    TABLE_TYPE,
    // 表备注
    REMARKS,
    // 编目类型
    TYPE_CAT,
    // 模式类型
    TYPE_SCHEM,
    // 类型名称
    TYPE_NAME,
    //
    SELF_REFERENCING_COL_NAME,
    //
    REF_GENERATION
}
