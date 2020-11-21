package be.malo.JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmail;
	private JTextField tfPassword;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	
	public Login() 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Main label
		JLabel lblSalle = new JLabel("Bosquet Wallon");
		lblSalle.setBounds(176, 11, 116, 40);
		contentPane.add(lblSalle);
		
		//Second label
		JLabel lblConnection = new JLabel("Connexion");
		lblConnection.setBounds(186, 62, 97, 28);
		contentPane.add(lblConnection);
		
		//Email label
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(84, 110, 46, 14);
		contentPane.add(lblEmail);
		
		//Email text field
		tfEmail = new JTextField();
		tfEmail.setBounds(84, 135, 268, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		//Password label
		JLabel lblPassword = new JLabel("Mot de passe :");
		lblPassword.setBounds(84, 170, 89, 14);
		contentPane.add(lblPassword);
		
		//Password text field
		tfPassword = new JTextField();
		tfPassword.setBounds(84, 195, 268, 20);
		contentPane.add(tfPassword);
		tfPassword.setColumns(10);
		
		//Login button
		JButton btnLogin = new JButton("Se connecter");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});		
		btnLogin.setBounds(167, 247, 116, 23);
		contentPane.add(btnLogin);
		
		//Register button
		JButton btnRegister = new JButton("Inscription");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register r = new Register();
				r.setVisible(true);
				dispose();
			}
		});
		btnRegister.setBounds(167, 281, 116, 23);
		contentPane.add(btnRegister);
		
		//Exit button
		JButton btnExit = new JButton("Quitter");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(336, 328, 89, 23);
		contentPane.add(btnExit);	
	}
}