package ar.com.carlos.rios.negocio.connectors.configs;
import ar.com.carlos.rios.negocio.connectors.ConnectorJDBC;
import java.sql.Connection;
public class SQLite {
    private final String driver="org.sqlite.JDBC";
    private final String url="jdbc:sqlite:/base.db";
    public Connection getConnection(){
        return new ConnectorJDBC(driver, url).getConnection();
    }
}
