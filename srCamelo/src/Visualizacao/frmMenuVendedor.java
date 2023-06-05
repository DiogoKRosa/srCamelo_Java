/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Modelagem.Produto;
import Modelagem.Vendedor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dsm-2
 */
public class frmMenuVendedor extends javax.swing.JFrame {

    /**
     * Creates new form frmMenuVendedor
     */
    public frmMenuVendedor() {
        initComponents();
    }
    
    Vendedor vend = new Vendedor();
    Produto prod = new Produto();
   
    
    public void adicionarPaineis() {
        // Limpa o painel panelProd
        ResultSet rs = prod.consultarProdutos(vend.getId());
        panelProd.removeAll();

        // Define o layout para o painel panelProd
        panelProd.setLayout(new GridLayout(0, 1, 0, 10));

        try {
            // Loop para adicionar os painéis com as labels
            
            do{
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
                // Label à esquerda com imagem
                JLabel leftLabel = new JLabel();
                leftLabel.setPreferredSize(new Dimension(141, 92));
                panel.add(leftLabel);
                
                
                // Painel para as labels à direita
                JPanel rightPanel = new JPanel();
                rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
                JLabel nomeProd = new JLabel(rs.getString(2));
                nomeProd.setPreferredSize(new Dimension(190,22));
                nomeProd.setForeground(new java.awt.Color(92, 172, 14));
                nomeProd.setFont(new java.awt.Font("Arial", 1, 16));
                rightPanel.add(nomeProd);
                
                JLabel precoProd = new JLabel("Preço: "+rs.getString(3));
                precoProd.setPreferredSize(new Dimension(190,22));
                precoProd.setForeground(new java.awt.Color(92, 172, 14));
                rightPanel.add(precoProd);
                
                JLabel descProd = new JLabel(rs.getString(4));
                descProd.setPreferredSize(new Dimension(190,22));
                descProd.setForeground(new java.awt.Color(92, 172, 14));
                rightPanel.add(descProd);
                
                rightPanel.setBackground(new java.awt.Color(255, 255, 255));
                panel.setBackground(new java.awt.Color(255, 255, 255));
                panel.add(rightPanel);
                panelProd.add(panel);
                //System.out.println(vend.getImg());
                
                setImagemProd(leftLabel, rs.getString(5));
            }while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(frmMenuVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Atualiza o painel panelProd
        panelProd.revalidate();
        panelProd.repaint();
        
        if(vend.getFormaPag().contains("Dinheiro")) {
            this.setImagem(imgDinheiro, "src/Imagens/Dinheiro.png");
        }
        if(vend.getFormaPag().contains("Debito")) {
            this.setImagem(imgDebito, "src/Imagens/Debito.png");
        }
        if(vend.getFormaPag().contains("Credito")) {
            this.setImagem(imgCredito, "src/Imagens/Credito.png");
        }
        if(vend.getFormaPag().contains("Pix")) {
            this.setImagem(imgPix, "src/Imagens/Pix.png");
        }
    }
    
    private void setImagemProd(JLabel txt, String caminhoImg){
        ImageIcon image = new ImageIcon(caminhoImg);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(141,92,Image.SCALE_SMOOTH));
        txt.setIcon(icon);
        this.repaint();
    }
    
    private void setImagem(JLabel txt, String caminhoImg){
        ImageIcon image = new ImageIcon(caminhoImg);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(txt.getWidth(),txt.getHeight(),Image.SCALE_SMOOTH));
        txt.setIcon(icon);
        this.repaint();
    }
    
    /*public void setarId(int cod){
        vend.setId(cod);
        
        ResultSet rs = null;
        rs = vend.consultaVendedor();
        
        try {
            rs.beforeFirst();
            if(rs.next()){
                vend.setNome(rs.getString(2));
                vend.setCpf(rs.getString(3));
                vend.setTel(rs.getString(4));
                vend.setCidade(rs.getString(5));
                vend.setEstado(rs.getString(6));
                vend.setFormaPag(rs.getString(7));
                vend.setEmail(rs.getString(8));
                vend.setSenha(rs.getString(9));
                vend.setImg(rs.getString(10));
                //txtNomenovo.setText(vend.getNome());
                //txtTelnovo.setText(vend.getTel());
                //txtEmailnovo.setText(vend.getEmail());
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    
    /*private void setImagem(JLabel txt, String caminhoImg){
        ImageIcon image = new ImageIcon(caminhoImg);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(txt.getWidth(),txt.getHeight(),Image.SCALE_SMOOTH));
        txt.setIcon(icon);
        this.repaint();
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        imgBanner = new javax.swing.JLabel();
        txtNome = new javax.swing.JLabel();
        txtTel = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelProd = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        imgDebito = new javax.swing.JLabel();
        imgCredito = new javax.swing.JLabel();
        imgDinheiro = new javax.swing.JLabel();
        imgPix = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnMapa = new javax.swing.JMenuItem();
        btnInicio = new javax.swing.JMenuItem();
        btnConta = new javax.swing.JMenuItem();
        btnProd = new javax.swing.JMenuItem();
        btnSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu Vendedor");
        setResizable(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(390, 876));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(390, 876));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(390, 876));

        jPanel1.setBackground(new java.awt.Color(255, 103, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        imgBanner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtNome.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtNome.setForeground(new java.awt.Color(92, 172, 14));
        txtNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNome.setText("Nome");

        txtTel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTel.setText("Telefone: ");

        txtEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEmail.setText("Email: ");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(92, 172, 14));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Produtos");

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(340, 332));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(340, 332));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(340, 332));

        panelProd.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelProdLayout = new javax.swing.GroupLayout(panelProd);
        panelProd.setLayout(panelProdLayout);
        panelProdLayout.setHorizontalGroup(
            panelProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        panelProdLayout.setVerticalGroup(
            panelProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panelProd);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Tipos de Pagamento Aceitos");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(imgDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(imgDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(imgCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgPix, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imgDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imgCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgPix, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(imgBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(imgBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(txtNome)
                .addGap(14, 14, 14)
                .addComponent(txtTel)
                .addGap(14, 14, 14)
                .addComponent(txtEmail)
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 112, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jMenu1.setText("Menu");

        btnMapa.setText("Mapa");
        btnMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMapaActionPerformed(evt);
            }
        });
        jMenu1.add(btnMapa);

        btnInicio.setText("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jMenu1.add(btnInicio);

        btnConta.setText("Editar Conta");
        btnConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContaActionPerformed(evt);
            }
        });
        jMenu1.add(btnConta);

        btnProd.setText("Editar Produtos");
        btnProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdActionPerformed(evt);
            }
        });
        jMenu1.add(btnProd);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jMenu1.add(btnSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapaActionPerformed
        frmMapaVendedor frm = new frmMapaVendedor();
        frm.setVisible(true);
        frm.vend.setarIdVendedor(vend.getId());
        this.dispose();
    }//GEN-LAST:event_btnMapaActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        frmMenuVendedor frm = new frmMenuVendedor();
        frm.vend.setarIdVendedor(vend.getId());
        frm.txtNome.setText(vend.getNome());
        frm.txtTel.setText("Telefone: "+vend.getTel());
        frm.txtEmail.setText("Email: "+vend.getEmail());
        this.setImagem(frm.imgBanner, vend.getImg());
        frm.adicionarPaineis();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContaActionPerformed
        frmEditarContaVendedor frm = new frmEditarContaVendedor();
        frm.setVisible(true);
        frm.vend.setarIdVendedor(vend.getId());
        frm.trazerDados();
        this.dispose();
    }//GEN-LAST:event_btnContaActionPerformed

    private void btnProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdActionPerformed
        frmEditarProdutoVendedor frm = new frmEditarProdutoVendedor();
        frm.setVisible(true);
        frm.vend.setarIdVendedor(vend.getId());
        frm.consultarProdutos();
        this.dispose();
    }//GEN-LAST:event_btnProdActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        frmInicio frm = new frmInicio();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMenuVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuVendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnConta;
    private javax.swing.JMenuItem btnInicio;
    private javax.swing.JMenuItem btnMapa;
    private javax.swing.JMenuItem btnProd;
    private javax.swing.JMenuItem btnSair;
    public javax.swing.JLabel imgBanner;
    private javax.swing.JLabel imgCredito;
    private javax.swing.JLabel imgDebito;
    private javax.swing.JLabel imgDinheiro;
    private javax.swing.JLabel imgPix;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelProd;
    public javax.swing.JLabel txtEmail;
    public javax.swing.JLabel txtNome;
    public javax.swing.JLabel txtTel;
    // End of variables declaration//GEN-END:variables
}
