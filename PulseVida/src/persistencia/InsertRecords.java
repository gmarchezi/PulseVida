/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author hmreb
 */
public class InsertRecords {
    
    public void insertRecord(pulsevida.Usuario usuario)
    {
        Connection c = null;
        Statement stmt = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pulseVida.db");
            
            System.out.println("Base de dados aberta.");
            String sql = "INSERT INTO USUARIO (CPF, NOME, CELULAR, EMAIL, SENHA)"
                            + "VALUES ("+ usuario.getNome() + "','"
                            + usuario.getCelular() + "','"
                            + usuario.getEmail() + "','"
                            + usuario.getSenha() +"');";
            stmt.executeUpdate(sql);
            stmt.close();
            
            c.close();
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Item criado com sucesso.");
    }
}
