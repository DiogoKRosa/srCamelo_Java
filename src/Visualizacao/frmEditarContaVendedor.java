/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Modelagem.Vendedor;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author dsm-2
 */
public class frmEditarContaVendedor extends javax.swing.JFrame {

    /**
     * Creates new form frmMenuVendedor
     */
    public frmEditarContaVendedor() {
        initComponents();
    }
    
    Vendedor vend = new Vendedor();
    
    private void setImagem(JLabel txt, String caminhoImg){
        ImageIcon image = new ImageIcon(caminhoImg);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(txt.getWidth(),txt.getHeight(),Image.SCALE_SMOOTH));
        txt.setIcon(icon);
        this.repaint();
    }
    
    public void trazerDados(){
        txtNome.setText(vend.getNome());
        txtTel.setText(vend.getTel());
        txtEmail.setText(vend.getEmail());
        setImagem(imgEscolhida, vend.getImg());
        txtCidade.setText(vend.getCidade());
        txtUf.setText(vend.getEstado());
        String Pagto = vend.getFormaPag();
                
        if(Pagto.contains("Dinheiro")){
            btnDinheiro.setSelected(true);
        }
        if(Pagto.contains("Debito")){
            btnDebito.setSelected(true);
        }
        if(Pagto.contains("Credito")){
            btnCredito.setSelected(true);
        }
        if(Pagto.contains("Pix")){
            btnPix.setSelected(true);
        }
    }
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
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        txtCidade1 = new javax.swing.JLabel();
        txtUf = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        btnDinheiro = new javax.swing.JCheckBox();
        btnDebito = new javax.swing.JCheckBox();
        btnCredito = new javax.swing.JCheckBox();
        btnPix = new javax.swing.JCheckBox();
        imgEscolhida = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtTel = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnMapa = new javax.swing.JMenuItem();
        btnInicio = new javax.swing.JMenuItem();
        btnConta = new javax.swing.JMenuItem();
        btnProd = new javax.swing.JMenuItem();
        btnSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu Vendedor");
        setMaximumSize(new java.awt.Dimension(390, 876));
        setResizable(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 103, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(390, 876));
        jPanel1.setPreferredSize(new java.awt.Dimension(390, 876));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(390, 99999));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(92, 172, 14));
        jLabel2.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNome.setForeground(new java.awt.Color(92, 172, 14));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(92, 172, 14));
        jLabel3.setText("Telefone:");

        txtEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(92, 172, 14));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(92, 172, 14));
        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(92, 172, 14));
        jLabel5.setText("Cidade:");

        txtCidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCidade.setForeground(new java.awt.Color(92, 172, 14));

        txtCidade1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCidade1.setForeground(new java.awt.Color(92, 172, 14));
        txtCidade1.setText("UF:");

        txtUf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtUf.setForeground(new java.awt.Color(92, 172, 14));

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(82, 172, 14));
        jLabel31.setText("Formas de Pagamento");

        btnDinheiro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDinheiro.setForeground(new java.awt.Color(82, 172, 14));
        btnDinheiro.setText("Dinheiro");

        btnDebito.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDebito.setForeground(new java.awt.Color(82, 172, 14));
        btnDebito.setText("Débito");

        btnCredito.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCredito.setForeground(new java.awt.Color(82, 172, 14));
        btnCredito.setText("Crédito");

        btnPix.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnPix.setForeground(new java.awt.Color(82, 172, 14));
        btnPix.setText("Pix");

        imgEscolhida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgEscolhida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/plus.png"))); // NOI18N
        imgEscolhida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 103, 0), 2, true));
        imgEscolhida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        imgEscolhida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgEscolhidaMouseClicked(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(82, 172, 14));
        jLabel32.setText("Alterar Foto");

        jButton1.setBackground(new java.awt.Color(255, 103, 0));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtTel.setForeground(new java.awt.Color(92, 172, 14));
        try {
            txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTel.setText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(imgEscolhida, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel32))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(btnDinheiro)
                            .addComponent(btnDebito)
                            .addComponent(btnCredito)
                            .addComponent(btnPix)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtCidade1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade1)
                    .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel31)
                .addGap(13, 13, 13)
                .addComponent(btnDinheiro)
                .addGap(15, 15, 15)
                .addComponent(btnDebito)
                .addGap(15, 15, 15)
                .addComponent(btnCredito)
                .addGap(15, 15, 15)
                .addComponent(btnPix)
                .addGap(43, 43, 43)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addComponent(imgEscolhida, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Editar Perfil");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //String senha = new String(txtSenhavend.getPassword()).trim();
        //String ConfirmarSenha = new String(txtSenhavend2.getPassword()).trim();
        String tiposPag = "";
        
        vend.setNome(txtNome.getText());
        //vend.setCpf(txtCpfvend.getText());
        vend.setEmail(txtEmail.getText());
        vend.setTel(txtTel.getText());
        //vend.setSenha(senha);
        vend.setEstado(txtUf.getText());
        vend.setCidade(txtCidade.getText());
        
        if(btnDinheiro.isSelected()){
            tiposPag = tiposPag.concat("Dinheiro");
        }
        if(btnDebito.isSelected()){
            tiposPag = tiposPag.concat("Debito");
        }
        if(btnCredito.isSelected()){
            tiposPag = tiposPag.concat("Credito");
        }
        if(btnPix.isSelected()){
            tiposPag = tiposPag.concat("Pix");
        }
        vend.setFormaPag(tiposPag);
        
        //existeCpf = consultarCPF(txtEmailvend.getText());
        
           
        vend.AlterarVendedor();

        JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!!");
        
        frmMenuVendedor frm = new frmMenuVendedor();
        frm.vend.setarIdVendedor(vend.getId());
        frm.txtNome.setText(vend.getNome());
        frm.txtTel.setText("Telefone: "+vend.getTel());
        frm.txtEmail.setText("Email: "+vend.getEmail());
        this.setImagem(frm.imgBanner, vend.getImg());
        frm.adicionarPaineis();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void imgEscolhidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEscolhidaMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename=f.getAbsolutePath();
        if(filename.endsWith(".png") || filename.endsWith(".jpg")){
            try {
                BufferedImage image = ImageIO.read(f);
                
                String imageName = "src/Banco_img/"+vend.getId()+"_Banner.png";
                ImageIcon icon = new ImageIcon(imageName);
                ImageIO.write(image, "png",new File(imageName));
                icon.getImage().flush();
                vend.setImg(imageName);
                setImagem(imgEscolhida, imageName);
            } catch (IOException ex) {
                Logger.getLogger(frmVendedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tipo de Arquivo deve ser .jpg ou .png");
        }
    }//GEN-LAST:event_imgEscolhidaMouseClicked

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
            java.util.logging.Logger.getLogger(frmEditarContaVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEditarContaVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEditarContaVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEditarContaVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEditarContaVendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnConta;
    private javax.swing.JCheckBox btnCredito;
    private javax.swing.JCheckBox btnDebito;
    private javax.swing.JCheckBox btnDinheiro;
    private javax.swing.JMenuItem btnInicio;
    private javax.swing.JMenuItem btnMapa;
    private javax.swing.JCheckBox btnPix;
    private javax.swing.JMenuItem btnProd;
    private javax.swing.JMenuItem btnSair;
    private javax.swing.JLabel imgEscolhida;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JLabel txtCidade1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTel;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}