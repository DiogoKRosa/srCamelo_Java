/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Modelagem.Produto;
import Modelagem.Usuario;
import Modelagem.Vendedor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author dsm-2
 */
public class frmPesquisa extends javax.swing.JFrame {

    /**
     * Creates new form frmMenuVendedor
     */
    public frmPesquisa() {
        initComponents();
    }
    Usuario usu = new Usuario();
    Vendedor vend = new Vendedor();
    Produto prod = new Produto();
   
    
    public void adicionarPaineis(ResultSet rs) {
        // Limpa o painel panelProd
        //resultadoPesquisa.removeAll();
        
        // Define o layout para o painel panelProd
        resultadoPesquisa.setLayout(new GridLayout(0, 1, 0, 5));

        try {
            // Loop para adicionar os painéis com as labels
            
            do{
                int idVendedor = Integer.parseInt(rs.getString(7));
                
                JPanel panel = new JPanel(/*new BorderLayout(10, 0)*/);
                panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
                
                JPanel espaco = new JPanel();
                //espaco.setLayout(new BoxLayout(espaco, BoxLayout.Y_AXIS));
                espaco.setBorder(new EmptyBorder(10, 10, 10, 10));
                espaco.setBackground(new java.awt.Color(255,255,255));
                //resultadoPesquisa.add(espaco);
                
                
                // Label à esquerda com imagem
                JLabel leftLabel = new JLabel(/*rs.getString(5)*/);
                leftLabel.setPreferredSize(new Dimension(141, 92));
                panel.add(leftLabel);
                
                /*panel.add(espaco);*/
                
                // Painel para as labels à direita
                JPanel rightPanel = new JPanel(/*new GridLayout(3, 1, 0, 10)*/);
                rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
                JLabel nomeProd = new JLabel(rs.getString(2));
                nomeProd.setPreferredSize(new Dimension(120,22));
                nomeProd.setForeground(new java.awt.Color(92, 172, 14));
                nomeProd.setFont(new java.awt.Font("Arial", 1, 16));
                rightPanel.add(nomeProd);
                
                JLabel precoProd = new JLabel("Preço: "+rs.getString(3));
                precoProd.setPreferredSize(new Dimension(120,22));
                precoProd.setForeground(new java.awt.Color(92, 172, 14));
                rightPanel.add(precoProd);
                
                JLabel descProd = new JLabel("<html>"+rs.getString(4)+"</html>");
                descProd.setPreferredSize(new Dimension(120,50));
                descProd.setForeground(new java.awt.Color(92, 172, 14));
                rightPanel.add(descProd);
                
                rightPanel.setBackground(new java.awt.Color(255, 255, 255));
                panel.setBackground(new java.awt.Color(255, 255, 255));
                
                panel.add(rightPanel);
                resultadoPesquisa.add(panel);
                //System.out.println(vend.getImg());
                
                setImagemProd(leftLabel, rs.getString(5));
                
                panel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    frmMenuVendedorCliente frm = new frmMenuVendedorCliente();
                    frm.vend.setarIdVendedor(idVendedor);
                    frm.usu.setarIdCliente(usu.getId());
                    frm.txtNome.setText(frm.vend.getNome());
                    frm.txtTel.setText("Telefone: "+frm.vend.getTel());
                    frm.txtEmail.setText("Email: "+frm.vend.getEmail());
                    
                    if(frm.vend.getImg().equals("")){
                        setImagem(frm.imgBanner, "src/Imagens/banner-padrao.png");
                    }else{
                        setImagem(frm.imgBanner, frm.vend.getImg());
                    }
                    
                    frm.adicionarPaineis();
                    frm.setVisible(true);
                    dispose();
                }});
                resultadoPesquisa.add(espaco);
                
            }while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(frmPesquisa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Atualiza o painel panelProd
        resultadoPesquisa.revalidate();
        resultadoPesquisa.repaint();
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

        jPanel1 = new javax.swing.JPanel();
        txtPesquisa = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultadoPesquisa = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnPesquisa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnMapa = new javax.swing.JMenuItem();
        btnInicio = new javax.swing.JMenuItem();
        btnSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu Vendedor");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 103, 0));

        txtPesquisa.setForeground(new java.awt.Color(92, 172, 14));
        txtPesquisa.setText("Pesquise Aqui...");
        txtPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPesquisaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPesquisaFocusLost(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(92, 172, 14));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Resultado");

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(340, 332));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(340, 332));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(340, 332));

        resultadoPesquisa.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout resultadoPesquisaLayout = new javax.swing.GroupLayout(resultadoPesquisa);
        resultadoPesquisa.setLayout(resultadoPesquisaLayout);
        resultadoPesquisaLayout.setHorizontalGroup(
            resultadoPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );
        resultadoPesquisaLayout.setVerticalGroup(
            resultadoPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(resultadoPesquisa);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pesquisa");

        btnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisa.png"))); // NOI18N
        btnPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisaMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pesquisa");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pesquisar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisa)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(jLabel1)
                    .addContainerGap(169, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisa))
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(323, 323, 323))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(595, 595, 595)
                    .addComponent(jLabel1)
                    .addContainerGap(595, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

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
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 883, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPesquisaFocusGained
        if(txtPesquisa.getText().equals("Pesquise Aqui...")){
            txtPesquisa.setText("");
        }
    }//GEN-LAST:event_txtPesquisaFocusGained

    private void txtPesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPesquisaFocusLost
        if(txtPesquisa.getText().equals("")){
            txtPesquisa.setText("Pesquise Aqui...");
        }
    }//GEN-LAST:event_txtPesquisaFocusLost

    private void btnPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisaMouseClicked
        frmPesquisa frm = new frmPesquisa();
        frm.usu.setarIdCliente(usu.getId());
        ResultSet rs;
        rs = prod.consultarNomeProd(txtPesquisa.getText());
        frm.adicionarPaineis(rs);
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPesquisaMouseClicked

    private void btnMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapaActionPerformed
        frmMapaCliente frm = new frmMapaCliente();
        frm.usu.setarIdCliente(usu.getId());
        frm.setVisible(true);
        //frm.setarId(vend.getId());
        this.dispose();
    }//GEN-LAST:event_btnMapaActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        frmCliente frm = new frmCliente();
        frm.usu.setarIdCliente(usu.getId());
        frm.adicionarVendProx();
        frm.setVisible(true);
        //frm.setarId(vend.getId());
        this.dispose();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        frmInicio frm = new frmInicio();
        frm.setVisible(true);
        //frm.setarId(vend.getId());
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
            java.util.logging.Logger.getLogger(frmPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPesquisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnInicio;
    private javax.swing.JMenuItem btnMapa;
    private javax.swing.JLabel btnPesquisa;
    private javax.swing.JMenuItem btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel resultadoPesquisa;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
