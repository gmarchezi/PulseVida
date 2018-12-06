/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsevida;

import conexoes.CriaBancoSQLite;
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
        CriaBancoSQLite _criarBanco = new CriaBancoSQLite();        
        persistencia.UsuarioDAO _userDAO = new persistencia.UsuarioDAO();
        persistencia.ContatoDAO _cttDAO = new persistencia.ContatoDAO();
        persistencia.CttUsuarioDAO _cttUserDAO = new persistencia.CttUsuarioDAO();
        //persistencia.HorarioRemedioDAO _horarioDAO = new persistencia.HorarioRemedioDAO();
        
        //Cria as seguintes tabelas, caso as mesmas não existam.
        _criarBanco.criarTabelaContato();
        _criarBanco.criarTabelaUsuario();
        _criarBanco.criarTabelaCttUsuario();
        
        String opcao = JOptionPane.showInputDialog("Escolha a opção"
                + "\n(1)Cadastrar Usuario"
                + "\n(2)Cadastrar Contato"
                + "\n(3)Cadastra contato do Usuario"
                + "\n(4)Listar Usuarios Cadastrados"
                + "\n(5)Listar Contatos Cadastrados"
                + "\n(6)Deletar Contato"
                + "\n(7)Deletar Usuario"
                + "\n(8)Simular monitoramento\n");
        int opcaoEscolhida = Integer.parseInt(opcao);
        
        //Listar listar = new Listar();
        switch (opcaoEscolhida) {
            case 1:
                {
                    int id = (_userDAO.ultimoID() + 1);
                    String nome = JOptionPane.showInputDialog("Nome:");
                    nome = validaString(nome,"Nome");
                    String celular = JOptionPane.showInputDialog("Celular:");
                    celular = validaString(celular,"Celular");
                    String email = JOptionPane.showInputDialog("E-mail:");
                    email = validaString(email,"E-mail");
                    String login = JOptionPane.showInputDialog("Login:");
                    login = validaString(login,"Login");
                    String senha = JOptionPane.showInputDialog("Senha:");
                    senha = validaString(senha,"Senha");
                    Usuario novoUsuario = new Usuario(id,nome,celular,email,login,senha);                    
                    _userDAO.salvar(novoUsuario);
                    break;
                }
            case 2:
                {
                    
                    
                    int id = (_cttDAO.ultimoID() + 1);
                    String nome = JOptionPane.showInputDialog("Nome:");
                    String celular = JOptionPane.showInputDialog("Celular:");
                    String email = JOptionPane.showInputDialog("E-mail:");
                    Contato novoContato = new Contato(id,nome,email,celular);                    
                    _cttDAO.salvar(novoContato);
                    break;
                }
            case 3:
                {
                    String login = JOptionPane.showInputDialog("Login do usuario':");
                    String celular = JOptionPane.showInputDialog("Celular do contato:");
                    CttUsuario cttUsuario = new CttUsuario(login,celular);                    
                    _cttUserDAO.salvar(cttUsuario);
                    break;
                }
            case 4:
                {                    
                    ArrayList list = _userDAO.selectTable();
                    listaUsuarios(list);
                    break;
                }
            case 5:
                {                    
                    ArrayList list = _cttDAO.selectTable();
                    listaContatos(list);
                    break;
                }
            case 6:
                {
                    String id = JOptionPane.showInputDialog("ID do contato:");
                    _cttDAO.deleteRecord(Integer.parseInt(id));
                    break;
                }
            case 7:
                {
                    String id = JOptionPane.showInputDialog("ID do usuario:");
                    _userDAO.deleteRecord(Integer.parseInt(id));
                    break;
                }
            case 8:
                {
                    persistencia.Monitor _monitor = new persistencia.Monitor();
                    _monitor.simularMonitoramento();
                    break;
                }
           
            default:
                break;
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
            Contato contato = (Contato) it.next();
            System.out.println("Nome: " + contato.getNome());
            System.out.println("E-mail: " + contato.getEmail());
            System.out.println("Celular: " + contato.getCelular());
            System.out.println();
        }
    }
    
    
    public static String validaString(String nome, String tipo){
        while(nome.isEmpty()){
            nome = JOptionPane.showInputDialog("Digite o " + tipo + ":");        
        }
        
        return nome;    
    }
}
