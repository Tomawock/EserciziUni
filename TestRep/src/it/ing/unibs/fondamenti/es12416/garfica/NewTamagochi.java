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

	private JFrame frmNewTamagoci;
	private TamaVita tamaVita;
	private JTextField txtNomeTamagochi;
	private Tamagochi tam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{

		NewTamagochi window = new NewTamagochi();
		window.frmNewTamagoci.setVisible(true);

	}

	/**
	 * Create the application.
	 */
	public NewTamagochi() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		tam=new Tamagochi();
		
		
		frmNewTamagoci = new JFrame();
		frmNewTamagoci.setResizable(false);
		frmNewTamagoci.setTitle("New Tamagoci");
		frmNewTamagoci.setBounds(100, 100, 340, 170);
		frmNewTamagoci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewTamagoci.getContentPane().setLayout(null);
		
		txtNomeTamagochi = new JTextField();
		txtNomeTamagochi.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomeTamagochi.setEnabled(true);
		txtNomeTamagochi.setEditable(true);
		txtNomeTamagochi.setText("");
		txtNomeTamagochi.setBounds(130, 11, 170, 20);
		frmNewTamagoci.getContentPane().add(txtNomeTamagochi);
		txtNomeTamagochi.setColumns(10);
		
		JLabel lblNomeTamagochi = new JLabel("Nome Tamagochi");
		lblNomeTamagochi.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeTamagochi.setLabelFor(txtNomeTamagochi);
		lblNomeTamagochi.setBounds(10, 11, 110, 20);
		frmNewTamagoci.getContentPane().add(lblNomeTamagochi);
		
		JLabel lblSazieta = new JLabel("Grado Saziet\u00E0");
		lblSazieta.setHorizontalAlignment(SwingConstants.LEFT);
		lblSazieta.setBounds(10, 42, 120, 20);
		frmNewTamagoci.getContentPane().add(lblSazieta);
		
		JComboBox cbSazieta = new JComboBox();
		cbSazieta.setMaximumRowCount(10);
		cbSazieta.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
		cbSazieta.setBounds(130, 42, 70, 20);
		frmNewTamagoci.getContentPane().add(cbSazieta);
		
		JComboBox cbSoddisfazione = new JComboBox();
		cbSoddisfazione.setMaximumRowCount(10);
		cbSoddisfazione.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
		cbSoddisfazione.setBounds(130, 73, 70, 20);
		frmNewTamagoci.getContentPane().add(cbSoddisfazione);
		
		JLabel lblSoddisfazione = new JLabel("Grado Soddisfazione");
		lblSoddisfazione.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoddisfazione.setBounds(10, 73, 110, 20);
		frmNewTamagoci.getContentPane().add(lblSoddisfazione);
		
		JButton btnOk = new JButton("OK");
		/**
		 * Crea evento di conferma per immissione dei dati
		 */
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
				tamaVita = new TamaVita(tam);
				tamaVita.getMe().setVisible(true);
			}
		});
		btnOk.setBounds(10, 104, 70, 25);
		frmNewTamagoci.getContentPane().add(btnOk);
	}
}
