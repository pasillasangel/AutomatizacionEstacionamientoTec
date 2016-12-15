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
    public partial class Form4 : Form
    {
        MySqlConnection cn = new MySqlConnection("Server = localhost; Uid = root; Password = root; Database = estacionamientopl; Port = 3306");
        MySqlCommand cmd = new MySqlCommand();
        public Form4()
        {
            InitializeComponent();
            timer1.Enabled = true;
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            label2.Text = DateTime.Now.ToShortTimeString();
        }

        private void label2_Resize(object sender, EventArgs e)
        {
           
        }

        private void Form4_Resize(object sender, EventArgs e)
        {
            label2.Top = this.Width - 100;
            label2.Top = this.Height - 50;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form2 f1 = new Form2();
            f1.Show();
            this.Hide();
        }

        private void timer1_Tick_1(object sender, EventArgs e)
        {
            label2.Text = DateTime.Now.ToShortTimeString();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            
            try
            {
                string MyConnection2 = "Server = localhost; Uid = root; Password = root; Database = EstacionamientoTec11; Port = 3306";
                string Query = "DELETE FROM Profesor WHERE Matricula='" + textBox2.Text + "';";
                MySqlConnection MyConn2 = new MySqlConnection(MyConnection2);
                MySqlCommand MyCommand2 = new MySqlCommand(Query, MyConn2);
                MySqlDataReader MyReader2;
                MyConn2.Open();
                MyReader2 = MyCommand2.ExecuteReader();
                MessageBox.Show("Elimino Correctamente","Estacionamiento");
                textBox2.Clear();
                while (MyReader2.Read())
                {
                }
                MyConn2.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
                   
        }

        private void Form4_Load(object sender, EventArgs e)
        {

        }
    }
}
