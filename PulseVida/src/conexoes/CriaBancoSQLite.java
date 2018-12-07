/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bruno
 */
public class CriaBancoSQLite {    
    
    
    public synchronized void criarTabelaPessoa() throws ClassNotFoundException, SQLException {                
        Connection c = null;
        Statement stmt = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");
            System.out.println("Base conectada.");
            stmt = c.createStatement();
            
            String query = "CREATE TABLE IF NOT EXISTS tbl_pessoa"
                + "("
                + "ID INT PRIMARY KEY NOT NULL,"
                + "NOME CHAR(100) NOT NULL,"
                + "EMAIL CHAR(100) NOT NULL,"
                + "CELULAR CHAR(10) NULL"
                + ")";
                
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
            
            System.out.println("Tabela pessoa criada!");
            
        }catch(SQLException e){
            System.err.println(e.getClass().getName() + ": " + 
            e.getMessage());
        }
    }

    public synchronized void criarTabelaContato() throws ClassNotFoundException, SQLException {                
        Connection c = null;
        Statement stmt = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");
            System.out.println("Base conectada.");
            stmt = c.createStatement();
            
            String query = "CREATE TABLE IF NOT EXISTS tbl_contato"
                + "("
                + "ID INT PRIMARY KEY NOT NULL,"
                + "ID_USUARIO INT NOT NULL,"
                + "NOME CHAR(100) NOT NULL,"
                + "EMAIL CHAR(100) NOT NULL,"
                + "CELULAR CHAR(10) NULL"
                + ")";
                
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
            
            System.out.println("Tabela contato criada!");
            
        }catch(SQLException e){
            System.err.println(e.getClass().getName() + ": " + 
            e.getMessage());
        }
    }

    public synchronized void criarTabelaUsuario() throws ClassNotFoundException, SQLException {                
        Connection c = null;
        Statement stmt = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");
            System.out.println("Base conectada.");
            stmt = c.createStatement();
            
            String query = "CREATE TABLE IF NOT EXISTS tbl_usuario"
                + "("
                + "ID INT PRIMARY KEY NOT NULL,"
                + "NOME CHAR(100) NOT NULL,"
                + "CELULAR CHAR(10) NULL,"
                + "EMAIL CHAR(100) NOT NULL,"
                + "LOGIN CHAR(100) NOT NULL,"
                + "SENHA CHAR(255) NOT NULL"
                + ");";
                
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
            
            System.out.println("Tabela usuario criada!");
            
        }catch(SQLException e){
            System.err.println(e.getClass().getName() + ": " + 
            e.getMessage());
        }
    }
}