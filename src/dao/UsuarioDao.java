package dao;

import SistemaAcademico.Curso;
import SistemaAcademico.Usuario;
import conexao.Conexao;
import conexao.ConexaoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author BlackRockShooter
 */
public class UsuarioDao {

    

    Connection conn;

    public ResultSet autenticacaoUsuario(Usuario objusuario) {

        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "select * from usuario where nome_usuario=? and senha_usuario = ? ";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuario.getNome_usuario());
            pstm.setString(2, objusuario.getSenha_usuario());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);

        }
        return null;
    }

    

}
