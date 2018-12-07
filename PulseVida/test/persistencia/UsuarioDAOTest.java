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
    public void Salvar() throws ClassNotFoundException, SQLException {
        Usuario usr = new Usuario(999,"Testador","27123456789","testador@hotmail.com","testador34","testando123");
        UsuarioDAO usrDAO = new UsuarioDAO();
        usrDAO.salvar(usr);
        
        Connection c = null;
        Statement stmt = null;       
        
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");  
        stmt = c.createStatement();
         
        ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_usuario WHERE ID=999");
        
        assertEquals(rs.getInt("ID"), usr.getId());
        assertEquals(rs.getString("NOME"), usr.getNome());
        assertEquals(rs.getString("EMAIL"), usr.getEmail());
        assertEquals(rs.getString("LOGIN"), usr.getLogin());
    }
    
}
