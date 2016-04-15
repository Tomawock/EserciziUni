package it.ing.unibs.fondamenti.es12416.garfica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import it.ing.unibs.fondamenti.es12416.Tamagochi;
import it.ing.unibs.fondamenti.tools.myMath;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
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
	 * Create the frame.
	 */
	public TamaVita(Tamagochi tam) 
	{
		initialize(tam);
	}
	
	private static boolean control(Tamagochi tam,JLabel immagine,JLabel stato) 
	{     
		boolean ret=true;
		
		if (tam.isMorto())
		{
			//immagine.setText("IL TAMAGOCHI "+tam.getNome()+"è MORTO");
			immagine.setIcon(new ImageIcon(TamaVita.class.getResource("/Media/tamDead.jpg")));
			stato.setText("MORTO");
			ret=false;
		}
		else if(tam.isInfelice())
		{
			//immagine.setText("IL TAMAGOCHI "+tam.getNome()+"è Triste");
			immagine.setIcon(new ImageIcon(TamaVita.class.getResource("/Media/tamSad.jpg")));
			stato.setText("INFELICE");
		}
		else
		{
			//immagine.setText("IL TAMAGOCHI "+tam.getNome()+"STA BENE");
			immagine.setIcon(new ImageIcon(TamaVita.class.getResource("/Media/TamHappy.jpg")));
			stato.setText("FELICE");
			//immagine.
		}
		immagine.updateUI();
		return ret;
	}

	private void initialize(Tamagochi tam)
	{
		tamaVita=new JFrame();
		contentPane = new JPanel();
		JLabel lblNewLabel = new JLabel("Stai Giocando con "+tam.getNome());
		JButton btnEsci = new JButton("Esci");
		JButton btnCarezza = new JButton("Accarezza");
		JButton btnBiscotto = new JButton("Dai un Biscotto");
		JLabel lblImmagine = new JLabel("");
		JLabel lblStato = new JLabel("");
		lblImmagine.setIcon(new ImageIcon(TamaVita.class.getResource("/Media/TamHappy.jpg")));
		
		
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblImmagine.setHorizontalAlignment(SwingConstants.CENTER);
		lblStato.setHorizontalAlignment(SwingConstants.CENTER);
		tamaVita.setTitle("Tamagochi");
		tamaVita.setResizable(false);
		tamaVita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tamaVita.setBounds(100, 100, 428, 400);
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
				}
			}
		});
		
		btnBiscotto.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tam.daiBiscotti(myMath.randInt(RANGE_MIN,RANGE_MAX));
				
				if(!TamaVita.control(tam,lblImmagine,lblStato))
				{
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
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblImmagine, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblStato, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGap(20)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEsci, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(btnBiscotto, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(btnCarezza, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCarezza, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
							.addGap(26)
							.addComponent(btnBiscotto, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
							.addGap(91)
							.addComponent(btnEsci, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblStato, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblImmagine)))
					.addContainerGap())
		);
		
		contentPane.setLayout(gl_contentPane);
	}
	
	public JFrame getMe()
	{
		return tamaVita;
	}
}
