
/*
 * Javier Zudaire
 */
package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;

public class Login2 extends JDialog {

    public static String username;

    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JLabel lbUsernameSignUp;
    private JTextField tfUsernameSignUp;
    private JLabel lbPasswordSignUp1;
    private JTextField tfPasswordSignUp1;
    private JLabel lbPasswordSignUp2;
    private JTextField tfPasswordSignUp2;
    private JLabel lbEmailSignUp;
    private JTextField tfEmailSignUp;
    private JLabel lbBirthdaySignUp;
    private JTextField tfBirthdaySignUp;
    private JLabel lbPhoneSignUp;
    private JTextField tfPhoneSignUp;
    private JButton btnLogin;
    private JButton btnSignUp1;
    private JButton btnSignUp2;
    private JLabel dyal;
    private JButton btnCancel;
    private boolean succeeded;

    public Login2(Frame parent) {
        super(parent, "DYAL", true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        lbUsername = new JLabel(" Usuario: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);

        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);

        lbPassword = new JLabel(" Contraseña: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);

        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        btnLogin = new JButton("Iniciar Sesión");

        getRootPane().setDefaultButton(btnLogin);

        btnLogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    if (Login1.authenticate(getUsername(), getPassword())) {
                        JOptionPane.showMessageDialog(Login2.this,
                                "Bienvenido " + getUsername() + "! Has accedido correctamente.",
                                "Iniciar Sesión",
                                JOptionPane.INFORMATION_MESSAGE);
                        User.getInstance().addUser(getUsername());
                        username = getUsername();
                        succeeded = true;
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(Login2.this,
                                "Usuario o contraseña invalido",
                                "Iniciar Sesión",
                                JOptionPane.ERROR_MESSAGE);

                        tfUsername.setText("");
                        pfPassword.setText("");
                        succeeded = false;

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnSignUp1 = new JButton("Crear Cuenta");

        btnSignUp2 = new JButton("Crear Cuenta");

        btnSignUp1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                panel.removeAll();
                panel.repaint();
                btnLogin.setVisible(false);
                btnSignUp1.setVisible(false);
                btnSignUp2.setVisible(true);

                setSize(500, 300);

                lbUsernameSignUp = new JLabel(" Usuario: ");
                cs.gridx = 0;
                cs.gridy = 0;
                cs.gridwidth = 1;
                panel.add(lbUsernameSignUp, cs);

                tfUsernameSignUp = new JTextField(20);
                cs.gridx = 1;
                cs.gridy = 0;
                cs.gridwidth = 2;
                panel.add(tfUsernameSignUp, cs);

                lbPasswordSignUp1 = new JLabel(" Contraseña: ");
                cs.gridx = 0;
                cs.gridy = 1;
                cs.gridwidth = 1;
                panel.add(lbPasswordSignUp1, cs);

                tfPasswordSignUp1 = new JTextField(20);
                cs.gridx = 1;
                cs.gridy = 1;
                cs.gridwidth = 2;
                panel.add(tfPasswordSignUp1, cs);

                lbPasswordSignUp2 = new JLabel(" Verifique contraseña: ");
                cs.gridx = 0;
                cs.gridy = 2;
                cs.gridwidth = 1;
                panel.add(lbPasswordSignUp2, cs);

                tfPasswordSignUp2 = new JTextField(20);
                cs.gridx = 1;
                cs.gridy = 2;
                cs.gridwidth = 2;
                panel.add(tfPasswordSignUp2, cs);
                panel.setBorder(new LineBorder(Color.GRAY));

                lbEmailSignUp = new JLabel(" Email: ");
                cs.gridx = 0;
                cs.gridy = 3;
                cs.gridwidth = 1;
                panel.add(lbEmailSignUp, cs);

                tfEmailSignUp = new JTextField(20);
                cs.gridx = 1;
                cs.gridy = 3;
                cs.gridwidth = 2;
                panel.add(tfEmailSignUp, cs);
                panel.setBorder(new LineBorder(Color.GRAY));

                lbBirthdaySignUp = new JLabel(" Fecha de nacimiento: ");
                cs.gridx = 0;
                cs.gridy = 4;
                cs.gridwidth = 1;
                panel.add(lbBirthdaySignUp, cs);

                tfBirthdaySignUp = new JTextField(20);
                tfBirthdaySignUp.setText("dd/mm/aa");
                cs.gridx = 1;
                cs.gridy = 4;
                cs.gridwidth = 2;
                panel.add(tfBirthdaySignUp, cs);
                panel.setBorder(new LineBorder(Color.GRAY));

                lbPhoneSignUp = new JLabel(" Número de teléfono: ");
                cs.gridx = 0;
                cs.gridy = 5;
                cs.gridwidth = 1;
                panel.add(lbPhoneSignUp, cs);

                tfPhoneSignUp = new JTextField(20);
                cs.gridx = 1;
                cs.gridy = 5;
                cs.gridwidth = 2;
                panel.add(tfPhoneSignUp, cs);
                panel.setBorder(new LineBorder(Color.GRAY));

            }

        });

        btnSignUp2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (!tfPasswordSignUp1.getText().equals(tfPasswordSignUp2.getText())) {

                    JOptionPane.showMessageDialog(Login2.this,
                            "Las contraseñas no coinciden",
                            "Crear Cuenta",
                            JOptionPane.ERROR_MESSAGE);

                    tfPasswordSignUp1.setText("");
                    tfPasswordSignUp2.setText("");

                } else {

                    String user = tfUsernameSignUp.getText();
                    String password = tfPasswordSignUp1.getText();
                    String email = tfEmailSignUp.getText();
                    String birthday = tfBirthdaySignUp.getText();
                    String phone = tfPhoneSignUp.getText();

                    try {
                        if (DatabaseAccess.getInstance().usuarioNoRepetido(user).equals("0") && DatabaseAccess.getInstance().emailNoRepetido(email).equals("0")) {
                            try {
                                DatabaseAccess.getInstance().crearUsuario(user, password, email, birthday, phone);
                            } catch (SQLException ex) {
                                Logger.getLogger(Login2.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            username = tfUsernameSignUp.getText();
                            succeeded = true;
                            dispose();
                        } else {

                            JOptionPane.showMessageDialog(Login2.this,
                                    "El nombre de usuario o email ya Existe. Por favor, elige otro distinto  ",
                                    "Crear Cuenta",
                                    JOptionPane.ERROR_MESSAGE);

                            tfPasswordSignUp1.setText("");
                            tfPasswordSignUp2.setText("");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Login2.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        });

        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnSignUp1);
        bp.add(btnSignUp2);
        bp.add(btnCancel);

        btnSignUp2.setVisible(false);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(parent);

    }

    public String getUsername() {
        return tfUsername.getText().trim();
    }

    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

    public boolean isSucceeded() {
        return succeeded;
    }

}
