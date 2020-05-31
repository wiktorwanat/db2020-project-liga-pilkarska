package pl.League.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class LeaguesGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaguesGui frame = new LeaguesGui();
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
	public LeaguesGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton backbutton = new JButton("Back");
		backbutton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backbutton.setBounds(171, 227, 89, 23);
		contentPane.add(backbutton);
		
		JLabel leaguesTitle = new JLabel("Leagues");
		leaguesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		leaguesTitle.setForeground(new Color(0, 128, 0));
		leaguesTitle.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		leaguesTitle.setBackground(new Color(0, 128, 0));
		leaguesTitle.setBounds(10, 11, 414, 38);
		contentPane.add(leaguesTitle);
		
		JButton addLeagueButton = new JButton("Add new League");
		addLeagueButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		addLeagueButton.setBounds(42, 193, 355, 23);
		contentPane.add(addLeagueButton);
	}

}
