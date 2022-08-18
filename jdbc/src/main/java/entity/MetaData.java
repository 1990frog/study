package entity;

import lombok.Builder;
import lombok.Data;

/**
 * <p>
 * 元数据类
 * </p>
 *
 * @author caijingquan@clinbrain.com
 * @since 2022/8/18
 */
@Data
@Builder
public class MetaData {
    private String catalog;
    private String schema;
    private String tableName;
    private String columnName;
    private String dataType;
    private String typeName;
    private String columnSize;
    private String bufferLength;
    private String decimalDigits;
    private String numPrecRadix;
    private String nullable;
    private String remarks;
    private String columnDef;
    private String sqlDataType;
    private String sqlDatetimeSub;
    private String charOctetLength;
    private String ordinalPosition;
    private String isNullable;
    private String scopeCatalog;
    private String scopeSchema;
    private String scopeTable;
    private String sourceDataType;
    private String isAutoincrement;
    private String isGeneratedColumn;
}
