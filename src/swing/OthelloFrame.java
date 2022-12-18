package swing;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import jeu.IJeu;
import jeu.Joueur;
import jeuxPions.*;
import utileJeux.*;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.io.IOException;
import java.io.OutputStream;

public class OthelloFrame extends OutputStream{
	
	JFrame OthelloFrame;
	static JPanel plateauOthello = new JPanel();
	
	
	private Jeu2JoueursAPion jeu;
	
	/**
	 * Create the application.
	 */
	public OthelloFrame(Joueur j1, Joueur j2) {
		IJeu jeu = new Othello(j1, j2);
		this.jeu = (Jeu2JoueursAPion) jeu;
		//jeu.jouer();
		initialize();
	}
	
	/**
	 * Boutons
	 */
	public static class Boutons {
    	public static Component getBoutonBlanc() {
    		JButton jCaseBlanc = new JButton();
        	jCaseBlanc.setBackground(Color.decode("#FFFFFF"));
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
            jCase.setBackground(Color.decode("#006400"));
            jCase.setOpaque(true);
        	return jCase;
    	}
    	
    	public static Component getBoutonCaseChoix() {
    		JButton jCaseChoix = new JButton();
        	jCaseChoix.setBackground(Color.decode("#DF5746"));
        	jCaseChoix.setOpaque(true);
        	/*jCaseChoix.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                	plateauOthello.remove(jCaseChoix);
                	plateauOthello.add(Boutons.getBoutonNoir());
                }
            });*/
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
                     	plateauOthello.add(Boutons.getBoutonCaseChoix());
                    }
                } else {
                 	plateauOthello.add(Boutons.getBoutonCase());
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
		OthelloFrame.setBounds(100, 100, 650, 700);
		OthelloFrame.setLocationRelativeTo(null);
		OthelloFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.afficherPlateau(plateauOthello);
        OthelloFrame.getContentPane().add(plateauOthello);
		OthelloFrame.getContentPane().add(plateauOthello, BorderLayout.CENTER);
        
        /**
    	 * Zone de texte : Dialogue affichant les instructions.
    	 */
        JLabel labelDialogue = DefaultComponentFactory.getInstance().createLabel("Tour du joueur (NOIR)");
        labelDialogue.setBounds(0, 0, 650, 00);
        labelDialogue.setOpaque(true);
        /*int delay = 2000; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //...Perform a task...
            	labelDialogue.setText("Veuillez choisir un coup possible parmis les propositions");
            	labelDialogue.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
            }
        };
        new Timer(delay, taskPerformer).start(); */

        labelDialogue.setHorizontalAlignment(SwingConstants.CENTER);
        labelDialogue.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        OthelloFrame.getContentPane().add(labelDialogue, BorderLayout.NORTH);
		
		/**
		 * Menu
		 */
		JMenuBar menuBar = new JMenuBar();
		OthelloFrame.setJMenuBar(menuBar);
		
		/**
		 * Recommencer
		 */
		JMenuItem menuItemNewgame = new JMenuItem("Nouvelle Partie");
		menuItemNewgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		menuBar.add(menuItemNewgame);
		
		/**
		 * Retour au menu
		 */
		JMenuItem menuItemReturn = new JMenuItem("Retour");
		menuItemReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                JeuGUI mainFrame = new JeuGUI();
                mainFrame.setVisible(true);
                OthelloFrame.dispose();
            }
        });
		menuBar.add(menuItemReturn);
		
		/**
		 * Quitter
		 */
		JMenuItem menuItemQuit = new JMenuItem("Quitter");
		menuItemQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
		menuBar.add(menuItemQuit);
	}

	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
