package be.malo.JFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import be.malo.POJO.Client;
import be.malo.POJO.Representation;
import be.malo.POJO.Spectacle;

public class ListRepresentationOrderFrame extends JFrame {

	private JPanel contentPane;
	private JTable tabListRepresentation;
	private ArrayList<Representation> listR = new ArrayList<Representation>();

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
	
	public ListRepresentationOrderFrame(Client cli, Spectacle spec) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Main label
		JLabel lblOrder = new JLabel("Commande :");
		lblOrder.setBounds(10, 11, 99, 19);
		contentPane.add(lblOrder);
		
		// Info label
		JLabel lblInfoOrder = new JLabel("Choisissez une représentation dans la liste ci-dessous :");
		lblInfoOrder.setBounds(10, 41, 414, 19);
		contentPane.add(lblInfoOrder);
		
		// Second label
		JLabel lblListRepresentation = new JLabel("Listes des représentations :");
		lblListRepresentation.setBounds(10, 71, 237, 19);
		contentPane.add(lblListRepresentation);
		
		// Tab list representation
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 718, 120);
		contentPane.add(scrollPane);
		
		tabListRepresentation = new JTable();
		tabListRepresentation.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Date et heure de début :", "Date et heure de fin :", "Heure d'ouverture des portes :"}) 
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
		DefaultTableModel model = (DefaultTableModel) tabListRepresentation.getModel();
		Representation r = new Representation();
		listR = r.find(spec.getId_spectacle());
		
		for(Representation r1 : listR)
		{
			Object[] row = new Object [] {r1.getDate_debut(), r1.getDate_fin(), r1.getHeure_porte_open()};
			model.addRow(row);
		}		
		scrollPane.setViewportView(tabListRepresentation);
		
		// Button valid
		JButton btnValid = new JButton("Valider choix");
		btnValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabListRepresentation.getSelectedRow() == -1)
				{
					JOptionPane.showMessageDialog(null, "Vous devez choisir une representation !");
				}
				else
				{
					Representation rep = listR.get(tabListRepresentation.getSelectedRow());
					CommandeFrame cf = new CommandeFrame(cli, spec, rep);
					cf.setVisible(true);
					dispose();
				}			
			}
		});
		btnValid.setBounds(562, 232, 166, 23);
		contentPane.add(btnValid);
		
		// Button return
		JButton btnReturn = new JButton("Retour");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListSpectacleOrderFrame lsof = new ListSpectacleOrderFrame(cli);
				lsof.setVisible(true);
				dispose();				
			}
		});
		btnReturn.setBounds(639, 9, 89, 23);
		contentPane.add(btnReturn);
	}
}