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

import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;

public class JeuGUI extends JFrame {

	JPanel contentPane;

	/**
	 * Launch the application.
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
	 * Create the frame.
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
		menuBar.setForeground(new Color(86, 78, 71));
		setJMenuBar(menuBar);
		
		JMenu menuJeu = new JMenu("Jeu");
		menuBar.add(menuJeu);
		
		JMenuItem menuItemOthello = new JMenuItem("Othello");
		menuItemOthello.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	OthelloFrame OFrame = new OthelloFrame();
				OFrame.OthelloFrame.setVisible(true);
				dispose();            
            }
        });
		menuJeu.add(menuItemOthello);
		
		JMenuItem menuItemP4 = new JMenuItem("Puissance 4");
		menuItemP4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P4Frame pFrame = new P4Frame();
				pFrame.P4Frame.setVisible(true);
				dispose();
			}
		});
		menuJeu.add(menuItemP4);
		
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
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Label
		 */
		JLabel lblPawnGames = DefaultComponentFactory.getInstance().createLabel("Pawn Games");
		lblPawnGames.setHorizontalAlignment(SwingConstants.CENTER);
		lblPawnGames.setBounds(205, 36, 400, 70);
		lblPawnGames.setForeground(new Color(117, 85, 71));
		lblPawnGames.setFont(new Font("Monospaced", Font.PLAIN, 60));
		lblPawnGames.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblPawnGames);
		
		JLabel lblChoix = DefaultComponentFactory.getInstance().createLabel("Choisissez votre jeu :");
		lblChoix.setBounds(262, 120, 260, 31);
		lblChoix.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblChoix.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(lblChoix);
		
		/**
		 * Bouton Othello
		 */
		JButton btnOthello = new JButton("Othello");
		btnOthello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OthelloFrame oFrame = new OthelloFrame();
				oFrame.OthelloFrame.setVisible(true);
				dispose();
			}
		});
		btnOthello.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnOthello.setBounds(76, 200, 300, 200);
		contentPane.add(btnOthello);
		
		/**
		 * Bouton Puissance 4
		 */
		JButton btnP4 = new JButton("Puissance 4");
		btnP4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P4Frame pFrame = new P4Frame();
				pFrame.P4Frame.setVisible(true);
				dispose();
			}
		});
		btnP4.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnP4.setBounds(417, 200, 300, 200);
		contentPane.add(btnP4);
	}
	
}
