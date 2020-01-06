package ar.com.carlos.rios.negocio.connectors;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectorJDBC {
    private final String driver;
    private final String vendor;
    private final String server;
    private final String port;
    private final String base;
    private final String params;
    private final String user;
    private final String pass;
    private final String url;
    public ConnectorJDBC(String driver, String url) {
        //Arme este constructor para SQLite
        this.driver = driver;
        this.url = url;
        this.vendor = "";
        this.server = "";
        this.port = "";
        this.base = "";
        this.params = "";
        this.user = "";
        this.pass = "";
    }
    public ConnectorJDBC(String driver, String vendor, String server, String port, String base, String params, String user, String pass) {
        this.driver = driver;
        this.vendor = vendor;
        this.server = server;
        this.port = port;
        this.base = base;
        this.params = params;
        this.user = user;
        this.pass = pass;
        this.url="jdbc:"+vendor+"://"+server+":"+port+"/"+base+params;
    }
    private Connection conn=null;
    public Connection getConnection(){
        try{
            if(conn==null || conn.isClosed()){
                Class.forName(driver);
                conn=DriverManager.getConnection(url, user, pass);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
