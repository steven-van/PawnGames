package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class P4Frame {

	JFrame P4Frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the application.
	 */
	public P4Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		P4Frame = new JFrame();
		P4Frame.setBounds(100, 100, 450, 300);
		P4Frame.setTitle("Puissance 4");
		P4Frame.getContentPane().setBackground(new Color(255, 250, 250));
		P4Frame.setBounds(100, 100, 600, 700);
		P4Frame.setLocationRelativeTo(null);
		P4Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
