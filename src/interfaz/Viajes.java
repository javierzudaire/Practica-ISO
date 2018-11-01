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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Viajes extends JFrame {

    String recogida;
    String devolucion;

    public Viajes() throws IOException {

        setTitle("DYAL");
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("InterfazBackground.png")))));

        JLabel label1 = new JLabel("VIAJES DISPONIBLES");
        add(label1);
        label1.setBounds(100, 270, 200, 27);
        JLabel label2 = new JLabel("CREAR VIAJE");
        add(label2);
        label2.setBounds(110, 510, 100, 27);
        JLabel label3 = new JLabel("Inicio:");
        add(label3);
        label3.setBounds(260, 510, 150, 27);
        JLabel label4 = new JLabel("Final:");
        add(label4);
        label4.setBounds(430, 510, 150, 27);
        JLabel label5 = new JLabel("Hora:");
        add(label5);
        label5.setBounds(600, 510, 100, 27);
        JTextField field1 = new JTextField("");
        add(field1);
        field1.setBounds(300, 510, 100, 27);
        JTextField field2 = new JTextField("");
        add(field2);
        field2.setBounds(470, 510, 100, 27);
        JTextField field3 = new JTextField("");
        add(field3);
        field3.setBounds(640, 510, 80, 27);
        JButton button1 = new JButton("✓");
        button1.setBounds(750, 502, 40, 40);
        add(button1);
        
        JTextArea text = new JTextArea(); 
        add(text);
        text.setBounds(135, 305, 630, 135);
        JScrollPane scroll = new JScrollPane(text);
        add(scroll);
        scroll.setBounds(135, 305, 630, 135);
        text.setEditable(false);
        
        setSize(900, 600);
        setLayout(null);
        setResizable(false);

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(70, 275, 760, 210);
        g.drawRect(75, 280, 750, 200);
        g.drawRect(93, 523, 110, 40);
    }

}
