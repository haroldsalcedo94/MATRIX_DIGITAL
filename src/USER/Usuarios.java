
package USER;

import BD.Conexion;
import VISTA.Menu;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public final class Usuarios extends javax.swing.JInternalFrame {
DefaultTableModel modelo;

String idfila="",codU="";
FileInputStream fi;  

    public Usuarios() throws FileNotFoundException {
        initComponents();
    
        mostrarusuarios();
    
       // Generarnumeracion();
        Usuarios.this.setBackground(new Color(0,0,0,0));//transparencia total
        
        
    }

   void mostrarusuarios() {
   String [] titulos= {"ID","NOMBRE","TIPO USUARIO","NOMBRE/C"};
   modelo=new  DefaultTableModel(null,titulos);   
   String datos []= new String[4];
   String sql="SELECT IdLogin,Nick,TipoUsuario,nombreCompleto FROM  login"; 
        try {
            
             Connection cc = Conexion.getConexion(); 
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                
                datos[0]=rs.getString("IdLogin");
                datos[1]=rs.getString("Nick");
                datos[2]= rs.getString("TipoUsuario");
                datos[3]= rs.getString("nombreCompleto");
                
                modelo.addRow(datos);
            }
            Conexion.close(cc);
            tbusuario.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mneliminar = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbusuario = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnick = new javax.swing.JTextField();
        cbotipo = new javax.swing.JComboBox();
        txtpassw = new javax.swing.JPasswordField();
        txtNombreCompleto = new javax.swing.JTextField();
        btnregistrar = new javax.swing.JButton();
        Jid = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jPopupMenu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        mneliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        mneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/eliminar_1.png"))); // NOI18N
        mneliminar.setText("Eliminar");
        mneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mneliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mneliminar);

        setClosable(true);
        setTitle("REGISTRO CUENTA");
        setMaximumSize(new java.awt.Dimension(906, 605));
        setMinimumSize(new java.awt.Dimension(906, 605));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(906, 605));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbusuario = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tbusuario.setBackground(new java.awt.Color(0, 0, 0));
        tbusuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tbusuario.setForeground(new java.awt.Color(255, 255, 255));
        tbusuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbusuario.setComponentPopupMenu(jPopupMenu1);
        tbusuario.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(tbusuario);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 840, 250));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 860, 270));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("USUARIO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 70, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("NOMBRE COMPLETO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 340, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("TIPO/USER");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 90, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("CLAVE:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 70, 20));

        txtnick.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnickActionPerformed(evt);
            }
        });
        txtnick.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnickKeyTyped(evt);
            }
        });
        jPanel1.add(txtnick, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 140, -1));

        cbotipo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbotipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuario", "Administrador" }));
        jPanel1.add(cbotipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 117, -1));

        txtpassw.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpassw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswActionPerformed(evt);
            }
        });
        txtpassw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpasswKeyTyped(evt);
            }
        });
        jPanel1.add(txtpassw, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 140, -1));

        txtNombreCompleto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreCompleto.setForeground(new java.awt.Color(0, 0, 102));
        txtNombreCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCompletoActionPerformed(evt);
            }
        });
        txtNombreCompleto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCompletoKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 380, 25));

        btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Autorizante50x50.png"))); // NOI18N
        btnregistrar.setToolTipText("");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 60, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 420, 260));

        Jid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Jid.setForeground(new java.awt.Color(204, 0, 0));
        Jid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Jid.setText("ID");
        getContentPane().add(Jid, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 30));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/U_principal.png"))); // NOI18N
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 130, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

     
    
    void eliminarUsuario(){
  try {
            Connection cc = Conexion.getConexion();  
            PreparedStatement pst = cc.prepareStatement("DELETE FROM login WHERE IdLogin='"+codU+"'");
            pst.executeUpdate();
            mostrarusuarios();
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } 
}
    
    
private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
    
    String ins="INSERT INTO login (Nick, Password,TipoUsuario,nombreCompleto) VALUES(?,?,?,?)";
         
        try {
            
            Connection cc = Conexion.getConexion(); 
            PreparedStatement pst = cc.prepareStatement(ins);
            
            pst.setString(1, txtnick.getText());
            pst.setString(2,new String(txtpassw.getPassword()));
            pst.setString(3, cbotipo.getSelectedItem().toString());            
            pst.setString(4, txtNombreCompleto.getText());
           
            
            
            int n= pst.executeUpdate();
            if(n>0)
            {
                JOptionPane.showMessageDialog(this, "Se Guardaron los Datos");
                mostrarusuarios();
                txtnick.setText(null);
                txtpassw.setText(null);
                cbotipo.setSelectedIndex(0);
                txtNombreCompleto.setText(null);
              
            }
            else
            {
                 JOptionPane.showMessageDialog(this, "Error");
            }
            Conexion.close(cc);
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de Registro");
        }

}//GEN-LAST:event_btnregistrarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
      Menu.seis = false;
     
    }//GEN-LAST:event_formInternalFrameClosed

    private void txtnickKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnickKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE))
            
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtnickKeyTyped

    private void txtpasswKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswKeyTyped
         char car = evt.getKeyChar();
        if((car<'0' || car>'9') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE))
            
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtpasswKeyTyped

    private void txtNombreCompletoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCompletoKeyTyped
         char car = evt.getKeyChar();
        if((car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE))
            
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreCompletoKeyTyped

    private void txtnickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnickActionPerformed
        txtnick.requestFocus();
        txtnick.transferFocus(); 
    }//GEN-LAST:event_txtnickActionPerformed

    private void txtpasswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswActionPerformed
        txtpassw.requestFocus();
        txtpassw.transferFocus(); 
    }//GEN-LAST:event_txtpasswActionPerformed

    private void mneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mneliminarActionPerformed
       int fila= tbusuario.getSelectedRow();   
       // codU=tbusuario.getValueAt(fila, 0).toString();
    codU=tbusuario.getValueAt(fila, 0).toString();
    Jid.setText(codU);
    if(fila>=0)
    {
    
     eliminarUsuario();
   
    }
    else
    {
        JOptionPane.showMessageDialog(this, "No ha selecionada ninguna fila");
    }

    }//GEN-LAST:event_mneliminarActionPerformed

    private void txtNombreCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCompletoActionPerformed
        txtNombreCompleto.requestFocus();
        txtNombreCompleto.transferFocus(); 
    }//GEN-LAST:event_txtNombreCompletoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jid;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JComboBox cbotipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mneliminar;
    private javax.swing.JTable tbusuario;
    private javax.swing.JTextField txtNombreCompleto;
    private javax.swing.JTextField txtnick;
    private javax.swing.JPasswordField txtpassw;
    // End of variables declaration//GEN-END:variables
  
}