/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author BlackRockShooter
 */
public class ConexaoDao {
    
    
public Connection conectaBD(){

Connection conn = null;

try {
String url = "jdbc:mysql://localhost:3306/projetojava?user=root&password=";
conn= DriverManager.getConnection(url);
} catch (SQLException erro){
JOptionPane.showMessageDialog(null, "eerro" +erro.getMessage());
}
return conn;

}
    
    
    
    
}
