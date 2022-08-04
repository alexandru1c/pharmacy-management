package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdaugaClienti extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String url = "jdbc:sqlserver://DESKTOP-EROKGO6:1433;databaseName=Farmacie";
	String user ="sa";
	String password ="parola123";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdaugaClienti frame = new AdaugaClienti();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdaugaClienti() {
		setTitle("Adaugare Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nume");
		lblNewLabel.setBounds(98, 68, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenume");
		lblNewLabel_1.setBounds(84, 110, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CNP");
		lblNewLabel_2.setBounds(102, 147, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Adauga client");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					Connection connection1 = DriverManager.getConnection(url, user, password);
				
					String sql1 = "INSERT INTO Clienti (Nume, Prenume, CNP) \r\n"
							+ "VALUES ('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"')";
					
					
					Statement statement1 = connection1.createStatement();
					
					statement1.executeUpdate(sql1);
					
					
					JOptionPane.showMessageDialog(null, "Adaugare reusita");
					contentPane.setVisible(false);
					dispose();
				
				
					
					connection1.close();
			}
			 catch (SQLException e1) {
				 JOptionPane.showMessageDialog(null, "Oops,there's an error");
				
				e1.printStackTrace();
			}
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(110, 187, 150, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Anulare");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.setVisible(false);
				dispose();
				
				
			}
		});
		btnNewButton_1.setBounds(151, 221, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(154, 65, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 107, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(154, 144, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}

}
