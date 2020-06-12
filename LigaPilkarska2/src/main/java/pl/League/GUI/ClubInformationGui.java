package pl.League.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pl.League.DAO.ClubDao;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class ClubInformationGui extends JFrame {

	private JPanel contentPane;
	private JTextField clubNameField;
	private JTextField cityField;
	private JTextField leagueField;
	private JTextField dateOfFoungingField;
	private JTextField stadiumNameField;
	private JTextField capacityField;
	private JTextField valueField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubInformationGui frame = new ClubInformationGui();
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
	public ClubInformationGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel addClubLabel = new JLabel("Club Informations");
		addClubLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addClubLabel.setForeground(new Color(0, 128, 0));
		addClubLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		addClubLabel.setBackground(new Color(0, 128, 0));
		addClubLabel.setBounds(10, 11, 414, 38);
		contentPane.add(addClubLabel);
		
		JLabel clubNameLabel = new JLabel("Club name:");
		clubNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clubNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clubNameLabel.setBounds(20, 60, 132, 21);
		contentPane.add(clubNameLabel);
		
		clubNameField = new JTextField("");
		clubNameField.setColumns(10);
		clubNameField.setBounds(60, 92, 331, 26);
		contentPane.add(clubNameField);
		
		JLabel cityLabel = new JLabel("City:");
		cityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cityLabel.setBounds(20, 129, 132, 21);
		contentPane.add(cityLabel);
		
		cityField = new JTextField("");
		cityField.setColumns(10);
		cityField.setBounds(60, 161, 331, 26);
		contentPane.add(cityField);
		
		JLabel leagueLabel = new JLabel("League:");
		leagueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leagueLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		leagueLabel.setBounds(20, 198, 132, 21);
		contentPane.add(leagueLabel);
		
		leagueField = new JTextField("");
		leagueField.setColumns(10);
		leagueField.setBounds(60, 230, 331, 26);
		contentPane.add(leagueField);
		
		JLabel dateOfFoundingLabel = new JLabel("Date of Fouding:");
		dateOfFoundingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateOfFoundingLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateOfFoundingLabel.setBounds(10, 267, 158, 21);
		contentPane.add(dateOfFoundingLabel);
		
		dateOfFoungingField = new JTextField("");
		dateOfFoungingField.setColumns(10);
		dateOfFoungingField.setBounds(60, 299, 331, 26);
		contentPane.add(dateOfFoungingField);
		
		JButton confirmButton = new JButton("Submit");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List info=ClubDao.informationAboutClub(clubNameField.getText());
				cityField.setText((String) info.get(1));
				leagueField.setText((String) info.get(5));
				dateOfFoungingField.setText( info.get(2).toString());
				stadiumNameField.setText((String) info.get(3));
				capacityField.setText(info.get(4).toString());
				valueField.setText(info.get(6).toString());
			}
		});
		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		confirmButton.setBounds(10, 544, 165, 29);
		contentPane.add(confirmButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ClubGui clubGui=new ClubGui();
				clubGui.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		backButton.setBounds(266, 544, 158, 29);
		contentPane.add(backButton);
		
		JLabel stadiumNameLabel = new JLabel("Stadium name:");
		stadiumNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stadiumNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		stadiumNameLabel.setBounds(10, 336, 132, 21);
		contentPane.add(stadiumNameLabel);
		
		stadiumNameField = new JTextField("");
		stadiumNameField.setColumns(10);
		stadiumNameField.setBounds(60, 368, 331, 26);
		contentPane.add(stadiumNameField);
		
		JLabel capacityLabel = new JLabel("Stadium capacity");
		capacityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		capacityLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		capacityLabel.setBounds(10, 405, 158, 21);
		contentPane.add(capacityLabel);
		
		capacityField = new JTextField("");
		capacityField.setColumns(10);
		capacityField.setBounds(60, 434, 331, 26);
		contentPane.add(capacityField);
		
		JLabel marketValueLabel = new JLabel("Sum of players market value");
		marketValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		marketValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		marketValueLabel.setBounds(10, 471, 225, 21);
		contentPane.add(marketValueLabel);
		
		valueField = new JTextField("");
		valueField.setColumns(10);
		valueField.setBounds(60, 503, 331, 26);
		contentPane.add(valueField);
	}
}
