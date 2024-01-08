package eunm;

import cn.hutool.core.util.StrUtil;
import entity.ConnectionParam;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DbmsEnum {

    mysql("jdbc:mysql://{}:{}/{}") {
        /**
         * instance == database == catalog
         * schema：支持，库名
         * @param params
         * @return
         */
        @Override
        public String getConnectUrl(ConnectionParam params) {
            return StrUtil.format(getUrl(), params.getHost(), params.getPort(), params.getSchema());
        }
    },
    sqlserver("jdbc:sqlserver://{}:{};database={}") {
        /**
         * catalog：库名
         * schema：库所属对象，例：dbo
         * @param params
         * @return
         */
        @Override
        public String getConnectUrl(ConnectionParam params) {
            return StrUtil.format(getUrl(), params.getHost(), params.getPort(), params.getSchema());
        }
    },
    greenplum("jdbc:postgresql://{}:{}/{}"){
        @Override
        public String getConnectUrl(ConnectionParam params) {
            return StrUtil.format(getUrl(), params.getHost(), params.getPort(), params.getSchema());
        }
    },
    oracle("jdbc:oracle:thin:@{}:{}:{}") {
        /**
         * catalog：不支持
         * schema：用户
         * @param params
         * @return
         */
        @Override
        public String getConnectUrl(ConnectionParam params) {
            return StrUtil.format(getUrl(), params.getHost(), params.getPort(), params.getSchema());
        }
    },
    sybase("jdbc:sybase://{}:{}/{}"){
        @Override
        public String getConnectUrl(ConnectionParam params) {
            return StrUtil.format(getUrl(), params.getHost(), params.getPort(), params.getSchema());
        }
    },
    presto("jdbc:presto://{}:{}/{}"){
        @Override
        public String getConnectUrl(ConnectionParam params) {
            return StrUtil.format(getUrl(), params.getHost(), params.getPort(), params.getSchema());
        }
    },
    cache("jdbc:Cache://{}:{}/{}"){
        @Override
        public String getConnectUrl(ConnectionParam params) {
            return StrUtil.format(getUrl(), params.getHost(), params.getPort(), params.getSchema());
        }
    };

    private final String url;

    public abstract String getConnectUrl(ConnectionParam params);
}
