package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import jeu.Joueur;
import utileJeux.Couleurs;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JeuGUI extends JFrame {

	JPanel contentPanel;
	

	/**
	 * @brief Lance l'application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JeuGUI frame = new JeuGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @brief creer la JFrame : fenetre principal
	 */
	public JeuGUI() {	
		setTitle("PawnGames");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setLocationRelativeTo(null);
		
		/**
		 * Menu
		 */
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 235, 217));
		menuBar.setOpaque(true);
		setJMenuBar(menuBar);
		
		JMenu menuJeu = new JMenu("Jeu");
		menuBar.add(menuJeu);
		
		JMenu menuInfos = new JMenu("?");
		menuBar.add(menuInfos);
		
		JMenuItem menuItemRules = new JMenuItem("Règles");
		menuItemRules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"...","Règles du jeu",JOptionPane.CLOSED_OPTION);              
            }
        });
		menuInfos.add(menuItemRules);
		
		JMenuItem menuItemCredit = new JMenuItem("Crédit");
		menuItemCredit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Développé par Sophie MINOS, Steven VAN et Nathalie LIU dans le cadre du premier projet JAVA. Promo 2025 LSI2","Crédit",JOptionPane.CLOSED_OPTION);              
            }
        });
		menuInfos.add(menuItemCredit);
		
		JMenuItem menuItemQuit = new JMenuItem("Quitter");
		menuItemQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        menuJeu.add(menuItemQuit);
		
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(255, 250, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		/**
		 * Label
		 */
		JLabel lblPawnGames = DefaultComponentFactory.getInstance().createLabel("Pawn Games");
		lblPawnGames.setHorizontalAlignment(SwingConstants.CENTER);
		lblPawnGames.setBounds(205, 36, 400, 70);
		lblPawnGames.setForeground(new Color(117, 85, 71));
		lblPawnGames.setFont(new Font("Monospaced", Font.PLAIN, 60));
		lblPawnGames.setVerticalAlignment(SwingConstants.TOP);
		contentPanel.add(lblPawnGames);
		
		JLabel lblChoix = DefaultComponentFactory.getInstance().createLabel("Choisissez votre jeu :");
		lblChoix.setBounds(262, 120, 260, 31);
		lblChoix.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblChoix.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPanel.add(lblChoix);
		
		/**
		 * Bouton Othello
		 */
		JButton btnOthello = new JButton("Othello");
		btnOthello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Joueur j1 = new Joueur(Couleurs.NOIR);
				Joueur j2 = new Joueur(Couleurs.BLANC);
				OthelloFrame oFrame = new OthelloFrame(j1, j2);
				oFrame.OthelloFrame.setVisible(true);
				dispose();
			}
		});
		btnOthello.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnOthello.setBounds(76, 200, 300, 200);
		btnOthello.setOpaque(true);
		contentPanel.add(btnOthello);
		
		/**
		 * Bouton Puissance 4
		 */
		JButton btnP4 = new JButton("Puissance 4");
		btnP4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Joueur j1 = new Joueur(Couleurs.JAUNE);
				Joueur j2 = new Joueur(Couleurs.ROUGE);
				P4Frame pFrame = new P4Frame(j1, j2);
				pFrame.P4Frame.setVisible(true);
				dispose();
			}
		});
		btnP4.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnP4.setBounds(417, 200, 300, 200);
		btnP4.setOpaque(true);
		contentPanel.add(btnP4);
	}
	
}
