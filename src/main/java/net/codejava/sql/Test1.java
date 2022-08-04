package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Test1 extends JFrame {

	private JPanel contentPane;
	String url = "jdbc:sqlserver://DESKTOP-EROKGO6:1433;databaseName=Farmacie";
	String user ="sa";
	String password ="parola123";
	private JTextField textField;
	private JTextField textField_1;
	JComboBox comboBox;
	int selectedValue;
	String[] options= {"ManagerID","Nume","Prenume","CNP","Strada","Numar","Oras","Judet","Sex","DataNasterii","Salariu"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1 frame = new Test1();
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
	public Test1() {
		setTitle("Angajati");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Afisare toti angajatii");
		btnNewButton.setBounds(242, 39, 200, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					try {
						
						Connection connection = DriverManager.getConnection(url, user, password);
						
						String sql ="SELECT * from Angajati";
						
						Statement statement = connection.createStatement();
						
						ResultSet result = statement.executeQuery(sql);
						
						String aux="";
						aux=aux+"AngajatID ManagerID Nume Prenume CNP Strada Numar Oras Judet Sex Data Nasterii Salariu\n";
						
					
						//JOptionPane.showMessageDialog(null,"AngajatID ManagerID Nume Prenume CNP Strada Numar Oras Judet Sex Data Nasterii Salariu");
						while(result.next()){
							
							aux=aux+result.getInt(1)+" "+result.getInt(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)
							+" "+result.getString(6)+" "+result.getInt(7)+" "+result.getString(8)+" "+ result.getString(9)+ " " + result.getString(10)+ " " + result.getString(11)+ " " +result.getInt(12)+"\n\n";
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
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Disconnect");
		btnNewButton_1.setBounds(341, 245, 112, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				Test.main(null);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Adaugare angajat");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdaugareAngajat obj = new AdaugareAngajat();
				obj.setVisible(true);
				
				
			}
		});
		btnNewButton_2.setBounds(46, 39, 139, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Stergere angajat");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					Connection connection2 = DriverManager.getConnection(url, user, password);
					
					String sql3 ="DELETE FROM Angajati WHERE AngajatID = "+ textField.getText()+" ";
					
					Statement stmt = connection2.createStatement();
					JOptionPane.showMessageDialog(null, "Angajatul cu ID-ul "+textField.getText()+" va fi sters din baza de date.");
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
		btnNewButton_3.setBounds(61, 181, 148, 28);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(122, 153, 87, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Modificare angajat");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					Connection connection5 = DriverManager.getConnection(url, user, password);
					
					String sqlv ="UPDATE Angajati "
							+ "SET " + options[selectedValue] + " = '" + textField_1.getText() 
							+"' WHERE AngajatID = " + textField.getText()+ " ";
					
					
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
		btnNewButton_4.setBounds(242, 181, 200, 28);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("AngajatID:");
		lblNewLabel.setBounds(61, 156, 86, 14);
		contentPane.add(lblNewLabel);
		
		
		
		comboBox = new JComboBox(options);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedValue = comboBox.getSelectedIndex();
				
				
				
			}
		});
		comboBox.setBounds(303, 104, 139, 22);
		contentPane.add(comboBox);
		
		JLabel lblCriteriu = new JLabel("Criteriu:");
		lblCriteriu.setBounds(242, 108, 86, 14);
		contentPane.add(lblCriteriu);
		
		JLabel lblNouaValoare = new JLabel("Noua valoare:");
		lblNouaValoare.setBounds(242, 153, 117, 14);
		contentPane.add(lblNouaValoare);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(325, 150, 117, 20);
		contentPane.add(textField_1);
	}
}
