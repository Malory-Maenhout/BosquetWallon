package be.malo.JFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import be.malo.POJO.Artistes;
import be.malo.POJO.Personne;
import javax.swing.JLabel;

public class ArtistesFrame extends JFrame {

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
	
	public ArtistesFrame(Personne login) {
		Artistes art = new Artistes(login.getId_personne(), login.getNom(), login.getPrenom(), login.getTel(), 
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
		JLabel lblArtistes = new JLabel("Artiste : ");
		lblArtistes.setBounds(10, 128, 127, 22);
		contentPane.add(lblArtistes);
		
		// Information label on Artiste (name & firstname)
		JLabel lblNameFirstName = new JLabel("Nom : " + art.getNom() + " Prénom : " + art.getPrenom());
		lblNameFirstName.setBounds(100, 128, 324, 22);
		contentPane.add(lblNameFirstName);
		
		// Button that will allow us to check the list of spectacle
		JButton btnListSpectacles = new JButton("Liste de mes spectacles");
		btnListSpectacles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				ListSpectacleFrame lsf = new ListSpectacleFrame(art);
				lsf.setVisible(true);
				dispose();
			}
		});
		btnListSpectacles.setBounds(100, 214, 228, 22);
		contentPane.add(btnListSpectacles);
		
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