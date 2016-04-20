package it.ing.unibs.fondamenti.es12416.garfica;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import it.ing.unibs.fondamenti.es12416.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NewTamagochi 
{
	private static final String[] VALUES= {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"};
	private JFrame frmNewTamagoci;
	private TamaVita tamaVita; //finestra relativa al ciclo di vita del tamagochi
	private JTextField txtNomeTamagochi;
	private Tamagotchi tam;

	/**
	 * Costruttore di default
	 */
	public NewTamagochi() 
	{
		initialize();
	}

	/**
	 * Inizializza i componenti del Frame, crea un nuova Finestra per la creazione di un tamagochi quando si schiaccia il tasto ok viene crato il ciclo di vita del tamagochi
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize()
	{
		tam=new Tamagotchi();
		//Crea un nuovo jfarme e gli setta i valori
		frmNewTamagoci = new JFrame();
		frmNewTamagoci.setResizable(false);
		frmNewTamagoci.setTitle("New Tamagoci");
		frmNewTamagoci.setBounds(100, 100, 405, 170);
		frmNewTamagoci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewTamagoci.getContentPane().setLayout(null);
		//Setta il il text in cui verrà salvato il nome del tamagochi
		txtNomeTamagochi = new JTextField();
		txtNomeTamagochi.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomeTamagochi.setEnabled(true);
		txtNomeTamagochi.setEditable(true);
		txtNomeTamagochi.setBounds(219, 11, 170, 20);
		frmNewTamagoci.getContentPane().add(txtNomeTamagochi);
		//Setta il label del nome del tamagochi
		JLabel lblNomeTamagochi = new JLabel("Nome Tamagochi");
		lblNomeTamagochi.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeTamagochi.setLabelFor(txtNomeTamagochi);
		lblNomeTamagochi.setBounds(10, 11, 199, 20);
		frmNewTamagoci.getContentPane().add(lblNomeTamagochi);
		//Setta il label della sazietà del tamagochi
		JLabel lblSazieta = new JLabel("Grado Saziet\u00E0");
		lblSazieta.setHorizontalAlignment(SwingConstants.CENTER);
		lblSazieta.setBounds(10, 42, 199, 20);
		frmNewTamagoci.getContentPane().add(lblSazieta);
		//Combo box dei dati della sazieta
		JComboBox cbSazieta = new JComboBox();
		cbSazieta.setMaximumRowCount(10);
		cbSazieta.setModel(new DefaultComboBoxModel(VALUES));
		cbSazieta.setBounds(219, 42, 70, 20);
		frmNewTamagoci.getContentPane().add(cbSazieta);
		//Combo box dei dati della soddisfazione
		JComboBox cbSoddisfazione = new JComboBox();
		cbSoddisfazione.setMaximumRowCount(10);
		cbSoddisfazione.setModel(new DefaultComboBoxModel(VALUES));
		cbSoddisfazione.setBounds(219, 73, 70, 20);
		frmNewTamagoci.getContentPane().add(cbSoddisfazione);
		//Setta il label della soddisfazione del tamagochi
		JLabel lblSoddisfazione = new JLabel("Grado Soddisfazione");
		lblSoddisfazione.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoddisfazione.setBounds(10, 73, 199, 20);
		frmNewTamagoci.getContentPane().add(lblSoddisfazione);
		//Bottone di conferma
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				tam.setNome(txtNomeTamagochi.getText());
				tam.setSazieta(Integer.parseInt(cbSazieta.getSelectedItem().toString()));
				//System.out.println(tam.getSazieta());
				tam.setSoddisfazione(Integer.parseInt(cbSoddisfazione.getSelectedItem().toString()));
				//chiudo la finestra
				frmNewTamagoci.setVisible(false);
				//Crea un nuovo oggetto tamagotchi
				tamaVita = new TamaVita(tam);
				//Apro quella del loop del tamagotchi
				tamaVita.getMe().setVisible(true);
			}
		});
		btnOk.setBounds(10, 104, 199, 25);
		frmNewTamagoci.getContentPane().add(btnOk);
		frmNewTamagoci.setVisible(true);
	}
}