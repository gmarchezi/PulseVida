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
 * @author hmreb
 */
public class ContatoDAO {
    
    public void salvar(pulsevida.Contato novoContato) throws ClassNotFoundException, SQLException{
        Connection c = null;
        Statement stmt = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");        
            System.out.println("Base conectada.");                      
            stmt = c.createStatement();
            
            String query = "INSERT INTO tbl_contato (ID,NOME,EMAIL,CELULAR) "
                    + "VALUES (" + novoContato.getId() + ",'" + 
                    novoContato.getNome()+ "','" +
                    novoContato.getEmail()+ "','" +
                    novoContato.getCelular()+ "');";
            
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_contato;");
            while (rs.next()) {
                pulsevida.Contato contato = new pulsevida.Contato();
                contato.setId(rs.getInt("ID"));
                contato.setNome(rs.getString("NOME"));
                contato.setEmail(rs.getString("EMAIL"));
                contato.setCelular(rs.getString("CELULAR"));
                listContatos.add(contato);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Operation done successfully");
        
        return listContatos;
    }
    
    public void deleteRecord(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");            
            System.out.println("Base conectada.");
            stmt = c.createStatement();
            String sql = "DELETE from tbl_contato where ID=" + id +";";
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
            ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM tbl_contato");            
            id = ((Number) rs.getObject(1)).intValue();
            rs.close();
            stmt.close();
            c.close();
        } 
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return id;
    }
}
