import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
import java.awt.Font;
import java.awt.Color;

public class Student extends JFrame {
	private JFrame frame;
    private JButton exitButton;
    private JTable table;
    private DefaultTableModel model;

    public Student() {
        setTitle("Student Grading System");
        setSize(765, 612);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 222, 179));
        getContentPane().add(panel);
        panel.setLayout(null);

        exitButton = new JButton("EXIT");
        exitButton.setBackground(new Color(255, 160, 122));
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        exitButton.setBounds(21, 458, 700, 49);
        panel.add(exitButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 108, 700, 312);
        panel.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(255, 255, 224));
        scrollPane.setViewportView(table);
        model = new DefaultTableModel();
        table.setModel(model);
        
        JLabel lblNewLabel = new JLabel("STUDENTS LIST");
        lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 51));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(103, 38, 536, 49);
        panel.add(lblNewLabel);
        model.addColumn("Student ID");
        model.addColumn("Firstname");
        model.addColumn("Lastname");
        model.addColumn("Subject");
        model.addColumn("Midterm Exam");
        model.addColumn("Final Exam");
        model.addColumn("Final Grade");

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	frame = new JFrame ("EXIT");
				if (JOptionPane.showConfirmDialog(frame, "You want to EXIT?", "Exiting the program...",
						JOptionPane.YES_NO_OPTION) ==JOptionPane.YES_NO_OPTION) {
				
				
				Portal.main(null);
				};
            	
            }
        });

        loadStudents();
    }

    private void loadStudents() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grading_system", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("student_id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("subject"),
                        rs.getDouble("midterm_exam"),
                        rs.getDouble("final_exam"),
                        rs.getDouble("final_grade")
                });
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Student().setVisible(true);
            }
        });
    }
}
