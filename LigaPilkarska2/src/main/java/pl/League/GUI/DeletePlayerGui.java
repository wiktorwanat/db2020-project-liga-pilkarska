package pl.League.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pl.League.DAO.PlayerDao;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeletePlayerGui extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField surnameField;
	private JTextField positionField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePlayerGui frame = new DeletePlayerGui();
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
	public DeletePlayerGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel addPlayerTitle = new JLabel("Delete player");
		addPlayerTitle.setHorizontalAlignment(SwingConstants.CENTER);
		addPlayerTitle.setForeground(new Color(0, 128, 0));
		addPlayerTitle.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		addPlayerTitle.setBackground(new Color(0, 128, 0));
		addPlayerTitle.setBounds(10, 11, 414, 38);
		contentPane.add(addPlayerTitle);
		
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
		
		JLabel positionLabel = new JLabel("Position:");
		positionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		positionLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		positionLabel.setBounds(26, 198, 105, 21);
		contentPane.add(positionLabel);
		
		positionField = new JTextField("");
		positionField.setColumns(10);
		positionField.setBounds(49, 230, 331, 26);
		contentPane.add(positionField);
		
		JButton confirmButton = new JButton("Submit");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerDao.deletePlayerByName(firstNameField.getText(), surnameField.getText(), positionField.getText());
				dispose();
				PlayerGui playerGui=new PlayerGui();
				playerGui.setVisible(true);
			}
		});
		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		confirmButton.setBounds(44, 287, 141, 29);
		contentPane.add(confirmButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PlayerGui playerGui=new PlayerGui();
				playerGui.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		backButton.setBounds(239, 287, 141, 29);
		contentPane.add(backButton);
	}
}
