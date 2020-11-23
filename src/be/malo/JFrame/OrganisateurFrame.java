package be.malo.JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.malo.POJO.Organisateur;
import be.malo.POJO.Personne;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrganisateurFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNameFirstName;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// It's to begin on Login Frame and not on Register frame
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
	
	public OrganisateurFrame(Personne login) {
		Organisateur orga = new Organisateur(login.getId_personne(), login.getNom(), login.getPrenom(), login.getTel(), 
				login.getAdresse(), login.getEmail(), login.getMdp(), login.getType_personne(), login.getVille(), 
				login.getCode_postal());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Main label
		JLabel lblBosquetWallon = new JLabel("Bienvenu sur Bosquet Wallon !");
		lblBosquetWallon.setBounds(132, 55, 237, 42);
		contentPane.add(lblBosquetWallon);
		
		// Second label
		JLabel lblOrganisateur = new JLabel("Organisateur : ");
		lblOrganisateur.setBounds(10, 128, 127, 22);
		contentPane.add(lblOrganisateur);
		
		// Information label on Organisateur (name & firstname)
		lblNameFirstName = new JLabel("Nom : " + orga.getNom() + " Prénom : " + orga.getPrenom());
		lblNameFirstName.setBounds(100, 128, 324, 22);
		contentPane.add(lblNameFirstName);
		
		// Button that will allow us to check the list of our room reservations
		JButton btnListRDV = new JButton("Liste r\u00E9servation");
		btnListRDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnListRDV.setBounds(29, 211, 161, 22);
		contentPane.add(btnListRDV);
		
		// Button that will allow us to take a room reservation
		JButton btnReservation = new JButton("R\u00E9server la salle");
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnReservation.setBounds(242, 211, 154, 23);
		contentPane.add(btnReservation);
		
		// Button LogOut
		JButton btnLogOut = new JButton("D\u00E9connexion");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame l = new LoginFrame();
				l.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setBounds(291, 11, 133, 23);
		contentPane.add(btnLogOut);
	}
}