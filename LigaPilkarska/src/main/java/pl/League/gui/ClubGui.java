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

public class ClubGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubGui frame = new ClubGui();
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
	public ClubGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton backbutton = new JButton("Back");
		backbutton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backbutton.setBounds(174, 227, 89, 23);
		contentPane.add(backbutton);
		
		JLabel ClubTitle = new JLabel("Clubs");
		ClubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		ClubTitle.setForeground(new Color(0, 128, 0));
		ClubTitle.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		ClubTitle.setBackground(new Color(0, 128, 0));
		ClubTitle.setBounds(10, 11, 414, 38);
		contentPane.add(ClubTitle);
		
		JButton addClubButton = new JButton("Add new Club");
		addClubButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		addClubButton.setBounds(41, 195, 355, 23);
		contentPane.add(addClubButton);
	}

}
