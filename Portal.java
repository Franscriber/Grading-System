import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Portal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portal window = new Portal();
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
	public Portal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 181));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("ADMIN");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.main(null);
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 28));
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.setBounds(97, 59, 242, 63);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnStudent = new JButton("STUDENT");
		btnStudent.setForeground(new Color(255, 255, 255));
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student.main(null);
			}
		});
		btnStudent.setFont(new Font("Arial Black", Font.BOLD, 28));
		btnStudent.setBackground(new Color(255, 160, 122));
		btnStudent.setBounds(97, 133, 242, 63);
		frame.getContentPane().add(btnStudent);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
