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
public class Produto {
    private int id, id_vend, id_cat;
    private float valor;
    private String nome, desc, img;
    
    Conexao conn = new Conexao();
    
    public Produto(){
        this(0,0,0,"",0,"","");
    }

    public Produto(int id, int id_vend, int id_cat, String nome, float valor, String desc, String img) {
        this.id = id;
        this.id_vend = id_vend;
        this.id_cat = id_cat;
        this.nome = nome;
        this.valor = valor;
        this.desc = desc;
        this.img = img;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_vend() {
        return id_vend;
    }

    public void setId_vend(int id_vend) {
        this.id_vend = id_vend;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public void inserirImgProduto(){
        String sql = "Update produtos set imagem_produto = '"+getImg()+"' where id_produto = "+getId();
        conn.executeSQL(sql);
    }
    
    public void pegarCodProd(){
        ResultSet tabela;
        String sql = "Select max(id_produto) from produtos where  id_vendedor ="+getId_vend();
        tabela = conn.RetornarResultset(sql);
        try{
            tabela.beforeFirst();
            if(tabela.next()){
                setId(Integer.parseInt(tabela.getString(1)));
            }
         
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: "+err);
        }
    }
    
    public void deletarProduto(){
        String sql = "Delete from produtos where id_produto = "+getId();
        conn.executeSQL(sql);
    }
    
    public void cadastrarProdutos(){
        String sql = "INSERT INTO produtos(nome_produto, preco_produto, descricao_produto, imagem_produto, id_vendedor, id_categoria) values"
                + "('"+getNome()+"','"+getValor()+"','"+getDesc()+"','"+getImg()+"',"+getId_vend()+","+getId_cat()+")";
        conn.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
    }
    
    public ResultSet consultarProdutos(int id){
        ResultSet tabela;
        String sql = "Select * from produtos where id_vendedor = "+id;
        tabela = conn.RetornarResultset(sql);
        return tabela;
    }
    
    public void editarProdutos(){
        String sql = "Update produtos set nome_produto='"+getNome()+"', preco_produto="+getValor()+", descricao_produto='"+getDesc()+"', "
                + "id_categoria="+getId_cat()+" where id_produto = "+getId();
        conn.executeSQL(sql);
    }
    
    public ResultSet consultarCategoria(int Categoria){
        ResultSet tabela;
        String sql = "Select * from produtos where id_categoria ="+Categoria;
        tabela = conn.RetornarResultset(sql);
        return tabela; 
    }
    
    public ResultSet consultarNomeProd(String nome){
        ResultSet tabela;
        String sql = "Select * from produtos where nome_produto like '%"+nome+"%'";
        tabela = conn.RetornarResultset(sql);
        return tabela;
    }
    
}
