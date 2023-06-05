/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacao;

import Modelagem.Produto;
import Modelagem.Usuario;
import Modelagem.Vendedor;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
public class frmCliente extends javax.swing.JFrame {

    /**
     * Creates new form frmCliente
     */
    public frmCliente() {
        initComponents();
    }
    
    Vendedor vend = new Vendedor();
    Usuario usu = new Usuario();
    Produto prod = new Produto();
    
    /*public double getDistanceBetweenPointsNew(double latitude1, double longitude1, double latitude2, double longitude2, String unit) {
    double theta = longitude1 - longitude2;
    double distance = 60 * 1.1515 * (180/Math.PI) * Math.acos(
        Math.sin(latitude1 * (Math.PI/180)) * Math.sin(latitude2 * (Math.PI/180)) + 
        Math.cos(latitude1 * (Math.PI/180)) * Math.cos(latitude2 * (Math.PI/180)) * Math.cos(theta * (Math.PI/180))
    );
    if (unit.equals("miles")) {
        return Math.round(distance, 2);
    } else if (unit.equals("kilometers")) {
        return Math.round(distance * 1.609344, 2);
    } else {
        return 0;
    }
}*/
    
    public void adicionarVendProx(){
        ResultSet rs = vend.consultaVendedores();
        vendedoresProx.removeAll();

        // Define o layout para o painel panelProd
        vendedoresProx.setLayout(new FlowLayout(FlowLayout.LEFT));
        int t = 250;
        try {
            // Loop para adicionar os painéis com as labels
            
            do{
                int idVendedor = Integer.parseInt(rs.getString(1));
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                // Label à esquerda com imagem
                JLabel leftLabel = new JLabel();
                leftLabel.setPreferredSize(new Dimension(120, 70));
                panel.add(leftLabel);
                
                JPanel rightPanel = new JPanel();
                rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
                rightPanel.setBorder(new EmptyBorder(5, 60, 5, 60));
                rightPanel.setBackground(new java.awt.Color(255,255,255));
                panel.add(rightPanel);
                // Painel para as labels à direita
                //JPanel rightPanel = new JPanel(new GridLayout(3, 1, 0, 10));
                JLabel nomeVend = new JLabel();
                nomeVend.setSize(new Dimension(120,22));
                
                nomeVend.setForeground(new java.awt.Color(92,172,14));
                nomeVend.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                nomeVend.setFont(new java.awt.Font("Arial", 1, 14));
                nomeVend.setText(rs.getString(2));
                
                JLabel distVend = new JLabel();
                distVend.setSize(new Dimension(120,22));
                distVend.setForeground(new java.awt.Color(92,172,14));
                distVend.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                distVend.setFont(new java.awt.Font("Arial", 1, 14));
                distVend.setText(t+"m");
                t+=250;
                
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
                }
            });
                
                panel.add(nomeVend);
                panel.add(distVend);
                
                panel.setBackground(new java.awt.Color(255, 255, 255));
                
                vendedoresProx.add(panel);
                //System.out.println(vend.getImg());
                if(rs.getString(10) == null){
                    setImagemVend(leftLabel, "src/Imagens/banner-padrao.png");
                }else{
                    setImagemVend(leftLabel, rs.getString(10));
                }
                
            }while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(frmMenuVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Atualiza o painel panelProd
        vendedoresProx.revalidate();
        vendedoresProx.repaint();
    }
    private void setImagem(JLabel txt, String caminhoImg){
        ImageIcon image = new ImageIcon(caminhoImg);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(txt.getWidth(),txt.getHeight(),Image.SCALE_SMOOTH));
        txt.setIcon(icon);
        this.repaint();
    }
    
    private void setImagemVend(JLabel txt, String caminhoImg){
        ImageIcon image = new ImageIcon(caminhoImg);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(120,70,Image.SCALE_SMOOTH));
        txt.setIcon(icon);
        this.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vendedoresProx = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Historico = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnSalgado = new javax.swing.JLabel();
        btnDoce = new javax.swing.JLabel();
        btnBijuteria = new javax.swing.JLabel();
        btnBebida = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnMapa = new javax.swing.JMenuItem();
        btnInicio = new javax.swing.JMenuItem();
        btnSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cliente");
        setMaximumSize(new java.awt.Dimension(390, 876));
        setMinimumSize(new java.awt.Dimension(390, 876));
        setPreferredSize(new java.awt.Dimension(390, 876));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 103, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(390, 876));
        jPanel1.setMinimumSize(new java.awt.Dimension(390, 876));
        jPanel1.setPreferredSize(new java.awt.Dimension(390, 876));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(390, 876));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Vendedores Próximos a Você");

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        vendedoresProx.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout vendedoresProxLayout = new javax.swing.GroupLayout(vendedoresProx);
        vendedoresProx.setLayout(vendedoresProxLayout);
        vendedoresProxLayout.setHorizontalGroup(
            vendedoresProxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        vendedoresProxLayout.setVerticalGroup(
            vendedoresProxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(vendedoresProx);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Histórico");

        jScrollPane2.setBorder(null);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(396, 127));

        Historico.setBackground(new java.awt.Color(255, 255, 255));
        Historico.setMaximumSize(new java.awt.Dimension(390, 876));

        javax.swing.GroupLayout HistoricoLayout = new javax.swing.GroupLayout(Historico);
        Historico.setLayout(HistoricoLayout);
        HistoricoLayout.setHorizontalGroup(
            HistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        HistoricoLayout.setVerticalGroup(
            HistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(Historico);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnSalgado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salgado.png"))); // NOI18N
        btnSalgado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalgadoMouseClicked(evt);
            }
        });

        btnDoce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/doce.png"))); // NOI18N
        btnDoce.setText("Doce");
        btnDoce.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoceMouseClicked(evt);
            }
        });

        btnBijuteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bijuteria.png"))); // NOI18N
        btnBijuteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBijuteriaMouseClicked(evt);
            }
        });

        btnBebida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bebida.png"))); // NOI18N
        btnBebida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBebidaMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Salgado");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Doce");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Bijuteria");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Bebidas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSalgado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBebida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBijuteria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDoce, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(49, 49, 49)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalgado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDoce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBebida)
                    .addComponent(btnBijuteria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)))
        );

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Categorias");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

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

        btnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisa.png"))); // NOI18N
        btnPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisaMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pesquisa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisa)
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisa)))
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisaMouseClicked
        if(!txtPesquisa.equals("")||!txtPesquisa.equals("Pesquise Aqui...")){
            frmPesquisa frm = new frmPesquisa();
            frm.usu.setarIdCliente(usu.getId());
            ResultSet rs;
            rs = prod.consultarNomeProd(txtPesquisa.getText());
            frm.adicionarPaineis(rs);
            frm.setVisible(true);
            dispose();
        }else{
            
        }
    }//GEN-LAST:event_btnPesquisaMouseClicked

    private void btnSalgadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalgadoMouseClicked
        frmPesquisa frm = new frmPesquisa();
        frm.usu.setarIdCliente(usu.getId());
        ResultSet rs;
        rs = prod.consultarCategoria(1);
        frm.adicionarPaineis(rs);
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSalgadoMouseClicked

    private void btnDoceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoceMouseClicked
        frmPesquisa frm = new frmPesquisa();
        frm.usu.setarIdCliente(usu.getId());
        ResultSet rs;
        rs = prod.consultarCategoria(2);
        frm.adicionarPaineis(rs);
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDoceMouseClicked

    private void btnBebidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBebidaMouseClicked
       frmPesquisa frm = new frmPesquisa();
        frm.usu.setarIdCliente(usu.getId());
        ResultSet rs;
        rs = prod.consultarCategoria(3);
        frm.adicionarPaineis(rs);
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBebidaMouseClicked

    private void btnBijuteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBijuteriaMouseClicked
        frmPesquisa frm = new frmPesquisa();
        frm.usu.setarIdCliente(usu.getId());
        ResultSet rs;
        rs = prod.consultarCategoria(4);
        frm.adicionarPaineis(rs);
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBijuteriaMouseClicked

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
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Historico;
    private javax.swing.JLabel btnBebida;
    private javax.swing.JLabel btnBijuteria;
    private javax.swing.JLabel btnDoce;
    private javax.swing.JMenuItem btnInicio;
    private javax.swing.JMenuItem btnMapa;
    private javax.swing.JLabel btnPesquisa;
    private javax.swing.JMenuItem btnSair;
    private javax.swing.JLabel btnSalgado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JPanel vendedoresProx;
    // End of variables declaration//GEN-END:variables
}
