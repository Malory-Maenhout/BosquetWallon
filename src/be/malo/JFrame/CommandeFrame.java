package be.malo.JFrame;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import be.malo.POJO.Categorie;
import be.malo.POJO.Client;
import be.malo.POJO.Commande;
import be.malo.POJO.Configuration;
import be.malo.POJO.LigneCommande;
import be.malo.POJO.Place;
import be.malo.POJO.Representation;
import be.malo.POJO.Spectacle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class CommandeFrame extends JFrame {

	private JPanel contentPane;
	private Configuration conf = new Configuration();
	private ArrayList<Categorie> listCat = new ArrayList<Categorie>();
	private JTable tabListOrder;
	private final ButtonGroup btnGMP = new ButtonGroup();
	private final ButtonGroup btnGML = new ButtonGroup();
	private ArrayList<Place> listOrder = new ArrayList<Place>();
	private Double prix = 0.0;
	private String mp;
	private String ml;

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
	
	public CommandeFrame(Client cli, Spectacle spec, Representation rep) {
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
		        DateFormat.SHORT,
		        DateFormat.SHORT);
		
		conf = conf.findById(spec.getId_spectacle());
		Categorie cat = new Categorie();
		listCat = cat.findAll(conf.getId_configuration());
		
		Date db = new Date((rep.getDate_debut()).getTime());
		Date df = new Date((rep.getDate_fin()).getTime());
		Date dh = new Date((rep.getHeure_porte_open()).getTime());
		
		Timestamp dbf = new Timestamp(db.getYear(), db.getMonth(), db.getDate(), db.getHours(), db.getMinutes(), 0, 0);
		Timestamp dff = new Timestamp(df.getYear(), df.getMonth(), df.getDate(), df.getHours(), df.getMinutes(), 0, 0);
		Timestamp dho = new Timestamp(dh.getYear(), dh.getMonth(), dh.getDate(), dh.getHours(), dh.getMinutes(), 0, 0);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Main label
		JLabel lblOrder = new JLabel("Commande :");
		lblOrder.setBounds(10, 11, 137, 25);
		contentPane.add(lblOrder);
		
		// Second label
		JLabel lblCustomer = new JLabel("Client :");
		lblCustomer.setBounds(10, 46, 87, 20);
		contentPane.add(lblCustomer);
		
		// Label info customer
		JLabel lblInfoClient = new JLabel("Nom : " + cli.getNom() + "   Prénom : " + cli.getPrenom());
		lblInfoClient.setBounds(62, 44, 488, 25);
		contentPane.add(lblInfoClient);
		
		// Label title
		JLabel lblTitre = new JLabel("Titre du spectacle : ");
		lblTitre.setBounds(10, 77, 236, 25);
		contentPane.add(lblTitre);
		
		// Label info title
		JLabel lblTitreSpectacle = new JLabel(spec.getTitre());
		lblTitreSpectacle.setBounds(131, 79, 488, 20);
		contentPane.add(lblTitreSpectacle);
		
		// Label number place by customer
		JLabel lblNbrPlaceByCustomer = new JLabel("Nombre de place max que vous pouvez commander :");
		lblNbrPlaceByCustomer.setBounds(10, 113, 353, 25);
		contentPane.add(lblNbrPlaceByCustomer);
		
		// Label with info number place by customer
		String npbc = String.valueOf(spec.getNbrPlaceParClient());
		JLabel lblNPBC = new JLabel(npbc);
		lblNPBC.setBounds(326, 115, 74, 20);
		contentPane.add(lblNPBC);
		
		// Label representation				
		JLabel lblRepresentation = new JLabel("Repr\u00E9sentation : ");
		lblRepresentation.setBounds(10, 149, 122, 25);
		contentPane.add(lblRepresentation);
		
		// Label info representation
		JLabel lblInfoRepresentation = new JLabel("Commence : " + shortDateFormat.format(dbf) + "   Termine : "+ shortDateFormat.format(dff));
		lblInfoRepresentation.setBounds(120, 151, 521, 20);
		contentPane.add(lblInfoRepresentation);
		
		// Label hour door open
		JLabel lblDoorOpen = new JLabel("Overture des portes : ");
		lblDoorOpen.setBounds(10, 185, 137, 20);
		contentPane.add(lblDoorOpen);
		
		// Label info hour door open
		JLabel lblInfoDoorOpen = new JLabel(shortDateFormat.format(dho));
		lblInfoDoorOpen.setBounds(141, 187, 222, 17);
		contentPane.add(lblInfoDoorOpen);
		
		// Label configuration	
		JLabel lblConfiguration = new JLabel("Type de configuration : ");
		lblConfiguration.setBounds(10, 222, 177, 25);
		contentPane.add(lblConfiguration);
		
		// Label info configuration
		JLabel lblInfoConfiguration = new JLabel(conf.getType_configuration());
		lblInfoConfiguration.setBounds(151, 221, 96, 26);
		contentPane.add(lblInfoConfiguration);
		
		// Button description conf
		JButton btnDescription = new JButton("Description");
		btnDescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, conf.getDescription());
			}
		});
		btnDescription.setBounds(216, 223, 113, 23);
		contentPane.add(btnDescription);
		
		// Label categorie
		JLabel lblCat = new JLabel("Cat\u00E9gories des places :");
		lblCat.setBounds(10, 258, 205, 25);
		contentPane.add(lblCat);
		
		// Label stand up
		JLabel lblStandUp = new JLabel("Debout : ");
		lblStandUp.setBounds(10, 299, 54, 20);
		contentPane.add(lblStandUp);
		
		// Label diams
		JLabel lblDiams = new JLabel("Diamant : ");
		lblDiams.setBounds(10, 330, 66, 25);
		contentPane.add(lblDiams);
		
		// Label gold
		JLabel lblGold = new JLabel("Or :");
		lblGold.setBounds(10, 366, 54, 25);
		contentPane.add(lblGold);
		
		// Label silver
		JLabel lblSilver = new JLabel("Argent : ");
		lblSilver.setBounds(10, 402, 54, 25);
		contentPane.add(lblSilver);
		
		// label bronze
		JLabel lblBronze = new JLabel("Bronze : ");
		lblBronze.setBounds(10, 438, 54, 25);
		contentPane.add(lblBronze);
			
		// All Label place with number place available and price
		JLabel lblInfoStandUp = new JLabel("Place Disponible : 0 places   Prix :  0 \u20AC ");
		lblInfoStandUp.setBounds(74, 299, 288, 20);
		contentPane.add(lblInfoStandUp);
		
		JLabel lblInfoDiams = new JLabel("Place Disponible : 0 places   Prix :  0 \u20AC ");
		lblInfoDiams.setBounds(74, 335, 288, 20);
		contentPane.add(lblInfoDiams);
		
		JLabel lblInfoGold = new JLabel("Place Disponible : 0 places   Prix :  0 \u20AC ");
		lblInfoGold.setBounds(74, 371, 288, 20);
		contentPane.add(lblInfoGold);
		
		JLabel lblInfoSilver = new JLabel("Place Disponible : 0 places   Prix :  0 \u20AC ");
		lblInfoSilver.setBounds(74, 407, 288, 20);
		contentPane.add(lblInfoSilver);
		
		JLabel lblInfoBronze = new JLabel("Place Disponible : 0 places   Prix :  0 \u20AC ");
		lblInfoBronze.setBounds(74, 443, 288, 20);
		contentPane.add(lblInfoBronze);
		
		// Add stand up
		JButton btnAddPlaceDebout = new JButton("Ajouter");
		btnAddPlaceDebout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				for(Categorie v : listCat)
				{
					if(v.getType_categorie().equals("Debout"))
					{
						if(v.getNbrPlaceDispo() == 0)
						{
							JOptionPane.showMessageDialog(null, "Il n'y a plus de place disponible !");
							btnAddPlaceDebout.setEnabled(false);
						}
						else
						{
							Place p = new Place();
							p.setNumplace(v.getNbrPlaceDispo());
							p.setPrix(v.getPrix());
							lblInfoStandUp.setText("Place Disponible : " + (v.getNbrPlaceDispo() - 1) + " places   Prix : " + v.getPrix() + " €");					
							Categorie update = new Categorie(v.getId_categorie(), v.getType_categorie(), v.getPrix(), v.getNbrPlaceDispo() - 1, v.getNbrPlaceMax(), v.getId_configuration());
							listCat.remove(v);
							listCat.add(update);
							listOrder.add(p);
							DefaultTableModel model = (DefaultTableModel) tabListOrder.getModel();
							Object[] row = new Object [] {v.getType_categorie(), p.getPrix(), p.getNumplace()};
							model.addRow(row);	
						}	
						break;
					}					
				}				
			}
		});
		btnAddPlaceDebout.setEnabled(false);
		btnAddPlaceDebout.setBounds(371, 298, 89, 23);
		contentPane.add(btnAddPlaceDebout);
		
		// Add diams
		JButton btnAddPlaceDiams = new JButton("Ajouter");
		btnAddPlaceDiams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Categorie v : listCat)
				{
					if(v.getType_categorie().equals("Diamant"))
					{
						if(v.getNbrPlaceDispo() == 0)
						{
							JOptionPane.showMessageDialog(null, "Il n'y a plus de place disponible !");
							btnAddPlaceDiams.setEnabled(false);
						}
						else
						{
							Place p = new Place();
							p.setNumplace(v.getNbrPlaceDispo());
							p.setPrix(v.getPrix());
							lblInfoDiams.setText("Place Disponible : " + (v.getNbrPlaceDispo() - 1) + " places   Prix : " + v.getPrix() + " €");					
							Categorie update = new Categorie(v.getId_categorie(), v.getType_categorie(), v.getPrix(), v.getNbrPlaceDispo() - 1, v.getNbrPlaceMax(), v.getId_configuration());
							listCat.remove(v);
							listCat.add(update);
							listOrder.add(p);
							DefaultTableModel model = (DefaultTableModel) tabListOrder.getModel();
							Object[] row = new Object [] {v.getType_categorie(), p.getPrix(), p.getNumplace()};
							model.addRow(row);	
						}	
						break;
					}					
				}
			}
		});
		btnAddPlaceDiams.setEnabled(false);
		btnAddPlaceDiams.setBounds(371, 331, 89, 23);
		contentPane.add(btnAddPlaceDiams);
		
		// Add gold
		JButton btnAddPlaceGold = new JButton("Ajouter");
		btnAddPlaceGold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Categorie v : listCat)
				{
					if(v.getType_categorie().equals("Or"))
					{
						if(v.getNbrPlaceDispo() == 0)
						{
							JOptionPane.showMessageDialog(null, "Il n'y a plus de place disponible !");
							btnAddPlaceGold.setEnabled(false);
						}
						else
						{
							Place p = new Place();
							p.setNumplace(v.getNbrPlaceDispo());
							p.setPrix(v.getPrix());
							lblInfoGold.setText("Place Disponible : " + (v.getNbrPlaceDispo() - 1) + " places   Prix : " + v.getPrix() + " €");					
							Categorie update = new Categorie(v.getId_categorie(), v.getType_categorie(), v.getPrix(), v.getNbrPlaceDispo() - 1, v.getNbrPlaceMax(), v.getId_configuration());
							listCat.remove(v);
							listCat.add(update);
							listOrder.add(p);
							DefaultTableModel model = (DefaultTableModel) tabListOrder.getModel();
							Object[] row = new Object [] {v.getType_categorie(), p.getPrix(), p.getNumplace()};
							model.addRow(row);	
						}	
						break;
					}					
				}
			}
		});
		btnAddPlaceGold.setEnabled(false);
		btnAddPlaceGold.setBounds(371, 367, 89, 23);
		contentPane.add(btnAddPlaceGold);
		
		// Add silver
		JButton btnAddPlaceSilver = new JButton("Ajouter");
		btnAddPlaceSilver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Categorie v : listCat)
				{
					if(v.getType_categorie().equals("Argent"))
					{
						if(v.getNbrPlaceDispo() == 0)
						{
							JOptionPane.showMessageDialog(null, "Il n'y a plus de place disponible !");
							btnAddPlaceSilver.setEnabled(false);
						}
						else
						{
							Place p = new Place();
							p.setNumplace(v.getNbrPlaceDispo());
							p.setPrix(v.getPrix());
							lblInfoSilver.setText("Place Disponible : " + (v.getNbrPlaceDispo() - 1) + " places   Prix : " + v.getPrix() + " €");					
							Categorie update = new Categorie(v.getId_categorie(), v.getType_categorie(), v.getPrix(), v.getNbrPlaceDispo() - 1, v.getNbrPlaceMax(), v.getId_configuration());
							listCat.remove(v);
							listCat.add(update);
							listOrder.add(p);
							DefaultTableModel model = (DefaultTableModel) tabListOrder.getModel();
							Object[] row = new Object [] {v.getType_categorie(), p.getPrix(), p.getNumplace()};
							model.addRow(row);	
						}	
						break;
					}					
				}
			}
		});
		btnAddPlaceSilver.setEnabled(false);
		btnAddPlaceSilver.setBounds(371, 403, 89, 23);
		contentPane.add(btnAddPlaceSilver);
		
		// Add bronze
		JButton btnAddPlaceBronze = new JButton("Ajouter");
		btnAddPlaceBronze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Categorie v : listCat)
				{
					if(v.getType_categorie().equals("Bronze"))
					{
						if(v.getNbrPlaceDispo() == 0)
						{
							JOptionPane.showMessageDialog(null, "Il n'y a plus de place disponible !");
							btnAddPlaceBronze.setEnabled(false);
						}
						else
						{
							Place p = new Place();
							p.setNumplace(v.getNbrPlaceDispo());
							p.setPrix(v.getPrix());
							lblInfoBronze.setText("Place Disponible : " + (v.getNbrPlaceDispo() - 1) + " places   Prix : " + v.getPrix() + " €");					
							Categorie update = new Categorie(v.getId_categorie(), v.getType_categorie(), v.getPrix(), v.getNbrPlaceDispo() - 1, v.getNbrPlaceMax(), v.getId_configuration());
							listCat.remove(v);
							listCat.add(update);
							listOrder.add(p);
							DefaultTableModel model = (DefaultTableModel) tabListOrder.getModel();
							Object[] row = new Object [] {v.getType_categorie(), p.getPrix(), p.getNumplace()};
							model.addRow(row);	
						}	
						break;
					}					
				}
			}
		});
		btnAddPlaceBronze.setEnabled(false);
		btnAddPlaceBronze.setBounds(371, 439, 89, 23);
		contentPane.add(btnAddPlaceBronze);
		
		// Modify all Label place with number place available and price
		if(conf.getType_configuration().equals("Debout"))
		{
			for(Categorie v : listCat)
			{
				if(v.getType_categorie().equals("Debout")) 
				{
					lblInfoStandUp.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceDebout.setEnabled(true);
				}				
				else if(v.getType_categorie().equals("Diamant"))
				{
					lblInfoDiams.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceDiams.setEnabled(true);
				}
				else if(v.getType_categorie().equals("Or"))
				{
					lblInfoGold.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceGold.setEnabled(true);
				}
				else if(v.getType_categorie().equals("Argent"))
				{
					lblInfoSilver.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceSilver.setEnabled(true);
				}
				else if(v.getType_categorie().equals("Bronze"))
				{
					lblInfoBronze.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceBronze.setEnabled(true);
				}			
			}
		}
		else if(conf.getType_configuration().equals("Concert"))
		{
			for(Categorie v : listCat)
			{
				if(v.getType_categorie().equals("Debout")) 
				{
					lblInfoStandUp.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceDebout.setEnabled(true);
				}				
				else if(v.getType_categorie().equals("Diamant"))
				{
					lblInfoDiams.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceDiams.setEnabled(true);
				}
				else if(v.getType_categorie().equals("Or"))
				{
					lblInfoGold.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceGold.setEnabled(true);
				}
				else if(v.getType_categorie().equals("Argent"))
				{
					lblInfoSilver.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceSilver.setEnabled(true);
				}
				else if(v.getType_categorie().equals("Bronze"))
				{
					lblInfoBronze.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceBronze.setEnabled(true);
				}
			}
		}
		else if(conf.getType_configuration().equals("Cirque"))
		{
			for(Categorie v : listCat)
			{
				if(v.getType_categorie().equals("Debout")) 
				{
					lblInfoStandUp.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceDebout.setEnabled(true);
				}				
				else if(v.getType_categorie().equals("Diamant"))
				{
					lblInfoDiams.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceDiams.setEnabled(true);
				}
				else if(v.getType_categorie().equals("Or"))
				{
					lblInfoGold.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceGold.setEnabled(true);
				}
				else if(v.getType_categorie().equals("Argent"))
				{
					lblInfoSilver.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceSilver.setEnabled(true);
				}
				else if(v.getType_categorie().equals("Bronze"))
				{
					lblInfoBronze.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
					btnAddPlaceBronze.setEnabled(true);
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Erreur avec le type de configuration !");
		}
		
		// Button return
		JButton btnReturn = new JButton("Retour");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListRepresentationOrderFrame lrof = new ListRepresentationOrderFrame(cli, spec);
				lrof.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(787, 12, 89, 23);
		contentPane.add(btnReturn);
		
		// Tab list place order
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(490, 334, 386, 219);
		contentPane.add(scrollPane);
		
		tabListOrder = new JTable();
		tabListOrder.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Catégorie :", "Prix :", "Numéro de place :"}) 
			{
			boolean[] columnEditables = new boolean[] {
					false, false, false
			};
			public boolean isCellEditable(int row, int column) 
			{
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tabListOrder);
		
		// Label prix
		JLabel lblPrix = new JLabel(prix + " €");
		lblPrix.setBounds(787, 564, 89, 25);
		contentPane.add(lblPrix);
		
		// Label prix total
		JLabel lblPrixTotal = new JLabel("Prix Total * :");
		lblPrixTotal.setBounds(704, 563, 122, 26);
		contentPane.add(lblPrixTotal);
		
		// Label place order
		JLabel lblPlaceOrder = new JLabel("Place commander :");
		lblPlaceOrder.setBounds(490, 302, 386, 25);
		contentPane.add(lblPlaceOrder);
		
		// Label mode de paiement
		JLabel lblModePaiement = new JLabel("Mode de paiement :");
		lblModePaiement.setBounds(490, 48, 386, 17);
		contentPane.add(lblModePaiement);
		
		// Visa
		JRadioButton rdbtnVisa = new JRadioButton("Visa");
		btnGMP.add(rdbtnVisa);
		rdbtnVisa.setBounds(490, 76, 129, 23);
		contentPane.add(rdbtnVisa);
		
		// PayPal
		JRadioButton rdbtnPayPal = new JRadioButton("PayPal");
		btnGMP.add(rdbtnPayPal);
		rdbtnPayPal.setBounds(490, 101, 129, 23);
		contentPane.add(rdbtnPayPal);
		
		// Virement
		JRadioButton rdbtnVirement = new JRadioButton("Virement SEPA");
		btnGMP.add(rdbtnVirement);
		rdbtnVirement.setBounds(490, 127, 151, 23);
		contentPane.add(rdbtnVirement);
		
		Long millis = System.currentTimeMillis();
	    Date date = new Date(millis);
	    int days = daysBetween(date, db);
		if(days <= 20)
		{
			rdbtnVirement.setEnabled(false);
		}
		else
		{
			rdbtnVirement.setEnabled(true);
		}
		
		// Label mode de livraison
		JLabel lblModeLivraison = new JLabel("Mode de livraison :");
		lblModeLivraison.setBounds(490, 182, 386, 20);
		contentPane.add(lblModeLivraison);
		
		// On place
		JRadioButton rdbtnOnPlace = new JRadioButton("Reprendre sur place le jour du spectacle");
		btnGML.add(rdbtnOnPlace);
		rdbtnOnPlace.setBounds(490, 209, 386, 23);
		contentPane.add(rdbtnOnPlace);
		
		// by Timbre prior
		JRadioButton rdbtnTimbre = new JRadioButton("Livrer par envoie timbres prior");
		btnGML.add(rdbtnTimbre);
		rdbtnTimbre.setBounds(490, 235, 386, 23);
		contentPane.add(rdbtnTimbre);
		
		// by secure send
		JRadioButton rdbtnSecure = new JRadioButton("livrer par envoie s\u00E9curis\u00E9 + 10 \u20AC");
		btnGML.add(rdbtnSecure);
		rdbtnSecure.setBounds(490, 259, 386, 23);
		contentPane.add(rdbtnSecure);
		
		// Button valid order
		JButton btnValid = new JButton("Valider commande et payer");
		btnValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Commande com = new Commande(cli.getId_personne(), mp, ml, prix);
				boolean x = com.create();
				if(x == true)
				{
					boolean y = false;					
					com = com.find();				
					for(Place pl : listOrder)
					{
						pl.setId_representation(rep.getId_representation());
						y = pl.create();
						Place newp = new Place();
						newp = pl.find();
						listOrder.remove(pl);
						listOrder.add(newp);
						
						if(y == false)
							break;
					}
					
					if(y == true)
					{
						boolean z = false;
						for(Place pla : listOrder)
						{
							LigneCommande lc = new LigneCommande(com.getId_cmd(), pla.getId_place());
							z = lc.create();
						}
						
						if(z == true)
						{
							boolean w = false;
							for(Categorie c : listCat)
							{
								w = c.update();
								if(w == false)
									break;
							}
							
							if(w == true)
							{
								JOptionPane.showMessageDialog(null, "Commande payer et valider !");
								ClientFrame cf = new ClientFrame(cli);
								cf.setVisible(true);
								dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Erreur lors de l'update des catégories !");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement de la/des ligne(s) commande !");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement de la/des place(s) !");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement de la commande !");
				}
			}
		});
		btnValid.setEnabled(false);
		btnValid.setBounds(640, 600, 236, 23);
		contentPane.add(btnValid);
		
		// Button verify order
		JButton btnVerifOrder = new JButton("V\u00E9rifier commande");
		btnVerifOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(listOrder.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Veuillez choisir au minimum une place !");
				}
				else
				{
					if(listOrder.size() <= spec.getNbrPlaceParClient())
					{
						if(rdbtnVisa.isSelected() || rdbtnPayPal.isSelected() || rdbtnVirement.isSelected())
						{
							if(rdbtnVisa.isSelected())
								mp = "Visa";
							else if(rdbtnPayPal.isSelected())
								mp = "PayPal";
							else if(rdbtnVirement.isSelected())
								mp = "Virement SEPA";
							
							if(rdbtnOnPlace.isSelected() || rdbtnTimbre.isSelected() || rdbtnSecure.isSelected())
							{		
								if(rdbtnOnPlace.isSelected())
									ml = "Retrais sur place le jour même";
								else if(rdbtnTimbre.isSelected())
									ml = "envoi avec timbres prior";
								else if(rdbtnSecure.isSelected())
									ml = "envoi sécurisé";
								
								if(rdbtnSecure.isSelected())
								{
									prix += 10;
								}
								prix += 5;
								for(Place place : listOrder)
								{
									Double i = place.getPrix();
									prix += i;
								}
								lblPrix.setText(prix + " €");
								btnValid.setEnabled(true);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Veuillez choisir un mode de livraison !");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Veuillez choisir un mode de paiement !");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Vous avez commandé trop de place \n vous pouvez commander maximum : " + spec.getNbrPlaceParClient() + " places !");
					}
				}
			}
		});
		btnVerifOrder.setBounds(326, 600, 236, 23);
		contentPane.add(btnVerifOrder);
		
		// Button reset
		JButton btnReset = new JButton("R\u00E9initialiser la commande");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGML.clearSelection();
				btnGMP.clearSelection();
				listOrder.removeAll(listOrder);
				lblPrix.setText("0 €");
				btnValid.setEnabled(false);
				DefaultTableModel model = (DefaultTableModel) tabListOrder.getModel();
			    for( int i = model.getRowCount() - 1; i >= 0; i-- ) {
			        model.removeRow(i);
			    }
			    
			    Categorie cat = new Categorie();
				listCat = cat.findAll(conf.getId_configuration());
				
			    if(conf.getType_configuration().equals("Debout"))
				{
					for(Categorie v : listCat)
					{
						if(v.getType_categorie().equals("Debout")) 
						{
							lblInfoStandUp.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceDebout.setEnabled(true);
						}				
						else if(v.getType_categorie().equals("Diamant"))
						{
							lblInfoDiams.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceDiams.setEnabled(true);
						}
						else if(v.getType_categorie().equals("Or"))
						{
							lblInfoGold.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceGold.setEnabled(true);
						}
						else if(v.getType_categorie().equals("Argent"))
						{
							lblInfoSilver.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceSilver.setEnabled(true);
						}
						else if(v.getType_categorie().equals("Bronze"))
						{
							lblInfoBronze.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceBronze.setEnabled(true);
						}			
					}
				}
				else if(conf.getType_configuration().equals("Concert"))
				{
					for(Categorie v : listCat)
					{
						if(v.getType_categorie().equals("Debout")) 
						{
							lblInfoStandUp.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceDebout.setEnabled(true);
						}				
						else if(v.getType_categorie().equals("Diamant"))
						{
							lblInfoDiams.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceDiams.setEnabled(true);
						}
						else if(v.getType_categorie().equals("Or"))
						{
							lblInfoGold.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceGold.setEnabled(true);
						}
						else if(v.getType_categorie().equals("Argent"))
						{
							lblInfoSilver.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceSilver.setEnabled(true);
						}
						else if(v.getType_categorie().equals("Bronze"))
						{
							lblInfoBronze.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceBronze.setEnabled(true);
						}
					}
				}
				else if(conf.getType_configuration().equals("Cirque"))
				{
					for(Categorie v : listCat)
					{
						if(v.getType_categorie().equals("Debout")) 
						{
							lblInfoStandUp.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceDebout.setEnabled(true);
						}				
						else if(v.getType_categorie().equals("Diamant"))
						{
							lblInfoDiams.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceDiams.setEnabled(true);
						}
						else if(v.getType_categorie().equals("Or"))
						{
							lblInfoGold.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceGold.setEnabled(true);
						}
						else if(v.getType_categorie().equals("Argent"))
						{
							lblInfoSilver.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceSilver.setEnabled(true);
						}
						else if(v.getType_categorie().equals("Bronze"))
						{
							lblInfoBronze.setText("Place Disponible : " + v.getNbrPlaceDispo() + " places   Prix : " + v.getPrix() + " €");
							btnAddPlaceBronze.setEnabled(true);
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Erreur avec le type de configuration !");
				}
			}
		});
		btnReset.setBounds(10, 600, 244, 23);
		contentPane.add(btnReset);
		
		// Label frais de dossier
		JLabel lblFraisDossier = new JLabel("* : il y a + 5 \u20AC de frais de dossier");
		lblFraisDossier.setBounds(18, 569, 228, 20);
		contentPane.add(lblFraisDossier);
	}

	public int daysBetween(Date d1, Date d2)
	{
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
}