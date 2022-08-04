package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdaugareAngajat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
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
					AdaugareAngajat frame = new AdaugareAngajat();
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
	public AdaugareAngajat() {
		setTitle("AdaugareAngajat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(174, 34, 118, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(174, 65, 118, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(174, 96, 118, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(174, 127, 118, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(174, 158, 118, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(174, 195, 118, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(174, 227, 118, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(174, 258, 118, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(174, 289, 118, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(174, 320, 118, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(174, 351, 118, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ManagerID");
		lblNewLabel.setBounds(87, 37, 93, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setBounds(87, 68, 93, 14);
		contentPane.add(lblNume);
		
		JLabel lblPrenume = new JLabel("Prenume");
		lblPrenume.setBounds(87, 99, 93, 14);
		contentPane.add(lblPrenume);
		
		JLabel lblCnp = new JLabel("CNP");
		lblCnp.setBounds(87, 130, 93, 14);
		contentPane.add(lblCnp);
		
		JLabel lblStrada = new JLabel("Strada");
		lblStrada.setBounds(87, 161, 93, 14);
		contentPane.add(lblStrada);
		
		JLabel lblNumar = new JLabel("Numar");
		lblNumar.setBounds(87, 198, 93, 14);
		contentPane.add(lblNumar);
		
		JLabel lblOras = new JLabel("Oras");
		lblOras.setBounds(87, 230, 93, 14);
		contentPane.add(lblOras);
		
		JLabel lblJudet = new JLabel("Judet");
		lblJudet.setBounds(87, 261, 93, 14);
		contentPane.add(lblJudet);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(87, 292, 93, 14);
		contentPane.add(lblSex);
		
		JLabel lblDatanasterii = new JLabel("DataNasterii");
		lblDatanasterii.setBounds(87, 323, 93, 14);
		contentPane.add(lblDatanasterii);
		
		JLabel lblSalariu = new JLabel("Salariu");
		lblSalariu.setBounds(87, 354, 93, 14);
		contentPane.add(lblSalariu);
		
		JButton btnNewButton = new JButton("Adaugare angajat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					Connection connection1 = DriverManager.getConnection(url, user, password);
				
					String sql1 = "INSERT INTO Angajati (ManagerID, Nume, Prenume, CNP,Strada,Numar,Oras,Judet,Sex,DataNasterii,Salariu)\r\n"
							+ "VALUES ('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_4.getText()+"','"+textField_5.getText()+"','"+textField_6.getText()+"','"+textField_7.getText()+"','"+textField_8.getText()+"','"+textField_9.getText()+"','"+textField_5.getText()+"')";
					
					
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
		btnNewButton.setBounds(120, 382, 205, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblFormatLunazian = new JLabel("(format: LUNA-ZI-AN)");
		lblFormatLunazian.setBounds(297, 323, 145, 14);
		contentPane.add(lblFormatLunazian);
		
		JButton btnNewButton_1 = new JButton("Anulare");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
			
				
				
			}
		});
		btnNewButton_1.setBounds(174, 416, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
