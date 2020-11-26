package be.malo.JFrame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import be.malo.POJO.Organisateur;
import be.malo.POJO.PlanningSalle;
import be.malo.POJO.Reservation;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ListReservationFrame extends JFrame {

	private JPanel contentPane;
	private JTable TabReservation;

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
	
	public ListReservationFrame(Organisateur orga) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Main label
		JLabel lblListReservation = new JLabel("List reservation :");
		lblListReservation.setBounds(10, 36, 159, 23);
		contentPane.add(lblListReservation);
		
		// Second label
		JLabel lblOrganisateur = new JLabel("Organisateur : ");
		lblOrganisateur.setBounds(10, 11, 127, 22);
		contentPane.add(lblOrganisateur);
		
		// Informations second label
		JLabel lblNameFirstName = new JLabel("Nom : " + orga.getNom() + " Prénom : " + orga.getPrenom());
		lblNameFirstName.setBounds(102, 11, 322, 22);
		contentPane.add(lblNameFirstName);
		
		// Button return
		JButton btnReturn = new JButton("Retour");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrganisateurFrame of = new OrganisateurFrame(orga);
				of.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(335, 227, 89, 23);
		contentPane.add(btnReturn);
		
		// ScrollPane that containes a table of data
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 70, 404, 146);
		contentPane.add(scrollPane);
		
		TabReservation = new JTable();
		TabReservation.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Date début :", "Date fin :", "Prix total :"}) 
			{
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) 
			{
				return columnEditables[column];
			}
		});
		
		// Ajout of eservation in table
		DefaultTableModel model = (DefaultTableModel) TabReservation.getModel();
		Reservation r = new Reservation();
		ArrayList<Reservation> ListReservation = new ArrayList<Reservation>(r.getList(orga.getId_personne()));
		for(Reservation res : ListReservation)
		{
			PlanningSalle ps = new PlanningSalle();
			ps = ps.getPS(res.getId_reservation());		
			Object[] row = new Object [] {ps.getDate_debut(),ps.getDate_fin(),res.getPrix_total()};
			model.addRow(row);
		}	
		scrollPane.setViewportView(TabReservation);
	}
}
