package entity;

import lombok.Data;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/8/19
 */
@Data
public class MetaDataResult extends TableMetaDataEntity {
    private List<ColumnMetaDataEntity> columns;
}
