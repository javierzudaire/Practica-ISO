/*
 *  Javier Zudaire
 */
package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reserva extends JFrame {

    public Reserva() throws IOException {

        setTitle("DYAL");
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("InterfazBackground.png")))));

        JLabel label1 = new JLabel("¡Muchas gracias por confiar en nosotros!");
        label1.setFont(new Font("Sans_Serif", Font.BOLD, 38));
        label1.setForeground(Color.GRAY.darker());
        add(label1);
        label1.setBounds(50, 270, 800, 50);

        JLabel label2 = new JLabel("NÚMERO DE CONFIRMACIÓN: " + getRandom());
        label2.setFont(new Font("Sans_Serif", Font.BOLD, 27));
        label2.setForeground(Color.GREEN.darker());
        add(label2);
        label2.setBounds(150, 350, 700, 50);

        JButton button1 = new JButton("Continuar");
        button1.setBounds(450, 470, 200, 50);
        add(button1);

        JButton button2 = new JButton("Salir");
        button2.setBounds(250, 470, 200, 50);
        add(button2);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }
        );

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        );

        setSize(900, 600);
        setLayout(null);
        setResizable(false);

    }

    protected String getRandom() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 9) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

}
