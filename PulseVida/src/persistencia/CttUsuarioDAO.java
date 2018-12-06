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
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class CttUsuarioDAO {
    
    public void salvar(pulsevida.CttUsuario novoCttusuario) throws ClassNotFoundException, SQLException{
        Connection c = null;
        Statement stmt = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");        
            System.out.println("Base conectada.");                      
            stmt = c.createStatement();
            
            String query = "INSERT INTO tbl_ctt_usuario (LOGIN_USU,CELULAR_CTT) "
                    + "VALUES ('" + novoCttusuario.getLogin() + "','" +
                    novoCttusuario.getCelular()+ "');";
            
            stmt.executeUpdate(query);
            stmt.close();
            //c.commit();
            c.close();
        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Salvo com sucesso.");
    }
    
    public synchronized ArrayList selectTable() {
        ArrayList listContatos = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");            
            System.out.println("Base conectada.");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_ctt_usuario;");
            while (rs.next()) {
                pulsevida.CttUsuario novoCttusuario = new pulsevida.CttUsuario();
                novoCttusuario.setLogin(rs.getString("LOGIN_USU"));
                novoCttusuario.setCelular(rs.getString("CELULAR_CTT"));                
                listContatos.add(novoCttusuario);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Carregado com sucesso.");
        
        return listContatos;
    }
    
    public void deleteRecord(String login) {
        Connection c = null;
        Statement stmt = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");            
            System.out.println("Base conectada.");
            stmt = c.createStatement();
            String sql = "DELETE from tbl_ctt_usuario where LOGIN_USU=" + login +";";
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Carregado com sucesso.");
    }
}
