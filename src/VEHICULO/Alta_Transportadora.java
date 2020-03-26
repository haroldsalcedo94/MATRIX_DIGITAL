
package VEHICULO;

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


public  class Alta_Transportadora extends javax.swing.JFrame {

    int NUEVO=0,ACTUALIZAR=0;
    DefaultTableModel modelo;
    public Alta_Transportadora() {
        initComponents();
          this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMAGENES/Ardulab_Firma150.png")));
      //  AWTUtilities.setWindowOpaque(this, false);
        this.setLocationRelativeTo(null);
        Bloqueo();
        Buscar_Trans("");
        
    }
    
    void Bloqueo(){
        
        btn_Guardar.setEnabled(false);
        btn_Actualizar.setEnabled(false);
        btn_Cancelar.setEnabled(false);
        
        txt_Cod_Trans.setEnabled(false);
        txt_Nit.setEnabled(false);
        txt_Nombre.setEnabled(false);
        txt_Dir.setEnabled(false);
        txt_Tel.setEnabled(false);        
        txt_Mail.setEnabled(false);
     
        txt_Buscar.requestFocus();
       
    }
    
    void Desbloqueo_Nuevo(){
        
        btn_Guardar.setEnabled(true);
        btn_Actualizar.setEnabled(false);
        btn_Cancelar.setEnabled(true);
        
         txt_Cod_Trans.setEnabled(true);
        txt_Nit.setEnabled(true);
        txt_Nombre.setEnabled(true);
        txt_Dir.setEnabled(true);
        txt_Tel.setEnabled(true);       
        txt_Mail.setEnabled(true);
        
        txt_Cod_Trans.requestFocus();
        
          NUEVO=1;
    }
    
     void Desbloqueo_Actulizar(){
        
        btn_Guardar.setEnabled(false);
        btn_Actualizar.setEnabled(true);
        btn_Cancelar.setEnabled(true);
       
        txt_Cod_Trans.setEnabled(false);
        txt_Nit.setEnabled(true);
        txt_Nombre.setEnabled(true);
        txt_Dir.setEnabled(true);
        txt_Tel.setEnabled(true);        
        txt_Mail.setEnabled(true);
        
        txt_Nit.requestFocus();
        
        ACTUALIZAR=1;

    }
    
    void Limpiar(){
        
         txt_Cod_Trans.setText("");
        txt_Nit.setText("");
        txt_Nombre.setText("");
        txt_Dir.setText("");
        txt_Tel.setText("");      
        txt_Mail.setText("");
        
        txt_Buscar.setText("");
        
        j_Cod.setText("");
       
    }
      
        void Buscar_Cod(String valor){
    String Sql="";
    
        Sql="SELECT cod_trans FROM transportadora WHERE cod_trans = '"+valor+"' ";
    
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
            Logger.getLogger(Alta_Transportadora.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    void Buscar_Trans(String valor){
    String Sql="";
    
        Sql="SELECT cod_trans,nit,nombre,dir,tel,mail FROM transportadora WHERE CONCAT(cod_trans,nit,nombre,tel) LIKE '%"+valor+"%' ";
    
    
    
        
    String []titulos={"CODIGO","NIT","NOMBRE","DIRECCION","TELEFONO","E-MAIL"};
    String []Registros=new String[6];
    modelo= new DefaultTableModel(null,titulos);
            
  
        try {
                Connection cc = Conexion.getConexion();            
            Statement st = cc.createStatement();           
             ResultSet rs = st.executeQuery(Sql);
              while(rs.next())
              {
                  Registros[0]= rs.getString("cod_trans");
                  Registros[1]= rs.getString("nit");
                  Registros[2]= rs.getString("nombre");
                  Registros[3]= rs.getString("dir");
                  Registros[4]= rs.getString("tel");
                  Registros[5]= rs.getString("mail");
                  
                 
                     
                  modelo.addRow(Registros);
              }
            jt_Trans.setModel(modelo);
            jt_Trans.getColumnModel().getColumn(0).setPreferredWidth(10);
            jt_Trans.getColumnModel().getColumn(1).setPreferredWidth(10);
            jt_Trans.getColumnModel().getColumn(2).setPreferredWidth(100);
            jt_Trans.getColumnModel().getColumn(3).setPreferredWidth(20);
            jt_Trans.getColumnModel().getColumn(4).setPreferredWidth(10);
            jt_Trans.getColumnModel().getColumn(5).setPreferredWidth(100);
            
                 Conexion.close(cc);      
        } catch (SQLException ex) {
            Logger.getLogger(Alta_Transportadora.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    void Guardar(){
     if (       this.txt_Cod_Trans.getText().isEmpty()
             || this.txt_Nit.getText().isEmpty() 
             || this.txt_Nombre.getText().isEmpty()  
             || this.txt_Dir.getText().isEmpty() 
             
             
                  
        
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
     
      String cod =   txt_Cod_Trans.getText();
      String  nit =  txt_Nit.getText();
      String  nom =  txt_Nombre.getText();
      String  dir =  txt_Dir.getText();
      String  tel =  txt_Tel.getText();        
      String  mail = txt_Mail.getText();
       
                
             
            sql="INSERT INTO transportadora (cod_trans,nit,nombre,dir,tel,mail) VALUES (?,?,?,?,?,?)";
        try {
           
            Connection cc = Conexion.getConexion();        
            PreparedStatement pst  = cc.prepareStatement(sql);            
     
            pst.setString(1, cod);
            pst.setString(2, nit);
            pst.setString(3, nom);
            pst.setString(4, dir);
            pst.setString(5, tel);
            pst.setString(6, mail);
            
            int n=pst.executeUpdate();
            
            if(n>0){
           // JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
            Limpiar();
            Bloqueo();
            NUEVO=0;
         
            }
            Buscar_Trans("");
        } catch (SQLException ex) {
            Logger.getLogger(Alta_Transportadora.class.getName()).log(Level.SEVERE, null, ex);
        }
        }  
}
    
    void Actualizar(){
       try {
       String cod =   txt_Cod_Trans.getText();
      String  nit =  txt_Nit.getText();
      String  nom =  txt_Nombre.getText();
      String  dir =  txt_Dir.getText();
      String  tel =  txt_Tel.getText();        
      String  mail = txt_Mail.getText();
           
         Connection cc = Conexion.getConexion();      
             
        PreparedStatement pst = cc.prepareStatement("UPDATE transportadora SET cod_trans='"+cod+"', nit='"+nit+"', nombre = '"+nom+"', dir = '"+dir+"', tel = '"+tel+"', mail = '"+mail+"' where cod_trans='"+j_Cod.getText()+"'"); 
       
        pst.executeUpdate();
        Buscar_Trans("");
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
        txt_Cod_Trans = new javax.swing.JTextField();
        txt_Dir = new javax.swing.JTextField();
        j_Cod = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_Tel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_Mail = new javax.swing.JTextField();
        txt_Nit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_Trans = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_Buscar = new javax.swing.JTextField();
        btn_Nuevo = new javax.swing.JButton();
        btn_Guardar = new javax.swing.JButton();
        btn_Actualizar = new javax.swing.JButton();
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
        setTitle("TRANSPORTADORA");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(950, 640));
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
        jLabel2.setText("DIRRECION:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("CODIGO:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("NOMBRE:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 60, 20));

        txt_Cod_Trans.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_Cod_Trans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Cod_TransActionPerformed(evt);
            }
        });
        txt_Cod_Trans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_Cod_TransKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Cod_Trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 110, -1));

        txt_Dir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_Dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DirActionPerformed(evt);
            }
        });
        txt_Dir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_DirKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 600, -1));

        j_Cod.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(j_Cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 170, 30));

        txt_Nombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreActionPerformed(evt);
            }
        });
        txt_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NombreKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 600, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("TELEFONO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 80, 20));

        txt_Tel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_Tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TelActionPerformed(evt);
            }
        });
        txt_Tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TelKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 200, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("E-MAIL:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 50, 20));

        txt_Mail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_Mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MailActionPerformed(evt);
            }
        });
        txt_Mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_MailKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 490, -1));

        txt_Nit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_Nit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NitActionPerformed(evt);
            }
        });
        txt_Nit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NitKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 200, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("NIT:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 890, 160));

        jt_Trans = new org.jdesktop.swingx.JXTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jt_Trans.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jt_Trans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jt_Trans.setComponentPopupMenu(jPopupMenu1);
        jt_Trans.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(jt_Trans);

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
        getContentPane().add(btn_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, 40));

        btn_Guardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Guardar_x30.png"))); // NOI18N
        btn_Guardar.setText("GUARDAR");
        btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 130, 40));

        btn_Actualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/actualizar_x30.png"))); // NOI18N
        btn_Actualizar.setText("ACTULIZAR");
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 130, 40));

        btn_Cancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/limpiar_x30.png"))); // NOI18N
        btn_Cancelar.setText("CANCELAR");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 130, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       VISTA.Menu.P2=false;
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

    private void txt_Cod_TransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Cod_TransActionPerformed
        txt_Nit.requestFocus();
    }//GEN-LAST:event_txt_Cod_TransActionPerformed

    private void txt_DirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DirActionPerformed
        txt_Tel.requestFocus();
    }//GEN-LAST:event_txt_DirActionPerformed

    private void mnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnmodificarActionPerformed

          if(MODIFICAR == 1){
        int filamodificar= jt_Trans.getSelectedRow();
        if(filamodificar>=0)
        {
            Desbloqueo_Actulizar();
            Limpiar();            
             
            j_Cod.setText(jt_Trans.getValueAt(filamodificar, 0).toString());
            txt_Cod_Trans.setText(jt_Trans.getValueAt(filamodificar, 0).toString());
            txt_Nit.setText(jt_Trans.getValueAt(filamodificar, 1).toString());
            txt_Nombre.setText(jt_Trans.getValueAt(filamodificar, 2).toString());
            txt_Dir.setText(jt_Trans.getValueAt(filamodificar, 3).toString());
            txt_Tel.setText(jt_Trans.getValueAt(filamodificar, 4).toString());
             txt_Mail.setText(jt_Trans.getValueAt(filamodificar, 5).toString());
            
            
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
          int fila= jt_Trans.getSelectedRow();
        String cod="";
        cod=jt_Trans.getValueAt(fila, 0).toString();
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
                    PreparedStatement pst = cc.prepareStatement("DELETE FROM  transportadora WHERE cod_trans = '"+cod+"'");
                    pst.executeUpdate();
                    Buscar_Cod("");
                } catch (SQLException ex) {
                    Logger.getLogger(Alta_Transportadora.class.getName()).log(Level.SEVERE, null, ex);
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

    private void txt_Cod_TransKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Cod_TransKeyTyped
          char car = evt.getKeyChar();
        if((car<'0' || car>'9') &&(car<'A' || car>'Z') && car !='Ñ' && (car!=(char)KeyEvent.VK_SPACE))
            
        {
            evt.consume();
        }
    }//GEN-LAST:event_txt_Cod_TransKeyTyped

    private void txt_DirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_DirKeyTyped
          char car = evt.getKeyChar();
        if((car<'0' || car>'9') &&(car<'A' || car>'Z') && car !='Ñ'&& car !='-' && car !='.' && car !='+' && (car!=(char)KeyEvent.VK_SPACE))
            
        {
            evt.consume();
        }
    }//GEN-LAST:event_txt_DirKeyTyped

    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed
      Buscar_Cod(txt_Cod_Trans.getText());
    }//GEN-LAST:event_btn_GuardarActionPerformed

    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
        Actualizar();
    }//GEN-LAST:event_btn_ActualizarActionPerformed

    private void txt_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreActionPerformed
        txt_Dir.requestFocus();
    }//GEN-LAST:event_txt_NombreActionPerformed

    private void txt_NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9') &&(car<'A' || car>'Z') && car !='Ñ' && (car!=(char)KeyEvent.VK_SPACE))
            
        {
            evt.consume();
        }
    }//GEN-LAST:event_txt_NombreKeyTyped

    private void txt_TelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TelActionPerformed
         txt_Mail.requestFocus();
    }//GEN-LAST:event_txt_TelActionPerformed

    private void txt_TelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9'))
            
        {
            evt.consume();
        }
    }//GEN-LAST:event_txt_TelKeyTyped

    private void txt_MailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MailActionPerformed
        if(NUEVO==1){
             btn_Guardar.requestFocus();
        }
         if(ACTUALIZAR==1){
             btn_Actualizar.requestFocus();
        }
    }//GEN-LAST:event_txt_MailActionPerformed

    private void txt_MailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MailKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9') &&(car<'a' || car>'z') && car !='ñ' && car !='-' && car !='_' && car !='.' && car !='@' )
            
        {
            evt.consume();
        }
    }//GEN-LAST:event_txt_MailKeyTyped

    private void txt_NitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NitActionPerformed
        txt_Nombre.requestFocus();
    }//GEN-LAST:event_txt_NitActionPerformed

    private void txt_NitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NitKeyTyped
       char car = evt.getKeyChar();
        if((car<'0' || car>'9') && car !='-' )
            
        {
            evt.consume();
        }
    }//GEN-LAST:event_txt_NitKeyTyped

    private void txt_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarKeyReleased
        Buscar_Trans(txt_Buscar.getText());
    }//GEN-LAST:event_txt_BuscarKeyReleased

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
            java.util.logging.Logger.getLogger(Alta_Transportadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alta_Transportadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alta_Transportadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alta_Transportadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alta_Transportadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel j_Cod;
    private javax.swing.JTable jt_Trans;
    private javax.swing.JMenuItem mneliminar;
    private javax.swing.JMenuItem mnmodificar;
    private javax.swing.JTextField txt_Buscar;
    private javax.swing.JTextField txt_Cod_Trans;
    private javax.swing.JTextField txt_Dir;
    private javax.swing.JTextField txt_Mail;
    private javax.swing.JTextField txt_Nit;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Tel;
    // End of variables declaration//GEN-END:variables
}
