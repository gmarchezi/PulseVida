/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsevida;

import java.sql.SQLException;
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
        
        criarBanco.criarTabelaPessoa();
        criarBanco.criarTabelaContato();
        criarBanco.criarTabelaUsuario();
        
        String opcao = JOptionPane.showInputDialog("Escolha a opção"
                + "\n(1)Cadastrar Pessoa"
                + "\n(2)Cadastrar Usuario\n");
        int opcaoEscolhida = Integer.parseInt(opcao);
        
        //Listar listar = new Listar();        
        if (opcaoEscolhida == 1) {
            Pessoa novaPessoa = new Pessoa();
            persistencia.PessoaDAO _pessoaDAO = new persistencia.PessoaDAO();
            
            String id = JOptionPane.showInputDialog("ID");
            String nome = JOptionPane.showInputDialog("Nome:");
            String celular = JOptionPane.showInputDialog("Celular:");
                        
            novaPessoa.setId(Integer.parseInt(id));
            novaPessoa.setNome(nome);
            novaPessoa.setCelular(celular);
            
            _pessoaDAO.Salvar(novaPessoa);
            
        } else if (opcaoEscolhida == 2) {
            Usuario novoUsuario = new Usuario();
            persistencia.UsuarioDAO _userDAO = new persistencia.UsuarioDAO();
            
            String id = JOptionPane.showInputDialog("ID");
            String nome = JOptionPane.showInputDialog("Nome:");
            String celular = JOptionPane.showInputDialog("Celular:");
            String email = JOptionPane.showInputDialog("E-mail:");
            String senha = JOptionPane.showInputDialog("Senha:");
                        
            novoUsuario.setId(Integer.parseInt(id));
            novoUsuario.setNome(nome);
            novoUsuario.setCelular(celular);
            novoUsuario.setEmail(email);
            novoUsuario.setSenha(senha);
            
            _userDAO.Salvar(novoUsuario);
        }         
    }
}
