package dao;

import SistemaAcademico.Alunos;
import SistemaAcademico.Curso;
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
public class CursoDao {

    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Curso> lista = new ArrayList<>();
    ArrayList<Alunos> lista2 = new ArrayList<>();
    

    private Conexao conexao;
    private Connection conn;

    public CursoDao() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Curso curso) {

        String sql = "INSERT INTO cursos(nomecurso , nivel , duracao) VALUES " + "(?,?,?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, curso.getNomecurso());
            stmt.setString(2, curso.getNivel());
            stmt.setInt(3, curso.getDuracao());
            stmt.execute();
        } catch (Exception e) {

            System.out.println(" EROOOOOOOOOOOO AO INSERIR" + e.getMessage());
        }

    }

    public ArrayList<Curso> PesquisarCurso() {
        String sql = "select * from cursos";

        conn = new ConexaoDao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                Curso objcurso = new Curso();
                objcurso.setId(rs.getInt("id"));
                objcurso.setNomecurso(rs.getString("nomecurso"));
                objcurso.setNivel(rs.getString("nivel"));
                objcurso.setDuracao(rs.getInt("duracao"));

                lista.add(objcurso);

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Pesquisa ERRO: " + erro);

        }
        return lista;

    }

    public void alterarCurso(Curso objcurso) {
        String sql = "update cursos set nomecurso =?, nivel = ?, duracao = ? where id =?";
        conn = new ConexaoDao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcurso.getNomecurso());
            pstm.setString(2, objcurso.getNivel());
            pstm.setInt(3, objcurso.getDuracao());
            pstm.setInt(4, objcurso.getId());
            pstm.execute();
        } catch (Exception e) {

            System.out.println(" EROOOOOOOOOOOO Alterar" + e.getMessage());
        }

    }
    
    
       public ResultSet listarSelect() {
        conn = new ConexaoDao().conectaBD();

        String sql = "select * from cursos ORDER BY nomecurso; ";

        try {
            pstm = conn.prepareStatement(sql);
            return  pstm.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, " erro no select curso " + erro.getMessage());
            return null;
        }

    }
    
    
    
    
    
    
    
    

    public void excluirCurso(Curso objcurso) {
        String sql = "delete from cursos where id = ?";
        conn = new ConexaoDao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, objcurso.getId());
            pstm.execute();
        } catch (Exception e) {

            System.out.println(" EROOOOOOOOOOOO exclui" + e.getMessage());
        }

    }

    
    
    public void AddAluno(Alunos objalunos) {

        String sql = "INSERT INTO aluno(nome_aluno , cpf , curso  ) VALUES " + "(?,?,?)";
         conn = new ConexaoDao().conectaBD();

        try {
           pstm = conn.prepareStatement(sql);
           pstm.setString(1,objalunos.getNome_aluno());
           pstm.setString(2,objalunos.getCpf());
           pstm.setString(3,objalunos.getCurso());
          
           
           
           pstm.execute();
           pstm.close();
           
        } catch (Exception e) {

            System.out.println(" EROOOOOOOOOOOO AO INSERIR NO ALUNO " + e.getMessage());
        }

    }
    
    public ArrayList<Alunos> PesquisarAlunos() {
        String sql = "select * from aluno";

        conn = new ConexaoDao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                Alunos objalunos = new Alunos();
                objalunos.setId_aluno(rs.getInt("id_aluno"));
                objalunos.setNome_aluno(rs.getString("nome_aluno"));
                objalunos.setCpf(rs.getString("cpf"));
                objalunos.setCurso(rs.getString("curso"));

                lista2.add(objalunos);

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Pesquisa ERRO lista alunos : " + erro);

        }
        return lista2;

    }
    
    
    
    
    
    
    

}
