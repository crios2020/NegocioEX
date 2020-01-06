package ar.com.carlos.rios.test.connectors;
import ar.com.carlos.rios.negocio.connectors.configs.DefaultConnection;
import java.sql.Connection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
public class TestDefaultConnection {
    @Test
    public void testDefaultConnection() {
        int ret=0;
        try {
            try(
                    Connection conn=new DefaultConnection().getConnection();
            ){
                conn.createStatement().executeUpdate(
                    "delete from clientes"
                    //"delete from negocioX.clientes"
                );
                ret=conn.createStatement().executeUpdate(
                    "insert into clientes (nombre,apellido,tipoDocumento,numeroDocumento,direccion) values ('Juan','Perez','DNI',20000000,'Larrea 234')"
                    //"insert into negocioX.clientes (nombre,apellido,tipoDocumento,numeroDocumento,direccion) values ('Juan','Perez','DNI',20000000,'Larrea 234')"
                );
            } catch (Exception e) { fail("testConnectorMySQL_Localhost: Lanzada excepcion no esperada: "+e); }
            assertEquals(1, ret);
        } catch (Exception e) { fail("testConnectorMySQL_Localhost: Lanzada excepcion no esperada Exception: "+e); }
    }
}
