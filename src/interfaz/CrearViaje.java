/*
 *  Javier Zudaire
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CrearViaje extends JFrame {

    public CrearViaje() throws IOException {

        setTitle("DYAL");
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("InterfazBackground.png")))));
        setSize(900, 600);
        setLayout(null);
        setResizable(false);

        JLabel label2 = new JLabel("NUEVO VIAJE");
        add(label2);
        label2.setBounds(110, 366, 100, 27);
        JLabel label3 = new JLabel("Inicio:");
        add(label3);
        label3.setBounds(240, 366, 150, 27);
        JLabel label4 = new JLabel("Final:");
        add(label4);
        label4.setBounds(410, 366, 150, 27);
        JLabel label5 = new JLabel("Hora:");
        add(label5);
        label5.setBounds(580, 366, 100, 27);
        JTextField field1 = new JTextField("");
        add(field1);
        field1.setBounds(280, 366, 100, 27);
        JTextField field2 = new JTextField("");
        add(field2);
        field2.setBounds(450, 366, 100, 27);
        String[] hora1 = {"5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"};
        JComboBox field3 = new JComboBox(hora1);
        add(field3);
        field3.setBounds(620, 366, 70, 27);
        String[] hora2 = {"00", "10", "20", "30", "40", "50"};
        JComboBox field4 = new JComboBox(hora2);
        add(field4);
        field4.setBounds(680, 366, 70, 27);

        JButton button1 = new JButton("✓");
        button1.setBounds(760, 359, 40, 40);
        add(button1);

        getRootPane().setDefaultButton(button1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String start = field1.getText();
                String end = field2.getText();

                if (start.equals("") || end.equals("") || start.matches("[0-9/[$-/:-?{-~!\"^_`\\[\\]]/]+") || end.matches("[0-9/[$-/:-?{-~!\"^_`\\[\\]]/]+")) {
                    JOptionPane.showMessageDialog(CrearViaje.this,
                            "Rellene todos los campos",
                            "Crear Viaje",
                            JOptionPane.ERROR_MESSAGE);
                    field1.setText("");
                    field2.setText("");
                } else {

                    try {
                        DatabaseAccess.getInstance().addViaje(field1.getText(), field2.getText(), (String) field3.getSelectedItem() + ":" + field4.getSelectedItem());

                        dispose();
                        Viajes window = null;
                        try {
                            window = new Viajes();
                        } catch (IOException ex) {
                            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        window.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(Viajes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
        );

        JButton back = new JButton("< VOLVER");
        back.setBounds(350, 482, 200, 50);
        add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        }
        );

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(70, 325, 760, 150);
        g.drawRect(75, 330, 750, 140);
        g.drawRect(87, 381, 123, 40);

    }

}
