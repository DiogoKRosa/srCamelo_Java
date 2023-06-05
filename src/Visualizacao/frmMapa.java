/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Modelagem.Usuario;
import Modelagem.Vendedor;

/**
 *
 * @author Diogo
 */
public class frmMapa extends javax.swing.JFrame {

    /**
     * Creates new form frmMapa
     */
    public frmMapa() {
        initComponents();
    }
    Usuario usu = new Usuario();
    Vendedor vend = new Vendedor();
    
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
    }
    
    private void setImagem(JLabel txt, String caminhoImg){
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

        pWrapper = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtNome = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mapa");

        pWrapper.setBackground(new java.awt.Color(255, 103, 0));
        pWrapper.setMaximumSize(new java.awt.Dimension(390, 860));
        pWrapper.setLayout(new java.awt.CardLayout());

        jPanel2.setMaximumSize(new java.awt.Dimension(390, 860));
        jPanel2.setMinimumSize(new java.awt.Dimension(390, 860));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(390, 860));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ponto.png"))); // NOI18N
        txtNome.setText("Erro");
        txtNome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txtNome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 390, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/plus-mapa.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 730, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Mapa_Vendedor.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, -1, 870));

        pWrapper.add(jPanel2, "Mapa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        frmCliente frm = new frmCliente();
        frm.usu.setarIdCliente(usu.getId());
        frm.adicionarVendProx();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmMapa().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel pWrapper;
    public javax.swing.JLabel txtNome;
    // End of variables declaration//GEN-END:variables
}
