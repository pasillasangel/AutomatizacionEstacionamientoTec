using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
using MySql.Data;

namespace EstacionamientoTec1
{
    public partial class Form1 : Form
    {
        MySqlConnection cn = new MySqlConnection("Server = localhost; Uid = root; Password = ; Database = EstacionamientoTec13; Port = 3306");
        MySqlCommand cmd = new MySqlCommand();

        public Form1()
        {
            InitializeComponent();
            textBox2.PasswordChar = '*';

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form2 f2 = new Form2();
            f2.Show();
            this.Hide();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            /*Form3 f3 = new Form3();
            f3.Show();
            this.Hide();*/
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            
            cn.Open();
            cmd.Connection = cn;

            try
            {
                cmd.CommandText = "select count(*) from USUARIO where usuario = '" + textBox1.Text + "'and pass = '" + textBox2.Text + "'";
                int valor = int.Parse(cmd.ExecuteScalar().ToString());
                //Comparamos si el valor recibido es 1 entonces existe si no NO
                if (valor == 1)
                {
                    MessageBox.Show("Bienvenido "," Estacionamiento");
                    Form2 form = new Form2();
                    form.Show();
                    this.Hide();
                }
                else {
                    MessageBox.Show("ERORR INTENTA DE NUEVO ","Estacionamiento"); }
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR","Estacionamiento"+ex);
            }
            cn.Close();
        } 

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
        
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
           
    }
}
