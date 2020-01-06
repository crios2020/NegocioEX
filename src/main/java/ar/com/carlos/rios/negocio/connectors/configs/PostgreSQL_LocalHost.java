package ar.com.carlos.rios.negocio.connectors.configs;
import ar.com.carlos.rios.negocio.connectors.ConnectorJDBC;
import java.sql.Connection;
public class PostgreSQL_LocalHost {
    private final String driver="org.postgresql.Driver";
    private final String vendor="postgresql";
    private final String server="localhost";
    private final String port="5432";
    private final String base="";
    private final String params="";
    private final String user="postgres";
    private final String pass="postgres";
    public Connection getConnection(){
        return new ConnectorJDBC(driver, vendor, server, port, base, params, user, pass).getConnection();
    }
}
