/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sir;

import ConnexionBD.DatabaseAccessProperties;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Brune
 */
public class SIR extends JFrame {
    DatabaseAccessProperties dap;
    
    public SIR() throws ClassNotFoundException {
        super("Hôpital Princeton Plainsborough");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);
        dap = new DatabaseAccessProperties();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel( new NimbusLookAndFeel());
        SIR sir = new SIR();
        sir.setVisible(true);
    }
    
}
