package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Clienti extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	String url = "jdbc:sqlserver://DESKTOP-EROKGO6:1433;databaseName=Farmacie";
	String user ="sa";
	String password ="parola123";
	String [] options = {"Nume", "Prenume","CNP"};
	int selectedValue;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clienti frame = new Clienti();
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
	public Clienti() {
		setTitle("Clienti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Afisare toti clientii");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection connection = DriverManager.getConnection(url, user, password);
					
					String sql ="SELECT * from Clienti";
					
					Statement statement = connection.createStatement();
					
					ResultSet result = statement.executeQuery(sql);
					
					String aux="";
					aux=aux+"Nume Prenume CNP\n";
					
				
					
					while(result.next()){
						
						aux=aux+result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+'\n';
					}
					JOptionPane.showMessageDialog(null,aux);
					connection.close();
			}
			 catch (SQLException e1) {
				 JOptionPane.showMessageDialog(null, "Oops,there's an error");
				
				e1.printStackTrace();
			}
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(244, 54, 143, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Adaugare client");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdaugaClienti obj = new AdaugaClienti();
				obj.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(53, 54, 124, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Stergere client");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
try {
							
					Connection connection2 = DriverManager.getConnection(url, user, password);
					
					String sql3 ="DELETE FROM Clienti WHERE idClient = "+ textField.getText()+" ";
					
					Statement stmt = connection2.createStatement();
					JOptionPane.showMessageDialog(null, "Clientul cu ID-ul "+textField.getText()+" va fi sters din baza de date.");
					stmt.executeUpdate(sql3);
					JOptionPane.showMessageDialog(null, "Stergere reusita");
					
					connection2.close();
			}
			 catch (SQLException e1) {
				 JOptionPane.showMessageDialog(null, "Oops,there's an error");
				
				e1.printStackTrace();
			}
				
				
				
			}
		});
		btnNewButton_2.setBounds(53, 150, 124, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Disconnect");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.setVisible(false);
				dispose();
				Test.main(null);
				
				
			}
		});
		btnNewButton_3.setBounds(314, 227, 110, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Modificare client");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					
					Connection connection5 = DriverManager.getConnection(url, user, password);
					
					String sqlv ="UPDATE Clienti "
							+ "SET " + options[selectedValue] + " = '" + textField_1.getText() 
							+"' WHERE idClient = " + textField.getText()+ " ";
					
					
					Statement stmt1 = connection5.createStatement();
					
					
					stmt1.executeUpdate(sqlv);
					JOptionPane.showMessageDialog(null, "Modificare reusita");
					
					connection5.close();
			}
			 catch (SQLException e1) {
				 JOptionPane.showMessageDialog(null, "Oops,there's an error");
				
				e1.printStackTrace();
			}
				
				
				
				
				
				
			}
			
		});
		btnNewButton_4.setBounds(258, 176, 129, 23);
		contentPane.add(btnNewButton_4);
		
		textField = new JTextField();
		textField.setBounds(89, 120, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Client ID:");
		lblNewLabel.setBounds(35, 123, 57, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Noua valoare:");
		lblNewLabel_1.setBounds(216, 154, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(298, 151, 89, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		comboBox = new JComboBox(options);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedValue = comboBox.getSelectedIndex();
				
				
			}
			
		});
		comboBox.setBounds(298, 119, 89, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Criteriu:");
		lblNewLabel_1_1.setBounds(216, 123, 79, 14);
		contentPane.add(lblNewLabel_1_1);
	}

}
