
package PRODUCTO;


import BD.Conexion;
import static INICIO.Login.ELIMINAR;
import static INICIO.Login.MODIFICAR;
import static INICIO.Login.REGISTRO;
import static VISTA.Menu.Icon1;
import static VISTA.Menu.Icon2;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public  class Alta_Producto extends javax.swing.JFrame {

    int NUEVO=0,ACTUALIZAR=0;
    DefaultTableModel modelo;
    public Alta_Producto() {
        initComponents();
          this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMAGENES/Ardulab_Firma150.png")));
      //  AWTUtilities.setWindowOpaque(this, false);
        this.setLocationRelativeTo(null);
        Bloqueo();
        Buscar_Pro("");
        
    }
    //hola
    void Bloqueo(){
        btn_Guardar.setEnabled(false);
        btn_Actualizar.setEnabled(false);
        btn_Cancelar.setEnabled(false);
        txt_Cod_Producto.setEnabled(false);
        txt_descripcion.setEnabled(false);
       jC_Iva.setEnabled(false);
        txt_Buscar.requestFocus();
       
    }
    
    void Desbloqueo_Nuevo(){
        
        btn_Guardar.setEnabled(true);
        btn_Actualizar.setEnabled(false);
        btn_Cancelar.setEnabled(true);
        txt_Cod_Producto.setEnabled(true);
        txt_descripcion.setEnabled(true);
       jC_Iva.setEnabled(true);
        txt_Cod_Producto.requestFocus();
          NUEVO=1;
    }
    
     void Desbloqueo_Actulizar(){
        
        btn_Guardar.setEnabled(false);
        btn_Actualizar.setEnabled(true);
        btn_Cancelar.setEnabled(true);
        txt_Cod_Producto.setEnabled(true);
        txt_descripcion.setEnabled(true);
        jC_Iva.setEnabled(true);
        txt_Cod_Producto.requestFocus();
        ACTUALIZAR=1;

    }
    
    void Limpiar(){
        txt_Cod_Producto.setText("");
        txt_descripcion.setText("");
         jC_Iva.setSelectedItem("SIN IVA");
        txt_Buscar.setText("");
        j_Cod.setText("");
       
    }
      
        void Buscar_Cod(String valor){
    String Sql="";
    
        Sql="SELECT cod_pro FROM producto WHERE cod_pro = '"+valor+"' ";
    
        try {
                Connection cc = Conexion.getConexion();            
            Statement st = cc.createStatement();           
             ResultSet rs = st.executeQuery(Sql);
              if(rs.next())
              {
                JOptionPane.showMessageDialog(this, "Codigo Existente"+" "
                + "Base De Datos");
                  
              }
              else{
                  Guardar(); 
              }
           
                 Conexion.close(cc);      
        } catch (SQLException ex) {
            Logger.getLogger(Alta_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    void Buscar_Pro(String valor){
    String Sql="";
    
        Sql="SELECT cod_pro,des,iva FROM producto WHERE CONCAT(cod_pro,des) LIKE '%"+valor+"%' ";
    
    
    
        
    String []titulos={"CODIGO","DESCRIPCION","IVA"};
    String []Registros=new String[3];
    modelo= new DefaultTableModel(null,titulos);
            
  
        try {
                Connection cc = Conexion.getConexion();            
            Statement st = cc.createStatement();           
             ResultSet rs = st.executeQuery(Sql);
              while(rs.next())
              {
                  Registros[0]= rs.getString("cod_pro");
                  Registros[1]= rs.getString("des");
                  int IVA = rs.getInt("iva");
                  if(IVA == 0){
                       Registros[2] = "SIN IVA";
                  }
                   if(IVA == 1){
                       Registros[2] = "CON IVA";
                  }
                  
                  
                           
                     
                  modelo.addRow(Registros);
              }
            jt_Producto.setModel(modelo);
            jt_Producto.getColumnModel().getColumn(0).setPreferredWidth(10);
            jt_Producto.getColumnModel().getColumn(1).setPreferredWidth(250);
            jt_Producto.getColumnModel().getColumn(2).setPreferredWidth(10);
            
            
                 Conexion.close(cc);      
        } catch (SQLException ex) {
            Logger.getLogger(Alta_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    void Guardar(){
     if (this.txt_Cod_Producto.getText().isEmpty()
        || this.txt_descripcion.getText().isEmpty()           
                  
        
        )

        {
            JOptionPane.showMessageDialog(this, "Todos Los Campos Son"+" "
                + "Obligatorios");
            return;

        }
           int nn = JOptionPane.showConfirmDialog(
            null,
            "Desea Guardar....?",
            "¡Esta Seguro...!",
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, Icon2);

        if(nn==1){

        }
        else {
    
        String sql="";
        String cod_pro=txt_Cod_Producto.getText();
        String des=txt_descripcion.getText();           
        String iva = (String) jC_Iva.getSelectedItem();         
        int IVA = 0;
        
        if(iva.equals("SIN IVA")){
            IVA = 0;
        }
         if(iva.equals("CON IVA")){
            IVA = 1;
        }
                
             
            sql="INSERT INTO producto(cod_pro,des,iva) VALUES (?,?,?)";
        try {
           
            Connection cc = Conexion.getConexion();        
            PreparedStatement pst  = cc.prepareStatement(sql);            
     
            pst.setString(1, cod_pro);
            pst.setString(2, des);
            pst.setInt(3, IVA);
           
            
            int n=pst.executeUpdate();
            
            if(n>0){
           // JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
            Limpiar();
            Bloqueo();
            NUEVO=0;
         
            }
            Buscar_Pro("");
        } catch (SQLException ex) {
            Logger.getLogger(Alta_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        }  
}
    
    void Actualizar(){
       try {
            String iva = (String) jC_Iva.getSelectedItem();   
         Connection cc = Conexion.getConexion();      
             
        PreparedStatement pst = cc.prepareStatement("UPDATE producto SET cod_pro='"+txt_Cod_Producto.getText()+"',des='"+txt_descripcion.getText()+"', iva = '"+iva+"' where cod_pro='"+j_Cod.getText()+"'"); 
       
        pst.executeUpdate();
        Buscar_Pro("");
        Limpiar();
        Bloqueo();
        ACTUALIZAR=0;

    } catch (Exception e) {
        System.out.print(e.getMessage());
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnmodificar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mneliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Cod_Producto = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        j_Cod = new javax.swing.JLabel();
        jC_Iva = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_Producto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_Buscar = new javax.swing.JTextField();
        btn_Nuevo = new javax.swing.JButton();
        btn_Guardar = new javax.swing.JButton();
        btn_Actualizar = new javax.swing.JButton();
        btn_Report = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();

        jPopupMenu1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        mnmodificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        mnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/actualizar_x30.png"))); // NOI18N
        mnmodificar.setText("Modificar");
        mnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnmodificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnmodificar);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPopupMenu1.add(jSeparator1);

        mneliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        mneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Eliminar_x30.png"))); // NOI18N
        mneliminar.setText("Eliminar");
        mneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mneliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mneliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRODUCTO");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(950, 640));
        setPreferredSize(new java.awt.Dimension(950, 640));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("IVA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 120, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("CODIGO PRODUCTO:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 120, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("DESCRIPCION:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 120, 20));

        txt_Cod_Producto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_Cod_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Cod_ProductoActionPerformed(evt);
            }
        });
        txt_Cod_Producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_Cod_ProductoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Cod_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 230, -1));

        txt_descripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descripcionActionPerformed(evt);
            }
        });
        txt_descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_descripcionKeyTyped(evt);
            }
        });
        jPanel1.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 530, -1));

        j_Cod.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(j_Cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 170, 30));

        jC_Iva.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jC_Iva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIN IVA", "CON IVA" }));
        jPanel1.add(jC_Iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 890, 100));

        jt_Producto = new org.jdesktop.swingx.JXTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jt_Producto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jt_Producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jt_Producto.setComponentPopupMenu(jPopupMenu1);
        jt_Producto.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(jt_Producto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 890, 310));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("BUSCAR:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 60, 20));

        txt_Buscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txt_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 330, -1));

        btn_Nuevo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/nuevo_x30.png"))); // NOI18N
        btn_Nuevo.setText("NUEVO");
        btn_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 130, 40));

        btn_Guardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Guardar_x30.png"))); // NOI18N
        btn_Guardar.setText("GUARDAR");
        btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 130, 40));

        btn_Actualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/actualizar_x30.png"))); // NOI18N
        btn_Actualizar.setText("ACTULIZAR");
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 130, 40));

        btn_Report.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/limpiar_x30.png"))); // NOI18N
        btn_Report.setText("CANCELAR");
        btn_Report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReportActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Report, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 130, 40));

        btn_Cancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/limpiar_x30.png"))); // NOI18N
        btn_Cancelar.setText("CANCELAR");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 130, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       VISTA.Menu.P1=false;
    }//GEN-LAST:event_formWindowClosed

    private void btn_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NuevoActionPerformed
      
        if(REGISTRO == 1){
             Desbloqueo_Nuevo();
        }
          if(REGISTRO == 0){
              JOptionPane.showMessageDialog(this, "Sin Permiso"+" "
                + "Administrador");
          }
       
    }//GEN-LAST:event_btn_NuevoActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        Limpiar();
        Bloqueo();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void txt_Cod_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Cod_ProductoActionPerformed
        txt_descripcion.requestFocus();
    }//GEN-LAST:event_txt_Cod_ProductoActionPerformed

    private void txt_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descripcionActionPerformed
        jC_Iva.requestFocus();
    }//GEN-LAST:event_txt_descripcionActionPerformed

    private void mnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnmodificarActionPerformed

          if(MODIFICAR == 1){
        int filamodificar= jt_Producto.getSelectedRow();
        if(filamodificar>=0)
        {
            Desbloqueo_Actulizar();
            Limpiar();            
             
            j_Cod.setText(jt_Producto.getValueAt(filamodificar, 0).toString());
            txt_Cod_Producto.setText(jt_Producto.getValueAt(filamodificar, 0).toString());
            txt_descripcion.setText(jt_Producto.getValueAt(filamodificar, 1).toString());
            String iva = jt_Producto.getValueAt(filamodificar, 2).toString();
             jC_Iva.setSelectedItem(iva);
            
        }
        else
        {
            JOptionPane.showMessageDialog(this,"No ha seleccionado ");
        }
          }
          
          if(MODIFICAR == 0){
             JOptionPane.showMessageDialog(this, "Sin Permiso"+" "
                + "Administrador");  
          }
          
          
    }//GEN-LAST:event_mnmodificarActionPerformed

    private void mneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mneliminarActionPerformed
       
         if(ELIMINAR == 1){
          int fila= jt_Producto.getSelectedRow();
        String cod="";
        cod=jt_Producto.getValueAt(fila, 0).toString();
        if(fila>=0)
        {
            int n = JOptionPane.showConfirmDialog(
                null,
                "Desea Borar....?",
                "¡Esta Seguro...!",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, Icon1);

            if(n==1){

            }
            else {

                try {
                    Connection cc = Conexion.getConexion();
                    PreparedStatement pst = cc.prepareStatement("DELETE FROM producto WHERE cod_pro='"+cod+"'");
                    pst.executeUpdate();
                    Buscar_Cod("");
                } catch (SQLException ex) {
                    Logger.getLogger(Alta_Producto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "No ha selecionada ninguna fila");
        }
         }
        if(ELIMINAR == 0) {
           JOptionPane.showMessageDialog(this, "Sin Permiso"+" "
                + "Administrador");
         }
       
    }//GEN-LAST:event_mneliminarActionPerformed

    private void txt_Cod_ProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Cod_ProductoKeyTyped
          char car = evt.getKeyChar();
        if((car<'0' || car>'9') &&(car<'A' || car>'Z') && car !='Ñ' && (car!=(char)KeyEvent.VK_SPACE))
            
        {
            evt.consume();
        }
    }//GEN-LAST:event_txt_Cod_ProductoKeyTyped

    private void txt_descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descripcionKeyTyped
          char car = evt.getKeyChar();
        if((car<'0' || car>'9') &&(car<'A' || car>'Z') && car !='Ñ' && (car!=(char)KeyEvent.VK_SPACE))
            
        {
            evt.consume();
        }
    }//GEN-LAST:event_txt_descripcionKeyTyped

    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed
      Buscar_Cod(txt_Cod_Producto.getText());
    }//GEN-LAST:event_btn_GuardarActionPerformed

    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
        Actualizar();
    }//GEN-LAST:event_btn_ActualizarActionPerformed

    private void txt_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarKeyReleased
        Buscar_Pro(txt_Buscar.getText());
    }//GEN-LAST:event_txt_BuscarKeyReleased

    private void btn_ReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ReportActionPerformed

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
            java.util.logging.Logger.getLogger(Alta_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alta_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alta_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alta_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alta_Producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JButton btn_Report;
    private javax.swing.JComboBox<String> jC_Iva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel j_Cod;
    private javax.swing.JTable jt_Producto;
    private javax.swing.JMenuItem mneliminar;
    private javax.swing.JMenuItem mnmodificar;
    private javax.swing.JTextField txt_Buscar;
    private javax.swing.JTextField txt_Cod_Producto;
    private javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables
}
