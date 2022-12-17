package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import jeu.IJeu;
import jeu.Joueur;
import jeuxPions.Jeu2JoueursAPion;
import jeuxPions.Othello;
import jeuxPions.Puissance4;
import swing.OthelloFrame.Boutons;
import utileJeux.Coord;
import utileJeux.Couleurs;
import java.awt.Button;

public class P4Frame {

	JFrame P4Frame;
	private Jeu2JoueursAPion jeu;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P4Frame window = new P4Frame();
					window.P4Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public P4Frame(Joueur j1, Joueur j2) {
		IJeu jeu = new Puissance4(j1, j2);
		this.jeu = (Jeu2JoueursAPion) jeu;
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
    		jCaseJaune.setBackground(Color.decode("#FFFF00"));
    		jCaseJaune.setOpaque(true);
        	return jCaseJaune;
    	}
    	
    	public static Component getBoutonRouge() {
    		JButton jCaseRouge = new JButton();
    		jCaseRouge.setBackground(Color.decode("#006400"));
    		jCaseRouge.setOpaque(true);
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
		JPanel choixColonne = new JPanel();
		choixColonne.setBounds(10, 10, 580, 50);
		choixColonne.setLayout(new GridLayout (1, 7, 10, 10));
		for (int i = 1; i <= this.jeu.getPlateau().getNbColonnes(); i++) {
			JButton jCaseChoix = new JButton("v");
			jCaseChoix.setFont(new Font("AppleGothic 13", Font.PLAIN, 25));
			jCaseChoix.setBackground(Color.decode("#FFFFFF"));
			jCaseChoix.setOpaque(true);
    		choixColonne.add(jCaseChoix);
    		
    		jCaseChoix.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                	
                	for (int i = 1; i <= jeu.getPlateau().getNbColonnes(); i++) {
                    	if (getLocationXButton(jCaseChoix) == i) {
                    		for (int j = 6; j >= jeu.getPlateau().getNbLignes(); j--) {
                    			
                    			plateauP4.add(Boutons.getBoutonRouge());
                    			
                        	}
                        }
            		}
                }
            });
		}
		P4Frame.getContentPane().add(choixColonne, BorderLayout.CENTER);
		
		/**
    	 * Zone de texte : Dialogue affichant les instructions.
    	 */
		JLabel lblDialogue = DefaultComponentFactory.getInstance().createLabel("Tour du joueur 1");
		lblDialogue.setBackground(new Color(255, 250, 250));
		lblDialogue.setOpaque(true);
		lblDialogue.setHorizontalAlignment(SwingConstants.CENTER);
		lblDialogue.setBounds(10, 582, 580, 50);
		P4Frame.getContentPane().add(lblDialogue);

		/**
		 * Menu
		 */
		JMenuBar menuBar = new JMenuBar();
		P4Frame.setJMenuBar(menuBar);
		
		JMenuItem menuItemNewgame = new JMenuItem("Nouvelle Partie");
		menuBar.add(menuItemNewgame);
		
		JMenuItem menuItemReturn = new JMenuItem("Retour");
		menuItemReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JeuGUI mainFrame = new JeuGUI();
                mainFrame.setVisible(true);
                P4Frame.dispose();   
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
