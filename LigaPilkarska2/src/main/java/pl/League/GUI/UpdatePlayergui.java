package pl.League.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pl.League.DAO.PlayerDao;

public class UpdatePlayergui extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField surnameField;
	private JTextField dateOfBithField;
	private JTextField clubField;
	private JTextField nationalityField;
	private JTextField valueField;
	private JTextField positionField;
	private JTextField footField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePlayergui frame = new UpdatePlayergui();
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
	public UpdatePlayergui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 819);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel updateTitle = new JLabel("Update player information");
		updateTitle.setHorizontalAlignment(SwingConstants.CENTER);
		updateTitle.setForeground(new Color(0, 128, 0));
		updateTitle.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		updateTitle.setBackground(new Color(0, 128, 0));
		updateTitle.setBounds(10, 11, 414, 38);
		contentPane.add(updateTitle);
		
		JLabel firstNameLabel = new JLabel("First name:");
		firstNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		firstNameLabel.setBounds(10, 60, 105, 21);
		contentPane.add(firstNameLabel);
		
		firstNameField = new JTextField("");
		firstNameField.setColumns(10);
		firstNameField.setBounds(49, 92, 331, 26);
		contentPane.add(firstNameField);
		
		JLabel surnameLabel = new JLabel("Surname:");
		surnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		surnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		surnameLabel.setBounds(10, 129, 105, 21);
		contentPane.add(surnameLabel);
		
		surnameField = new JTextField("");
		surnameField.setColumns(10);
		surnameField.setBounds(49, 161, 331, 26);
		contentPane.add(surnameField);
		
		JLabel dateOfBirthLabel = new JLabel("Date of Birth:");
		dateOfBirthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateOfBirthLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateOfBirthLabel.setBounds(10, 352, 129, 21);
		contentPane.add(dateOfBirthLabel);
		
		dateOfBithField = new JTextField("");
		dateOfBithField.setColumns(10);
		dateOfBithField.setBounds(49, 384, 331, 26);
		contentPane.add(dateOfBithField);
		
		JLabel clubLabel = new JLabel("Club:");
		clubLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clubLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clubLabel.setBounds(10, 421, 105, 21);
		contentPane.add(clubLabel);
		
		clubField = new JTextField("");
		clubField.setColumns(10);
		clubField.setBounds(49, 453, 331, 26);
		contentPane.add(clubField);
		
		
		JLabel nationalityLabell = new JLabel("Nationality:");
		nationalityLabell.setHorizontalAlignment(SwingConstants.CENTER);
		nationalityLabell.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nationalityLabell.setBounds(10, 490, 105, 21);
		contentPane.add(nationalityLabell);
		
		nationalityField = new JTextField("");
		nationalityField.setColumns(10);
		nationalityField.setBounds(49, 522, 331, 26);
		contentPane.add(nationalityField);
		
		JLabel valueLabel = new JLabel("Value:");
		valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		valueLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		valueLabel.setBounds(10, 559, 105, 21);
		contentPane.add(valueLabel);
		
		valueField = new JTextField("");
		valueField.setColumns(10);
		valueField.setBounds(49, 591, 331, 26);
		contentPane.add(valueField);
		
		JLabel positionLabel = new JLabel("Position:");
		positionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		positionLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		positionLabel.setBounds(10, 198, 105, 21);
		contentPane.add(positionLabel);
		
		positionField = new JTextField("");
		positionField.setColumns(10);
		positionField.setBounds(49, 230, 331, 26);
		contentPane.add(positionField);
		
		JLabel footLabel = new JLabel("Foot:");
		footLabel.setHorizontalAlignment(SwingConstants.CENTER);
		footLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		footLabel.setBounds(10, 628, 105, 21);
		contentPane.add(footLabel);
		
		footField = new JTextField("");
		footField.setColumns(10);
		footField.setBounds(49, 660, 331, 26);
		contentPane.add(footField);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PlayerGui playerGui=new PlayerGui();
				playerGui.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		backButton.setBounds(239, 697, 141, 29);
		contentPane.add(backButton);
		
		JButton updateButton = new JButton("Update Data");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerDao.updatePlayer(firstNameField.getText(), surnameField.getText(), positionField.getText(), footField.getText(), valueField.getText(), clubField.getText(), nationalityField.getText(), dateOfBithField.getText());
				dispose();
				PlayerGui gui=new PlayerGui();
				gui.setVisible(true);
			}
		});
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		updateButton.setBounds(49, 697, 141, 29);
		contentPane.add(updateButton);
		
		JButton findButton_1 = new JButton("Get User Data");
		findButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List player=PlayerDao.findPlayer(surnameField.getText(), firstNameField.getText(), positionField.getText());
				firstNameField.setText(player.get(0).toString());
				surnameField.setText(player.get(1).toString());
				positionField.setText(player.get(5).toString());
				footField.setText(player.get(6).toString());
				valueField.setText(player.get(7).toString());
				nationalityField.setText(player.get(4).toString());
				clubField.setText(player.get(3).toString());
				dateOfBithField.setText(player.get(2).toString());
			}
		});
		findButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		findButton_1.setBounds(145, 267, 141, 29);
		contentPane.add(findButton_1);
	}
}
