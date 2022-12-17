package swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
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
import jeuxPions.*;
import utileJeux.*;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.SwingConstants;

public class OthelloFrame {
	
	private Jeu2JoueursAPion jeu;
	
	JFrame OthelloFrame;
	
	/**
	 * Create the application.
	 */
	public OthelloFrame(Joueur j1, Joueur j2) {
		IJeu jeu = new Othello(j1, j2);
		this.jeu = (Jeu2JoueursAPion) jeu;
		// jeu.jouer();
		initialize();
	}
	
	/**
	 * Boutons
	 */
	public static class Boutons {
    	public static Component getBoutonBlanc() {
    		JButton jCaseBlanc = new JButton();
        	jCaseBlanc.setBackground(Color.decode("#ffffff"));
        	jCaseBlanc.setOpaque(true);
        	return jCaseBlanc;
    	}
    	
    	public static Component getBoutonNoir() {
    		JButton jCaseNoir = new JButton();
	        jCaseNoir.setBackground(Color.decode("#000000"));
	        jCaseNoir.setOpaque(true);
        	return jCaseNoir;
    	}
    	
    	public static Component getBoutonCase() {
    		JButton jCase = new JButton();
            jCase.setBackground(Color.decode("#DF5746"));
            jCase.setOpaque(true);
        	return jCase;
    	}
    	
    	public static Component getBoutonCaseChoix() {
    		JButton jCaseChoix = new JButton();
        	jCaseChoix.setBackground(Color.decode("#006400"));
        	jCaseChoix.setOpaque(true);
        	return jCaseChoix;
    	}
    }

	/**
	 * Generer le plateau
	 */
	public void afficherPlateau(JPanel plateauOthello) {
		plateauOthello.setLayout(new GridLayout (8, 8, 10, 10));
        for (int i = 1; i <= this.jeu.getPlateau().getNbLignes(); i++) {
            for (int j = 1; j <= this.jeu.getPlateau().getNbColonnes(); j++) {
                
            	if (this.jeu.getPlateau().getCase(new Coord(i, j)) != null) {
            		
            		if (this.jeu.getPlateau().getCase(new Coord(i, j)).getCouleur() == Couleurs.NOIR) {
                    	plateauOthello.add(Boutons.getBoutonNoir());

                    } else if (this.jeu.getPlateau().getCase(new Coord(i, j)).getCouleur() == Couleurs.BLANC)  {
                    	plateauOthello.add(Boutons.getBoutonBlanc());
                    	
                    } else {
                     	JButton jCase = new JButton();
                     	plateauOthello.add(Boutons.getBoutonCase());
                    }
                } else {
                 	plateauOthello.add(Boutons.getBoutonCaseChoix());

                	/*jCaseChoix.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                        	plateauOthello.remove(jCaseChoix);
                        	
                        	plateauOthello.add(Boutons.getBoutonNoir());
                        }
                    });**/
                } 
            }
        }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		OthelloFrame = new JFrame();
		OthelloFrame.setTitle("Othello");
		OthelloFrame.getContentPane().setBackground(new Color(255, 250, 250));
		
		JPanel plateauOthello = new JPanel();
		this.afficherPlateau(plateauOthello);
        
        OthelloFrame.getContentPane().add(plateauOthello);
		OthelloFrame.getContentPane().add(plateauOthello, BorderLayout.CENTER);
		OthelloFrame.setBounds(100, 100, 650, 700);
		OthelloFrame.setLocationRelativeTo(null);
		OthelloFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /**
    	 * Zone de texte : Dialogue affichant les instructions.
    	 */
        JLabel labelDialogue = DefaultComponentFactory.getInstance().createLabel("Tour du joueur (NOIR)");
        labelDialogue.setBounds(0, 0, 650, 00);
        labelDialogue.setOpaque(true);
        int delay = 2000; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //...Perform a task...
            	labelDialogue.setText("Veuillez choisir un coup possible parmis les propositions");
            	labelDialogue.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
            }
        };
        new Timer(delay, taskPerformer).start();

        labelDialogue.setHorizontalAlignment(SwingConstants.CENTER);
        labelDialogue.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        OthelloFrame.getContentPane().add(labelDialogue, BorderLayout.NORTH);
		
		/**
		 * Menu
		 */
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
