
package conexao;
    
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author BlackRockShooter
 */
public class Conexao {
  
    
    public Connection getConexao(){
        try {
        Connection conn = DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/projetojava?useTimezone=true&serverTimezone=UTC",
"root",
"");
return conn;
} catch (Exception e) {

 System.out.println("erro Conectado."+ e.getMessage());
return null;
}
    }
    
    
    

    
  
}
