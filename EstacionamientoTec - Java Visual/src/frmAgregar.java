import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;


public class frmAgregar extends javax.swing.JFrame {

    private static Connection Conexion;

    public frmAgregar() {
        initComponents();
        this.setLocation(400, 200);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagenes/tire.png")));;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImagenAgregar = new javax.swing.JLabel();
        lblRegresar = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblTexto = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtPosicion = new javax.swing.JTextField();
        lblm = new javax.swing.JLabel();
        lblL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        lblImagenAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mortarboard.png"))); // NOI18N

        lblRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/previous.png"))); // NOI18N
        lblRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarMouseClicked(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setText("Agregar Maestro al Estacionamiento");

        lblTexto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTexto.setText("Ingrese la matricula del Profesor y el Lugar donde se coloco:");

        txtMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyTyped(evt);
            }
        });

        txtPosicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPosicionKeyTyped(evt);
            }
        });

        lblm.setText("Matricula:");

        lblL.setText("Lugar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTexto)
                            .addComponent(lblTitulo)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRegresar)
                                .addGap(144, 144, 144)
                                .addComponent(lblImagenAgregar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblL)
                                    .addComponent(lblm))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMatricula)
                                    .addComponent(txtPosicion)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTexto)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblm))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblL))
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImagenAgregar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRegresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseClicked
        this.setVisible(false);
        
        frmMenu Menu = new frmMenu();
        Menu.setVisible(true);
    }//GEN-LAST:event_lblRegresarMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String matricula, posicion;
        matricula = txtMatricula.getText();
        posicion = txtPosicion.getText();
        
        if(txtMatricula.getText().equals("")){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe llenar la matricula. \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txtMatricula.requestFocus();
        }else if(txtPosicion.getText().equals("")){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe llenar la matricula. \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txtPosicion.requestFocus();
        }else{
            try {
                
                MySQLConnection("root", "", "EstacionamientoTec13");
                agregar(matricula, posicion);
            } catch (Exception ex) {
                Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_txtMatriculaKeyTyped

    private void txtPosicionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPosicionKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_txtPosicionKeyTyped

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
            java.util.logging.Logger.getLogger(frmAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgregar().setVisible(true);
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
    
    public void agregar(String matri, String posi) throws Exception {
        try {
            //Buscar si existe la matricula
            String Query = "SELECT Nombre, ApellidoPaterno FROM PROFESOR WHERE Matricula = " + matri + "";
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            
            if(resultSet.next()){
                                //Buscar si existe la matricula
                Query = "SELECT IdMatriculaOcupado FROM LUGAROCUPADO WHERE IdMatriculaOcupado = " + matri + "";
                st = Conexion.createStatement();
                resultSet = st.executeQuery(Query);
                //Si existe la matricula
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Los matricula ya se ha ingresado. Intente de nuevo.");
                }else{
                    int p = Integer.parseInt(posi);
                    //Entre los lugares que existen
                    if((p>=1 && p<=40)){
                        //Buscamos si nadie lo ha utilizados
                        Query = "SELECT * FROM LUGAROCUPADO WHERE Lugar = " + p + "";
                        st = Conexion.createStatement();
                        resultSet = st.executeQuery(Query);
                        
                        
                        //Si se encuentra
                        if(resultSet.next()){
                            JOptionPane.showMessageDialog(null, "El lugar que eligio ya esta en uso. Intentelo de nuevo con otro lugar.");
                        }else{
                           int m = Integer.parseInt(matri);
                           //Ingresar la matricula
                           Query = "INSERT INTO LUGAROCUPADO (IdMatriculaOcupado,Lugar) VALUES("+m+","+p+")";
                           st = Conexion.createStatement();
                           st.executeUpdate(Query);
                           
                           //Restar la cantidad de espacio disponible
                           String Query1 = "UPDATE LugaresDisponibles SET Lugares = Lugares - 1 WHERE Espacio = 1";
                           Statement st1 = Conexion.createStatement();
                           java.sql.ResultSet resultSet1;
                           st1.executeUpdate(Query1);
                           
                           //Mandar mensaje de realizado con exito.
                           javax.swing.JOptionPane.showMessageDialog(this,"Se agregado Correctamente la Matricula. \n","EXITO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);

                           //Regresamos al Menu
                            this.setVisible(false);
                            frmMenu Menu = new frmMenu();
                            Menu.setVisible(true);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Eliga un lugar del 1 al 40. Intentelo de nuevo con otro lugar.");
                    }

                }
            }else{
                JOptionPane.showMessageDialog(null, "La matricula no existe. Intente de nuevo.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel lblImagenAgregar;
    private javax.swing.JLabel lblL;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblm;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtPosicion;
    // End of variables declaration//GEN-END:variables
}


                         /*//Ingresar la matricula
                           Query = "INSERT INTO LUGAROCUPADO (IdMatriculaOcupado) VALUES ( " + matri + ")";
                           st = Conexion.createStatement();
                           resultSet = st.executeQuery(Query);

                           //Restar la cantidad de espacio disponible
                           Query = "UPDATE LugaresDisponibles SET Lugares = Lugares - 1 WHERE Espacio = 1";
                           st = Conexion.createStatement();
                           resultSet = st.executeQuery(Query);

                           //Mandar mensaje de realizado con exito.
                           javax.swing.JOptionPane.showMessageDialog(this,"Se agregado Correctamente la Matricula. \n","EXITO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);

                           //Regresamos al Menu
                            this.setVisible(false);
                            frmMenu Menu = new frmMenu();
                            Menu.setVisible(true);*/