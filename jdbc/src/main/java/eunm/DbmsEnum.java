package eunm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DbmsEnum {

//    mysql("com.mysql.cj.jdbc.Driver", "jdbc:mysql://%s:%s/%s?serverTimezone=UTC"),
//    oracle("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@%s:%s:%s"),
//    sqlserver("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://%s:%s;database=%s"),
//    greenplum("org.postgresql.Driver", "jdbc:postgresql://%s:%s/%s"),
//    hive("org.apache.hive.jdbc.HiveDriver", "jdbc:hive2://%s:%s/%s"),
//    presto("com.facebook.presto.jdbc.PrestoDriver", "jdbc:presto://%s:%s/%s"),
//    sybase("net.sourceforge.jtds.jdbc.Driver", "jdbc:jtds:sybase://%s:%s/%s"),
//    cache("com.intersys.jdbc.CacheDriver", "jdbc:Cache://%s:%s/%s");
//
//    private final String driver;
//    private final String jdbcUrl;
//    private final String queryTablesSql;
//    private final String queryColumnsSql;

    mysql("jdbc:mysql://localhost:13306/data_quality", "root", "P@ssw0rd"),
    mssql("jdbc:sqlserver://localhost:1433;database=master", "sa", "P@ssw0rd"),
    greenplum("jdbc:postgresql://localhost:5432/cdr_db", "gpadmin", "pivotal"),
    oracle("jdbc:oracle:thin:@localhost:1521:XE", "CJQ", "123456"),
    sybase("jdbc:sybase://localhost:5000/hello", "sa", "password"),
    presto("jdbc:presto://localhost:8080/greenplum/public", "root", "");

    private final String url;
    private final String userName;
    private final String password;


}
