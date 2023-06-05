/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

import Controle.Conexao;

/**
 *
 * @author Diogo
 */
public class Localiza {
    private int id_localiza, id_vendedor, id_cliente;
    
    Conexao conn = new Conexao();
    
    public Localiza(){
        this(0,0,0);
    }

    public Localiza(int id_localiza, int id_vendedor, int id_cliente) {
        this.id_localiza = id_localiza;
        this.id_vendedor = id_vendedor;
        this.id_cliente = id_cliente;
    }

    public int getId_localiza() {
        return id_localiza;
    }

    public void setId_localiza(int id_localiza) {
        this.id_localiza = id_localiza;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public void inserirLocaliza(){
        String sql = "Insert into Localiza_Vendedor (id_vendedor, id_cliente) values ("+getId_vendedor()+","+getId_cliente()+")";
        conn.executeSQL(sql);
    }
}
