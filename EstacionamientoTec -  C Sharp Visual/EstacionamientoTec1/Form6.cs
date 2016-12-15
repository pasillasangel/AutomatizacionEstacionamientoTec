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
    public partial class Form6 : Form
    {
        public Form6()
        {
            InitializeComponent();
            timer1.Enabled = true;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form2 f1 = new Form2();
            f1.Show();
            this.Hide();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            label2.Text = DateTime.Now.ToShortTimeString();
        }

        private void Form6_Load(object sender, EventArgs e)
        {

        }
    }
}
