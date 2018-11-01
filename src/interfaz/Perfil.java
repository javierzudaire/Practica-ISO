/*
 * Javier Zudaire
 */
package interfaz;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Perfil extends JFrame {

    public Perfil() throws IOException {

        setTitle("DYAL");
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("InterfazBackground.png")))));
        setSize(900, 600);
        setLayout(null);
        setResizable(false);

        JTextArea text = new JTextArea();

        text.append("\n");

        JLabel label1 = new JLabel("Nombre: Javier Zudaire");
        add(label1);
        label1.setBounds(230, 240, 370, 27);
        JLabel label2 = new JLabel("Tipo usuario: Viajero");
        add(label2);
        label2.setBounds(230, 260, 370, 27);
        //JTextField field = new JTextField();
        //add(field);
        //field.setBounds(583, 355, 80, 27);

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(220, 375, 450, 30);

    }

}
