package ar.com.carlos.rios.negocio.connectors.configs;
import ar.com.carlos.rios.negocio.connectors.ConnectorJDBC;
import java.sql.Connection;
public class MySQL_LocalHost {
    private final String driver="com.mysql.cj.jdbc.Driver";
    private final String vendor="mysql";
    private final String server="localhost";
    private final String port="3306";
    private final String base="negocioX";
    private final String params="?serverTimezone=UTC";
    private final String user="root";
    private final String pass="";
    public Connection getConnection(){
        return new ConnectorJDBC(driver, vendor, server, port, base, params, user, pass).getConnection();
    }
}
