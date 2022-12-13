package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jeu.IJeu;
import jeu.Joueur;
import jeuxPions.Othello;
import utileJeux.Couleurs;

import java.awt.BorderLayout;

public class OthelloFrame {

	JFrame OthelloFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OthelloFrame window = new OthelloFrame();
					window.OthelloFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OthelloFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		OthelloFrame = new JFrame();
		OthelloFrame.setTitle("Othello");
		OthelloFrame.getContentPane().setBackground(new Color(255, 250, 250));
		
		JPanel plateauOthello = new JPanel();
		plateauOthello.setLayout(new GridLayout (8, 8));
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                
                if ((i == 4 && j == 4) || (i == 5 && j == 5)) {
        	        JButton jCaseNoir = new JButton();
        	        jCaseNoir.setBackground(Color.decode("#000000"));
        	        jCaseNoir.setOpaque(true);
        	        plateauOthello.add(jCaseNoir);
                } else if (i == 5 && j == 4) {
                	JButton jCaseBlanc = new JButton();
                	jCaseBlanc.setBackground(Color.decode("#ffffff"));
                	jCaseBlanc.setOpaque(true);
                	plateauOthello.add(jCaseBlanc);
                } else {
                	JButton jCase = new JButton();
                    jCase.setBackground(Color.decode("#006400"));
                    jCase.setOpaque(true);
                    plateauOthello.add(jCase);
                }
            }
        }
        
        OthelloFrame.add(plateauOthello);
        
		OthelloFrame.getContentPane().add(plateauOthello, BorderLayout.CENTER);
		OthelloFrame.setBounds(100, 100, 650, 700);
		OthelloFrame.setLocationRelativeTo(null);
		OthelloFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		OthelloFrame.setJMenuBar(menuBar);
		
		JMenuItem menuItemNewgame = new JMenuItem("Nouvelle Partie");
		menuBar.add(menuItemNewgame);
		
		JMenuItem menuItemReturn = new JMenuItem("Retour");
		menuItemReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JeuGUI mainFrame = new JeuGUI();
                mainFrame.setVisible(true);
                OthelloFrame.dispose();   
            }
        });
		menuBar.add(menuItemReturn);
		
		JMenuItem menuItemQuit = new JMenuItem("Quitter");
		menuItemQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
		menuBar.add(menuItemQuit);
	}

}
