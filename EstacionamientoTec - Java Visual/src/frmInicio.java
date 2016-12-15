
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class frmInicio extends javax.swing.JFrame {

    //Variable Conexion
    private static Connection Conexion;
    
    public frmInicio() {
        initComponents();
        this.setLocation(400, 200);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagenes/tire.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtu = new javax.swing.JTextField();
        txtp = new javax.swing.JPasswordField();
        btnSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        lblpass = new javax.swing.JLabel();
        lbltexto = new javax.swing.JLabel();
        lbltexto2 = new javax.swing.JLabel();
        lbltexto3 = new javax.swing.JLabel();
        txtfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estacionamiento Tec");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtu, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 128, 108, -1));
        getContentPane().add(txtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 166, 108, -1));

        btnSesion.setText("Iniciar");
        btnSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 216, 108, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/itt-logo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 19, -1, -1));

        lbluser.setText("Usuario:");
        getContentPane().add(lbluser, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 131, -1, -1));

        lblpass.setText("Password:");
        getContentPane().add(lblpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 169, -1, -1));

        lbltexto.setText("Automatizacion de control de acceso de ");
        lbltexto.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        getContentPane().add(lbltexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 30, 210, 22));

        lbltexto2.setText("estacionamiento para Profesores del");
        getContentPane().add(lbltexto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 57, -1, -1));

        lbltexto3.setText(" Instituto Tecnologico de Tijuana");
        getContentPane().add(lbltexto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 77, -1, -1));

        txtfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(txtfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, -1, 530, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSesionActionPerformed
        String u, p;
        u = txtu.getText();
        p = txtp.getText();
        
        if(txtu.getText().equals("") || (txtp.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe llenar ambos los campos \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txtu.requestFocus();
        }else{
            try {
                buscarUsuario(u,p);
            } catch (Exception ex) {
                Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSesionActionPerformed

    public static void main(String args[]) throws Exception {
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
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        frmInicio db = new frmInicio();
        db.MySQLConnection("root", "", "EstacionamientoTec13");  
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInicio().setVisible(true);
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

    public void buscarUsuario(String u, String p) throws Exception {
        try {
            String Query = "SELECT * FROM USUARIO WHERE usuario = '" + u + "' AND pass = '"+ p + "'";
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
 
            if (resultSet.next()) {
                //JOptionPane.showMessageDialog(null, "Bienvenido!");
                this.setVisible(false);
                
                frmMenu Menu = new frmMenu();
                Menu.setVisible(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "Los datos son incorrectos. Intente de nuevo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }
    
     public void closeConnection() {
        try {
            Conexion.close();
            JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblpass;
    private javax.swing.JLabel lbltexto;
    private javax.swing.JLabel lbltexto2;
    private javax.swing.JLabel lbltexto3;
    private javax.swing.JLabel lbluser;
    private javax.swing.JLabel txtfondo;
    private javax.swing.JPasswordField txtp;
    private javax.swing.JTextField txtu;
    // End of variables declaration//GEN-END:variables
}
