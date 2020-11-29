package be.malo.JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.malo.POJO.Client;
import be.malo.POJO.Organisateur;
import be.malo.POJO.Personne;

import javax.swing.JLabel;

public class ClientFrame extends JFrame {

	private JPanel contentPane;

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
	
	public ClientFrame(Personne login) {
		Client cli = new Client(login.getId_personne(), login.getNom(), login.getPrenom(), login.getTel(), 
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
		JLabel lblOrganisateur = new JLabel("Client : ");
		lblOrganisateur.setBounds(10, 128, 127, 22);
		contentPane.add(lblOrganisateur);
		
		// Information label on Client (name & firstname)
		JLabel lblNameFirstName = new JLabel("Nom : " + cli.getNom() + "     Prénom : " + cli.getPrenom());
		lblNameFirstName.setBounds(100, 128, 324, 22);
		contentPane.add(lblNameFirstName);
		
		// Button that will allow us to check the list of your reservations
		JButton btnListRDV = new JButton("Liste des commandes");
		btnListRDV.setBounds(10, 172, 414, 22);
		btnListRDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				//
				//
				//
				//
				//
			}
		});
		contentPane.add(btnListRDV);
		
		// Button that will allow us to take an order
		JButton btnReservation = new JButton("Commander une/des place(s) de spectacle");
		btnReservation.setBounds(10, 216, 414, 23);
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListSpectacleOrderFrame lsc = new ListSpectacleOrderFrame(cli);
				lsc.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnReservation);
		
		// Button LogOut
		JButton btnLogOut = new JButton("D\u00E9connexion");
		btnLogOut.setBounds(291, 11, 133, 23);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame l = new LoginFrame();
				l.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnLogOut);		
	}
}