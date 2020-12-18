
package finaljava;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Logan
 */
public class Conn {
    
    /**
     *
     * @return
     */
    public static Connection open(){
        Connection con = null;
        
            try {
                // Criar a estrutura aqui
                //instanciar o drive
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                // receber infos para conectar ao BD
                String url="jdbc:mysql://127.0.0.1/dbcadclientes?user=root&password=";
                // con url ao driver e acessando a instancia do BD
                con = DriverManager.getConnection(url);
                System.out.println("Conexão aberta!");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return con;
    }
    
    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Conexão fechada!");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
