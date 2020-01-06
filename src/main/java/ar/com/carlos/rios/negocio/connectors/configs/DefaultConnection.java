package ar.com.carlos.rios.negocio.connectors.configs;
import java.sql.Connection;
public class DefaultConnection {
    public Connection getConnection(){
        return new MySQL_LocalHost().getConnection();
        //return new MySQL_RemoteMySQL().getConnection();
        //return new SQLite().getConnection();
        //return new PostgreSQL_LocalHost().getConnection();
    }
}