
package interfaz;

import static interfaz.Login2.username;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Perfil extends JFrame {

    public Perfil() throws IOException {

        setTitle("DYAL");
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("InterfazBackground.png")))));
        setSize(900, 600);
        setLayout(null);
        setResizable(false);

        JTextArea text = new JTextArea();

        text.append("\n");

        JLabel label1 = new JLabel("Nombre:");
        add(label1);
        label1.setBounds(330, 300, 370, 27);
        JLabel label2 = new JLabel("Email:");
        add(label2);
        label2.setBounds(330, 340, 370, 27);
        JLabel label3 = new JLabel("Teléfono:");
        add(label3);
        label3.setBounds(330, 380, 370, 27);
        JLabel label4 = new JLabel("Cumpleaños:");
        add(label4);
        label4.setBounds(330, 420, 370, 27);

        String usuario = username;

        JLabel label5 = new JLabel((String) DatabaseAccess.getInstance().obtenerPerfil(usuario).get(0));
        add(label5);
        label5.setBounds(450, 300, 370, 27);
        JLabel label6 = new JLabel((String) DatabaseAccess.getInstance().obtenerPerfil(usuario).get(1));
        add(label6);
        label6.setBounds(450, 340, 370, 27);
        JLabel label7 = new JLabel((String) DatabaseAccess.getInstance().obtenerPerfil(usuario).get(2));
        add(label7);
        label7.setBounds(450, 380, 370, 27);
        JLabel label8 = new JLabel((String) DatabaseAccess.getInstance().obtenerPerfil(usuario).get(3));
        add(label8);
        label8.setBounds(450, 420, 370, 27);

    }

    public void paintComponent(Graphics g) {

        super.paint(g);
        g.drawRect(220, 280, 450, 220);

    }

    public void paint(Graphics g) {

        super.paint(g);
        g.drawRect(220, 280, 450, 220);

    }

}
