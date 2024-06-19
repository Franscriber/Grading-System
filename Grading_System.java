import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
import java.awt.Font;
import java.awt.Color;

public class Grading_System extends JFrame {
    private JTextField studentIDField, firstnameField, lastnameField, subjectField;
    private JTextField classParticipationField, quizzesField, majorExamField, attendanceField, midtermExamField, finalExamField;
    private JButton addButton, updateButton, deleteButton, clearButton, exitButton;
    private JTable table;
    private DefaultTableModel model;

    public Grading_System() {
        setTitle("Student Grading System");
        setSize(1278, 755);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 222, 179));
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblStudentID = new JLabel("Student ID:");
        lblStudentID.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblStudentID.setBounds(115, 98, 133, 25);
        panel.add(lblStudentID);

        studentIDField = new JTextField();
        studentIDField.setFont(new Font("Tahoma", Font.BOLD, 13));
        studentIDField.setBounds(257, 98, 109, 25);
        panel.add(studentIDField);

        JLabel lblFirstname = new JLabel("Firstname:");
        lblFirstname.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblFirstname.setBounds(376, 98, 133, 25);
        panel.add(lblFirstname);

        firstnameField = new JTextField();
        firstnameField.setFont(new Font("Tahoma", Font.BOLD, 13));
        firstnameField.setBounds(503, 98, 114, 25);
        panel.add(firstnameField);

        JLabel lblLastname = new JLabel("Lastname:");
        lblLastname.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblLastname.setBounds(627, 98, 117, 25);
        panel.add(lblLastname);

        lastnameField = new JTextField();
        lastnameField.setFont(new Font("Tahoma", Font.BOLD, 13));
        lastnameField.setBounds(754, 98, 117, 25);
        panel.add(lastnameField);

        JLabel lblSubject = new JLabel("Subject:");
        lblSubject.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblSubject.setBounds(881, 98, 96, 25);
        panel.add(lblSubject);

        subjectField = new JTextField();
        subjectField.setFont(new Font("Tahoma", Font.BOLD, 13));
        subjectField.setBounds(978, 98, 122, 25);
        panel.add(subjectField);

        JLabel lblClassParticipation = new JLabel("Class Participation:");
        lblClassParticipation.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblClassParticipation.setBounds(304, 175, 222, 25);
        panel.add(lblClassParticipation);

        classParticipationField = new JTextField();
        classParticipationField.setFont(new Font("Tahoma", Font.BOLD, 13));
        classParticipationField.setBounds(523, 175, 132, 25);
        panel.add(classParticipationField);

        JLabel lblQuizzes = new JLabel("Quizzes:");
        lblQuizzes.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblQuizzes.setBounds(302, 211, 117, 25);
        panel.add(lblQuizzes);

        quizzesField = new JTextField();
        quizzesField.setFont(new Font("Tahoma", Font.BOLD, 13));
        quizzesField.setBounds(523, 211, 132, 25);
        panel.add(quizzesField);

        JLabel lblMajorExam = new JLabel("Major Exam:");
        lblMajorExam.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblMajorExam.setBounds(718, 175, 142, 25);
        panel.add(lblMajorExam);

        majorExamField = new JTextField();
        majorExamField.setFont(new Font("Tahoma", Font.BOLD, 13));
        majorExamField.setBounds(870, 175, 138, 25);
        panel.add(majorExamField);

        JLabel lblAttendance = new JLabel("Attendance:");
        lblAttendance.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblAttendance.setBounds(718, 211, 142, 25);
        panel.add(lblAttendance);

        attendanceField = new JTextField();
        attendanceField.setFont(new Font("Tahoma", Font.BOLD, 13));
        attendanceField.setBounds(870, 211, 138, 25);
        panel.add(attendanceField);

        JLabel lblMidtermExam = new JLabel("Midterm Exam:");
        lblMidtermExam.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblMidtermExam.setBounds(346, 308, 172, 25);
        panel.add(lblMidtermExam);

        midtermExamField = new JTextField();
        midtermExamField.setFont(new Font("Tahoma", Font.BOLD, 13));
        midtermExamField.setBounds(523, 312, 132, 25);
        panel.add(midtermExamField);

        JLabel lblFinalExam = new JLabel("Final Exam:");
        lblFinalExam.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblFinalExam.setBounds(718, 308, 142, 25);
        panel.add(lblFinalExam);

        finalExamField = new JTextField();
        finalExamField.setFont(new Font("Tahoma", Font.BOLD, 13));
        finalExamField.setBounds(870, 312, 138, 25);
        panel.add(finalExamField);

        addButton = new JButton("SAVE");
        addButton.setBackground(new Color(255, 160, 122));
        addButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        addButton.setBounds(582, 364, 90, 46);
        panel.add(addButton);

        updateButton = new JButton("UPDATE");
        updateButton.setBackground(new Color(255, 160, 122));
        updateButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        updateButton.setBounds(483, 622, 90, 49);
        panel.add(updateButton);

        deleteButton = new JButton("DELETE");
        deleteButton.setBackground(new Color(255, 160, 122));
        deleteButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        deleteButton.setBounds(638, 622, 90, 49);
        panel.add(deleteButton);

        clearButton = new JButton("CLEAR");
        clearButton.setBackground(new Color(255, 160, 122));
        clearButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        clearButton.setBounds(698, 364, 90, 46);
        panel.add(clearButton);

        exitButton = new JButton("EXIT");
        exitButton.setBackground(new Color(255, 160, 122));
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        exitButton.setBounds(783, 622, 90, 49);
        panel.add(exitButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 458, 1251, 150);
        panel.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(255, 255, 224));
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int i=table.getSelectedRow();
				studentIDField.setText(model.getValueAt(i, 0).toString());
				firstnameField.setText(model.getValueAt(i, 1).toString());
				lastnameField.setText(model.getValueAt(i, 2).toString());
				subjectField.setText(model.getValueAt(i, 3).toString());
				classParticipationField.setText(model.getValueAt(i, 4).toString());
				quizzesField.setText(model.getValueAt(i, 5).toString());
				majorExamField.setText(model.getValueAt(i, 6).toString());
				attendanceField.setText(model.getValueAt(i, 7).toString());
				midtermExamField.setText(model.getValueAt(i, 8).toString());
				finalExamField.setText(model.getValueAt(i, 9).toString());
				
				
        	}
        });
        scrollPane.setViewportView(table);
        model = new DefaultTableModel();
        table.setModel(model);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 259, 1251, 25);
        panel.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 139, 1251, 25);
        panel.add(separator_1);
        
        JLabel lblNewLabel = new JLabel("GRADING SYSTEM");
        lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 51));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(403, 38, 536, 49);
        panel.add(lblNewLabel);
        model.addColumn("Student ID");
        model.addColumn("Firstname");
        model.addColumn("Lastname");
        model.addColumn("Subject");
        model.addColumn("Class Participation");
        model.addColumn("Quizzes");
        model.addColumn("Major Exam");
        model.addColumn("Attendance");
        model.addColumn("Midterm Exam");
        model.addColumn("Final Exam");
        model.addColumn("Final Grade");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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
                        rs.getDouble("class_participation"),
                        rs.getDouble("quizzes"),
                        rs.getDouble("major_exam"),
                        rs.getDouble("attendance"),
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

    private void addStudent() {
        try {
            double classParticipation = Double.parseDouble(classParticipationField.getText());
            double quizzes = Double.parseDouble(quizzesField.getText());
            double majorExam = Double.parseDouble(majorExamField.getText());
            double attendance = Double.parseDouble(attendanceField.getText());
            double midtermExam = Double.parseDouble(midtermExamField.getText());
            double finalExam = Double.parseDouble(finalExamField.getText());

            double total = (classParticipation + quizzes + majorExam + attendance) / 0.4;
            double finalGrade = (total) + (midtermExam * 0.3) + (finalExam * 0.3);

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grading_system", "root", "");
            String sql = "INSERT INTO students (student_id, firstname, lastname, subject, class_participation, quizzes, major_exam, attendance, midterm_exam, final_exam, final_grade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentIDField.getText());
            pstmt.setString(2, firstnameField.getText());
            pstmt.setString(3, lastnameField.getText());
            pstmt.setString(4, subjectField.getText());
            pstmt.setDouble(5, classParticipation);
            pstmt.setDouble(6, quizzes);
            pstmt.setDouble(7, majorExam);
            pstmt.setDouble(8, attendance);
            pstmt.setDouble(9, midtermExam);
            pstmt.setDouble(10, finalExam);
            pstmt.setDouble(11, finalGrade);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Saved!");

            conn.close();
            loadStudents();
            clearFields();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fill up the Form");
        }
    }

    private void updateStudent() {
        try {
            double classParticipation = Double.parseDouble(classParticipationField.getText());
            double quizzes = Double.parseDouble(quizzesField.getText());
            double majorExam = Double.parseDouble(majorExamField.getText());
            double attendance = Double.parseDouble(attendanceField.getText());
            double midtermExam = Double.parseDouble(midtermExamField.getText());
            double finalExam = Double.parseDouble(finalExamField.getText());

            double total = (classParticipation + quizzes + majorExam + attendance) / 0.4;
            double finalGrade = (total / 0.4) + (midtermExam * 0.3) + (finalExam * 0.3);

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grading_system", "root", "");
            String sql = "UPDATE students SET firstname=?, lastname=?, subject=?, class_participation=?, quizzes=?, major_exam=?, attendance=?, midterm_exam=?, final_exam=?, final_grade=? WHERE student_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstnameField.getText());
            pstmt.setString(2, lastnameField.getText());
            pstmt.setString(3, subjectField.getText());
            pstmt.setDouble(4, classParticipation);
            pstmt.setDouble(5, quizzes);
            pstmt.setDouble(6, majorExam);
            pstmt.setDouble(7, attendance);
            pstmt.setDouble(8, midtermExam);
            pstmt.setDouble(9, finalExam);
            pstmt.setDouble(10, finalGrade);
            pstmt.setInt(11, Integer.parseInt(studentIDField.getText()));
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Updated!");
            
            conn.close();
            loadStudents();
            clearFields();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Select column from Table");
        }
    }

    private void deleteStudent() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grading_system", "root", "");
            String sql = "DELETE FROM students WHERE student_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(studentIDField.getText()));
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Deleted!");

            conn.close();
            loadStudents();
            clearFields();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Select a column");
        }
    }

    private void clearFields() {
        studentIDField.setText("");
        firstnameField.setText("");
        lastnameField.setText("");
        subjectField.setText("");
        classParticipationField.setText("");
        quizzesField.setText("");
        majorExamField.setText("");
        attendanceField.setText("");
        midtermExamField.setText("");
        finalExamField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Grading_System().setVisible(true);
            }
        });
    }
}
