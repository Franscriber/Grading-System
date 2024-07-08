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
import java.awt.Cursor;
import javax.swing.SwingConstants;

public class login {

	private static JFrame frame;
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
					frame.setLocationRelativeTo(null);
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
		frame.setResizable(false);
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
		
		JLabel lblLogInSystem = new JLabel("ADMIN LOGIN");
		lblLogInSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogInSystem.setForeground(new Color(0, 0, 0));
		lblLogInSystem.setFont(new Font("Algerian", Font.BOLD, 50));
		lblLogInSystem.setBounds(187, 33, 410, 73);
		frame.getContentPane().add(lblLogInSystem);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setForeground(new Color(0, 0, 0));
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
					frame.dispose();
				}
				else JOptionPane.showMessageDialog(null, "Wrong Username or Password", "Login Error!", JOptionPane.ERROR_MESSAGE);
				
				textFieldFirst.setText(null);
				textPassword.setText(null);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(78, 391, 156, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("CLEAR");
		btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.setBackground(new Color(255, 160, 122));
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				textFieldFirst.setText("");
				textPassword.setText("");

			}});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(306, 391, 156, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setBackground(new Color(255, 160, 122));
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Portal.main(null);
				frame.dispose();
			}
			
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBounds(546, 391, 156, 23);
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
