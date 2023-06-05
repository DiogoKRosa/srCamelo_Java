/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

/**
 *
 * @author Diogo
 */
public class Tabela_Produto {
    private int Id;
    private String Nome;
    private float Valor;
    private String Desc, Categoria, Img;
    
    public Tabela_Produto(){
        this(0,"",0,"","","");
    }

    public Tabela_Produto(int Id, String Nome, float Valor, String Desc, String Categoria, String Img) {
        this.Id = Id;
        this.Nome = Nome;
        this.Valor = Valor;
        this.Desc = Desc;
        this.Categoria = Categoria;
        this.Img = Img;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }
    
}
