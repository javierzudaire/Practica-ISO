/*
 * Javier Zudaire
 */
package interfaz;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Viajes extends JFrame {

    String recogida;
    String devolucion;

    public Viajes() throws IOException {

        setTitle("DYAL");
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("InterfazBackground.png")))));

        String[] horas = {"7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00"};

        JLabel label1 = new JLabel("Fecha de viaje: ");
        add(label1);
        label1.setBounds(100, 200, 200, 27);
        JTextField field1 = new JTextField("dd/mm/yy");
        add(field1);
        field1.setBounds(220, 200, 80, 27);
        JLabel label2 = new JLabel("Hora: ");
        add(label2);
        label2.setBounds(310, 200, 100, 27);
        JComboBox combobox1 = new JComboBox(horas);
        combobox1.setBounds(345, 200, 86, 30);
        add(combobox1);

        setSize(900, 600);
        setLayout(null);
        setResizable(false);

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(70, 275, 760, 210);
        g.drawRect(75, 280, 750, 200);
    }

}
