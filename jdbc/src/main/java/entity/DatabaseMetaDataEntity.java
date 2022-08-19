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
public class DatabaseMetaDataEntity {
    private String catalog;
    private String schema;
    private String host;
    private String port;
    private String username;
    private String password;
}
