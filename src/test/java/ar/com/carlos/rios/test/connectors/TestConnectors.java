package ar.com.carlos.rios.test.connectors;

import ar.com.carlos.rios.negocio.connectors.configs.MySQL_LocalHost;
import ar.com.carlos.rios.negocio.connectors.configs.MySQL_RemoteMySQL;
import ar.com.carlos.rios.negocio.connectors.configs.PostgreSQL_LocalHost;
import ar.com.carlos.rios.negocio.connectors.configs.SQLite;
import java.sql.Connection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
public class TestConnectors {
    @Test
    public void testConnectorMySQL_Localhost() {
        int ret=0;
        try {
            try(
                    Connection conn=new MySQL_LocalHost().getConnection();
            ){
                conn.createStatement().executeUpdate(
                    "delete from clientes"
                );
                ret=conn.createStatement().executeUpdate(
                    "insert into clientes (nombre,apellido,tipoDocumento,numeroDocumento,direccion) values ('Juan','Perez','DNI',20000000,'Larrea 234')"
                );
            } catch (Exception e) { fail("testConnectorMySQL_Localhost: Lanzada excepcion no esperada: "+e); }
            assertEquals(1, ret);
        } catch (Exception e) { fail("testConnectorMySQL_Localhost: Lanzada excepcion no esperada Exception: "+e); }
    }
    @Test
    public void testConnectorMySQL_RemoteMySQL() {
        int ret=0;
        try {
            try(
                    Connection conn=new MySQL_RemoteMySQL().getConnection();
            ){
                conn.createStatement().executeUpdate(
                    "delete from clientes"
                );
                ret=conn.createStatement().executeUpdate(
                    "insert into clientes (nombre,apellido,tipoDocumento,numeroDocumento,direccion) values ('Juan','Perez','DNI',20000000,'Larrea 234')"
                );
            } catch (Exception e) { fail("testConnectorMySQL_RemoteMySQL: Lanzada excepcion no esperada: "+e); }
            assertEquals(1, ret);
        } catch (Exception e) { fail("testConnectorMySQL_RemoteMySQL: Lanzada excepcion no esperada Exception: "+e); }
    }
    @Test
    public void testConnectorSQLite() {
        int ret=0;
        try {
            try(
                    Connection conn=new SQLite().getConnection();
            ){
                conn.createStatement().executeUpdate(
                    "delete from clientes"
                );
                ret=conn.createStatement().executeUpdate(
                    "insert into clientes (nombre,apellido,tipoDocumento,numeroDocumento,direccion) values ('Juan','Perez','DNI',20000000,'Larrea 234')"
                );
            } catch (Exception e) { fail("testConnectorMySQL_RemoteMySQL: Lanzada excepcion no esperada: "+e); }
            assertEquals(1, ret);
        } catch (Exception e) { fail("testConnectorMySQL_RemoteMySQL: Lanzada excepcion no esperada Exception: "+e); }
    }
    @Test
    public void testConnectorPostgreSQL() {
        int ret=0;
        try {
            try(
                    //Connection conn=new MySQL_LocalHost().getConnection();
                    //Connection conn=new MySQL_RemoteMySQL().getConnection();
                    //Connection conn=new SQLite().getConnection();
                    Connection conn=new PostgreSQL_LocalHost().getConnection();
            ){
                conn.createStatement().executeUpdate(
                    //"insert into clientes (nombre,apellido,tipoDocumento,numeroDocumento,direccion) values ('Juan','Perez','DNI',20000000,'Larrea 234')"
                    "delete from negocioX.clientes"
                );
                ret=conn.createStatement().executeUpdate(
                    //"insert into clientes (nombre,apellido,tipoDocumento,numeroDocumento,direccion) values ('Juan','Perez','DNI',20000000,'Larrea 234')"
                    "insert into negocioX.clientes (nombre,apellido,tipoDocumento,numeroDocumento,direccion) values ('Juan','Perez','DNI',20000000,'Larrea 234')"
                );
            } catch (Exception e) { fail("testConnectorMySQL_RemoteMySQL: Lanzada excepcion no esperada: "+e); }
            assertEquals(1, ret);
        } catch (Exception e) { fail("testConnectorMySQL_RemoteMySQL: Lanzada excepcion no esperada Exception: "+e); }
    }
}