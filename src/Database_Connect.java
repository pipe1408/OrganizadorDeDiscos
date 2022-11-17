import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database_Connect {

    public Connection CreateDB() {
        Connection con = null;
        String sep = File.separator;
        String db_dir = System.getProperty("user.dir") + sep + "db_discos";
        File url = new File(db_dir);

        if (!url.exists()) {
            try {
                String driver = "org.apache.derby.jdbc.driver.EmbeddedDriver";
                Class.forName(driver);
                String db_con = "jdbc:derby:" + db_dir + ";create=true";
                con = DriverManager.getConnection(db_con);

                //String tabla_discos = "CREATE TABLE world";
            }catch(Exception exception) {
                System.out.println("Error: " + exception);
            }

        }
        return con;
    }
}
