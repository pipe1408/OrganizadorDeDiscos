import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database_Connect {

    public Connection CreateDB() {
        Connection con = null;
        String sep = File.separator;
        String db_dir = System.getProperty("user.dir") + sep + "db_discos";
        File url = new File(db_dir);

        if (!url.exists()) {
            try {
                String driver = "org.apache.derby.jdbc.EmbeddedDriver";
                Class.forName(driver);
                String db_url = "jdbc:derby:" + db_dir + ";create=true";
                con = DriverManager.getConnection(db_url);
                //String tabla_discos = "";
                //PreparedStatement ps = con.prepareStatement(tabla_discos);
                //ps.execute();
                //ps.close();
                con.close();
                return con;
            }catch(Exception exception) {
                System.out.println("Error: " + exception);
            }

        }
        return con;
    }
}
