/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;
import Controle.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author dsm-2
 */
public class Vendedor {
    private int id;
    private String nome, cpf, tel, cidade, estado, formaPag, email, senha, img;
    
    Conexao conn = new Conexao();
    
    public Vendedor(){
    this(0,"","","","","","","","", "");    
    }
    
    public Vendedor(int id, String nome, String cpf, String tel, String cidade, String estado, String formaPag, String email, String senha, String img) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
        this.cidade = cidade;
        this.estado = estado;
        this.formaPag = formaPag;
        this.email = email;
        this.senha = senha;
        this.img= img;
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

    public String getFormaPag() {
        return formaPag;
    }

    public void setFormaPag(String formaPag) {
        this.formaPag = formaPag;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public void cadastrarVendedor(){
        String sql = "INSERT INTO vendedor(nome_vendedor, cpf_vendedor, celular_vendedor, cidade_vendedor, estado_vendedor, forma_pagamento, email_vendedor, senha_vendedor) VALUES ('"
                +getNome()+"','"
                +getCpf()+"','"
                +getTel()+"','"
                +getCidade()+"','"
                +getEstado()+"','"
                +getFormaPag()+"','"
                +getEmail()+"','"
                +getSenha()+"')";
        conn.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Conta Cadastrada com sucesso");
    }
    
    public ResultSet consultaVendedor(){
        ResultSet tabela;
        String sql = "Select * from vendedor where id_vendedor ="+getId();
        tabela = conn.RetornarResultset(sql);
        return tabela;  
    }
    
    public ResultSet consultaVendedores(){
        ResultSet tabela;
        String sql = "Select * from vendedor";
        tabela = conn.RetornarResultset(sql);
        return tabela;  
    }
    
    public void AtualizarImg(){
        String sql = "Update vendedor set imagem_vendedor ='"+getImg()+"' where id_vendedor ="+getId();
        conn.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Imagem Inserida com sucesso");
    }
    
    public void AlterarVendedor(){
        String sql = "Update vendedor set nome_vendedor = '"+this.getNome()+"', email_vendedor = '"+getEmail()+"',"
                + "celular_vendedor = '"+getTel()+"', cidade_vendedor = '"+getCidade()+"', estado_vendedor='"+getEstado()+"',"
                + "forma_pagamento = '"+getFormaPag()+"' where id_vendedor ="+getId();
        conn.executeSQL(sql);
    }
    
    public void setarIdVendedor(int cod){
        setId(cod);
        
        ResultSet rs = null;
        rs = consultaVendedor();
        
        try {
            rs.beforeFirst();
            if(rs.next()){
                setNome(rs.getString(2));
                setCpf(rs.getString(3));
                setTel(rs.getString(4));
                setCidade(rs.getString(5));
                setEstado(rs.getString(6));
                setFormaPag(rs.getString(7));
                setEmail(rs.getString(8));
                setSenha(rs.getString(9));
                setImg(rs.getString(10));
                //txtNomenovo.setText(vend.getNome());
                //txtTelnovo.setText(vend.getTel());
                //txtEmailnovo.setText(vend.getEmail());
            }
        } catch (SQLException ex) {
            //Logger.getLogger(frmVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
