
package interfaz;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SignUp extends JFrame {
    
    public SignUp() throws IOException {
        
        setTitle("DYAL");
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("InterfazBackground.png")))));
        setSize(900, 600);
        setLayout(null);
        setResizable(false);
        
        
        
    }
    
}
