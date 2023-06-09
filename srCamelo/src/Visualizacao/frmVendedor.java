/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;


import Modelagem.CategoriaProd;
import Modelagem.Produto;
import Modelagem.QuickSort_Int;
import Modelagem.Tabela_Produto;
import Modelagem.Vendedor;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dsm-2
 */
public class frmVendedor extends javax.swing.JFrame {
    Vendedor vend =  new Vendedor();
    Produto prod =  new Produto();
    CategoriaProd cat = new CategoriaProd();
    /**
     * Creates new form frmVendedor
     */
    public frmVendedor() {
        initComponents();
    }
    
    /*private void popularTabela(){
        
    }*/
    
    
    private ArrayList<Tabela_Produto> ordenarProd(){
        QuickSort_Int q = new QuickSort_Int();
        ResultSet rs = prod.consultarProdutos(vend.getId());
        try{
            ArrayList<Tabela_Produto> arrayProd = new ArrayList<Tabela_Produto>();
            rs.first();
            do{
                System.out.println(rs.getRow());
                int id = Integer.parseInt(rs.getString(1));
                String nome = rs.getString(2);
                float preco = Float.parseFloat(rs.getString(3));
                String desc = rs.getString(4);
                String categoria = rs.getString(6);
                String img = rs.getString(5);
                Tabela_Produto tblProd = new Tabela_Produto(id, nome, preco, desc, categoria, img); 
                arrayProd.add(tblProd);
            }while(rs.next());
            q.quicksort(arrayProd);
            System.out.println(arrayProd);
            return arrayProd;
            
        }catch(SQLException e){
            //e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }
    
    
    
    private void setImagem(JLabel txt, String caminhoImg){
        ImageIcon image = new ImageIcon(caminhoImg);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(txt.getWidth(),txt.getHeight(),Image.SCALE_SMOOTH));
        txt.setIcon(icon);
        this.repaint();
    }
    
    public int vendedorNovo(){
        ResultSet rs;
        rs = prod.consultarProdutos(vend.getId());
        try{
            rs.beforeFirst();
            if(!rs.next()){
            
            return 1;
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Erro ao consultar a tabela:\n"+err);
        }
        return 0;
    }
    
    private void consultarProdutosCad(){
        ResultSet rs;
        rs = prod.consultarProdutos(vend.getId());
        
        DefaultTableModel modelo = (DefaultTableModel) tblProdCad.getModel();
        modelo.setNumRows(0);

        try
        {
            do{
                modelo.addRow(new String[]{rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(6),rs.getString(5)});
            }while(rs.next());
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao consultar a tabela:\n"+erro);
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

        jFileChooser1 = new javax.swing.JFileChooser();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        pWrapper = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        imgEscolhida = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtNomenovo = new javax.swing.JLabel();
        labelTelefone = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        imgMostra = new javax.swing.JLabel();
        txtEmailnovo = new javax.swing.JLabel();
        txtTelnovo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnFinalizar = new javax.swing.JButton();
        imgProdCad = new javax.swing.JLabel();
        btnProdEd = new javax.swing.JLabel();
        txtProdNomeCad = new javax.swing.JTextField();
        txtProdPrecoCad = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtProdDescCad = new javax.swing.JTextArea();
        txtProdCategoriaCad = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProdCad = new javax.swing.JTable();
        btnOrdernarPrecCad = new javax.swing.JToggleButton();
        btnProdCad = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Users\\dsm-2\\Desktop"));

        jMenuItem4.setText("Mapa");
        jPopupMenu1.add(jMenuItem4);

        jMenuItem1.setText("Menu Principal");
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Editar Perfil");
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("Editar Produtos");
        jPopupMenu1.add(jMenuItem3);

        jMenuItem5.setText("Sair");
        jPopupMenu1.add(jMenuItem5);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendedor");
        setMinimumSize(new java.awt.Dimension(390, 860));
        setResizable(false);

        pWrapper.setBackground(new java.awt.Color(255, 103, 0));
        pWrapper.setMaximumSize(new java.awt.Dimension(390, 860));
        pWrapper.setLayout(new java.awt.CardLayout());

        jPanel3.setMaximumSize(new java.awt.Dimension(390, 860));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(390, 32767));
        jPanel5.setMinimumSize(new java.awt.Dimension(390, 860));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 103, 0), 1, true));
        jPanel6.setMaximumSize(new java.awt.Dimension(338, 162));
        jPanel6.setMinimumSize(new java.awt.Dimension(338, 162));
        jPanel6.setPreferredSize(new java.awt.Dimension(338, 162));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        imgEscolhida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgEscolhida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/plus.png"))); // NOI18N
        imgEscolhida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgEscolhida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgEscolhida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 103, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("<html><p>Adicione uma imagem que represente o seu negócio</p></html>");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, 340, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Pré-Visualização");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 319, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 103, 0), 1, true));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNomenovo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtNomenovo.setText("Nome");
        jPanel7.add(txtNomenovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 168, -1, -1));

        labelTelefone.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        labelTelefone.setText("Telefone: ");
        jPanel7.add(labelTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 197, -1, -1));

        labelEmail.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        labelEmail.setText("Email: ");
        jPanel7.add(labelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 224, -1, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        imgMostra.setBackground(new java.awt.Color(255, 255, 255));
        imgMostra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/banner-padrao.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(imgMostra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(imgMostra, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));

        txtEmailnovo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtEmailnovo.setText("...");
        jPanel7.add(txtEmailnovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 224, -1, -1));

        txtTelnovo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtTelnovo.setText("...");
        jPanel7.add(txtTelnovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 197, -1, -1));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 359, 339, 279));

        jButton1.setBackground(new java.awt.Color(255, 103, 0));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Próximo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 660, 235, 69));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 390, 760));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Foto do perfil");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 55, -1, -1));

        pWrapper.add(jPanel3, "Foto_banner");

        jScrollPane1.setBackground(new java.awt.Color(255, 103, 0));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel4.setBackground(new java.awt.Color(255, 103, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setMaximumSize(new java.awt.Dimension(390, 32767));
        jPanel9.setMinimumSize(new java.awt.Dimension(390, 860));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFinalizar.setBackground(new java.awt.Color(255, 103, 0));
        btnFinalizar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        jPanel9.add(btnFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 670, 235, 69));

        imgProdCad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgProdCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/plus.png"))); // NOI18N
        imgProdCad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 103, 0)));
        imgProdCad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        imgProdCad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgProdCadMouseClicked(evt);
            }
        });
        jPanel9.add(imgProdCad, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 40, 123, 130));

        btnProdEd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/edita.png"))); // NOI18N
        btnProdEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProdEdMouseClicked(evt);
            }
        });
        jPanel9.add(btnProdEd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

        txtProdNomeCad.setForeground(new java.awt.Color(255, 103, 0));
        txtProdNomeCad.setText("Nome");
        txtProdNomeCad.setToolTipText("Nome");
        txtProdNomeCad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProdNomeCadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProdNomeCadFocusLost(evt);
            }
        });
        jPanel9.add(txtProdNomeCad, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 40, 160, 26));

        txtProdPrecoCad.setForeground(new java.awt.Color(255, 103, 0));
        txtProdPrecoCad.setText("Preço");
        txtProdPrecoCad.setToolTipText("Uitilizar '.' para casa decimal");
        txtProdPrecoCad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProdPrecoCadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProdPrecoCadFocusLost(evt);
            }
        });
        jPanel9.add(txtProdPrecoCad, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 70, 160, 26));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtProdDescCad.setColumns(20);
        txtProdDescCad.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtProdDescCad.setForeground(new java.awt.Color(255, 103, 0));
        txtProdDescCad.setRows(5);
        txtProdDescCad.setText("Descrição....");
        txtProdDescCad.setToolTipText("Digite uma Breve Descrição do seu produto");
        txtProdDescCad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProdDescCadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProdDescCadFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(txtProdDescCad);

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 100, 160, 40));

        txtProdCategoriaCad.setForeground(new java.awt.Color(255, 103, 0));
        txtProdCategoriaCad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione uma Categoria...", "Salgado", "Doce", "Bebidas", "Bijuteria", " " }));
        jPanel9.add(txtProdCategoriaCad, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 144, 160, 26));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/close.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        jPanel1.setOpaque(false);

        jScrollPane3.setOpaque(false);

        tblProdCad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Preço R$", "Descrição", "Categoria", "Caminho"
            }
        ));
        tblProdCad.setOpaque(false);
        tblProdCad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdCadMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProdCad);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 350, 270));

        btnOrdernarPrecCad.setBackground(new java.awt.Color(255, 103, 0));
        btnOrdernarPrecCad.setText("Ordernar por Preço");
        btnOrdernarPrecCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdernarPrecCadActionPerformed(evt);
            }
        });
        jPanel9.add(btnOrdernarPrecCad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        btnProdCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/plus-produto.png"))); // NOI18N
        btnProdCad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProdCadMouseClicked(evt);
            }
        });
        jPanel9.add(btnProdCad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 390, 760));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cadastrar Produtos");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jScrollPane1.setViewportView(jPanel4);

        pWrapper.add(jScrollPane1, "cadProd");

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

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename=f.getAbsolutePath();
        if(filename.endsWith(".png") || filename.endsWith(".jpg")){
            try {
                BufferedImage image = ImageIO.read(f);
                
                String imageName = "src/Banco_img/"+vend.getId()+"_banner.png";
                ImageIcon icon = new ImageIcon(imageName);
                ImageIO.write(image, "png",new File(imageName));
                icon.getImage().flush();
                vend.setImg(imageName);
                setImagem(imgEscolhida, imageName);
                setImagem(imgMostra, imageName);
            } catch (IOException ex) {
                Logger.getLogger(frmVendedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tipo de Arquivo deve ser .jpg ou .png");
        }
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        vend.AtualizarImg();
        CardLayout cl = (CardLayout) pWrapper.getLayout();
        cl.show(pWrapper, "cadProd");
        this.consultarProdutosCad();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        frmMapaVendedor frm = new frmMapaVendedor();
        frm.vend.setarIdVendedor(vend.getId());
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void imgProdCadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgProdCadMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename=f.getAbsolutePath();
        if(filename.endsWith(".png") || filename.endsWith(".jpg")){
            try {
                BufferedImage image = ImageIO.read(f);

                String imageName = "src/Banco_img/"+vend.getId()+"_Prod.png";
                ImageIcon icon = new ImageIcon(imageName);
                ImageIO.write(image, "png",new File(imageName));
                icon.getImage().flush();
                prod.setImg(imageName);
                setImagem(imgProdCad, imageName);
            } catch (IOException ex) {
                Logger.getLogger(frmVendedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tipo de Arquivo deve ser .jpg ou .png");
        }
    }//GEN-LAST:event_imgProdCadMouseClicked

    private void btnProdEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdEdMouseClicked
        prod.setNome(txtProdNomeCad.getText());
        prod.setValor(Float.parseFloat(txtProdPrecoCad.getText()));
        prod.setDesc(txtProdDescCad.getText());
        prod.setId_vend(vend.getId());
        prod.setId_cat(txtProdCategoriaCad.getSelectedIndex());
        cat.setId(prod.getId_cat());
        //prod.cadastrarProdutos();

        //prod.pegarCodProd();
        String nomeArquivo = "src/Banco_img/"+vend.getId()+"_"+prod.getId()+"_Prod.png";

        try {
            Files.move(new File(prod.getImg()).toPath(), new File(nomeArquivo).toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            prod.setImg(nomeArquivo);
            prod.inserirImgProduto();
        } catch (IOException ex) {
            Logger.getLogger(frmVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        prod.editarProdutos();

        txtProdNomeCad.setText("Nome");
        txtProdPrecoCad.setText("Preço");
        txtProdDescCad.setText("Descrição...");
        txtProdCategoriaCad.setSelectedIndex(0);

        ImageIcon image = new ImageIcon("src/Imagens/plus.png");
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH));
        imgProdCad.setIcon(icon);

        this.consultarProdutosCad();
    }//GEN-LAST:event_btnProdEdMouseClicked

    private void txtProdNomeCadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProdNomeCadFocusGained
        if(txtProdNomeCad.getText().equals("Nome")){
            txtProdNomeCad.setText("");
        }
    }//GEN-LAST:event_txtProdNomeCadFocusGained

    private void txtProdNomeCadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProdNomeCadFocusLost
        if(txtProdNomeCad.getText().equals("")){
            txtProdNomeCad.setText("Nome");
        }
    }//GEN-LAST:event_txtProdNomeCadFocusLost

    private void txtProdPrecoCadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProdPrecoCadFocusGained
        if(txtProdPrecoCad.getText().equals("Preço")){
            txtProdPrecoCad.setText("");
        }
    }//GEN-LAST:event_txtProdPrecoCadFocusGained

    private void txtProdPrecoCadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProdPrecoCadFocusLost
        if(txtProdPrecoCad.getText().equals("")){
            txtProdPrecoCad.setText("Preço");
        }
    }//GEN-LAST:event_txtProdPrecoCadFocusLost

    private void txtProdDescCadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProdDescCadFocusGained
        if(txtProdDescCad.getText().equals("Descrição....")){
            txtProdDescCad.setText("");
        }
    }//GEN-LAST:event_txtProdDescCadFocusGained

    private void txtProdDescCadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProdDescCadFocusLost
        if(txtProdDescCad.getText().equals("")){
            txtProdDescCad.setText("Descrição....");
        }
    }//GEN-LAST:event_txtProdDescCadFocusLost

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        prod.deletarProduto();

        txtProdNomeCad.setText("Nome");
        txtProdPrecoCad.setText("Preço");
        txtProdDescCad.setText("Descrição....");
        txtProdCategoriaCad.setSelectedIndex(0);

        ImageIcon image = new ImageIcon("src/Imagens/plus.png");
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH));
        imgProdCad.setIcon(icon);

        this.consultarProdutosCad();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void tblProdCadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdCadMouseClicked
        int linhaselecionada = tblProdCad.getSelectedRow();

        prod.setId(Integer.parseInt(tblProdCad.getValueAt(linhaselecionada, 0).toString()));
        txtProdNomeCad.setText(tblProdCad.getValueAt(linhaselecionada, 1).toString());
        txtProdPrecoCad.setText(tblProdCad.getValueAt(linhaselecionada, 2).toString());
        txtProdDescCad.setText(tblProdCad.getValueAt(linhaselecionada, 3).toString());
        txtProdCategoriaCad.setSelectedIndex(Integer.parseInt(tblProdCad.getValueAt(linhaselecionada, 4).toString()));
        setImagem(imgProdCad, tblProdCad.getValueAt(linhaselecionada, 5).toString());
        prod.setImg(tblProdCad.getValueAt(linhaselecionada, 5).toString());
    }//GEN-LAST:event_tblProdCadMouseClicked

    private void btnOrdernarPrecCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdernarPrecCadActionPerformed
        ArrayList<Tabela_Produto> arrayProd;
        DefaultTableModel modelo = (DefaultTableModel) tblProdCad.getModel();
        modelo.setNumRows(0);

        arrayProd = this.ordenarProd();
        int i = 0;
        int j = arrayProd.size();
        //id, nome_usuario, login_usuario, senha_usuario, cpf, email, telefone, dt_nasc, dt_criacao
        do{
            //int id = tabela.get(i).getId();
            modelo.addRow(new String[]{
                String.valueOf(arrayProd.get(i).getId()),
                //id.toString(),
                String.valueOf(arrayProd.get(i).getNome()),
                String.valueOf(arrayProd.get(i).getValor()),
                String.valueOf(arrayProd.get(i).getDesc()),
                String.valueOf(arrayProd.get(i).getCategoria()),
                String.valueOf(arrayProd.get(i).getImg())});
        i++;
        }while(i < j);
    }//GEN-LAST:event_btnOrdernarPrecCadActionPerformed

    private void btnProdCadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdCadMouseClicked
        prod.setNome(txtProdNomeCad.getText());
        prod.setValor(Float.parseFloat(txtProdPrecoCad.getText()));
        prod.setDesc(txtProdDescCad.getText());
        prod.setId_vend(vend.getId());
        prod.setId_cat(txtProdCategoriaCad.getSelectedIndex());
        cat.setId(prod.getId_cat());
        prod.cadastrarProdutos();

        prod.pegarCodProd();
        String nomeArquivo = "src/Banco_img/"+vend.getId()+"_"+prod.getId()+"_Prod.png";

        try {
            Files.move(new File(prod.getImg()).toPath(), new File(nomeArquivo).toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            prod.setImg(nomeArquivo);
            prod.inserirImgProduto();
        } catch (IOException ex) {
            Logger.getLogger(frmVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtProdNomeCad.setText("Nome");
        txtProdPrecoCad.setText("Preço");
        txtProdDescCad.setText("Descrição...");
        txtProdCategoriaCad.setSelectedIndex(0);

        ImageIcon image = new ImageIcon("src/Imagens/plus.png");
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH));
        imgProdCad.setIcon(icon);

        this.consultarProdutosCad();
    }//GEN-LAST:event_btnProdCadMouseClicked

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
            java.util.logging.Logger.getLogger(frmVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JToggleButton btnOrdernarPrecCad;
    private javax.swing.JLabel btnProdCad;
    private javax.swing.JLabel btnProdEd;
    private javax.swing.JLabel imgEscolhida;
    private javax.swing.JLabel imgMostra;
    private javax.swing.JLabel imgProdCad;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelTelefone;
    public javax.swing.JPanel pWrapper;
    private javax.swing.JTable tblProdCad;
    private javax.swing.JLabel txtEmailnovo;
    private javax.swing.JLabel txtNomenovo;
    private javax.swing.JComboBox txtProdCategoriaCad;
    private javax.swing.JTextArea txtProdDescCad;
    private javax.swing.JTextField txtProdNomeCad;
    private javax.swing.JTextField txtProdPrecoCad;
    private javax.swing.JLabel txtTelnovo;
    // End of variables declaration//GEN-END:variables
}
