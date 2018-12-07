/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import static org.junit.Assert.*;
import persistencia.UsuarioDAO;
import pulsevida.Usuario;

/**
 *
 * @author Guilherme
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
    }

    @Test
    public void salvar() throws ClassNotFoundException, SQLException {
        Usuario usr = new Usuario(999,"Testador","27123456789","testador@hotmail.com","testador34","testando123");
        UsuarioDAOTest usrDAO = new UsuarioDAOTest();
        salvar(usr);
        
        Connection c = null;
        Statement stmt = null;       
        
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");  
        stmt = c.createStatement();
         
        ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_usuarioTeste WHERE ID=999");
        
        assertEquals(rs.getInt("ID"), usr.getId());
        assertEquals(rs.getString("NOME"), usr.getNome());
        assertEquals(rs.getString("EMAIL"), usr.getEmail());
        assertEquals(rs.getString("LOGIN"), usr.getLogin());
    }
    
    public void salvar(pulsevida.Usuario novoUsuario) throws ClassNotFoundException, SQLException{
        Connection c = null;
        Statement stmt = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");        
            System.out.println("Base conectada.");  
            stmt = c.createStatement();
            
            String query = "INSERT INTO tbl_usuarioTeste (ID,NOME,CELULAR,EMAIL,LOGIN,SENHA) "
                    + "VALUES (" + novoUsuario.getId() + ",'" + 
                    novoUsuario.getNome()+ "','" +
                    novoUsuario.getCelular()+ "','" +
                    novoUsuario.getEmail()+ "','" +
                    novoUsuario.getLogin()+ "','" +
                    novoUsuario.getSenha()+ "');";
            
            stmt.executeUpdate(query);
            stmt.close();
            //c.commit();
            c.close();
        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Salvo com sucesso.");
    }
}
