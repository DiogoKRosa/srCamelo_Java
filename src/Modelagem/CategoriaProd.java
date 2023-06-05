/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;
import Controle.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dsm-2
 */
public class CategoriaProd {
    private int id;
    private String nome, desc;
    
    Conexao conn = new Conexao();
    
    public CategoriaProd(){
        this(0,"","");
    }

    public CategoriaProd(int id, String nome, String desc) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public ResultSet consultarCategoria(){
        ResultSet tabela;
        String sql = "Select * from Categoria_produtos";
        tabela = conn.RetornarResultset(sql);
        return tabela;
    }
    
    public void trazerId(){
        ResultSet tabela;
        String sql = "Select Id_categoria from Categoria_produtos where nome_categoria = '"+getNome()+"'";
        tabela = conn.RetornarResultset(sql);
        try {
            if(tabela.next()){
                setId(Integer.parseInt(tabela.getString(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaProd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
