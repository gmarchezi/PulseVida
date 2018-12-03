/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsevida;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author 20161BSI0012
 */
public class PulseVida {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        CriaBancoSQLite criarBanco = new CriaBancoSQLite();
        
        //Cria as seguintes tabelas, caso as mesmas não existam.
        criarBanco.criarTabelaPessoa();
        criarBanco.criarTabelaContato();
        criarBanco.criarTabelaUsuario();
        criarBanco.criarTabelaCttUsuario();
        
        String opcao = JOptionPane.showInputDialog("Escolha a opção"
                + "\n(1)Cadastrar Usuario"
                + "\n(2)Cadastrar Contato"
                + "\n(3)Cadastra contato do Usuario"
                + "\n(4)Listar Usuarios Cadastrados"
                + "\n(5)Listar Contatos Cadastrados"
                + "\n(6)Simular monitoramento\n");
        int opcaoEscolhida = Integer.parseInt(opcao);
        
        //Listar listar = new Listar();        
        if (opcaoEscolhida == 1) {            
           
            String nome = JOptionPane.showInputDialog("Nome:");
            String celular = JOptionPane.showInputDialog("Celular:");
            String email = JOptionPane.showInputDialog("E-mail:");
            String login = JOptionPane.showInputDialog("Login:");
            String senha = JOptionPane.showInputDialog("Senha:");
            
            Usuario novoUsuario = new Usuario(nome,celular,email,login,senha);
            persistencia.UsuarioDAO _userDAO = new persistencia.UsuarioDAO();
            
            _userDAO.Salvar(novoUsuario);
            
        } else if (opcaoEscolhida == 2) {
            
           
            String nome = JOptionPane.showInputDialog("Nome:");
            String celular = JOptionPane.showInputDialog("Celular:");
            String email = JOptionPane.showInputDialog("E-mail:");
            
            Contato novoContato = new Contato(nome,celular,email);
            persistencia.ContatoDAO _cttDAO = new persistencia.ContatoDAO();
            
            _cttDAO.Salvar(novoContato);
        }
        else if (opcaoEscolhida == 3) {
            
            CttUsuario cttUsuario = new CttUsuario();
            persistencia.CttUsuarioDAO _cttUserDAO = new persistencia.CttUsuarioDAO();
            
            String login = JOptionPane.showInputDialog("Login:");
            String celular = JOptionPane.showInputDialog("Celular do contato:");
            
            _cttUserDAO.Salvar(cttUsuario);
        }
        else if (opcaoEscolhida == 4){
            
            persistencia.UsuarioDAO _userDAO = new persistencia.UsuarioDAO();
            ArrayList list = _userDAO.selectTable();
            listaUsuarios(list);
        }
        else if (opcaoEscolhida == 5){
            
            persistencia.ContatoDAO _cttDAO = new persistencia.ContatoDAO();
            ArrayList list = _cttDAO.selectTable();
            listaContatos(list);
        }
        else if (opcaoEscolhida == 6){
            persistencia.Monitor _monitor = new persistencia.Monitor();
            _monitor.simularMonitoramento();
        }
    }
    
    //Metodo que lista os itens usuarios do array no console
    public static void listaUsuarios(ArrayList lista) {
        Iterator it = lista.iterator();
        while (it.hasNext()) {
            Usuario usuario = (Usuario) it.next();
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("E-mail: " + usuario.getEmail());
            System.out.println("Celular: " + usuario.getCelular());
            System.out.println("Login: " + usuario.getLogin());
            System.out.println();
        }
    }
    
    //Metodo que lista os itens contatos do array no console
    public static void listaContatos(ArrayList lista) {
        Iterator it = lista.iterator();
        while (it.hasNext()) {
            Usuario usuario = (Usuario) it.next();
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("E-mail: " + usuario.getEmail());
            System.out.println("Celular: " + usuario.getCelular());
            System.out.println("Login: " + usuario.getLogin());
            System.out.println();
        }
    }
}
