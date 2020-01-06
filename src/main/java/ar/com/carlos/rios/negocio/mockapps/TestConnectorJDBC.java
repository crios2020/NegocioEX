package ar.com.carlos.rios.negocio.mockapps;
import ar.com.carlos.rios.negocio.connectors.configs.DefaultConnection;
import ar.com.carlos.rios.negocio.connectors.configs.MySQL_LocalHost;
import ar.com.carlos.rios.negocio.connectors.configs.MySQL_RemoteMySQL;
import ar.com.carlos.rios.negocio.connectors.configs.PostgreSQL_LocalHost;
import ar.com.carlos.rios.negocio.connectors.configs.SQLite;
import java.sql.Connection;
public class TestConnectorJDBC {
    public static void main(String[] args) {
        try(
                //Connection conn=new MySQL_LocalHost().getConnection();
                //Connection conn=new MySQL_RemoteMySQL().getConnection();
                //Connection conn=new SQLite().getConnection();
                //Connection conn=new PostgreSQL_LocalHost().getConnection();
                Connection conn=new DefaultConnection().getConnection();
        ){
            conn.createStatement().execute(
                    "delete from clientes"
                    //"delete from negocioX.clientes"
            );
            conn.createStatement().execute(
                "insert into clientes (nombre,apellido,tipoDocumento,numeroDocumento,direccion) values ('Juan','Perez','DNI',20000000,'Larrea 234')"
                //"insert into negocioX.clientes (nombre,apellido,tipoDocumento,numeroDocumento,direccion) values ('Juan','Perez','DNI',20000000,'Larrea 234')"
            );
        } catch (Exception e) { e.printStackTrace(); }
    }
}