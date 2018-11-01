
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
    private JButton btnLogin;
    private JButton btnSignUp;
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
        
//        btnSignUp = new JButton("Crear Cuenta");
//        
//        btnSignUp.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//                SignUp window = null;
//                try {
//                    window = new SignUp();
//                } catch (IOException ex) {
//                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                window.setVisible(true);
//                setVisible(true);
//                
//            }
//        });
        
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        //bp.add(btnSignUp);
        bp.add(btnCancel);

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
