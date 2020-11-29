package be.malo.JFrame;

import java.awt.BorderLayout;
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

import be.malo.POJO.Client;
import be.malo.POJO.Commande;
import be.malo.POJO.LigneSpectacle;
import be.malo.POJO.PlanningSalle;
import be.malo.POJO.Spectacle;

public class ListCommandeFrame extends JFrame {

	private JPanel contentPane;
	private JTable tabListOrder;

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
	
	public ListCommandeFrame(Client cli) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Main label
		JLabel lblListCommande = new JLabel("List de commande :");
		lblListCommande.setBounds(10, 36, 159, 23);
		contentPane.add(lblListCommande);
		
		// Second label
		JLabel lblClient = new JLabel("Client  : ");
		lblClient.setBounds(10, 11, 127, 22);
		contentPane.add(lblClient);
		
		// Informations second label
		JLabel lblNameFirstName = new JLabel("Nom : " + cli.getNom() + "   Prénom : " + cli.getPrenom());
		lblNameFirstName.setBounds(102, 11, 322, 22);
		contentPane.add(lblNameFirstName);
		
		// Button return
		JButton btnReturn = new JButton("Retour");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientFrame cf = new ClientFrame(cli);
				cf.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(335, 227, 89, 23);
		contentPane.add(btnReturn);
		
		// ScrollPane that containes a table of data
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 414, 146);
		contentPane.add(scrollPane);
		
		tabListOrder = new JTable();
		tabListOrder.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Mode de paiement :", "Mode de livraison :", "Prix :", }) 
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
		DefaultTableModel model = (DefaultTableModel) tabListOrder.getModel();
		Commande c = new Commande();
		ArrayList<Commande> listCom = new ArrayList<Commande>();
		listCom = c.getList(cli.getId_personne());
		
		for(Commande co : listCom)
		{
			Object[] row = new Object [] {co.getMode_paiement(), co.getMode_livraison(), co.getPrix_total()};
			model.addRow(row);
		}
		scrollPane.setViewportView(tabListOrder);				
	}
}