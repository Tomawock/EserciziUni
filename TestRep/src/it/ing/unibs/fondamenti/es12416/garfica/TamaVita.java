package it.ing.unibs.fondamenti.es12416.garfica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.ing.unibs.fondamenti.es12416.Tamagochi;
import it.ing.unibs.fondamenti.tools.myMath;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DropMode;
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
		tamaVita=new JFrame();
		tamaVita.setTitle("Tamagochi");
		tamaVita.setResizable(false);
		tamaVita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tamaVita.setBounds(100, 100, 390, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		tamaVita.setContentPane(contentPane);
		
		JButton btnCarezza = new JButton("Accarezza");
		
		btnCarezza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				tam.daiCarezza(myMath.randInt(RANGE_MIN,RANGE_MAX));
			}
		});
		
		JEditorPane immagine = new JEditorPane();
		immagine.setEditable(false);
		immagine.setDropMode(DropMode.INSERT);
		immagine.setText(tam.status());
		
		JButton btnBiscotto = new JButton("Dai un Biscotto");
		btnBiscotto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tam.daiBiscotti(myMath.randInt(RANGE_MIN,RANGE_MAX));
			}
		});
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tamaVita.setVisible(false);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Stai Giocando con "+tam.getNome());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(immagine, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEsci, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
						.addComponent(btnBiscotto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCarezza, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCarezza, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addGap(26)
							.addComponent(btnBiscotto, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addGap(91)
							.addComponent(btnEsci, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
						.addComponent(immagine, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public JFrame getMe()
	{
		return tamaVita;
	}
}
