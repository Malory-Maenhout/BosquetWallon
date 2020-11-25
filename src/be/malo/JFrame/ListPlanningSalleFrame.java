package be.malo.JFrame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.malo.POJO.Gestionnaire;
import be.malo.POJO.PlanningSalle;
import be.malo.POJO.Reservation;

public class ListPlanningSalleFrame extends JFrame {

	private JPanel contentPane;
	private JTable TabPlanningSalle;

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
	
	public ListPlanningSalleFrame(Gestionnaire gest) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Main label
		JLabel lblListReservation = new JLabel("Planning de la salle :");
		lblListReservation.setBounds(10, 36, 159, 23);
		contentPane.add(lblListReservation);
				
		// Second label
		JLabel lblOrganisateur = new JLabel("Gestionnaire : ");
		lblOrganisateur.setBounds(10, 11, 127, 22);
		contentPane.add(lblOrganisateur);
				
		// Informations second label
		JLabel lblNameFirstName = new JLabel("Nom : " + gest.getNom() + " Prénom : " + gest.getPrenom());
		lblNameFirstName.setBounds(102, 11, 322, 22);
		contentPane.add(lblNameFirstName);
				
		// Button return
		JButton btnReturn = new JButton("Retour");
		btnReturn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				GestionnaireFrame gf = new GestionnaireFrame(gest);
				gf.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(335, 227, 89, 23);
		contentPane.add(btnReturn);
				
		// ScrollPane that containes à table data
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 414, 159);
		contentPane.add(scrollPane);
				
		TabPlanningSalle = new JTable();
		TabPlanningSalle.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Date début :", "Date fin :", "Prix total :"}) 
					{
					boolean[] columnEditables = new boolean[] {
						false, false, false
					};
					public boolean isCellEditable(int row, int column) 
					{
						return columnEditables[column];
					}
				});
				
				// Ajout of planning room in table
				DefaultTableModel model = (DefaultTableModel) TabPlanningSalle.getModel();
				PlanningSalle ps = new PlanningSalle();
				ArrayList<PlanningSalle> ListPlanningSalle = new ArrayList<PlanningSalle>(ps.getList(gest.getId_personne()));
				for(PlanningSalle res : ListPlanningSalle)
				{			
					Reservation r = new Reservation();
					r = r.getRes(res.getId_reservation());
					Object[] row = new Object [] {res.getDate_debut(),res.getDate_fin(), r.getPrix_total()};
					model.addRow(row);
				}			
				scrollPane.setViewportView(TabPlanningSalle);
	}
}