package be.malo.JFrame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import be.malo.POJO.Artistes;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class SpectacleFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfPrixDebout;
	private JTextField tfPrixDiams;
	private JTextField tfPrixOr;
	private JTextField tfPrixArgent;
	private JTextField tfPrixBronze;
	private JTable tabListArtistes;
	private JTable tabListArtistesInSpectacle;
	private ArrayList<Artistes> ListB = new ArrayList<Artistes>();
	private boolean verif;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpectacleFrame frame = new SpectacleFrame();
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
	
	public SpectacleFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Main label
		JLabel lblSpectacle = new JLabel("Spectacle :");
		lblSpectacle.setBounds(20, 11, 125, 22);
		contentPane.add(lblSpectacle);
		
		// Second label
		JLabel lblInfoSpectacle = new JLabel("Cr\u00E9e le spectacle correspondant \u00E0 votre r\u00E9servation.");
		lblInfoSpectacle.setBounds(20, 47, 299, 22);
		contentPane.add(lblInfoSpectacle);
		
		// Label titre
		JLabel lblTtireSpectacle = new JLabel("Titre : ");
		lblTtireSpectacle.setBounds(20, 80, 62, 22);
		contentPane.add(lblTtireSpectacle);
		
		// Titre text field
		tfTitre = new JTextField();
		tfTitre.setBounds(81, 82, 397, 20);
		tfTitre.setColumns(10);
		contentPane.add(tfTitre);
		
		// Label number place max by poeple
		JLabel lblNbrMaxPlace = new JLabel("Nombre de place maximum par client : ");
		lblNbrMaxPlace.setBounds(20, 115, 299, 22);
		contentPane.add(lblNbrMaxPlace);
		
		// Spinner number place max by poeple
		JSpinner spinnerNbrMaxPlace = new JSpinner();
		spinnerNbrMaxPlace.setBounds(277, 113, 89, 20);
		contentPane.add(spinnerNbrMaxPlace);
		
		// Label configuration
		JLabel lblTypeConfiguration = new JLabel("Configuration : ");
		lblTypeConfiguration.setBounds(20, 155, 125, 23);
		contentPane.add(lblTypeConfiguration);
		
		// Button description stand up
		JButton btnDescDebout = new JButton("Description debout");
		btnDescDebout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String debout = "Salle avec 8000 places debout de disponible";
				JOptionPane.showMessageDialog(null, debout);
			}
		});
		btnDescDebout.setBounds(230, 155, 190, 23);
		contentPane.add(btnDescDebout);
		
		// Button description concert
		JButton btnDescConcert = new JButton("Description concert");
		btnDescConcert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String concert = "Salle avec 5000 places de dicponibles et différentes catégories de places comme : \n Or(500 places), Argent(1500 places) et Bronze(3000 places)";
				JOptionPane.showMessageDialog(null, concert);
			}
		});
		btnDescConcert.setBounds(230, 189, 190, 23);
		contentPane.add(btnDescConcert);
		
		// Button description cirque
		JButton btnDescCirque = new JButton("Description cirque");
		btnDescCirque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cirque = "Salle avec 6000 places de dicponibles et différentes catégories de places comme : \n Diamant(1000 places), Or(2000 places), Argent(1500 places) et Bronze(1500 places)";
				JOptionPane.showMessageDialog(null, cirque);
			}
		});
		btnDescCirque.setBounds(230, 223, 190, 23);
		contentPane.add(btnDescCirque);
		
		// Label number of place by category and price
		JLabel lblPlacePrix = new JLabel("Nombre  de places par cat\u00E9gorie et prix :");
		lblPlacePrix.setBounds(20, 301, 299, 21);
		contentPane.add(lblPlacePrix);
		
		// Label places max
		JLabel lblPlaceMax = new JLabel("Places MAX : ");
		lblPlaceMax.setBounds(277, 302, 223, 18);
		contentPane.add(lblPlaceMax);
		
		// Label place stand up
		JLabel lblDebout = new JLabel("Debout :");
		lblDebout.setBounds(20, 333, 62, 21);
		contentPane.add(lblDebout);
		
		// Label place diam's
		JLabel lblDiamant = new JLabel("Diamant :");
		lblDiamant.setBounds(20, 365, 62, 23);
		contentPane.add(lblDiamant);
		
		// Label place gold
		JLabel lblOr = new JLabel("Or :");
		lblOr.setBounds(21, 399, 46, 23);
		contentPane.add(lblOr);
		
		// Label place silver
		JLabel lblArgent = new JLabel("Argent :");
		lblArgent.setBounds(20, 433, 62, 25);
		contentPane.add(lblArgent);
		
		// Label place bronze
		JLabel lblBronze = new JLabel("Bronze :");
		lblBronze.setBounds(20, 469, 62, 23);		
		contentPane.add(lblBronze);
		
		// Label number place to stand up
		JLabel lblPlaceDebout = new JLabel("0 places");
		lblPlaceDebout.setBounds(92, 334, 83, 18);
		contentPane.add(lblPlaceDebout);
		
		// Label number place to diam's
		JLabel lblPlaceDiams = new JLabel("0 places");
		lblPlaceDiams.setBounds(92, 367, 83, 19);
		contentPane.add(lblPlaceDiams);
		
		// Label number place to gold
		JLabel lblPlaceOr = new JLabel("0 places");
		lblPlaceOr.setBounds(92, 401, 83, 19);
		contentPane.add(lblPlaceOr);
		
		// Label number place to silver
		JLabel lblPlaceArgent = new JLabel("0 places");
		lblPlaceArgent.setBounds(92, 435, 83, 20);
		contentPane.add(lblPlaceArgent);
		
		// Label number place to bronze
		JLabel lblPlaceBronze = new JLabel("0 places");
		lblPlaceBronze.setBounds(92, 471, 83, 19);
		contentPane.add(lblPlaceBronze);
		
		// Radio button stand up
		JRadioButton rdbtnDebout = new JRadioButton("Debout");
		rdbtnDebout.setBounds(119, 155, 92, 23);
		buttonGroup.add(rdbtnDebout);		
		contentPane.add(rdbtnDebout);
		
		if(rdbtnDebout.isSelected())
		{
			lblPlaceDebout.setText("8000 places");
		}
		
		// Radio button concert
		JRadioButton rdbtnConcert = new JRadioButton("Concert");
		rdbtnConcert.setBounds(119, 189, 92, 23);
		buttonGroup.add(rdbtnConcert);
		contentPane.add(rdbtnConcert);
		
		// Radio button cirque
		JRadioButton rdbtnCirque = new JRadioButton("Cirque");
		rdbtnCirque.setBounds(119, 223, 92, 23);
		buttonGroup.add(rdbtnCirque);
		contentPane.add(rdbtnCirque);
		
		// Text field price to stand up
		tfPrixDebout = new JTextField();
		tfPrixDebout.setBounds(185, 333, 86, 20);
		contentPane.add(tfPrixDebout);
		tfPrixDebout.setColumns(10);
		tfPrixDebout.setEditable(false);
		
		// Text field price to diam's
		tfPrixDiams = new JTextField();
		tfPrixDiams.setBounds(185, 366, 86, 20);
		contentPane.add(tfPrixDiams);
		tfPrixDiams.setColumns(10);
		tfPrixDiams.setEditable(false);
		
		// Text field price to gold
		tfPrixOr = new JTextField();
		tfPrixOr.setBounds(185, 400, 86, 20);
		contentPane.add(tfPrixOr);
		tfPrixOr.setColumns(10);
		tfPrixOr.setEditable(false);
		
		// Text field price to silver
		tfPrixArgent = new JTextField();
		tfPrixArgent.setBounds(185, 435, 86, 20);
		contentPane.add(tfPrixArgent);
		tfPrixArgent.setColumns(10);
		tfPrixArgent.setEditable(false);
		
		// Text field price to bronze
		tfPrixBronze = new JTextField();
		tfPrixBronze.setBounds(185, 470, 86, 20);
		contentPane.add(tfPrixBronze);
		tfPrixBronze.setColumns(10);
		tfPrixBronze.setEditable(false);
		
		// Label euro
		JLabel lblEuro1 = new JLabel("\u20AC");
		lblEuro1.setBounds(273, 334, 46, 18);
		contentPane.add(lblEuro1);
		
		// Label euro
		JLabel lblEuro2 = new JLabel("\u20AC");
		lblEuro2.setBounds(273, 367, 46, 18);
		contentPane.add(lblEuro2);
		
		// Label euro
		JLabel lblEuro3 = new JLabel("\u20AC");
		lblEuro3.setBounds(273, 401, 46, 18);
		contentPane.add(lblEuro3);
		
		// Label euro
		JLabel lblEuro4 = new JLabel("\u20AC");
		lblEuro4.setBounds(273, 436, 46, 18);
		contentPane.add(lblEuro4);
		
		// Label euro
		JLabel lblEuro5 = new JLabel("\u20AC");
		lblEuro5.setBounds(273, 471, 46, 18);
		contentPane.add(lblEuro5);
		
		// Button to valid the configuration
		JButton btnConfValid = new JButton("Valid\u00E9 la configuration");
		btnConfValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDebout.isSelected())
				{
					lblPlaceMax.setText("Places MAX : 8000 places");
					lblPlaceDebout.setText("8000 places");
					tfPrixDebout.setEditable(true);
				}
				if(rdbtnConcert.isSelected())
				{
					lblPlaceMax.setText("Places MAX : 5000 places");
					lblPlaceOr.setText("500 places");
					tfPrixOr.setEditable(true);
					lblPlaceArgent.setText("1500 places");
					tfPrixArgent.setEditable(true);
					lblPlaceBronze.setText("3000 places");
					tfPrixBronze.setEditable(true);
				}
				if(rdbtnCirque.isSelected())
				{
					lblPlaceMax.setText("Places MAX : 6000 places");
					lblPlaceDiams.setText("1000 places");
					tfPrixDiams.setEditable(true);
					lblPlaceOr.setText("2000 places");
					tfPrixOr.setEditable(true);
					lblPlaceArgent.setText("1500 places");
					tfPrixArgent.setEditable(true);
					lblPlaceBronze.setText("1500 places");
					tfPrixBronze.setEditable(true);
				}
			}
		});
		btnConfValid.setBounds(20, 267, 190, 23);
		contentPane.add(btnConfValid);
			
		// Label list artistes
		JLabel lblListArtiste = new JLabel("Liste des artistes :");
		lblListArtiste.setBounds(510, 15, 130, 18);
		contentPane.add(lblListArtiste);
		
		// Tab of artistes
		JScrollPane scrollPaneA = new JScrollPane();
		scrollPaneA.setBounds(510, 44, 321, 195);
		contentPane.add(scrollPaneA);
		
		tabListArtistes = new JTable();
		tabListArtistes.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Nom", "Prénom"}) 
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
		scrollPaneA.setViewportView(tabListArtistes);
		
		Artistes a = new Artistes();
		ArrayList<Artistes> ListA = new ArrayList<Artistes>(a.getAllArtistes());
		
		for(Artistes art : ListA)
		{
			DefaultTableModel model = (DefaultTableModel) tabListArtistes.getModel();
			Object[] row = new Object [] {art.getNom(), art.getPrenom()};
			model.addRow(row);
		}		
		
		// Button add to spectacle
		JButton btnAddToSpectacle = new JButton("Ajouter au spectacle");
		btnAddToSpectacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligne =tabListArtistes.getSelectedRow();
				String nomA = (String) tabListArtistes.getValueAt(ligne, 0);
				String prenomA = (String) tabListArtistes.getValueAt(ligne, 1);
				
				Artistes search = new Artistes();
				search = search.findByNameAndFirstname(nomA, prenomA);
				
				for(Artistes v : ListB)
				{
					if(v.getId_personne() == search.getId_personne())
					{
						verif = true;
					}
					else
					{
						verif = false;
					}
				}
				
				if(verif == true)
				{
					JOptionPane.showMessageDialog(null, search.getPrenom() + " " + search.getNom() + " est déjà dans le spectacle !" );
				}
				else
				{
					ListB.add(search);			
					DefaultTableModel model = (DefaultTableModel) tabListArtistesInSpectacle.getModel();
					Object[] row = new Object [] {search.getNom(), search.getPrenom()};
					model.addRow(row);
				}				
			}
		});
		btnAddToSpectacle.setBounds(510, 256, 321, 23);
		contentPane.add(btnAddToSpectacle);
		
		// Label list artistes in spectacle
		JLabel lblListArtistesInSpectacle = new JLabel("Liste des artistes dans le spectacles :");
		lblListArtistesInSpectacle.setBounds(510, 290, 321, 22);
		contentPane.add(lblListArtistesInSpectacle);
		
		// Tab of artistes in spectacle
		JScrollPane scrollPaneB = new JScrollPane();
		scrollPaneB.setBounds(510, 321, 321, 171);
		contentPane.add(scrollPaneB);
		
		tabListArtistesInSpectacle = new JTable();
		tabListArtistesInSpectacle.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Nom", "Prénom"}) 
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
		scrollPaneB.setViewportView(tabListArtistesInSpectacle);
		
		// Button reset
		JButton btnReset = new JButton("R\u00E9initialiser les donn\u00E9es");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfTitre.setText(null);
				spinnerNbrMaxPlace.setValue(0);
				buttonGroup.clearSelection();
				lblPlaceDebout.setText("0 places");
				lblPlaceDiams.setText("0 places");
				lblPlaceOr.setText("0 places");
				lblPlaceArgent.setText("0 places");
				lblPlaceBronze.setText("0 places");
				tfPrixDebout.setText("");
				tfPrixDiams.setText("");
				tfPrixOr.setText("");
				tfPrixArgent.setText("");
				tfPrixBronze.setText("");
				tfPrixDebout.setEditable(false);
				tfPrixDiams.setEditable(false);
				tfPrixOr.setEditable(false);
				tfPrixArgent.setEditable(false);
				tfPrixBronze.setEditable(false);
				lblPlaceMax.setText("Places MAX : ");			
				ListB.removeAll(ListB);				
				DefaultTableModel model = (DefaultTableModel) tabListArtistesInSpectacle.getModel();
			    for( int i = model.getRowCount() - 1; i >= 0; i-- ) {
			        model.removeRow(i);
			    }
			}
		});
		btnReset.setBounds(277, 11, 207, 23);
		contentPane.add(btnReset);
		
		// Button validity
		JButton btnValider = new JButton("Valider la cr\u00E9ation");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnValider.setBounds(296, 469, 207, 23);
		contentPane.add(btnValider);
	}
}
