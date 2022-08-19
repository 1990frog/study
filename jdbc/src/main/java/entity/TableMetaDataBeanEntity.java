package entity;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author caijingquan@clinbrain.com
 * @since 2022/8/19
 */
@Data
public class TableMetaDataBeanEntity {
    private String TABLE_CAT;
    private String TABLE_SCHEM;
    private String TABLE_NAME;
    private String TABLE_TYPE;
    private String REMARKS;
    private String TYPE_CAT;
    private String TYPE_SCHEM;
    private String TYPE_NAME;
    private String SELF_REFERENCING_COL_NAME;
    private String REF_GENERATION;
}
