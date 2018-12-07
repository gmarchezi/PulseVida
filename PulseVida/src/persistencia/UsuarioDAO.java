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
import javax.swing.JOptionPane;
import pulsevida.Usuario;

/**
 *
 * @author hmreb
 */
public class UsuarioDAO {
    
    public void salvar(pulsevida.Usuario novoUsuario) throws ClassNotFoundException, SQLException{
        Connection c = null;
        Statement stmt = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");        
            System.out.println("Base conectada.");  
            stmt = c.createStatement();
            
            String query = "INSERT INTO tbl_usuario (ID,NOME,CELULAR,EMAIL,LOGIN,SENHA) "
                    + "VALUES (" + novoUsuario.getId() + ",'" + 
                    novoUsuario.getNome()+ "','" +
                    novoUsuario.getCelular()+ "','" +
                    novoUsuario.getEmail()+ "','" +
                    novoUsuario.getLogin()+ "','" +
                    novoUsuario.getSenha()+ "');";
            
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Salvo com sucesso.");
    }
    
    public synchronized ArrayList selectTable() {
        ArrayList listUsuarios = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");            
            System.out.println("Base conectada.");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_usuario;");
            while (rs.next()) {
                pulsevida.Usuario usuario = new pulsevida.Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setCelular(rs.getString("CELULAR"));
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setSenha(rs.getString("SENHA"));
                listUsuarios.add(usuario);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Lista recuperada com sucesso.");
        
        return listUsuarios;
    }
    
    public synchronized Usuario recuperarPorLogin(String login){
        Usuario usuario = new Usuario();        
        Connection c = null;
        Statement stmt = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");
            System.out.println("Base conectada.");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_usuario WHERE LOGIN = '" + login + "'");
            if (rs != null) {
                usuario.setId(rs.getInt("ID"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setCelular(rs.getString("CELULAR"));
                usuario.setLogin(rs.getString("LOGIN"));
                usuario.setSenha(rs.getString("SENHA"));
                
                rs.close();
                stmt.close();
                c.close();
            }
            else{
                rs.close();
                stmt.close();
                c.close();
                
                JOptionPane.showInputDialog("Usuário não encontrado!");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Usuario recuperado com sucesso.");
        
        return usuario;
    }
    
    public void deleteRecord(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");            
            System.out.println("Base conectada.");
            stmt = c.createStatement();
            String sql = "DELETE from tbl_usuario where ID=" + id +";";
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Deletado com sucesso.");
    }
    
    public int ultimoID () {
        Connection c = null;
        Statement stmt = null;
        int id = 0;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");
            System.out.println("Base conectada.");
            stmt = c.createStatement();
            try (ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM tbl_usuario")) {
                if (rs == null) {
                    id = 1;
                }
                else
                    id = ((Number) rs.getObject(1)).intValue();
            }            
            stmt.close();
            c.close();
        } 
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return id;
    }
}
