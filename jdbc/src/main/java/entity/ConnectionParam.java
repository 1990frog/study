package entity;

import eunm.DbmsEnum;
import lombok.Builder;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/8/19
 */
@Data
@Builder
public class ConnectionParam {
    private String catalog;
    private String schema;
    private String host;
    private String port;
    private String username;
    private String password;
    private DbmsEnum db;

    public String getConnectionUrl(){
        return this.db.getConnectUrl(this);
    }
}
