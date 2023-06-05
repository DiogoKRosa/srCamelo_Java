/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;
import Controle.Conexao;
import Visualizacao.frmVendedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author dsm-2
 */
public class Usuario {
    private int id;
    private String nome, cpf, tel, cidade, estado, email, senha;
    
    Conexao conn = new Conexao();
    
    public Usuario(){
        this(0,"","","","","","","");
    }

    public Usuario(int id, String nome, String cpf, String tel, String cidade, String estado, String email , String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void cadastrarCliente(){
        String sql="INSERT INTO clientes(nome_cliente, cpf_cliente, celular_cliente, cidade_cliente, estado_cliente, email_cliente, senha_cliente) values ('"
                +getNome()+"','"
                +getCpf()+"','"
                +getTel()+"','"
                +getCidade()+"','"
                +getEstado()+"','"
                +getEmail()+"','"
                +getSenha()+"')";
                
        conn.executeSQL(sql);
        
        JOptionPane.showMessageDialog(null, "Conta Cadastrada com sucesso");
    }
    
    public ResultSet consultarCliente(){
        ResultSet tabela;
        String sql = "SELECT * FROM clientes WHERE id_cliente = "+getId();
        tabela = conn.RetornarResultset(sql);
        return tabela;
    }
    
    public void setarIdCliente(int cod){
        setId(cod);
        System.out.println(getId());
        ResultSet rs = null;
        rs = consultarCliente();
        
        try {
            rs.beforeFirst();
            if(rs.next()){
                setNome(rs.getString(2));
                setCpf(rs.getString(3));
                setTel(rs.getString(4));
                setCidade(rs.getString(5));
                setEstado(rs.getString(6));
                setEmail(rs.getString(7));
                setSenha(rs.getString(8));
                //txtNomenovo.setText(vend.getNome());
                //txtTelnovo.setText(vend.getTel());
                //txtEmailnovo.setText(vend.getEmail());
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
