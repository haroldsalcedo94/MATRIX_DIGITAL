
package INICIO;
import static INICIO.Login.URL;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;
public class Bienvenida extends javax.swing.JFrame {
public Timer objetotimer;
public int a;
String Raiz="";


    public Bienvenida() {
        initComponents();
         this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMAGENES/Ardulab_Firma150.png")));
         Bienvenida.this.setBackground(new Color(0,0,0,0));
        this.setLocationRelativeTo(null);      
          objetotimer = new Timer(15,new claseTimer());
        objetotimer.start();
        INICIO();
        
    }
void INICIO(){
    
       jLOGO.setIcon(new ImageIcon(URL+"shield2.png"));
    jFONDO.setIcon(new ImageIcon(URL+"transparente_2.png"));
    jNOMBRE.setText(Login.NOMBRE_USER);
}
    
    ///////////////////////////////
        public class claseTimer implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          a=jProgressBar1.getValue();
          if (a <100){
              a++;
              jProgressBar1.setValue(a);
               }
         else{
              objetotimer.stop();
              
              if(Login.TIPO==1){                  
                   VISTA.Menu ingreso = new VISTA.Menu();
                   ingreso.setVisible(true);
                   ingreso.pack();                   
                   dispose();
                  
              }
               if(Login.TIPO==2){
                   VISTA.Menu ingreso = new VISTA.Menu();
                   ingreso.setVisible(true);                 
                   ingreso.pack();                   
                   dispose(); 
                  
                 
              }
               if(Login.TIPO==3){                  
                   VISTA.Menu ingreso = new VISTA.Menu();
                   ingreso.setVisible(true);
                   ingreso.pack();                   
                   dispose();
                 
              }
              
             // JOptionPane.showMessageDialog(null, "Bienvenido ");
                  //  Login ingreso = new Login();
                   // ingreso.setVisible(true);
                  //  ingreso.pack();
                  // P_Administrador.lblusu.setText(USUARIO);
                   // dispose();
                    
          }                  
         
        }
    
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jNOMBRE = new javax.swing.JLabel();
        jLOGO = new javax.swing.JLabel();
        jFONDO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        setMinimumSize(new java.awt.Dimension(480, 258));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(480, 258));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jProgressBar1.setStringPainted(true);
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 440, 20));

        jNOMBRE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jNOMBRE.setForeground(new java.awt.Color(204, 0, 0));
        jNOMBRE.setText("NOMBRE");
        getContentPane().add(jNOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 310, -1));

        jLOGO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLOGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 150));
        getContentPane().add(jFONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 440, 178));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Bienvenida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jFONDO;
    private javax.swing.JLabel jLOGO;
    public static javax.swing.JLabel jNOMBRE;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
