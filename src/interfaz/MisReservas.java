
package interfaz;

import static interfaz.Login2.username;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MisReservas extends JFrame {

    public MisReservas() throws IOException {

        setTitle("DYAL");
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("InterfazBackground.png")))));
        setSize(900, 600);
        setLayout(null);
        setResizable(false);

        String usuario = username;

        JTextArea text = new JTextArea();
        add(text);
        text.setBounds(135, 305, 630, 135);
        JScrollPane scroll = new JScrollPane(text);
        add(scroll);
        scroll.setBounds(135, 305, 630, 135);
        text.setEditable(false);

        for (int i = 0; i < DatabaseAccess.getInstance().obtenerMisReservas(usuario).size(); i++) {
            text.append(String.valueOf(DatabaseAccess.getInstance().obtenerMisReservas(usuario).get(i)) + '\n' + '\n');

        }

    }

}
