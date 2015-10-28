package tests.UserServices;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
public class TestFrameExample {
   public static void main(String s[]) {
       JFrame frame = new JFrame("MedTrav - Return home healthier");
       Image icon = Toolkit.getDefaultToolkit().getImage("medtrav.JPG");
      frame.setIconImage(icon);
       JPanel panel = new JPanel();
       panel.setLayout(new FlowLayout());
      // JLabel label = new JLabel("This is a label!");
       JLabel loginLabel = new JLabel("Login");
       JTextField loginField  = new JTextField();
       JLabel pwdLabel = new JLabel("Password");
       JTextField pwdField  = new JTextField();
       JButton button = new JButton();
       button.setText("Login");
       //panel.add(label);
       panel.add(loginLabel);
       panel.add(loginField);
       panel.add(pwdLabel);
       panel.add(pwdField);
       panel.add(button);
       frame.add(panel);
       frame.setSize(800, 600);
       frame.setResizable(false);
       frame.setLocationRelativeTo(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
   }
}
