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
    public partial class Form3 : Form
    {
        MySqlConnection cn = new MySqlConnection("Server = localhost; Uid = root; Password = root; Database = estacionamientopl; Port = 3306");
        MySqlCommand cmd = new MySqlCommand();
        public Form3()
        {
            InitializeComponent();
            timer1.Enabled = true;
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Form2 f1 = new Form2();
            f1.Show();
            this.Hide();
        }

        private void Form3_Load(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {}

        private void button4_Click(object sender, EventArgs e)
        {}

        private void button1_Click(object sender, EventArgs e)
        {}

        private void timer1_Tick(object sender, EventArgs e)
        {
            lab3.Text = DateTime.Now.ToShortTimeString();
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            /*
            cn.Open();
            cmd.Connection = cn;
            int m = Convert.ToInt32(textBox1.Text);

            try
            {
                cmd.CommandText = "insert info (Matricula) values ( "+m+")";
                cmd.ExecuteNonQuery();
                int valor = int.Parse(cmd.ExecuteScalar().ToString());
                //Comparamos si el valor recibido es 1 entonces existe si no NO
                if (valor == 1)
                {
                    MessageBox.Show("Se agrego correctamente la matricula ", " Estacionamiento");
                  
                }
                else
                {
                    MessageBox.Show("ERORR INTENTA DE NUEVO ", "Estacionamiento");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR", "Estacionamiento" + ex);
            }
            cn.Close();*/


            try
            {
                string MyConnection2 = "Server = localhost; Uid = root; Password = root; Database = EstacionamientoTec11; Port = 3306";
                string Query = "DELETE FROM Profesor WHERE Matricula='" + textBox1.Text + "';";
                MySqlConnection MyConn2 = new MySqlConnection(MyConnection2);
                MySqlCommand MyCommand2 = new MySqlCommand(Query, MyConn2);
                MySqlDataReader MyReader2;
                MyConn2.Open();
                MyReader2 = MyCommand2.ExecuteReader();
                MessageBox.Show("Ingresor Correctamente","Estacionamiento");
                textBox1.Clear();
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
        }
    }

