package net.codejava.sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Test {
	JLabel label;
	JFrame frmCocosilaAlexandruaa;
	JPanel panel;
	String url = "jdbc:sqlserver://DESKTOP-EROKGO6:1433;databaseName=Farmacie";
	String user ="sa";
	String password ="parola123";
	char [] aux;
	private JTextField textField;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Start app
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Test window = new Test();
					window.frmCocosilaAlexandruaa.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}
	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		final int[] arr = new int[1];
		arr[0]=0;
		frmCocosilaAlexandruaa =  new JFrame();
		frmCocosilaAlexandruaa.getContentPane().setBackground(Color.CYAN);
		frmCocosilaAlexandruaa.setResizable(false);
		frmCocosilaAlexandruaa.setBounds(100, 100, 470, 381);
		frmCocosilaAlexandruaa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0,1));
		
		//frame.add(panel,BorderLayout.CENTER);
		frmCocosilaAlexandruaa.setTitle("Cocosila Alexandru 333AA - Proiect BD");
		//frame.pack();
		
		
		JButton btnNewButton = new JButton("Connect to Database");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(127, 127, 187, 51);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				user=textField.getText();
				aux=passwordField.getPassword();
				password=String.valueOf(aux);
				try {
					
					Connection connection = DriverManager.getConnection(url, user, password);
					
					JOptionPane.showMessageDialog(null, "Connected to Database");
					arr[0]=1;
					
					connection.close();
			}
			 catch (SQLException e) {
				 JOptionPane.showMessageDialog(null, "Error connecting to Database");
				
				e.printStackTrace();
			}
				
				
		}
			});
		frmCocosilaAlexandruaa.getContentPane().setLayout(null);
		frmCocosilaAlexandruaa.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Evidenta medicamentelor intr-o farmacie");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		lblNewLabel.setBounds(25, 11, 403, 53);
		frmCocosilaAlexandruaa.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(206, 68, 86, 20);
		frmCocosilaAlexandruaa.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("user");
		lblNewLabel_2.setBounds(150, 71, 32, 14);
		frmCocosilaAlexandruaa.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("password");
		lblNewLabel_2_1.setBounds(127, 99, 76, 14);
		frmCocosilaAlexandruaa.getContentPane().add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(206, 96, 86, 20);
		frmCocosilaAlexandruaa.getContentPane().add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCocosilaAlexandruaa.dispose();
			}
		});
		btnNewButton_1.setBounds(336, 308, 89, 23);
		frmCocosilaAlexandruaa.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Operatii angajati");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arr[0]==1) {
				frmCocosilaAlexandruaa.dispose();
				Test1 obj = new Test1();
				obj.setVisible(true);}
				else JOptionPane.showMessageDialog(null, "Nu sunteti conectat la baza de date.");
			}
		});
		btnNewButton_2.setBounds(10, 209, 187, 23);
		frmCocosilaAlexandruaa.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Operatii clienti");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2_1.setBackground(Color.CYAN);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(arr[0]==1) {
					frmCocosilaAlexandruaa.dispose();
					Clienti obj = new Clienti();
					obj.setVisible(true);}
					else JOptionPane.showMessageDialog(null, "Nu sunteti conectat la baza de date.");
				
				
				
				
			}
		});
		btnNewButton_2_1.setBounds(242, 209, 171, 23);
		frmCocosilaAlexandruaa.getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("Join-uri");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arr[0]==1) {
					frmCocosilaAlexandruaa.dispose();
					Join obj = new Join();
					obj.setVisible(true);}
					else JOptionPane.showMessageDialog(null, "Nu sunteti conectat la baza de date.");
				
				
			}
		});
		btnNewButton_3.setBounds(10, 264, 187, 23);
		frmCocosilaAlexandruaa.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Subcereri");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBackground(Color.CYAN);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(arr[0]==1) {
					frmCocosilaAlexandruaa.dispose();
					Subcereri obj = new Subcereri();
					obj.setVisible(true);}
					else JOptionPane.showMessageDialog(null, "Nu sunteti conectat la baza de date.");
				
				
			}
		});
		btnNewButton_4.setBounds(248, 264, 165, 23);
		frmCocosilaAlexandruaa.getContentPane().add(btnNewButton_4);
	}
}


