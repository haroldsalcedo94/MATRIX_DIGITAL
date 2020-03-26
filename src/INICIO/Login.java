
package INICIO;

import java.awt.Color;
import javax.swing.JOptionPane;
import BD.Conexion;
import com.sun.glass.events.KeyEvent;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.util.Properties;
import javax.swing.ImageIcon;
import java.net.InetAddress;

import javax.swing.table.DefaultTableModel;


public class Login extends javax.swing.JFrame {
    
    public static int LINUX=0; 

 
    //WINDOWS
    public static String URL="C:\\MATRIX\\ICON\\";
    public static String URL_0="C:\\MATRIX\\"; 
   
    //LINUX
  // public static String URL="/home/porteria/NV_V/ICON/";
  //  public static String URL_0="/home/porteria/NV_V/"; 
  
    InetAddress ping; 
    public static String CODIGO_AD="",NOMBRE_USER="",TIPO_A="",DEP_CODIGO="",NOMBRE_DEP="",app="",color_id="",dia="",Lector="",Key_Voz="",Voz="",Del="",lv="",lem="";
    public static int TIPO,MODEL,CARNET,EMP,OB_SALIDA,VH,CAM,IP,IP_PING,RT,VOZ,LC,AMD,LV,LEM,NOV;
     public static int PESAJE,CAJA,ADMIN,ELIMINAR,MODIFICAR,REGISTRO;
   public static double CALCULO;
    String model="",carnet="",AP_TIPO="",emp="",ob_salida="",vh="",cam="",ip_ping="",rt="",voz="",lc="",amd="",nov="";
   public static  String ip_cam="";
  public static   String  tcam="";
   public static  int TCAM;
    DefaultTableModel modelo;
    ImageIcon Icon1 = new ImageIcon(URL+"U_principal.png");
    ImageIcon Icon2 = new ImageIcon(URL+"U_normal.png");
    ImageIcon Icon3 = new ImageIcon(URL+"R_Entradax60.png");
    ImageIcon Icon4 = new ImageIcon(URL+"R_Salidax60.png");
    ImageIcon Icon5 = new ImageIcon(URL+"AltaUsuariox60.png");
    ImageIcon Icon6 = new ImageIcon(URL+"R_Empleadox60.png");
    
    public Login() {
        initComponents();
          Login.this.setBackground(new Color(0,0,0,0)); 
           
       
        this.setLocationRelativeTo(null);
       // java.awt.Shape forma = new java.awt.geom.RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30); 
       // com.sun.awt.AWTUtilities.setWindowShape(this, forma); 
        // Config();     
        inicio();
    }
    
    
  void inicio(){
      this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMAGENES/Ardulab_Firma150.png")));
    
    
        
         j_logo_1.setIcon(new ImageIcon(URL+"Logo_1.png"));
     
  }
  
  void Config(){
        //
         Properties prop = new Properties();
	InputStream input = null;
	try {
		input = new FileInputStream(URL_0+"config.properties");
		// load a properties file
		prop.load(input);
		
               
            //   calculo=prop.getProperty("TIPO");
              //  CALCULO = Double.parseDouble(calculo);
               
               model=prop.getProperty("MODEL");
               MODEL = Integer.parseInt(model); 
                
                carnet=prop.getProperty("CARNET");
                CARNET = Integer.parseInt(carnet); 
                
                AP_TIPO=prop.getProperty("AP_TIPO");
                  
                emp=prop.getProperty("EMP");
                EMP = Integer.parseInt(emp); 
                
                ob_salida=prop.getProperty("OB_SALIDA");
                OB_SALIDA = Integer.parseInt(ob_salida); 
                
                 vh = prop.getProperty("VH");
                 VH = Integer.parseInt(vh);
                 
                  cam = prop.getProperty("CAM");
                 CAM = Integer.parseInt(cam);
                 
                  ip_cam = prop.getProperty("IP_CAM");
                 //IP = Integer.parseInt(ip);
              
                  ip_ping = prop.getProperty("IP_PING");
                //IP_PING = Integer.parseInt(ip_ping);
                
                 rt = prop.getProperty("RT");
                RT= Integer.parseInt(rt);
                
                voz = prop.getProperty("VOZ");
                 VOZ = Integer.parseInt(voz);
                
                   Key_Voz=prop.getProperty("KEY_VOZ");
                   
                    lc = prop.getProperty("LC");
                 LC = Integer.parseInt(lc);
                 
                   lv = prop.getProperty("LV");
                 LV = Integer.parseInt(lv);
                 
                  amd = prop.getProperty("ADM");
                 AMD = Integer.parseInt(amd);
                 
                 lem = prop.getProperty("LEM");
                 LEM = Integer.parseInt(lem);
                  nov = prop.getProperty("NOV");
                 NOV = Integer.parseInt(nov);
                 
               tcam=prop.getProperty("TCAM");
               TCAM = Integer.parseInt(tcam); 
                
               
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        //// 
  }

  
 
  
  void LOGIN(){
       String usu=txtNombre.getText();
        String pas=new String(txtClave.getPassword());
        acceder(usu, pas);
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        j_logo_1 = new javax.swing.JLabel();
        P_login = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        bntLogin = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        j_Id = new javax.swing.JLabel();
        j_Nombre = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        j_logo_1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        j_logo_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(j_logo_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 160, 160));

        P_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(null);
        txtNombre.setMinimumSize(new java.awt.Dimension(100, 25));
        txtNombre.setPreferredSize(new java.awt.Dimension(100, 25));
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtNombreMouseEntered(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        P_login.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 250, 25));

        txtClave.setBackground(new java.awt.Color(0, 0, 0));
        txtClave.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtClave.setForeground(new java.awt.Color(255, 255, 255));
        txtClave.setBorder(null);
        txtClave.setMinimumSize(new java.awt.Dimension(100, 25));
        txtClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtClaveMouseEntered(evt);
            }
        });
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        P_login.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 250, 25));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("USUARIO");
        P_login.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("PASSWORD");
        P_login.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        P_login.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 250, 10));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        P_login.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 250, 10));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("INICIO DE SESION");
        P_login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        bntLogin.setBackground(new java.awt.Color(97, 212, 195));
        bntLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bntLogin.setForeground(new java.awt.Color(255, 255, 255));
        bntLogin.setText("INGRESAR");
        bntLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntLogin.setIconTextGap(1);
        bntLogin.setPreferredSize(new java.awt.Dimension(50, 50));
        bntLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bntLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bntLoginMouseExited(evt);
            }
        });
        bntLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLoginActionPerformed(evt);
            }
        });
        bntLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bntLoginKeyPressed(evt);
            }
        });
        P_login.add(bntLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 250, 40));

        btnsalir.setBackground(new java.awt.Color(255, 0, 0));
        btnsalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnsalir.setText("SALIR");
        btnsalir.setMaximumSize(new java.awt.Dimension(128, 37));
        btnsalir.setMinimumSize(new java.awt.Dimension(128, 37));
        btnsalir.setPreferredSize(new java.awt.Dimension(128, 37));
        btnsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsalirMouseExited(evt);
            }
        });
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        P_login.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 250, 40));

        j_Id.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        j_Id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        P_login.add(j_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 350, 30));

        j_Nombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        j_Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        P_login.add(j_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 350, 30));

        txtTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        P_login.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 160, 20));

        getContentPane().add(P_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 370, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

        txtNombre.requestFocus();
        txtNombre.transferFocus();
        Mostrar_Admin(txtNombre.getText());

    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed

        txtClave.requestFocus();
        txtClave.transferFocus();

    }//GEN-LAST:event_txtClaveActionPerformed
//////////////////////    
      void Mostrar_Admin(String valor)
    {
     
        String  Nombre="",Id="";       
       
        String Sql=" SELECT id,usuario,nombre FROM login WHERE usuario = '"+valor+"' " ;
       
        try {
            
            Connection cc = Conexion.getConexion();            
            Statement st = cc.createStatement();           
             ResultSet rs = st.executeQuery(Sql);
             
             if(rs.next())
             {
               
               Id=rs.getString("id");
               Nombre=rs.getString("nombre");              

               j_Nombre.setText("");              
               j_Id.setText("");

                j_Id.setText(Id);
               j_Nombre.setText(Nombre);
               
             }
             else{
               j_Nombre.setText("");              
               j_Id.setText("");
               
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
       
    
    
    
    
    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed

        System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void bntLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLoginActionPerformed

        String usu = txtNombre.getText();
        String pas  =  new String(txtClave.getPassword());
        acceder(usu, pas);

    }//GEN-LAST:event_bntLoginActionPerformed

    private void bntLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bntLoginKeyPressed

        if (evt.getKeyCode()== KeyEvent.VK_ENTER){

            String usu=txtNombre.getText();
            String pas=new String(txtClave.getPassword());
            acceder(usu, pas);

        }

    }//GEN-LAST:event_bntLoginKeyPressed

    private void btnsalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseEntered
      
         txtTitulo.setText("SALIR");
       
                                
    }//GEN-LAST:event_btnsalirMouseEntered

    private void btnsalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseExited
       
              txtTitulo.setText("");
         
                                
    }//GEN-LAST:event_btnsalirMouseExited

    private void bntLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntLoginMouseEntered
      
         txtTitulo.setText("INGRESAR");
        
    }//GEN-LAST:event_bntLoginMouseEntered

    private void bntLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntLoginMouseExited
      
         txtTitulo.setText("");
       
    }//GEN-LAST:event_bntLoginMouseExited

    private void txtNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseEntered
       txtTitulo.setText("USUARIO");
        
                                  
    }//GEN-LAST:event_txtNombreMouseEntered

    private void txtClaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClaveMouseEntered
        txtTitulo.setText("PASSWORD");
         
          
         
          Mostrar_Admin(txtNombre.getText());
    }//GEN-LAST:event_txtClaveMouseEntered
    
   
    /////
        void acceder(String usuario, String pass)
    {
     
       String sql=" SELECT id,usuario,clave,nombre,pesaje,caja,admin,eliminar,modificar,registro FROM login WHERE usuario = '"+usuario+"' && clave = '"+pass+"'";
       
        try {
            Connection cc = Conexion.getConexion();            
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next())                
            {
               
                NOMBRE_USER=rs.getString("nombre");
                PESAJE = rs.getInt("pesaje");
                CAJA = rs.getInt("caja");
                ADMIN = rs.getInt("admin");
                ELIMINAR = rs.getInt("eliminar");
                MODIFICAR = rs.getInt("modificar");
                REGISTRO = rs.getInt("registro");
                
                 this.setVisible(false);                    
                  VISTA.Menu ingreso = new VISTA.Menu();
                   ingreso.setVisible(true);
                   ingreso.pack();    
                
            }            
            
           else
            {
                JOptionPane.showMessageDialog(this, "Usuario No Registrado");
            }
            
            Conexion.close(cc);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
       

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel P_login;
    private javax.swing.JButton bntLogin;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel j_Id;
    private javax.swing.JLabel j_Nombre;
    private javax.swing.JLabel j_logo_1;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
