package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class Subcereri extends JFrame {

	private JPanel contentPane;
	String url = "jdbc:sqlserver://DESKTOP-EROKGO6:1433;databaseName=Farmacie";
	String user ="sa";
	String password ="parola123";
	JComboBox comboBox;
	String [] options = {"Fitterman","PharmaSun","Pfizer","Moderna"};
	int selectedValue;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Subcereri frame = new Subcereri();
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
	public Subcereri() {
		setTitle("Subcereri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Sa se afiseze toti clientii care au primit retete de la angajatul cu numele \"Ionescu\"");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					Connection connection = DriverManager.getConnection(url, user, password);
					
					String sql ="select distinct c.Nume,c.Prenume\r\n"
							+ "from Clienti c\r\n"
							+ "inner join Reteta r on c.idClient=r.idClient\r\n"
							+ "where r.idAngajat = ANY  (select a.AngajatID from Angajati a where a.nume='Ionescu')\r\n"
							+ "";
					
					Statement statement = connection.createStatement();
					
					ResultSet result = statement.executeQuery(sql);
					
					String aux="";
					aux=aux+"-- Nume Prenume \n";
					
				
					//JOptionPane.showMessageDialog(null,"AngajatID ManagerID Nume Prenume CNP Strada Numar Oras Judet Sex Data Nasterii Salariu");
					while(result.next()){
						
						aux=aux+result.getString(1)+" "+result.getString(2)+'\n';
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
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.setBounds(28, 35, 532, 54);
		contentPane.add(btnNewButton);
		
		JButton btnSaSeAfiseze = new JButton("Sa se afiseze medicamentele care expira dupa 15 februarie 2022");
		btnSaSeAfiseze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					Connection connection = DriverManager.getConnection(url, user, password);
					
					String sql ="select m1.idMedicament,m1.Denumire,m1.cod\r\n"
							+ "from Medicamente m1\r\n"
							+ "where m1.idMedicament NOT IN (select m.idMedicament\r\n"
							+ "from Medicamente m\r\n"
							+ "inner join RetetaMed rm on m.idMedicament=rm.idMedicament) and m1.dataExpirarii>(02-15-2022)\r\n"
							+ "";
					
					Statement statement = connection.createStatement();
					
					ResultSet result = statement.executeQuery(sql);
					
					String aux="";
					aux=aux+"idMedicament Denumire Cod \n";
					
				
					//JOptionPane.showMessageDialog(null,"AngajatID ManagerID Nume Prenume CNP Strada Numar Oras Judet Sex Data Nasterii Salariu");
					while(result.next()){
						
						aux=aux+result.getInt(1)+" "+result.getString(2)+" "+result.getInt(3)+'\n';
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
		btnSaSeAfiseze.setBackground(UIManager.getColor("Button.light"));
		btnSaSeAfiseze.setBounds(28, 100, 532, 54);
		contentPane.add(btnSaSeAfiseze);
		
		JLabel lblNewLabel = new JLabel("si care nu se afla pe nicio reteta in acest moment");
		lblNewLabel.setBounds(169, 157, 441, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(UIManager.getColor("Button.light"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.setVisible(false);
				dispose();
				Test.main(null);
				
			}
		});
		btnNewButton_1.setBounds(551, 382, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnSaSeAfiseze_2 = new JButton("Sa se afiseze angajatii care au peste 2 retete scrise si ");
		btnSaSeAfiseze_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					Connection connection = DriverManager.getConnection(url, user, password);
					
					String sql ="select ab.Nume,ab.Prenume,ab.salariu\r\n"
							+ "from Angajati ab \r\n"
							+ "inner join Reteta r on ab.AngajatID=r.idAngajat\r\n"
							+ "where EXISTS (select a.AngajatID\r\n"
							+ "from Angajati a, Angajati a2\r\n"
							+ "group by a.AngajatID, a.Salariu\r\n"
							+ "having a.salariu > avg(a2.salariu))\r\n"
							+ "group by ab.Nume,ab.Prenume,ab.Salariu\r\n"
							+ "having count(r.idAngajat)>=2 \r\n"
							+ "";
					
					Statement statement = connection.createStatement();
					
					ResultSet result = statement.executeQuery(sql);
					
					String aux="";
					aux=aux+"Nume Prenume Salariu \n";
					
				
					//JOptionPane.showMessageDialog(null,"AngajatID ManagerID Nume Prenume CNP Strada Numar Oras Judet Sex Data Nasterii Salariu");
					while(result.next()){
						
						aux=aux+result.getString(1)+" "+result.getString(2)+" "+result.getInt(3)+'\n';
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
		btnSaSeAfiseze_2.setBackground(UIManager.getColor("Button.light"));
		btnSaSeAfiseze_2.setBounds(28, 182, 532, 54);
		contentPane.add(btnSaSeAfiseze_2);
		
		JLabel lblNewLabel_1 = new JLabel("salariul peste salariul mediu al farmaciei.");
		lblNewLabel_1.setBounds(197, 247, 319, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSaSeAfiseze_2_1 = new JButton("Sa se afiseze toti clientii care au retete cu medicamente de la un anumit producator.");
		btnSaSeAfiseze_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					Connection connection = DriverManager.getConnection(url, user, password);
					
					String sql ="select c.Nume,c.Prenume\r\n"
							+ "from Clienti c\r\n"
							+ "inner join Reteta r on c.idClient=r.idClient\r\n"
							+ "inner join RetetaMed rm on r.idReteta=rm.idReteta\r\n"
							+ "inner join Medicamente m on rm.idMedicament = m.idMedicament\r\n"
							+ "where m.idMedicament in (select mm.idMedicament from Medicamente mm inner join Producatori p on mm.idProducator=p.idProducator\r\n"
							+ "where p.NumeProducator = '"+options[selectedValue]+"')";
					
					Statement statement = connection.createStatement();
					
					ResultSet result = statement.executeQuery(sql);
					
					String aux="";
					aux=aux+"Nume Prenume \n";
					
				
					//JOptionPane.showMessageDialog(null,"AngajatID ManagerID Nume Prenume CNP Strada Numar Oras Judet Sex Data Nasterii Salariu");
					while(result.next()){
						
						aux=aux+result.getString(1)+" "+result.getString(2)+'\n';
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
		btnSaSeAfiseze_2_1.setBackground(UIManager.getColor("Button.light"));
		btnSaSeAfiseze_2_1.setBounds(28, 272, 532, 54);
		contentPane.add(btnSaSeAfiseze_2_1);
		
		comboBox = new JComboBox(options);
		comboBox.setBackground(UIManager.getColor("Button.light"));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectedValue = comboBox.getSelectedIndex();
				
			}
		});
		comboBox.setBounds(244, 348, 98, 28);
		contentPane.add(comboBox);
	}
}
