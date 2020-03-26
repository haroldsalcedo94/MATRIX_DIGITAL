
package VISTA;

import BD.Conexion;
import static INICIO.Login.ADMIN;
import static INICIO.Login.CAJA;
import static INICIO.Login.ELIMINAR;
import static INICIO.Login.MODIFICAR;
import static INICIO.Login.NOMBRE_USER;
import static INICIO.Login.PESAJE;
import static INICIO.Login.REGISTRO;
import static INICIO.Login.URL;
import java.awt.Component;
import java.awt.Point;
import static java.awt.SystemColor.menu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Menu extends javax.swing.JFrame  {
    public static ImageIcon IconA = new ImageIcon(URL+"shield.png");
    public static ImageIcon Icon0 = new ImageIcon(URL+"Salir_x30.png");
    public static ImageIcon Icon1 = new ImageIcon(URL+"Eliminar_x30.png");
    public static ImageIcon Icon2 = new ImageIcon(URL+"Guardar_x30.png");
    public static String NOMBRE_EMP="",DIR_EMP="",TEL_EMP="",NIT_EMP="",REG_EMP="",CIU_EMP="",DEP_EMP="";
    public static boolean P1=false,P2=false,P3=false,P4=false,P5=false;
    
    public Menu() {
        initComponents();
         
        /////////////
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMAGENES/Ardulab_Firma150.png")));
      //  AWTUtilities.setWindowOpaque(this, false);
        this.setLocationRelativeTo(null);
       //  java.awt.Shape forma = new java.awt.geom.RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30); 
       // com.sun.awt.AWTUtilities.setWindowShape(this, forma); 
         
         inicio(); 
     ////////////////////////////////////////////////////////////////   
    }
       public void inicio(){
            
        lblusu.setText(NOMBRE_USER);
        jLogo.setIcon(new ImageIcon(URL+"Logoax80.png"));
        Mostrar_Empresa();
        
        if(PESAJE == 1){
            
        }
         if(CAJA == 1){
            
        }
          if(ADMIN == 1){
            
        }
           if(ELIMINAR == 1){
            
        }
            if(MODIFICAR == 1){
            
        }
           if(REGISTRO == 1){
            
        }

       } 
       
             void Mostrar_Empresa()
    {
     
        String Sql=" SELECT id,nom_emp,dir_emp,tel_emp,nit_emp,reg_emp,ciudad_emp,depart_emp  FROM empresa WHERE id = '1' " ;
       
        try {
            
            Connection cc = Conexion.getConexion();            
            Statement st = cc.createStatement();           
             ResultSet rs = st.executeQuery(Sql);
             
             if(rs.next())
             {
               
               NOMBRE_EMP=rs.getString("nom_emp");
               DIR_EMP=rs.getString("dir_emp");
               TEL_EMP=rs.getString("tel_emp");
               NIT_EMP=rs.getString("nit_emp");
               REG_EMP=rs.getString("reg_emp");
               CIU_EMP=rs.getString("ciudad_emp");
               DEP_EMP=rs.getString("depart_emp"); 
               j_Empresa.setText(NOMBRE_EMP);
               
             }
             else{
               NOMBRE_EMP="";
               DIR_EMP="";
               TEL_EMP="";
               NIT_EMP="";
               REG_EMP="";
               CIU_EMP="";
               DEP_EMP=""; 
               
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_Menu_Vehiculo = new javax.swing.JPopupMenu();
        mn_Placas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mn_Trans = new javax.swing.JMenuItem();
        BtnExit = new javax.swing.JButton();
        lblusu = new javax.swing.JLabel();
        btn_Informe = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLogo = new javax.swing.JLabel();
        j_Empresa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_Productos = new javax.swing.JButton();
        btn_Vehiculo = new javax.swing.JButton();
        btn_tercero = new javax.swing.JButton();
        btn_Pesaje = new javax.swing.JButton();

        jP_Menu_Vehiculo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        mn_Placas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        mn_Placas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/placa_x30.png"))); // NOI18N
        mn_Placas.setText("Placa");
        mn_Placas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_PlacasActionPerformed(evt);
            }
        });
        jP_Menu_Vehiculo.add(mn_Placas);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jP_Menu_Vehiculo.add(jSeparator1);

        mn_Trans.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        mn_Trans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/trans_x30.png"))); // NOI18N
        mn_Trans.setText("Transportadora");
        mn_Trans.setToolTipText("");
        mn_Trans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_TransActionPerformed(evt);
            }
        });
        jP_Menu_Vehiculo.add(mn_Trans);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MENU");
        setIconImages(null);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(818, 536));
        setPreferredSize(new java.awt.Dimension(818, 536));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnExit.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BtnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Salir_x30.png"))); // NOI18N
        BtnExit.setText("Salir");
        BtnExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnExit.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnExit.setIconTextGap(20);
        BtnExit.setMaximumSize(new java.awt.Dimension(60, 60));
        BtnExit.setMinimumSize(new java.awt.Dimension(60, 60));
        BtnExit.setPreferredSize(new java.awt.Dimension(60, 60));
        BtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExitActionPerformed(evt);
            }
        });
        getContentPane().add(BtnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, 140, 50));

        lblusu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblusu.setText("USUARIO");
        getContentPane().add(lblusu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 760, 30));

        btn_Informe.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Informe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/informe_x30.png"))); // NOI18N
        btn_Informe.setText("INFORME");
        btn_Informe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Informe.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_Informe.setIconTextGap(20);
        btn_Informe.setMaximumSize(new java.awt.Dimension(60, 60));
        btn_Informe.setMinimumSize(new java.awt.Dimension(60, 60));
        btn_Informe.setPreferredSize(new java.awt.Dimension(60, 60));
        btn_Informe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InformeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Informe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 160, 50));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLogo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 80));

        j_Empresa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        j_Empresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        j_Empresa.setText("EMPRESA");
        j_Empresa.setToolTipText("");
        jPanel1.add(j_Empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 690, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema Automatico de Pesaje Con Indicador Matrix Digital");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 690, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 800, 100));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MENU PRINCIPAL");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 6, 790, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, 800, 40));

        btn_Productos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Config_x30.png"))); // NOI18N
        btn_Productos.setText("PRODUCTO");
        btn_Productos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Productos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_Productos.setIconTextGap(20);
        btn_Productos.setMaximumSize(new java.awt.Dimension(60, 60));
        btn_Productos.setMinimumSize(new java.awt.Dimension(60, 60));
        btn_Productos.setPreferredSize(new java.awt.Dimension(60, 60));
        btn_Productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProductosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 160, 50));

        btn_Vehiculo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Vehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/vehiculo_x30.png"))); // NOI18N
        btn_Vehiculo.setText("VEHICULO");
        btn_Vehiculo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Vehiculo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_Vehiculo.setIconTextGap(20);
        btn_Vehiculo.setMaximumSize(new java.awt.Dimension(60, 60));
        btn_Vehiculo.setMinimumSize(new java.awt.Dimension(60, 60));
        btn_Vehiculo.setPreferredSize(new java.awt.Dimension(60, 60));
        btn_Vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VehiculoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 160, 50));

        btn_tercero.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_tercero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Cliente_x30.png"))); // NOI18N
        btn_tercero.setText("TERCERO");
        btn_tercero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_tercero.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_tercero.setIconTextGap(20);
        btn_tercero.setMaximumSize(new java.awt.Dimension(60, 60));
        btn_tercero.setMinimumSize(new java.awt.Dimension(60, 60));
        btn_tercero.setPreferredSize(new java.awt.Dimension(60, 60));
        btn_tercero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_terceroActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tercero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 160, 50));

        btn_Pesaje.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Pesaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/vascula_x30.png"))); // NOI18N
        btn_Pesaje.setText("PESAJE");
        btn_Pesaje.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Pesaje.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_Pesaje.setIconTextGap(20);
        btn_Pesaje.setMaximumSize(new java.awt.Dimension(60, 60));
        btn_Pesaje.setMinimumSize(new java.awt.Dimension(60, 60));
        btn_Pesaje.setPreferredSize(new java.awt.Dimension(60, 60));
        btn_Pesaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PesajeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Pesaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 160, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExitActionPerformed
       
                int n = JOptionPane.showConfirmDialog(
            null,
            "Desea Salir....?",
            "¡Esta Seguro...!",
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, Icon0);

        if(n==1){

        }
        else {
            
               repaint();
            System.exit(0);
            }            
      
    }//GEN-LAST:event_BtnExitActionPerformed

    private void btn_InformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InformeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_InformeActionPerformed

    private void btn_ProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProductosActionPerformed
          
        if(P1 == false){
            P1=true;
             PRODUCTO.Alta_Producto in = new PRODUCTO.Alta_Producto();
            in.setVisible(true);
            in.pack();
            
        }
       
    }//GEN-LAST:event_btn_ProductosActionPerformed

    private void btn_VehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VehiculoActionPerformed
    
        showPopup(evt);
     
    }//GEN-LAST:event_btn_VehiculoActionPerformed

    private void btn_terceroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_terceroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_terceroActionPerformed

    private void btn_PesajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PesajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_PesajeActionPerformed

    private void mn_PlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_PlacasActionPerformed

  

    }//GEN-LAST:event_mn_PlacasActionPerformed

    private void mn_TransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_TransActionPerformed
    
         if(P2 == false){
            P2=true;
             VEHICULO.Alta_Transportadora in = new VEHICULO.Alta_Transportadora();
            in.setVisible(true);
            in.pack();
            
        }
  

    }//GEN-LAST:event_mn_TransActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnExit;
    private javax.swing.JButton btn_Informe;
    private javax.swing.JButton btn_Pesaje;
    private javax.swing.JButton btn_Productos;
    private javax.swing.JButton btn_Vehiculo;
    private javax.swing.JButton btn_tercero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLogo;
    private javax.swing.JPopupMenu jP_Menu_Vehiculo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel j_Empresa;
    public static javax.swing.JLabel lblusu;
    private javax.swing.JMenuItem mn_Placas;
    private javax.swing.JMenuItem mn_Trans;
    // End of variables declaration//GEN-END:variables


    
   private void showPopup(ActionEvent ae)
    {
        // Get the event source
        Component b=(Component)ae.getSource();
        
        // Get the location of the point 'on the screen'
        Point p = b.getLocationOnScreen();
        
        // Show the JPopupMenu via program
        
        // Parameter desc
        // ----------------
        // this - represents current frame
        // 0,0 is the co ordinate where the popup
        // is shown
        jP_Menu_Vehiculo.show(this,195,270);
        
        // Now set the location of the JPopupMenu
        // This location is relative to the screen
       // jP_Menu_Vehiculo.setLocation(p.x,p.y + b.getHeight());
    }
    
   



}

