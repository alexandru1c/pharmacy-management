package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Join extends JFrame {

	private JPanel contentPane;
	String url = "jdbc:sqlserver://DESKTOP-EROKGO6:1433;databaseName=Farmacie";
	String user ="sa";
	String password ="parola123";
	JComboBox comboBox;
	String [] options = {"Gedeon","Richter","Famexim","Beautik"};
	int selectedValue;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join frame = new Join();
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
	public Join() {
		setTitle("Exercitii join.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Id, cod, denumirea medicamentelor ce se afla pe minimum 2 retete.");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection connection = DriverManager.getConnection(url, user, password);
					
					String sql ="select m.idMedicament,m.Denumire,m.cod\r\n"
							+ "from Medicamente m\r\n"
							+ "inner join RetetaMed rm on m.idMedicament=rm.idMedicament\r\n"
							+ "group by m.idMedicament,m.cod,m.Denumire\r\n"
							+ "having count(*)>=2\r\n"
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
		btnNewButton.setBounds(27, 56, 621, 34);
		contentPane.add(btnNewButton);
		
		JButton btnTotiClientiiCare = new JButton("Toti clientii care au retete realizate de Angajatul cu id 18.");
		btnTotiClientiiCare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					Connection connection1 = DriverManager.getConnection(url, user, password);
					
					String sql1 ="select DISTINCT c.idClient,c.Nume,c.Prenume\r\n"
							+ "from Clienti c\r\n"
							+ "inner join Reteta r on c.idClient=r.idClient\r\n"
							+ "where r.idAngajat=18\r\n"
							+ "";
					
					Statement statement1 = connection1.createStatement();
					
					ResultSet result = statement1.executeQuery(sql1);
					
					String aux="";
					aux=aux+"idClient Nume Prenume \n";
					
				
					//JOptionPane.showMessageDialog(null,"AngajatID ManagerID Nume Prenume CNP Strada Numar Oras Judet Sex Data Nasterii Salariu");
					while(result.next()){
						
						aux=aux+result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+'\n';
					}
					JOptionPane.showMessageDialog(null,aux);
					connection1.close();
			}
			 catch (SQLException e1) {
				 JOptionPane.showMessageDialog(null, "Oops,there's an error");
				
				e1.printStackTrace();
			}
				
				
				
				
				
			}
		});
		btnTotiClientiiCare.setBounds(27, 101, 621, 34);
		contentPane.add(btnTotiClientiiCare);
		
		JButton btnToateMedicamenteleDe = new JButton("Toate medicamentele de la producatorul Fitterman");
		btnToateMedicamenteleDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					Connection connection1 = DriverManager.getConnection(url, user, password);
					
					String sql1 ="select m.idMedicament, m.Denumire,m.cod\r\n"
							+ "from Medicamente m\r\n"
							+ "inner join Producatori p on m.idProducator=p.idProducator\r\n"
							+ "where p.NumeProducator='Fitterman'";
					
					Statement statement1 = connection1.createStatement();
					
					ResultSet result = statement1.executeQuery(sql1);
					
					String aux="";
					aux=aux+"idMedicament Denumire Cod \n";
					
				
					//JOptionPane.showMessageDialog(null,"AngajatID ManagerID Nume Prenume CNP Strada Numar Oras Judet Sex Data Nasterii Salariu");
					while(result.next()){
						
						aux=aux+result.getInt(1)+" "+result.getString(2)+" "+result.getInt(3)+'\n';
					}
					JOptionPane.showMessageDialog(null,aux);
					connection1.close();
			}
			 catch (SQLException e1) {
				 JOptionPane.showMessageDialog(null, "Oops,there's an error");
				
				e1.printStackTrace();
			}
				
				
				
				
				
			}
		});
		btnToateMedicamenteleDe.setBounds(27, 146, 621, 34);
		contentPane.add(btnToateMedicamenteleDe);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				Test.main(null);
				
				
			}
		});
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnSaSeAfiseze = new JButton("Sa se afiseze toate medicamentele distrbuite de un anumit furnizor.");
		btnSaSeAfiseze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					Connection connection12 = DriverManager.getConnection(url, user, password);
					
					String sql12 ="select m.idMedicament,m.Denumire,m.cod\r\n"
							+ "from Medicamente m\r\n"
							+ "inner join Furnizori f on m.idFurnizor=f.idFurnizor\r\n"
							+ "where f.NumeFurnizor = '"+options[selectedValue]+"'";
					
					
					
					Statement statement11 = connection12.createStatement();
					
					ResultSet resultx = statement11.executeQuery(sql12);
					
					String aux="";
					aux=aux+"idMedicament Denumire Cod \n";
					
				
					//JOptionPane.showMessageDialog(null,"AngajatID ManagerID Nume Prenume CNP Strada Numar Oras Judet Sex Data Nasterii Salariu");
					while(resultx.next()){
		
						aux=aux+resultx.getInt(1)+" "+resultx.getString(2)+" "+resultx.getInt(3)+'\n';
					}
					JOptionPane.showMessageDialog(null,aux);
					connection12.close();
			}
			 catch (SQLException e1) {
				 JOptionPane.showMessageDialog(null, "Oops,there's an error");
				
				e1.printStackTrace();
			}
				
				
				
				
				
				
				
				
				
			}
		});
		btnSaSeAfiseze.setBounds(27, 200, 496, 34);
		contentPane.add(btnSaSeAfiseze);
		
		comboBox = new JComboBox(options);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectedValue = comboBox.getSelectedIndex();
				
			}
		});
		comboBox.setBounds(550, 203, 98, 28);
		contentPane.add(comboBox);
		
		JButton btnTotiAngajatiiCare = new JButton("Toti angajatii care s-au nascut inainte de 2000 si au cel putin 1 reteta cu 10% procent Compensat");
		btnTotiAngajatiiCare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					Connection connection12 = DriverManager.getConnection(url, user, password);
					
					String sql12 ="select distinct a.Nume,a.Prenume\r\n"
							+ "from Angajati a\r\n"
							+ "inner join Reteta r on r.idAngajat=a.AngajatID\r\n"
							+ "where a.DataNasterii<='2000-01-01' and r.procentCompensat>=10";
					
					
					
					Statement statement11 = connection12.createStatement();
					
					ResultSet resultx = statement11.executeQuery(sql12);
					
					String aux="";
					aux=aux+"Nume Prenume \n";
					
				
					//JOptionPane.showMessageDialog(null,"AngajatID ManagerID Nume Prenume CNP Strada Numar Oras Judet Sex Data Nasterii Salariu");
					while(resultx.next()){
		
						aux=aux+resultx.getString(1)+" "+resultx.getString(2)+'\n';
					}
					JOptionPane.showMessageDialog(null,aux);
					connection12.close();
			}
			 catch (SQLException e1) {
				 JOptionPane.showMessageDialog(null, "Oops,there's an error");
				
				e1.printStackTrace();
			}
				
				
				
			}
		});
		btnTotiAngajatiiCare.setBounds(27, 261, 621, 34);
		contentPane.add(btnTotiAngajatiiCare);
		
		JButton btnSaSeScrie = new JButton("Sa se scrie id-ul retetelor care contin, printre altele, si medicamentul DigestinFORTE.");
		btnSaSeScrie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					Connection connection12 = DriverManager.getConnection(url, user, password);
					
					String sql12 ="select r.idReteta, a.Nume,a.Prenume\r\n"
							+ "from RetetaMed r\r\n"
							+ "inner join Medicamente m on r.idMedicament=m.idMedicament\r\n"
							+ "inner join Reteta r1 on r.idReteta=r1.idReteta\r\n"
							+ "inner join Angajati a on r1.idAngajat=a.AngajatID\r\n"
							+ "where m.Denumire='DigestinFORTE'";
					
					
					
					Statement statement11 = connection12.createStatement();
					
					ResultSet resultx = statement11.executeQuery(sql12);
					
					String aux="";
					aux=aux+"idReteta Nume Prenume\n";
					
				
					//JOptionPane.showMessageDialog(null,"AngajatID ManagerID Nume Prenume CNP Strada Numar Oras Judet Sex Data Nasterii Salariu");
					while(resultx.next()){
		
						aux=aux+resultx.getInt(1)+" "+resultx.getString(2)+" "+resultx.getString(3)+'\n';
					}
					JOptionPane.showMessageDialog(null,aux);
					connection12.close();
			}
			 catch (SQLException e1) {
				 JOptionPane.showMessageDialog(null, "Oops,there's an error");
				
				e1.printStackTrace();
			}
				
				
				
				
			}
		});
		btnSaSeScrie.setBounds(27, 315, 621, 34);
		contentPane.add(btnSaSeScrie);
		
		JLabel lblNewLabel = new JLabel("Precum si numele celor care le-au scris");
		lblNewLabel.setBounds(217, 351, 368, 14);
		contentPane.add(lblNewLabel);
	}
}
