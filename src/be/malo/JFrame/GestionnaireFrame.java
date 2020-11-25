package be.malo.JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.malo.POJO.Gestionnaire;
import be.malo.POJO.Organisateur;
import be.malo.POJO.Personne;

import javax.swing.JLabel;

public class GestionnaireFrame extends JFrame {

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
	
	public GestionnaireFrame(Personne login) {
		Gestionnaire gest = new Gestionnaire(login.getId_personne(), login.getNom(), login.getPrenom(), login.getTel(), 
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
		JLabel lblOrganisateur = new JLabel("Gestionnaire : ");
		lblOrganisateur.setBounds(10, 128, 127, 22);
		contentPane.add(lblOrganisateur);
		
		// Information label on Gestionnaire (name & firstname)
		JLabel lblNameFirstName = new JLabel("Nom : " + gest.getNom() + " Prénom : " + gest.getPrenom());
		lblNameFirstName.setBounds(100, 128, 324, 22);
		contentPane.add(lblNameFirstName);
		
		// Button that will allow us to check the list of PlanningSalle
		JButton btnListRDV = new JButton("Liste r\u00E9servation");
		btnListRDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPlanningSalleFrame lpsf = new ListPlanningSalleFrame(gest);
				lpsf.setVisible(true);
				dispose();
			}
		});
		btnListRDV.setBounds(132, 211, 161, 22);
		contentPane.add(btnListRDV);
		
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
