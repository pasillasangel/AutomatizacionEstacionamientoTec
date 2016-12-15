
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmMostrar extends javax.swing.JFrame {
    
    private static Connection Conexion;
    private DefaultTableModel modelo;
    //DefaultTableModel modelo = (DefaultTableModel) t_maestros.getModel();
    

    public frmMostrar() throws Exception {
        initComponents();
        this.setLocation(350, 200);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagenes/tire.png")));
        
        MySQLConnection("root", "", "EstacionamientoTec13");
        cargartabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImagenMostrar = new javax.swing.JLabel();
        lblRegresar = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_maestros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        lblImagenMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/desk(1).png"))); // NOI18N

        lblRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/previous.png"))); // NOI18N
        lblRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarMouseClicked(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setText("Ver los profesores que Ocupan un estacionamiento");

        t_maestros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(t_maestros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblRegresar)
                        .addGap(218, 218, 218)
                        .addComponent(lblImagenMostrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRegresar)
                    .addComponent(lblImagenMostrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseClicked
        this.setVisible(false);
        
        frmMenu Menu = new frmMenu();
        Menu.setVisible(true);
    }//GEN-LAST:event_lblRegresarMouseClicked

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
            java.util.logging.Logger.getLogger(frmMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmMostrar().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(frmMostrar.class.getName()).log(Level.SEVERE, null, ex);
                }
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

    public void cargartabla() throws SQLException{

        String consultasql = "SELECT LUGAROCUPADO.IdMatriculaOcupado, PROFESOR.Matricula, PROFESOR.Nombre, PROFESOR.ApellidoPaterno, DATE_FORMAT(LUGAROCUPADO.Entr, '%e %M') AS Fecha, DATE_FORMAT(LUGAROCUPADO.Entr, '%H:%i') AS Hora, LUGAROCUPADO.Lugar FROM LUGAROCUPADO,PROFESOR WHERE LUGAROCUPADO.IdMatriculaOcupado = PROFESOR.Matricula";
        String Titulo[] ={"Matricula","Nombre","Apellido", "Fecha", "Hora", "Lugar"};
        String registros[] =new String[9];
        modelo= new DefaultTableModel(null,Titulo);
        Statement st = Conexion.createStatement();
        java.sql.ResultSet resultSet;
        resultSet = st.executeQuery(consultasql);
        while(resultSet.next()){

            //registros[0]=resultSet.getString(1);
            registros[0]=resultSet.getString(2);
            registros[1]=resultSet.getString(3);
            registros[2]=resultSet.getString(4);
            registros[3]=resultSet.getString(5);
            registros[4]=resultSet.getString(6);
            registros[5]=resultSet.getString(7);
            modelo.addRow(registros);
        }
        t_maestros.setModel(modelo);

    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImagenMostrar;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable t_maestros;
    // End of variables declaration//GEN-END:variables

    private static class resultSet {

        public resultSet() {
        }
    }

}
