package be.malo.JFrame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import be.malo.POJO.Organisateur;
import be.malo.POJO.PlanningSalle;
import be.malo.POJO.Reservation;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ReservationFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfPrixTotal;
	private Date d = new Date();

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
	
	public ReservationFrame(Organisateur orga) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Main Label
		JLabel lblReservation = new JLabel("Reservation :");
		lblReservation.setBounds(10, 11, 115, 30);
		contentPane.add(lblReservation);
		
		// Return Button
		JButton btnReturn = new JButton("Retour");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrganisateurFrame of = new OrganisateurFrame(orga);
				of.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(579, 15, 115, 23);
		contentPane.add(btnReturn);
		
		// Second label info on organisateur
		JLabel lblInfoOrga = new JLabel("Organisateur Nom : " + orga.getNom() + " Prénom : " + orga.getPrenom());
		lblInfoOrga.setBounds(96, 19, 473, 14);
		contentPane.add(lblInfoOrga);
		
		// Label to JDC begin date
		JLabel lblBeginDate = new JLabel("Date de d\u00E9but de r\u00E9servation :");
		lblBeginDate.setBounds(10, 78, 219, 20);
		contentPane.add(lblBeginDate);
		
		// JDC to begin date od reservation
		JDateChooser dateChooserBegin = new JDateChooser();
		dateChooserBegin.getJCalendar().setMinSelectableDate(d);
		((JTextFieldDateEditor)dateChooserBegin.getDateEditor()).setEditable(false);
		dateChooserBegin.setDateFormatString("dd/MM/yy 12:00:00");
		dateChooserBegin.setBounds(194, 78, 219, 20);
		contentPane.add(dateChooserBegin);
		
		// Label to JDC end date
		JLabel lblEndDate = new JLabel("Date de fin de r\u00E9servation :");
		lblEndDate.setBounds(10, 132, 219, 20);
		contentPane.add(lblEndDate);
		
		// JDC to end date od reservation
		JDateChooser dateChooserEnd = new JDateChooser();
		dateChooserEnd.getJCalendar().setMinSelectableDate(d);
		((JTextFieldDateEditor)dateChooserEnd.getDateEditor()).setEditable(false);
		dateChooserEnd.setDateFormatString("dd/MM/yy 12:00:00");
		dateChooserEnd.setBounds(194, 132, 219, 20);
		contentPane.add(dateChooserEnd);
		
		// Label prix total
		JLabel lblPrixTotal = new JLabel("Prix total : ");
		lblPrixTotal.setBounds(440, 77, 75, 23);
		contentPane.add(lblPrixTotal);
		
		// Text field prix total
		tfPrixTotal = new JTextField();
		tfPrixTotal.setBounds(525, 78, 128, 20);
		contentPane.add(tfPrixTotal);
		tfPrixTotal.setColumns(10);
		
		// Button that will allows us to valide the datas of reservation
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy 12:00:00");
				String start = sdf.format(dateChooserBegin.getDate());
				String end = sdf.format(dateChooserEnd.getDate());	
				
				java.sql.Date d1 = new java.sql.Date((dateChooserBegin.getDate()).getTime());
				java.sql.Date d2 = new java.sql.Date((dateChooserEnd.getDate()).getTime());
				
				Timestamp dt1 = new Timestamp(d1.getYear(), d1.getMonth(), d1.getDate(), 12, 0, 0, 0);
				Timestamp dt2 = new Timestamp(d2.getYear(), d2.getMonth(), d2.getDate(), 12, 0, 0, 0);
				
				double prixTotal = 0 ;
				int cpt = d1.getDay();
				int fin = d2.getDay();
				
				do
				{
					if(cpt == 0)
					{
						prixTotal += 3000;
					}
					else if(cpt == 1)
					{
						prixTotal += 3000;
					}
					else if(cpt == 2)
					{
						prixTotal += 3000;
					}
					else if(cpt == 3)
					{
						prixTotal += 3000;
					}
					else if(cpt == 4)
					{
						prixTotal += 3000;
					}
					else if(cpt == 5)
					{
						prixTotal += 4500;
					}
					else if(cpt == 6)
					{
						prixTotal += 4500;
					}	
					
					if(cpt == 6)
					{
						cpt = 0;
					}
					else
					{
						cpt++;
					}					
				}while(cpt != fin);	
				
				String pt = String.valueOf(prixTotal);
				tfPrixTotal.setText(pt);
				
				if(start.compareTo(end) < 0)
				{		
					try {		
							// Verify the dates of the reservation
							PlanningSalle ps = new PlanningSalle();
							boolean x = ps.verify(dt1, dt2);
							
							if(x == false)
							{						
								JOptionPane.showMessageDialog(null, "La plage de réservation est mauvaise");
							}
							else
							{
								JOptionPane.showMessageDialog(null, "La plage de réservation est bonne");

								// Create reservation
								Reservation r = new Reservation(prixTotal, orga.getId_personne());
								boolean y = r.create();
								
								if(y == true)
								{
									// Find reservation, create a planningSalle 
									r = r.find();
									int Id_gestionnaire = 5;
									PlanningSalle plan = new PlanningSalle(d1, d2, r.getId_reservation(), Id_gestionnaire);
									boolean z = plan.create();
									
									if(z == true)
									{
										JOptionPane.showMessageDialog(null, "Reservation enregistrer");
										
										plan = plan.find();
										SpectacleFrame sf = new SpectacleFrame(plan);
										sf.setVisible(true);
										dispose();
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement du PlanningSalle");
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement de la Reservation");
								}
							}	
						}
					catch(Exception e1) {
							e1.printStackTrace();
						}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "La plage de réservation est mauvaise");
				}
			}
		});
		btnValider.setBounds(504, 184, 149, 23);
		contentPane.add(btnValider);
		
		// Button that will allows us to reset all field of data in the form
		JButton btnReset = new JButton("R\u00E9initilialiser les donn\u00E9es");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateChooserBegin.setDate(null);
				dateChooserEnd.setDate(null);
				tfPrixTotal.setText(null);
			}
		});
		btnReset.setBounds(194, 184, 219, 23);
		contentPane.add(btnReset);
	}
}
