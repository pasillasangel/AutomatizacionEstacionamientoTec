using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EstacionamientoTec1
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Form1 f1 = new Form1();
            f1.Show();
            this.Hide();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form4 f4 = new Form4();
            f4.Show();
            this.Hide();
        }

        private void b1_Click(object sender, EventArgs e)
        {
             Form3 f1 = new Form3();
            f1.Show();
            this.Hide();
        }

        private void b2_Click(object sender, EventArgs e)
        {
            Form4 f1 = new Form4();
            f1.Show();
            this.Hide();
        }

        private void b3_Click(object sender, EventArgs e)
        {
            Form5 f1 = new Form5();
            f1.Show();
            this.Hide();
        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            Form6 f1 = new Form6();
            f1.Show();
            this.Hide();
        }
    }
}
