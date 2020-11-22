package be.malo.JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import be.malo.POJO.Personne;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfFirstName;
	private JTextField tfPhoneNumber;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JTextField tfPassword;
	private JTextField tfCity;
	private JTextField tfPostalCode;

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
	
	public RegisterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Main label
		JLabel Register = new JLabel("Inscription :");
		Register.setBounds(279, 11, 119, 36);
		contentPane.add(Register);
		
		// Obligation label
		JLabel lblObligation = new JLabel("* : obligatoire");
		lblObligation.setBounds(499, 17, 148, 25);
		contentPane.add(lblObligation);
		
		// Name label
		JLabel lblName = new JLabel("Nom : *");
		lblName.setBounds(28, 54, 59, 22);
		contentPane.add(lblName);
		
		// Name text field
		tfName = new JTextField();
		tfName.setBounds(82, 55, 210, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		// Firstname label
		JLabel lblFistName = new JLabel("Pr\u00E9nom : *");
		lblFistName.setBounds(329, 54, 69, 22);
		contentPane.add(lblFistName);
		
		// Firstname text field
		tfFirstName = new JTextField();
		tfFirstName.setBounds(400, 54, 210, 20);
		contentPane.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		// Phone number label
		JLabel lblPhoneNumber = new JLabel("T\u00E9l\u00E9phone : *");
		lblPhoneNumber.setBounds(28, 107, 104, 22);
		contentPane.add(lblPhoneNumber);
		
		// Phone number text field
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setBounds(111, 108, 181, 20);
		contentPane.add(tfPhoneNumber);
		tfPhoneNumber.setColumns(10);
		
		// Address label
		JLabel lblAddress = new JLabel("Adresse : *");
		lblAddress.setBounds(28, 163, 59, 14);
		contentPane.add(lblAddress);
		
		// Address text field
		tfAddress = new JTextField();
		tfAddress.setBounds(111, 160, 499, 20);
		contentPane.add(tfAddress);
		tfAddress.setColumns(10);
		
		// Email label
		JLabel lblEmail = new JLabel("Email : *");
		lblEmail.setBounds(28, 257, 59, 22);
		contentPane.add(lblEmail);
		
		// Email text field
		tfEmail = new JTextField();
		tfEmail.setBounds(82, 258, 210, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		// Password label
		JLabel lblPassword = new JLabel("Mot de passe : *");
		lblPassword.setBounds(302, 259, 104, 18);
		contentPane.add(lblPassword);
		
		// Password text field
		tfPassword = new JTextField();
		tfPassword.setBounds(400, 258, 210, 20);
		contentPane.add(tfPassword);
		tfPassword.setColumns(10);
		
		// Type of poeple label
		JLabel lblTypePoeple = new JLabel("Type : *");
		lblTypePoeple.setBounds(329, 111, 46, 14);
		contentPane.add(lblTypePoeple);
		
		// List of combobox
		Object[] TypePoeple = new Object[] {"Client", "Organisateur", "Artistes"};
		
		// Combobox type of poeple
		JComboBox cbTypePoeple = new JComboBox(TypePoeple);
		cbTypePoeple.setBounds(400, 107, 210, 22);
		contentPane.add(cbTypePoeple);
		
		// City label
		JLabel lblCity = new JLabel("Ville : *");
		lblCity.setBounds(28, 210, 46, 22);
		contentPane.add(lblCity);
		
		// City text field
		tfCity = new JTextField();
		tfCity.setBounds(82, 211, 210, 20);
		contentPane.add(tfCity);
		tfCity.setColumns(10);
		
		// Postal code label
		JLabel lblPostalCode = new JLabel("Code postal : *");
		lblPostalCode.setBounds(302, 214, 96, 18);
		contentPane.add(lblPostalCode);
		
		// Postal code text field
		tfPostalCode = new JTextField();
		tfPostalCode.setBounds(400, 211, 210, 20);
		contentPane.add(tfPostalCode);
		tfPostalCode.setColumns(10);
		
		// Register button
		JButton btnRegister = new JButton("S'inscrire");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean x = verif();
				if(x == true)
				{
					// Stockage data
					String name = tfName.getText();
					String firstName = tfFirstName.getText();
					String phoneNumber = tfPhoneNumber.getText();
					String address = tfAddress.getText();
					String email = tfEmail.getText();
					String password = tfPassword.getText();
					String typePoeple = cbTypePoeple.getSelectedItem().toString();
					String city = tfCity.getText();
					String postalCode = tfPostalCode.getText();
					
					// Creation object Personne
					Personne newPoeple = new Personne(name, firstName, phoneNumber, address, email, password, typePoeple, city, postalCode);					
					
					// Add to DB + verification
					boolean inscrit = newPoeple.create();
					if(inscrit == true)
					{
						JOptionPane.showMessageDialog(null, "Vous êtes inscrit !");
						LoginFrame l = new LoginFrame();
						l.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Erreur lors de l'inscription !");
					}						
				}
			}
		});
		btnRegister.setBounds(28, 312, 89, 23);
		contentPane.add(btnRegister);
		
		// Return main frame button
		JButton btnReturnMain = new JButton("Retour");
		btnReturnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame l = new LoginFrame();
				l.setVisible(true);
				dispose();
			}
		});
		btnReturnMain.setBounds(521, 312, 89, 23);
		contentPane.add(btnReturnMain);
		
		// Reset text field button
		JButton btnReset = new JButton("R\u00E9initialiser les donn\u00E9es");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFrame();
			}
		});
		btnReset.setBounds(229, 312, 177, 23);
		contentPane.add(btnReset);
	}
	
	// Methode to clear all frame
	private void clearFrame() {
		tfName.setText(null);
		tfFirstName.setText(null);
		tfPhoneNumber.setText(null);
		tfAddress.setText(null);
		tfEmail.setText(null);
		tfPassword.setText(null);
		tfCity.setText(null);
		tfPostalCode.setText(null);
	}
	
	// Methode to verify that all text fields have been completed 
	private boolean verif()
	{
		if(tfName.getText().equals("") || tfFirstName.getText().equals("") ||
			tfPhoneNumber.getText().equals("") || tfAddress.getText().equals("") ||
			tfEmail.getText().equals("") || tfPassword.getText().equals("") ||
			tfCity.getText().equals("") || tfPostalCode.getText().equals(""))
		{	
			JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs !");
			return false;
		}
		else
		{
			if(tfPhoneNumber.getText().matches("[0-9]+") && tfPostalCode.getText().length() <= 5 && tfPostalCode.getText().matches("[0-9]+"))
			{
				return true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Veuillez remplir avec les bonnes données le champs \"Téléphone\" ou \"Code Postal\" !");
				return false;
			}
		}
	}
}
