/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.DriverManager;
import java.sql.Connection;
 
/**
 *
 * @author hmreb
 */
public class DBConnection {
    
    private static Connection instance = null;
    
    private DBConnection(){}
    
    public static synchronized Connection getInstance() {
        if (instance == null) {
            try{
                Connection c = null;
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:pulseVidaDB.db");
                c.setAutoCommit(true);
                instance = c;
            }catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
        
        return instance;
    }
//    private Connection conexao;
//        
//    //Conecta a um banco ou cria caso não exista
//    public boolean conectar() {        
//        try{
//            String url = "jdbc:sqlite:pulseVidaDB.db";
//        
//            this.conexao = DriverManager.getConnection(url);
//        }
//        catch(SQLException e){
//            System.err.println(e.getMessage());
//            return false;
//        }
//        System.out.println("Conectou!");
//        
//        return true;
//    }
//    
//    public boolean desconectar() {        
//        try{
//            if (this.conexao.isClosed() == false) {
//                this.conexao.close();
//            }
//        }
//        catch(SQLException e){
//            System.err.println(e.getMessage());
//            return false;
//        }
//        System.out.println("Desconectou!");
//        
//        return true;
//    }
//    
//    //Criar os statements para executar os sqls
//    public Statement criarStatement(){
//        try{
//            return this.conexao.createStatement();
//        }catch(SQLException e){
//            return null;
//        }
//    }
//    
//    public PreparedStatement criarPreparedStatement(String query){
//        try{
//            PreparedStatement st = null;
//            st = this.conexao.prepareStatement(query);
//            
//            return st;
//        }catch(SQLException e){
//            System.err.println(e.getMessage());
//        }
//        return null;
//    }
//    
//    public Connection getConexao(){
//        return this.conexao;
//    }
}
