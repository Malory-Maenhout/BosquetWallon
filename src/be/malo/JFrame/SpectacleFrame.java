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
import be.malo.POJO.Categorie;
import be.malo.POJO.Configuration;
import be.malo.POJO.LigneSpectacle;
import be.malo.POJO.PlanningSalle;
import be.malo.POJO.Spectacle;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;

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
	private ArrayList<Artistes> ListA = new ArrayList<Artistes>();
	private boolean verif;
	private int nbrMaxPlace;
	private String rdbtnChoice;
	private String debout = "Salle avec 8000 places debout de disponible";
	private String concert = "Salle avec 5000 places assises de dicponibles et différentes catégories de places comme : \n Or(500 places), Argent(1500 places) et Bronze(3000 places)";
	private String cirque = "Salle avec 6000 places assises de dicponibles et différentes catégories de places comme : \n Diamant(1000 places), Or(2000 places), Argent(1500 places) et Bronze(1500 places)";

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
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
	
	public SpectacleFrame(PlanningSalle ps) {
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
		spinnerNbrMaxPlace.setModel(new SpinnerNumberModel(0, 0, 10, 1));
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
				JOptionPane.showMessageDialog(null, debout);
			}
		});
		btnDescDebout.setBounds(230, 155, 190, 23);
		contentPane.add(btnDescDebout);
		
		// Button description concert
		JButton btnDescConcert = new JButton("Description concert");
		btnDescConcert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, concert);
			}
		});
		btnDescConcert.setBounds(230, 189, 190, 23);
		contentPane.add(btnDescConcert);
		
		// Button description cirque
		JButton btnDescCirque = new JButton("Description cirque");
		btnDescCirque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		JLabel lblDebout = new JLabel("Debout");
		lblDebout.setBounds(20, 333, 62, 21);
		contentPane.add(lblDebout);
		
		// Label place diam's
		JLabel lblDiamant = new JLabel("Diamant");
		lblDiamant.setBounds(20, 365, 62, 23);
		contentPane.add(lblDiamant);
		
		// Label place gold
		JLabel lblOr = new JLabel("Or");
		lblOr.setBounds(21, 399, 46, 23);
		contentPane.add(lblOr);
		
		// Label place silver
		JLabel lblArgent = new JLabel("Argent");
		lblArgent.setBounds(20, 433, 62, 25);
		contentPane.add(lblArgent);
		
		// Label place bronze
		JLabel lblBronze = new JLabel("Bronze");
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
					tfPrixDebout.setEditable(false);
					tfPrixDiams.setEditable(false);
					tfPrixOr.setEditable(false);
					tfPrixArgent.setEditable(false);
					tfPrixBronze.setEditable(false);
					tfPrixDebout.setText("");
					tfPrixDiams.setText("");
					tfPrixOr.setText("");
					tfPrixArgent.setText("");
					tfPrixBronze.setText("");
					lblPlaceMax.setText("Places MAX : 8000 places");
					lblPlaceDebout.setText("8000 places");
					tfPrixDebout.setEditable(true);
				}
				if(rdbtnConcert.isSelected())
				{
					tfPrixDebout.setEditable(false);
					tfPrixDiams.setEditable(false);
					tfPrixOr.setEditable(false);
					tfPrixArgent.setEditable(false);
					tfPrixBronze.setEditable(false);
					tfPrixDebout.setText("");
					tfPrixDiams.setText("");
					tfPrixOr.setText("");
					tfPrixArgent.setText("");
					tfPrixBronze.setText("");
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
					tfPrixDebout.setEditable(false);
					tfPrixDiams.setEditable(false);
					tfPrixOr.setEditable(false);
					tfPrixArgent.setEditable(false);
					tfPrixBronze.setEditable(false);
					tfPrixDebout.setText("");
					tfPrixDiams.setText("");
					tfPrixOr.setText("");
					tfPrixArgent.setText("");
					tfPrixBronze.setText("");
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
		ListA = new ArrayList<Artistes>(a.getAllArtistes());
		
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
				Artistes search = ListA.get(tabListArtistes.getSelectedRow());
				
				for(Artistes v : ListB)
				{
					if(v.getNom().equals(search.getNom()) && v.getPrenom().equals(search.getPrenom()))
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
				nbrMaxPlace = (int) spinnerNbrMaxPlace.getValue();
				
				if(rdbtnDebout.isSelected())
				{
					rdbtnChoice = "Debout";
				}
				else if(rdbtnConcert.isSelected())
				{
					rdbtnChoice = "Concert";
				}
				else if(rdbtnCirque.isSelected())
				{
					rdbtnChoice = "Cirque";
				}
				else
				{
					rdbtnChoice = "";
				}
				
				String w = verif();
				if(w.equals("Ok"))
				{
					Spectacle s = new Spectacle(tfTitre.getText(), (int) spinnerNbrMaxPlace.getValue(), ps.getId_planningsalle());
					boolean x = s.create();
					if(x == true) 
					{
						s = s.find();
						String v = "";
						for(Artistes artistes : ListB)
						{
							LigneSpectacle ls = new LigneSpectacle(s.getId_spectacle(), artistes.getId_personne());
							boolean y = ls.create();
							if(y == true)
							{
								v = "Ok";
							}
							else
							{
								v = "";
							}
						}
						
						if(v.equals("Ok"))
						{
							Configuration c = new Configuration();
							boolean z = false;
							
							if(rdbtnDebout.isSelected())
							{
								c = new Configuration(rdbtnDebout.getText(), debout, s.getId_spectacle());
								z = c.create();
							}
							else if(rdbtnConcert.isSelected())
							{
								c = new Configuration(rdbtnConcert.getText(), concert, s.getId_spectacle());
								z = c.create();
							}
							else if(rdbtnCirque.isSelected())
							{
								c = new Configuration(rdbtnCirque.getText(), cirque, s.getId_spectacle());
								z = c.create();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Erreur lors de la création de la configuration !");
							}
							
							if(z == true)
							{
								c = c.find();
								boolean fin = false;
								
								if(rdbtnDebout.isSelected())
								{
									double dbl1 = Double.parseDouble(tfPrixDebout.getText());
									int place = 8000;
									
									Categorie cat1 = new Categorie(lblDebout.getText(), dbl1, place, place, c.getId_configuration());
									
									fin = cat1.create();
								}
								else if(rdbtnConcert.isSelected())
								{
									double dbl1 = Double.parseDouble(tfPrixOr.getText());
									double dbl2 = Double.parseDouble(tfPrixArgent.getText());
									double dbl3 = Double.parseDouble(tfPrixBronze.getText());
									int place1 = 500;
									int place2 = 1500;
									int place3 = 3000;
									
									Categorie cat1, cat2, cat3 = new Categorie();
									cat1 = new Categorie(lblOr.getText(), dbl1, place1, place1, c.getId_configuration());
									cat2 = new Categorie(lblArgent.getText(), dbl2, place2, place2, c.getId_configuration());
									cat3 = new Categorie(lblBronze.getText(), dbl3, place3, place3, c.getId_configuration());
									
									fin = cat1.create();
									fin = cat2.create();
									fin = cat3.create();
								}
								else if(rdbtnCirque.isSelected())
								{
									double dbl1 = Double.parseDouble(tfPrixOr.getText());
									double dbl2 = Double.parseDouble(tfPrixArgent.getText());
									double dbl3 = Double.parseDouble(tfPrixBronze.getText());
									double dbl4 = Double.parseDouble(tfPrixDiams.getText());
									int place1 = 2000;
									int place2 = 1500;
									int place3 = 1500;
									int place4 = 1000;
									
									Categorie cat1, cat2, cat3, cat4 = new Categorie();
									cat1 = new Categorie(lblOr.getText(), dbl1, place1, place1, c.getId_configuration());
									cat2 = new Categorie(lblArgent.getText(), dbl2, place2, place2, c.getId_configuration());
									cat3 = new Categorie(lblBronze.getText(), dbl3, place3, place3, c.getId_configuration());
									cat4 = new Categorie(lblDiamant.getText(), dbl4, place4, place4, c.getId_configuration());
									
									fin = cat1.create();
									fin = cat2.create();
									fin = cat3.create();
									fin = cat4.create();
								}
								
								if(fin == true)
								{
									JOptionPane.showMessageDialog(null, "Votre Spectacle a été enregistrer !");

									RepresentationFrame rf = new RepresentationFrame(s);
									rf.setVisible(true);
									dispose();
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement de la/des catégorie(s) !");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement de la configuration !");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement de la liste des artistes du spectacle !");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement du spectacle !");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, w);
				}			
			}
		});
		btnValider.setBounds(296, 469, 207, 23);
		contentPane.add(btnValider);
	}
	
	public String verif()
	{
		if(tfTitre.getText().equals("") || nbrMaxPlace == 0)
		{
			return "Remplisser tous les champs disponible avant de valider !";
		}
		else
		{		
			if(ListB.isEmpty())
			{
				return "Remplisser tous les champs disponible avant de valider !";
			}
			else
			{
				if(rdbtnChoice.equals("Debout"))
				{
					if(tfPrixDebout.getText().equals("") || tfPrixDebout.getText().matches("^[a-zA-Z]+$"))
					{
						return "Remplisser tous les champs disponible avant de valider !";
					}
					else
					{
						return "Ok";
					}
				}
				else if(rdbtnChoice.equals("Concert"))
				{
					if(tfPrixOr.getText().equals("") || tfPrixArgent.getText().equals("") || tfPrixBronze.getText().equals("") 
							|| tfPrixOr.getText().matches("^[a-zA-Z]+$") || tfPrixArgent.getText().matches("^[a-zA-Z]+$") || tfPrixBronze.getText().matches("^[a-zA-Z]+$"))
					{
						return "Remplisser tous les champs disponible avant de valider !";
					}
					else
					{
						return "Ok";
					}
				}
				else if(rdbtnChoice.equals("Cirque"))
				{
					if(tfPrixOr.getText().equals("") || tfPrixArgent.getText().equals("") || tfPrixBronze.getText().equals("") || tfPrixDiams.getText().equals("")
							|| tfPrixOr.getText().matches("^[a-zA-Z]+$") || tfPrixArgent.getText().matches("^[a-zA-Z]+$") || tfPrixBronze.getText().matches("^[a-zA-Z]+$") || tfPrixDiams.getText().matches("^[a-zA-Z]+$"))
					{
						return "Remplisser tous les champs disponible avant de valider !";
					}
					else
					{
						return "Ok";
					}
				}
				else
				{
					return "Remplisser tous les champs disponible avant de valider !";
				}
			}
		}
	}
}
