package be.malo.JFrame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import be.malo.POJO.Client;
import be.malo.POJO.PlanningSalle;
import be.malo.POJO.Spectacle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListSpectacleOrderFrame extends JFrame {

	private JPanel contentPane;
	private JTable tabListSpectacle;
	private ArrayList<Spectacle> listS = new ArrayList<Spectacle>();

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
	
	public ListSpectacleOrderFrame(Client cli) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Main label
		JLabel lblOrder = new JLabel("Commande :");
		lblOrder.setBounds(10, 11, 99, 19);
		contentPane.add(lblOrder);
		
		// Info label
		JLabel lblInfoOrder = new JLabel("Choisissez un spectacle dans la liste ci-dessous :");
		lblInfoOrder.setBounds(10, 41, 414, 19);
		contentPane.add(lblInfoOrder);
		
		// Second label
		JLabel lblListSpectacle = new JLabel("Listes des spectacles :");
		lblListSpectacle.setBounds(10, 71, 237, 19);
		contentPane.add(lblListSpectacle);
		
		// Tab list spectacle
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 414, 120);
		contentPane.add(scrollPane);
		
		tabListSpectacle = new JTable();
		tabListSpectacle.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Titre :", "Date debut :", "Date fin :"}) 
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
		DefaultTableModel model = (DefaultTableModel) tabListSpectacle.getModel();
		Spectacle s = new Spectacle();
		listS = s.findAll();
		for(Spectacle s1 : listS)
		{
			PlanningSalle ps = new PlanningSalle();
			ps = ps.getById(s1.getId_planningSalle());
			Object[] row = new Object [] {s1.getTitre(), ps.getDate_debut(),ps.getDate_fin()};
			model.addRow(row);
		}		
		scrollPane.setViewportView(tabListSpectacle);
		
		// Button valid
		JButton btnValid = new JButton("Valider choix");
		btnValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabListSpectacle.getSelectedRow() == -1)
				{
					JOptionPane.showMessageDialog(null, "Vous devez choisir un spectacle !");
				}
				else
				{
					Spectacle spec = listS.get(tabListSpectacle.getSelectedRow());
					ListRepresentationOrderFrame lrof = new ListRepresentationOrderFrame(cli, spec);
					lrof.setVisible(true);
					dispose();
				}			
			}
		});
		btnValid.setBounds(258, 232, 166, 23);
		contentPane.add(btnValid);
		
		// Button return
		JButton btnReturn = new JButton("Retour");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientFrame cf = new ClientFrame(cli);
				cf.setVisible(true);
				dispose();				
			}
		});
		btnReturn.setBounds(335, 9, 89, 23);
		contentPane.add(btnReturn);
	}
}