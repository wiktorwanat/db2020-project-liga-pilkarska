package pl.League.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StadiumGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StadiumGui frame = new StadiumGui();
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
	public StadiumGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel stadiumtitle = new JLabel("Stadiums");
		stadiumtitle.setHorizontalAlignment(SwingConstants.CENTER);
		stadiumtitle.setForeground(new Color(0, 128, 0));
		stadiumtitle.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		stadiumtitle.setBackground(new Color(0, 128, 0));
		stadiumtitle.setBounds(10, 11, 414, 38);
		contentPane.add(stadiumtitle);
		
		JButton addStadiumButton = new JButton("Add new stadium");
		addStadiumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addStadiumButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		addStadiumButton.setBounds(39, 254, 355, 23);
		contentPane.add(addStadiumButton);
		
		JButton backbutton = new JButton("Back");
		backbutton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backbutton.setBounds(172, 288, 89, 23);
		contentPane.add(backbutton);
	}

}
