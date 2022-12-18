package swing;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;

import jeu.IJeu;
import jeu.Joueur;
import jeuxPions.*;
import pions.Pion;
import utileJeux.*;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class P4Frame {

	JFrame P4Frame;
	private Jeu2JoueursAPion jeu;

	/**
	 * Create the application.
	 */
	public P4Frame(Joueur j1, Joueur j2) {
		IJeu jeu = new Puissance4(j1, j2);
		this.jeu = (Jeu2JoueursAPion) jeu;
		//jeu.jouer();
		initialize();
	}
	
	/**
	 * Classe pour arrondir les boutons
	 */
	private static class RoundedBorder implements Border {

	    private int radius;


	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }


	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }


	    public boolean isBorderOpaque() {
	        return true;
	    }


	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	        g.fillOval(0, 0, width-1, height-1);
	    }
	}

	/**
	 * Boutons
	 */
	public static class Boutons {
    	public static Component getBoutonJaune() {
    		JButton jCaseJaune = new JButton();
    		jCaseJaune.setForeground(Color.decode("#FFFF00"));
    		jCaseJaune.setBorder(new RoundedBorder(100));
    		jCaseJaune.setBackground(Color.decode("#FFFF00"));
    		jCaseJaune.setOpaque(false);
        	return jCaseJaune;
    	}
    	
    	public static Component getBoutonRouge() {
    		JButton jCaseRouge = new JButton();
    		jCaseRouge.setForeground(Color.decode("#006400"));
    		jCaseRouge.setBorder(new RoundedBorder(100));
    		jCaseRouge.setBackground(Color.decode("#006400"));
    		jCaseRouge.setOpaque(false);
        	return jCaseRouge;
    	}
    	
    	public static Component getBoutonCase() {
    		JButton jCase = new JButton();
    		jCase.setForeground(Color.WHITE);
    		jCase.setBorder(new RoundedBorder(100));
            jCase.setBackground(Color.decode("#FFFFFF"));
            jCase.setOpaque(false);
        	return jCase;
    	}
    	
    }
	
	/**
	 * Obtenir la position d'un bouton
	 * @return 
	 */
	public float getLocationXButton(JButton jCaseChoix) {
		float xPos = jCaseChoix.getAlignmentX();
		return xPos;
	}
	
	public float getLocationYButton(JButton button) {
		float yPos = button.getAlignmentY();
		return yPos;
	}
	
	/**
	 * Generer le plateau
	 */
	public void afficherPlateau(JPanel plateauP4) {
		plateauP4.setLayout(new GridLayout (6, 7, 10, 10));
		for (int i = 1; i <= this.jeu.getPlateau().getNbColonnes(); i++) {
            for (int j = 1; j <= this.jeu.getPlateau().getNbLignes(); j++) {
            	
            	if (this.jeu.getPlateau().getCase(new Coord(i, j)) != null) {
            	
	            	if (this.jeu.getPlateau().getCase(new Coord(i, j)).getCouleur() == Couleurs.JAUNE) {
	                	plateauP4.add(Boutons.getBoutonJaune());
	            	}
	            	else if (this.jeu.getPlateau().getCase(new Coord(i, j)).getCouleur() == Couleurs.ROUGE)  {
	            		plateauP4.add(Boutons.getBoutonRouge());
	            	}

            	}
            	plateauP4.add(Boutons.getBoutonCase());
            }
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		P4Frame = new JFrame();
		P4Frame.setTitle("Puissance 4");
		P4Frame.getContentPane().setBackground(Color.decode("#0000CD"));
		P4Frame.setBounds(0, 0, 600, 700);
		P4Frame.setLocationRelativeTo(null);
		P4Frame.getContentPane().setLayout(null);
		P4Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * Plateau de jeu
		 */
		JPanel plateauP4 = new JPanel();
		plateauP4.setBounds(10, 70, 580, 500);
		plateauP4.setBackground(Color.decode("#0000CD"));
		plateauP4.setOpaque(true);
		this.afficherPlateau(plateauP4);
		P4Frame.getContentPane().add(plateauP4, BorderLayout.CENTER);
		
		/**
		 * Boutons pour choisir la colonne
		 */
		JPanel panelChoix = new JPanel();
		panelChoix.setBackground(new Color(33, 33, 33));
		panelChoix.setOpaque(true);
		panelChoix.setBounds(10, 582, 580, 58);
		P4Frame.getContentPane().add(panelChoix);
		panelChoix.setLayout(null);
		
		JLabel lblSaisie = DefaultComponentFactory.getInstance().createLabel("Choix de colonne (1 - 7) :");
		lblSaisie.setForeground(new Color(255, 245, 238));
		lblSaisie.setBounds(116, 18, 249, 25);
		lblSaisie.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaisie.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panelChoix.add(lblSaisie);
		
		TextField textField = new TextField();
		textField.setBounds(377 , 18, 51, 25);
		textField.setBackground(new Color(255, 255, 255));
		panelChoix.add(textField);
		
		/**
    	 * Zone de texte : Dialogue affichant les instructions.
    	 */
		JLabel lblDialogue = DefaultComponentFactory.getInstance().createLabel("Tour du joueur ROUGE");
		lblDialogue.setForeground(new Color(255, 235, 205));
		lblDialogue.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblDialogue.setBackground(new Color(33, 33, 33));
		lblDialogue.setOpaque(true);
		lblDialogue.setHorizontalAlignment(SwingConstants.CENTER);
		lblDialogue.setBounds(10, 8, 580, 50);
		P4Frame.getContentPane().add(lblDialogue);
		

		/**
		 * Menu
		 */
		JMenuBar menuBar = new JMenuBar();
		P4Frame.setJMenuBar(menuBar);
		
		/**
		 * Recommencer
		 */
		JMenuItem menuItemNewgame = new JMenuItem("Nouvelle Partie");
		menuItemNewgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Joueur j1 = new Joueur(Couleurs.JAUNE);
				Joueur j2 = new Joueur(Couleurs.ROUGE);
				P4Frame pFrame = new P4Frame(j1, j2);
				pFrame.P4Frame.setVisible(true);
				P4Frame.dispose();
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
                P4Frame.dispose();   
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
}
