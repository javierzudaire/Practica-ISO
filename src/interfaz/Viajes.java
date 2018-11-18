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

        JButton nuevoViaje = new JButton("CREAR NUEVO VIAJE");
        nuevoViaje.setBounds(690, 40, 150, 40);
        add(nuevoViaje);

        JLabel label1 = new JLabel("VIAJES DISPONIBLES");
        add(label1);
        label1.setBounds(100, 270, 200, 27);
        JLabel label2 = new JLabel("RESERVAR VIAJE");
        add(label2);
        label2.setBounds(205, 510, 100, 27);
        JLabel label3 = new JLabel("Introduzca el número de viaje:");
        add(label3);
        label3.setBounds(345, 510, 200, 27);
        JTextField field1 = new JTextField("");
        add(field1);
        field1.setBounds(550, 510, 50, 27);

        String[] universidades = {"Todas", "Universidad CEU San Pablo", "Universidad Francisco de Vitoria", "Universidad Complutense", "Universidad Autónoma", "Universidad Europea"};
        JComboBox filtros = new JComboBox(universidades);
        add(filtros);
        filtros.setBounds(470, 270, 250, 30);

        JButton filtrar = new JButton("FILTRAR");
        filtrar.setBounds(710, 270, 90, 30);
        add(filtrar);

        JButton button1 = new JButton("RESERVAR");
        button1.setBounds(630, 502, 110, 40);
        add(button1);

        JTextArea text = new JTextArea();
        add(text);
        text.setBounds(135, 305, 630, 135);
        JScrollPane scroll = new JScrollPane(text);
        add(scroll);
        scroll.setBounds(135, 305, 630, 135);
        text.setEditable(false);

        for (int i = 0; i < DatabaseAccess.getInstance().obtenerViajes().size(); i++) {
            text.append(" | " + String.valueOf(DatabaseAccess.getInstance().obtenerViajes().get(i)) + '\n' + '\n');

        }

        getRootPane().setDefaultButton(button1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Reserva window = null;
                try {
                    window = new Reserva();
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
                window.setVisible(true);
            }
        }
        );

        filtrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                if (filtros.getSelectedItem() == "Todas") {
                    for (int i = 0; i < DatabaseAccess.getInstance().obtenerViajes().size(); i++) {
                        text.append(" | " + String.valueOf(DatabaseAccess.getInstance().obtenerViajes().get(i)) + '\n' + '\n');

                    }

                } else {
                    for (int i = 0; i < DatabaseAccess.getInstance().obtenerViajesFiltrados((String) filtros.getSelectedItem()).size(); i++) {
                        text.append(" | " + String.valueOf(DatabaseAccess.getInstance().obtenerViajesFiltrados((String) filtros.getSelectedItem()).get(i)) + '\n' + '\n');

                    }
                }

            }
        }
        );

        nuevoViaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CrearViaje window = null;
                try {
                    window = new CrearViaje();
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

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(70, 275, 760, 210);
        g.drawRect(75, 280, 750, 200);
        g.drawRect(192, 523, 123, 40);
    }

}
