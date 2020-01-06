package ar.com.carlos.rios.negocio.connectors.configs;
import ar.com.carlos.rios.negocio.connectors.ConnectorJDBC;
import java.sql.Connection;
public class MySQL_RemoteMySQL {
    private final String driver="com.mysql.cj.jdbc.Driver";
    private final String vendor="mysql";
    private final String server="remotemysql.com";
    private final String port="3306";
    private final String base="dS8cEP1rPM";
    private final String params="?serverTimezone=UTC";
    private final String user="dS8cEP1rPM";
    private final String pass="y0fG9478g0";
    public Connection getConnection(){
        return new ConnectorJDBC(driver, vendor, server, port, base, params, user, pass).getConnection();
    }
}
