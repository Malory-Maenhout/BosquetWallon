package be.malo.JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import be.malo.POJO.Artistes;
import be.malo.POJO.LigneSpectacle;
import be.malo.POJO.PlanningSalle;
import be.malo.POJO.Reservation;
import be.malo.POJO.Spectacle;

public class ListSpectacleFrame extends JFrame {

	private JPanel contentPane;
	private JTable tabSpectacle;

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
	
	public ListSpectacleFrame(Artistes art) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Main label
		JLabel lblListSpectacle = new JLabel("List de spectacle :");
		lblListSpectacle.setBounds(10, 36, 159, 23);
		contentPane.add(lblListSpectacle);
		
		// Second label
		JLabel lblArtistes = new JLabel("Artiste  : ");
		lblArtistes.setBounds(10, 11, 127, 22);
		contentPane.add(lblArtistes);
		
		// Informations second label
		JLabel lblNameFirstName = new JLabel("Nom : " + art.getNom() + " Prénom : " + art.getPrenom());
		lblNameFirstName.setBounds(102, 11, 322, 22);
		contentPane.add(lblNameFirstName);
		
		// Button return
		JButton btnReturn = new JButton("Retour");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArtistesFrame of = new ArtistesFrame(art);
				of.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(335, 227, 89, 23);
		contentPane.add(btnReturn);
		
		// ScrollPane that containes a table of data
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 414, 163);
		contentPane.add(scrollPane);
		
		tabSpectacle = new JTable();
		tabSpectacle.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Titre :", "Date debut :", "Date fin :", }) 
			{
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) 
			{
				return columnEditables[column];
			}
		});
		
		// Ajout of spectacle in table
		DefaultTableModel model = (DefaultTableModel) tabSpectacle.getModel();
		
		LigneSpectacle ls = new LigneSpectacle();
		ArrayList<LigneSpectacle> listLS = new ArrayList<LigneSpectacle>();
		listLS = ls.getList(art.getId_personne());
		
		ArrayList<Spectacle> listS = new ArrayList<Spectacle>();
		for(LigneSpectacle l : listLS)
		{
			Spectacle s = new Spectacle();
			s = s.finById(l.getId_spectacle());
			listS.add(s);
		}
		
		for(Spectacle s : listS)
		{
			PlanningSalle ps = new PlanningSalle();
			ps = ps.getById(s.getId_planningSalle());
			DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
			        DateFormat.SHORT,
			        DateFormat.SHORT);
			Object[] row = new Object [] {s.getTitre(), shortDateFormat.format(ps.getDate_debut()), shortDateFormat.format(ps.getDate_fin())};
			model.addRow(row);
		}
		scrollPane.setViewportView(tabSpectacle);
	}
}