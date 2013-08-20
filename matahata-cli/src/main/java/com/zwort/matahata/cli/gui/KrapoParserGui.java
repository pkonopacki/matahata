package com.zwort.matahata.cli.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class KrapoParserGui extends JFrame {
	
	private static final long serialVersionUID = 4406010948100417159L;

	public KrapoParserGui() {
		setTitle("KrapoParserGui");
		setSize(200, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				KrapoParserGui kpg = new KrapoParserGui();
				kpg.setVisible(true);
			}
		});
	}

}
