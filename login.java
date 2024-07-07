import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class login {

	private JFrame frame;
	private JTextField textFieldFirst;
	private JPasswordField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 181));
		frame.setBounds(100, 100, 782, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(196, 187, 156, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblPassword.setBounds(196, 236, 156, 38);
		frame.getContentPane().add(lblPassword);
		
		textFieldFirst = new JTextField();
		textFieldFirst.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldFirst.setBounds(362, 190, 213, 31);
		frame.getContentPane().add(textFieldFirst);
		textFieldFirst.setColumns(10);
		
		JLabel lblLogInSystem = new JLabel("LOG IN SYSTEM");
		lblLogInSystem.setForeground(new Color(0, 0, 0));
		lblLogInSystem.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblLogInSystem.setBounds(165, 46, 410, 38);
		frame.getContentPane().add(lblLogInSystem);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(255, 160, 122));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username=textFieldFirst.getText();
				String password=textPassword.getText();
				
				if (password.contains("admin1")&& username.contains("admin"))
				{
					textFieldFirst.setText(null);
					textPassword.setText(null);
					
					Grading_System.main(null);
				}
				else JOptionPane.showMessageDialog(null, "Wrong Username or Password", "Login Error!", JOptionPane.ERROR_MESSAGE);
				
				textFieldFirst.setText(null);
				textPassword.setText(null);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(70, 391, 156, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("CLEAR");
		btnReset.setBackground(new Color(255, 160, 122));
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				textFieldFirst.setText("");
				textPassword.setText("");

			}});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBounds(296, 391, 156, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBackground(new Color(255, 160, 122));
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame ("EXIT");
				if (JOptionPane.showConfirmDialog(frame, "You want to EXIT?", "Exiting the program...",
						JOptionPane.YES_NO_OPTION) ==JOptionPane.YES_NO_OPTION) {
				
				
				Portal.main(null);
				}
			;
			}
			
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBounds(516, 391, 156, 23);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(70, 130, 632, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(70, 349, 632, 2);
		frame.getContentPane().add(separator_1);
		
		textPassword = new JPasswordField();
		textPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		textPassword.setBounds(362, 241, 213, 31);
		frame.getContentPane().add(textPassword);
	}
}
