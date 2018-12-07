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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guilherme
 */
public class CriaBancoSQLiteTest {
    
    public CriaBancoSQLiteTest() {
    }

    @Test
    public synchronized void criarTabelaUsuarioTeste() throws ClassNotFoundException, SQLException {                
        Connection c = null;
        Statement stmt = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");
            System.out.println("Base conectada.");
            stmt = c.createStatement();
            
            String query = "CREATE TABLE IF NOT EXISTS tbl_usuarioTeste"
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
