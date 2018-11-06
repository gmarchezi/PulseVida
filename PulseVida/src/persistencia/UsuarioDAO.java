/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hmreb
 */
public class UsuarioDAO {
    
    public void Salvar(pulsevida.Usuario novoUsuario) throws ClassNotFoundException, SQLException{
        Connection c = null;
        Statement stmt = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");        
            System.out.println("Base conectada.");                      
            stmt = c.createStatement();
            
            String query = "INSERT INTO tbl_usuario (ID,NOME,CELULAR,EMAIL,SENHA) "
                    + "VALUES (" + novoUsuario.getId() + ",'" + 
                    novoUsuario.getNome()+ "','" +
                    novoUsuario.getCelular()+ "','" +
                    novoUsuario.getEmail()+ "','" +
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
