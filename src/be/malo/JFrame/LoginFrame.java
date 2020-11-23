package be.malo.JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.malo.POJO.Personne;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel pfPassword;
	private JTextField tfEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	
	public LoginFrame() 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 401);
		pfPassword = new JPanel();
		pfPassword.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pfPassword);
		pfPassword.setLayout(null);
		
		// Main label
		JLabel lblSalle = new JLabel("Bosquet Wallon");
		lblSalle.setBounds(176, 11, 116, 40);
		pfPassword.add(lblSalle);
		
		// Second label
		JLabel lblConnection = new JLabel("Connexion");
		lblConnection.setBounds(186, 62, 97, 28);
		pfPassword.add(lblConnection);
		
		// Email label
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(84, 110, 46, 14);
		pfPassword.add(lblEmail);
		
		// Email text field
		tfEmail = new JTextField();
		tfEmail.setBounds(84, 135, 268, 20);
		pfPassword.add(tfEmail);
		tfEmail.setColumns(10);
		
		// Password label
		JLabel lblPassword = new JLabel("Mot de passe :");
		lblPassword.setBounds(84, 170, 89, 14);
		pfPassword.add(lblPassword);

		// Password field
		passwordField = new JPasswordField();
		passwordField.setBounds(84, 195, 268, 20);
		pfPassword.add(passwordField);
		
		// Login button
		JButton btnLogin = new JButton("Se connecter");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = tfEmail.getText();
				char[] tab = passwordField.getPassword();
				String password = new String(tab);
				
				Personne poeple = new Personne("", "", "", "", email, password, "", "", "");
				Personne login = poeple.find();
				if(login.getId_personne() != 0 )
				{
					JOptionPane.showMessageDialog(null, "Vous êtes connecté !");
					
					if(login.getType_personne().equals("Gestionnaire")) 
					{
						GestionnaireFrame gf = new GestionnaireFrame(login);
						gf.setVisible(true);
						dispose();
					}
					else if(login.getType_personne().equals("Organisateur"))
					{
						OrganisateurFrame of = new OrganisateurFrame(login);
						of.setVisible(true);
						dispose();
					}
					else if(login.getType_personne().equals("Artistes"))
					{
						ArtistesFrame af = new ArtistesFrame(login);
						af.setVisible(true);
						dispose();
					}
					else if(login.getType_personne().equals("Client"))
					{
						ClientFrame cf = new ClientFrame(login);
						cf.setVisible(true);
						dispose();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrect !");
				}
			}
		});		
		btnLogin.setBounds(167, 247, 116, 23);
		pfPassword.add(btnLogin);
		
		// Register button
		JButton btnRegister = new JButton("Inscription");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterFrame r = new RegisterFrame();
				r.setVisible(true);
				dispose();
			}
		});
		btnRegister.setBounds(167, 281, 116, 23);
		pfPassword.add(btnRegister);
		
		// Exit button
		JButton btnExit = new JButton("Quitter");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(336, 328, 89, 23);
		pfPassword.add(btnExit);	
	}
}