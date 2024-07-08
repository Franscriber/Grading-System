import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Dimension;

public class Portal {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portal window = new Portal();
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
	public Portal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.getContentPane().setBackground(new Color(255, 228, 181));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("ADMIN");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.setBounds(97, 59, 242, 63);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnStudent = new JButton("STUDENT");
		btnStudent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStudent.setForeground(new Color(0, 0, 0));
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student.main(null);
				frame.dispose();
			}
		});
		btnStudent.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnStudent.setBackground(new Color(255, 160, 122));
		btnStudent.setBounds(97, 133, 242, 63);
		frame.getContentPane().add(btnStudent);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
