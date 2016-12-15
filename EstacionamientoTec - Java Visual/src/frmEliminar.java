import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class frmEliminar extends javax.swing.JFrame {

    private static Connection Conexion;
    
    public frmEliminar() {
        initComponents();
        this.setLocation(400, 200);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagenes/tire.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImagenEliminar = new javax.swing.JLabel();
        lblRegresar = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblTexto = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        lblImagenEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/apple.png"))); // NOI18N

        lblRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/previous.png"))); // NOI18N
        lblRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarMouseClicked(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setText("Eliminar Maestro al Estacionamiento");

        lblTexto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTexto.setText("Ingrese la matricula del Profesor que quiere eliminar:");

        txtMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyTyped(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblRegresar)
                        .addGap(137, 137, 137)
                        .addComponent(lblImagenEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(lblTitulo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTexto)
                                .addGap(27, 27, 27)
                                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTitulo)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTexto)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(lblImagenEliminar))
                    .addComponent(lblRegresar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseClicked
        this.setVisible(false);
        
        frmMenu Menu = new frmMenu();
        Menu.setVisible(true);
    }//GEN-LAST:event_lblRegresarMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String matricula;
        matricula = txtMatricula.getText();
        
        if(txtMatricula.getText().equals("")){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe llenar la matricula. \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txtMatricula.requestFocus();
        }else{
            try {
                int m = Integer.parseInt(matricula);
                MySQLConnection("root", "", "EstacionamientoTec13");
                eliminar(m);
            } catch (Exception ex) {
                Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_txtMatriculaKeyTyped

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
            java.util.logging.Logger.getLogger(frmEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEliminar().setVisible(true);
            }
        });
    }

    public void MySQLConnection(String user, String pass, String db_name) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            //JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(int matri) throws Exception {
        try {
            //Buscar si existe la matricula
            String Query = "SELECT IdMatriculaOcupado FROM LUGAROCUPADO WHERE IdMatriculaOcupado = " + matri + "";
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            
            //Si existe la matricula
            if (resultSet.next()) {
                   //Buscar si ya esta ingresada la martricula
                   Query = "SELECT IdMatriculaOcupado FROM LUGAROCUPADO WHERE IdMatriculaOcupado = " + matri + "";
                   st = Conexion.createStatement();
                   resultSet = st.executeQuery(Query);
                   //Si vuelve a encontrar la matricula
                   if(resultSet.next()){
                       //Ingresar la matricula
                       Query = "DELETE FROM LUGAROCUPADO WHERE IdMatriculaOcupado = ( " + matri + ")";
                       st = Conexion.createStatement();
                       st.executeUpdate(Query);
                       
                       //Sumar la cantidad de espacio disponible
                       Query = "UPDATE LugaresDisponibles SET Lugares = Lugares + 1 WHERE Espacio = 1";
                       st = Conexion.createStatement();
                       st.executeUpdate(Query);
                       
                       //Actualizar
                       
                       //Mandar mensaje de realizado con exito.
                       javax.swing.JOptionPane.showMessageDialog(this,"Se eliminado Correctamente la Matricula. \n","EXITO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                       
                       //Regresamos al Menu
                        this.setVisible(false);
                        frmMenu Menu = new frmMenu();
                        Menu.setVisible(true);
                       
                       
                   }else{
                       JOptionPane.showMessageDialog(null, "La matricula " + matri +" ya esta ingresada. Intentelo de nuevo con otra matricula.");
                   }
                
            }else{
                JOptionPane.showMessageDialog(null, "Los matricula no existe. Intente de nuevo.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel lblImagenEliminar;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
}
