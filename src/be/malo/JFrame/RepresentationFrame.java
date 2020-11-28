package be.malo.JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.malo.POJO.Artistes;
import be.malo.POJO.Organisateur;
import be.malo.POJO.PlanningSalle;
import be.malo.POJO.Representation;
import be.malo.POJO.Reservation;
import be.malo.POJO.Spectacle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JSpinner;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class RepresentationFrame extends JFrame {

	private JPanel contentPane;
	private JTable tabListRepresentation;
	private ArrayList<Representation> ListRepresentation = new ArrayList<Representation>();

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
	
	public RepresentationFrame(Spectacle s) {
		PlanningSalle ps = new PlanningSalle();
		ps = ps.getById(s.getId_planningSalle());
		java.sql.Date d1 = new java.sql.Date((ps.getDate_debut()).getTime());
		java.sql.Date d2 = new java.sql.Date((ps.getDate_fin()).getTime());
		
		Timestamp dt1 = new Timestamp(d1.getYear(), d1.getMonth(), d1.getDate(), 12, 0, 0, 0);
		Timestamp dt2 = new Timestamp(d2.getYear(), d2.getMonth(), d2.getDate(), 12, 0, 0, 0);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Main label
		JLabel lblRepresentation = new JLabel("Repr\u00E9sentation :");
		lblRepresentation.setBounds(10, 11, 131, 21);
		contentPane.add(lblRepresentation);
		
		// Second label
		JLabel lblRepresentation2 = new JLabel("Cr\u00E9e votre liste de repr\u00E9sentation :");
		lblRepresentation2.setBounds(10, 32, 272, 21);
		contentPane.add(lblRepresentation2);
		
		// Label title list
		JLabel lblListRepresentation = new JLabel("Liste des repr\u00E9sentation :");
		lblListRepresentation.setBounds(10, 243, 313, 21);
		contentPane.add(lblListRepresentation);
		
		// Label info date begin reservation
		JLabel lblBeginReservation = new JLabel("Date d\u00E9but de r\u00E9servation :");
		lblBeginReservation.setBounds(10, 64, 172, 14);
		contentPane.add(lblBeginReservation);
		
		// Label data begin reservation
		JLabel lblDReservation = new JLabel(dt1.toString());
		lblDReservation.setBounds(187, 61, 156, 21);
		contentPane.add(lblDReservation);
		
		// Label info date end reservation
		JLabel lblEndReservation = new JLabel("Date fin de r\u00E9servation :");
		lblEndReservation.setBounds(10, 90, 172, 14);
		contentPane.add(lblEndReservation);
		
		// Label end begin reservation
		JLabel lblFReservation = new JLabel(dt2.toString());
		lblFReservation.setBounds(187, 90, 156, 21);
		contentPane.add(lblFReservation);
		
		// Label to begin representation
		JLabel lblBeginRepresentation = new JLabel("D\u00E9but de rep\u00E9sentation :");
		lblBeginRepresentation.setBounds(10, 144, 172, 21);
		contentPane.add(lblBeginRepresentation);
		
		// Label to end representation
		JLabel lblEndRepresentation = new JLabel("Fin de repr\u00E9sentation :");
		lblEndRepresentation.setBounds(10, 181, 172, 21);
		contentPane.add(lblEndRepresentation);
		
		// Label door open to representation
		JLabel lblHDoorOpen = new JLabel("Heure d'ouverture des portes :");
		lblHDoorOpen.setBounds(10, 221, 172, 23);
		contentPane.add(lblHDoorOpen);
		
		// Spinner begin date and hoour of representation
		JSpinner spinnerDB = new JSpinner();
		spinnerDB.setModel(new SpinnerDateModel(new Date(1577833200000L), null, null, Calendar.DAY_OF_WEEK));
		spinnerDB.setBounds(197, 144, 146, 20);
		contentPane.add(spinnerDB);
		
		// Spinner end date and hoour of representation
		JSpinner spinnerDF = new JSpinner();
		spinnerDF.setModel(new SpinnerDateModel(new Date(1577833200000L), null, null, Calendar.DAY_OF_WEEK));
		spinnerDF.setBounds(197, 181, 146, 20);
		contentPane.add(spinnerDF);
			
		// Spinner date and hour door open to the representation
		JSpinner spinnerHO = new JSpinner();
		spinnerHO.setModel(new SpinnerDateModel(new Date(1577833200000L), null, null, Calendar.DAY_OF_YEAR));
		spinnerHO.setBounds(197, 222, 146, 20);
		contentPane.add(spinnerHO);
		
		// Tab list of all representation add
		JScrollPane scrollPaneA = new JScrollPane();
		scrollPaneA.setBounds(10, 270, 610, 195);
		contentPane.add(scrollPaneA);
		
		tabListRepresentation = new JTable();
		tabListRepresentation.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Date et heure de début :", "Date et heure de fin :", "Heure d'ouverture des portes :"}) 
		{
			boolean[] columnEditables = new boolean[] 
			{
				false, false
			};
			public boolean isCellEditable(int row, int column) 
			{
				return columnEditables[column];
			}
		});
		scrollPaneA.setViewportView(tabListRepresentation);
		
		// Button add to list of representation
		JButton btnAddToList = new JButton("Ajouter ");
		btnAddToList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				Date db = new Date(((Date) spinnerDB.getValue()).getTime());
				Date df = new Date(((Date) spinnerDF.getValue()).getTime());
				Date dh = new Date(((Date) spinnerHO.getValue()).getTime());
				
				Timestamp dbf = new Timestamp(db.getYear(), db.getMonth(), db.getDate(), db.getHours(), db.getMinutes(), 0, 0);
				Timestamp dff = new Timestamp(df.getYear(), df.getMonth(), df.getDate(), df.getHours(), df.getMinutes(), 0, 0);
				Timestamp dho = new Timestamp(dh.getYear(), dh.getMonth(), dh.getDate(), dh.getHours(), dh.getMinutes(), 0, 0);

				if(dbf.compareTo(dff) < 0)
				{
					if((dt1.compareTo(dbf) == 0 || dt1.compareTo(dbf) < 0) && (dt2.compareTo(dff) == 0 || dt2.compareTo(dff) > 0))
					{
						if((dbf.compareTo(dho) > 0 || dbf.compareTo(dho) == 0) && (dt1.compareTo(dho) < 0))
						{
							Representation r = new Representation(dbf, dff, s.getId_spectacle(), dho);
							boolean verif = false;
							
							for(Representation rp : ListRepresentation)
							{
								if(rp.getDate_debut().equals(r.getDate_debut()) && rp.getDate_fin().equals(r.getDate_fin()))
								{
									verif = true;
									break;
								}
								else
								{
									verif = false;
								}
							}
							
							if(verif == true)
							{
								JOptionPane.showMessageDialog(null, " il y a déjà cette représenation dans la liste !" );
							}
							else
							{
								ListRepresentation.add(r);			
								DefaultTableModel model = (DefaultTableModel) tabListRepresentation.getModel();
								Object[] row = new Object [] {r.getDate_debut(), r.getDate_fin(), r.getHeure_porte_open()};
								model.addRow(row);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Votre Heur de porte ouverte n'est pas bonne !");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Votre représentation ne se trouve pas entre \n la date de début et de fin de réservation !");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Votre date de fin de représentation \n est inférieur à la date de début ou égale !");
				}
			}
		});
		btnAddToList.setBounds(483, 221, 137, 23);
		contentPane.add(btnAddToList);
		
		// Button valid all
		JButton btnValider = new JButton("Valider la liste");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ListRepresentation.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Veuillez remplire la liste des représentations !");
				}
				else
				{			
					boolean res = false;
					for(Representation r : ListRepresentation)
					{
						Representation rep = new Representation(r.getDate_debut(), r.getDate_fin(), r.getId_spectacle(), r.getHeure_porte_open());
						res = rep.create();
						
						if(res == false)
							break;
					}
					
					if(res == true)
					{
						JOptionPane.showMessageDialog(null, "List des représentation enregistrée !");
						
						PlanningSalle ps = new PlanningSalle();
						ps = ps.getById(s.getId_planningSalle());
						Reservation r = new Reservation();
						r = r.getRes(ps.getId_reservation());
						Organisateur orga = new Organisateur();
						orga = orga.find(r.getId_organisateur());
						
						OrganisateurFrame frame = new OrganisateurFrame(orga);
						frame.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement de la représentation !");
					}
				}
			}
		});
		btnValider.setBounds(483, 476, 137, 23);
		contentPane.add(btnValider);
		
		// Button to reset the list of representation
		JButton btnReset = new JButton("R\u00E9initialiser la list");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListRepresentation.removeAll(ListRepresentation);
				DefaultTableModel model = (DefaultTableModel) tabListRepresentation.getModel();
			    for( int i = model.getRowCount() - 1; i >= 0; i-- ) {
			    model.removeRow(i);
			    }
			}
		});
		btnReset.setBounds(259, 476, 214, 23);
		contentPane.add(btnReset);
	}
}