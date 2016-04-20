package it.ing.unibs.fondamenti.es12416.garfica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import it.ing.unibs.fondamenti.es12416.Tamagotchi;
import it.ing.unibs.fondamenti.tools.myMath;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TamaVita 
{
	private static final int RANGE_MIN = 1;
	private static final int RANGE_MAX = 10;
	private JFrame tamaVita;
	private JPanel contentPane;

	/**
	 * Costruttore a cui viene passato un Tamagochi
	 * @param tam Oggetto tamagochi che è stato creato in precedenza da un altro frame
	 */
	public TamaVita(Tamagotchi tam) 
	{
		initialize(tam);	
	}
	/**
	 * Funzione di controllo in grado di modificare i valori del frame e di alcuni oggeti presenti al suo interno,iene invocata per controllare e modificare il frame stesso
	 * @param tam Oggetto Tamagochi
	 * @param immagine Zona in cui viene caricata l'immagine
	 * @param stato label in cui viene definito lo stato del tamagochi
	 * @return
	 */
	private static boolean control(Tamagotchi tam,JLabel immagine,JLabel stato) 
	{     
		boolean ret=true;
		
		if (tam.isMorto())
		{
			//immagine.setText("IL TAMAGOCHI "+tam.getNome()+"è MORTO");
			immagine.setIcon(new ImageIcon(TamaVita.class.getResource("/Media/tamDead.png")));
			stato.setText("MORTO");
			ret=false;
		}
		else if(tam.isInfelice())
		{
			//immagine.setText("IL TAMAGOCHI "+tam.getNome()+"è Triste");
			immagine.setIcon(new ImageIcon(TamaVita.class.getResource("/Media/tamSad.png")));
			stato.setText("TRISTE");
		}
		else
		{
			//immagine.setText("IL TAMAGOCHI "+tam.getNome()+"STA BENE");
			immagine.setIcon(new ImageIcon(TamaVita.class.getResource("/Media/TamHappy.png")));
			stato.setText("FELICE");
			//immagine.
		}
		immagine.updateUI();
		return ret;
	}
	/**
	 * Funzione che inizializza tutti i valori dei vari componenti del frame e gestisce i vari event del frame
	 * @param tam passa un oggetto tamagochi per gestire la modifica dei valori del tamagochi creto in precedenza
	 */
	private void initialize(Tamagotchi tam)
	{
		tamaVita=new JFrame();
		contentPane = new JPanel();
		JLabel lblNewLabel = new JLabel("Stai Giocando con "+tam.getNome());
		JButton btnEsci = new JButton("Esci");
		JButton btnCarezza = new JButton("Accarezza");
		JButton btnBiscotto = new JButton("Dai un Biscotto");
		JLabel lblImmagine = new JLabel("");
		JLabel lblStato = new JLabel("");
		TamaVita.control(tam,lblImmagine,lblStato);
		//lblImmagine.setIcon(new ImageIcon(TamaVita.class.getResource("/Media/TamHappy.jpg")));
		//set degli attributi degli oggetti
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblImmagine.setHorizontalAlignment(SwingConstants.CENTER);
		lblStato.setHorizontalAlignment(SwingConstants.CENTER);
		tamaVita.setTitle("Tamagochi");
		tamaVita.setResizable(false);
		tamaVita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tamaVita.setBounds(100, 100, 452, 400);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		tamaVita.setContentPane(contentPane);
			
		btnCarezza.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				tam.daiCarezza(myMath.randInt(RANGE_MIN,RANGE_MAX));
				//se il tamagochi muore spengo i bottoni
				if(!TamaVita.control(tam,lblImmagine,lblStato))
				{
					btnCarezza.setEnabled(false);
					btnBiscotto.setEnabled(false);
				}
			}
		});
		
		btnBiscotto.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tam.daiBiscotti(myMath.randInt(RANGE_MIN,RANGE_MAX));
				//se il tamagochi muore spengo i bottoni
				if(!TamaVita.control(tam,lblImmagine,lblStato))
				{
					btnCarezza.setEnabled(false);
					btnBiscotto.setEnabled(false);
				}
			}
		});
		
		btnEsci.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tamaVita.setVisible(false);
			}
		});
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(20)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblStato, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblImmagine, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEsci, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
						.addComponent(btnBiscotto, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
						.addComponent(btnCarezza, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCarezza, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
							.addGap(26)
							.addComponent(btnBiscotto, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
							.addGap(91)
							.addComponent(btnEsci, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblStato, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblImmagine, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * Getter del frame
	 * @return tamaVita: frame di questa classe
	 */
	public JFrame getMe()
	{
		return tamaVita;
	}
}
