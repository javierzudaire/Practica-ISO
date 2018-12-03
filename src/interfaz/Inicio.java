
package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Inicio extends JFrame {

    public Inicio() throws IOException {

        final JFrame frame = new JFrame("Login");

        Login2 loginDlg = new Login2(frame);
        loginDlg.setVisible(true);

        setTitle("DYAL");
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("InterfazBackground.png")))));
        JButton button1 = new JButton("PERFIL");
        button1.setBounds(225, 270, 200, 100);
        add(button1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Perfil window = null;
                try {
                    window = new Perfil();
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
                window.setVisible(true);
            }
        }
        );

        JButton button2 = new JButton("VIAJES");
        button2.setBounds(485, 270, 200, 100);
        add(button2);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Viajes window = null;
                try {
                    window = new Viajes();
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
                window.setVisible(true);
            }
        }
        );

        JButton button3 = new JButton("MIS RESERVAS >");
        button3.setBounds(225, 422, 460, 70);
        add(button3);

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MisReservas window = null;
                try {
                    window = new MisReservas();
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
                window.setVisible(true);
            }
        }
        );

        setSize(900, 600);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
