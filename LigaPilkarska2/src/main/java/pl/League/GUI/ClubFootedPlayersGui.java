package pl.League.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pl.League.DAO.PlayerDao;

public class ClubFootedPlayersGui extends JFrame {

	private JPanel contentPane;
	private JTextField footField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubFootedPlayersGui frame = new ClubFootedPlayersGui();
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
	public ClubFootedPlayersGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel clubValueTitle = new JLabel("Top 5 clubs with biggest number of left/right footed players");
		clubValueTitle.setHorizontalAlignment(SwingConstants.CENTER);
		clubValueTitle.setForeground(new Color(0, 128, 0));
		clubValueTitle.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		clubValueTitle.setBackground(new Color(0, 128, 0));
		clubValueTitle.setBounds(10, 11, 542, 38);
		contentPane.add(clubValueTitle);
		
		JLabel footLabel = new JLabel("left/right foot:");
		footLabel.setHorizontalAlignment(SwingConstants.CENTER);
		footLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		footLabel.setBounds(10, 60, 169, 21);
		contentPane.add(footLabel);
		
		footField = new JTextField("");
		footField.setColumns(10);
		footField.setBounds(52, 92, 464, 26);
		contentPane.add(footField);
		
		JButton confirmButton = new JButton("Submit");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] footed=PlayerDao.calculateFootedPlayers(footField.getText());
				textField.setText(footed[0]);
				textField_1.setText(footed[1]);
				textField_2.setText(footed[2]);
				textField_3.setText(footed[3]);
				textField_4.setText(footed[4]);
			}});
		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		confirmButton.setBounds(10, 414, 141, 29);
		contentPane.add(confirmButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ClubGui conuntryGui=new ClubGui();
				conuntryGui.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		backButton.setBounds(283, 414, 141, 29);
		contentPane.add(backButton);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(95, 154, 372, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(95, 204, 372, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(95, 248, 372, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(95, 294, 372, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(95, 338, 372, 20);
		contentPane.add(textField_4);
		
		JLabel iterator = new JLabel("1.");
		iterator.setHorizontalAlignment(SwingConstants.CENTER);
		iterator.setFont(new Font("Tahoma", Font.PLAIN, 18));
		iterator.setBounds(27, 154, 36, 21);
		contentPane.add(iterator);
		
		JLabel iterator_1 = new JLabel("2.");
		iterator_1.setHorizontalAlignment(SwingConstants.CENTER);
		iterator_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		iterator_1.setBounds(27, 201, 36, 21);
		contentPane.add(iterator_1);
		
		JLabel iterator_2 = new JLabel("3.");
		iterator_2.setHorizontalAlignment(SwingConstants.CENTER);
		iterator_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		iterator_2.setBounds(27, 245, 36, 21);
		contentPane.add(iterator_2);
		
		JLabel iterator_3 = new JLabel("4.");
		iterator_3.setHorizontalAlignment(SwingConstants.CENTER);
		iterator_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		iterator_3.setBounds(27, 291, 36, 21);
		contentPane.add(iterator_3);
		
		JLabel iterator_4 = new JLabel("5.");
		iterator_4.setHorizontalAlignment(SwingConstants.CENTER);
		iterator_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		iterator_4.setBounds(27, 335, 36, 21);
		contentPane.add(iterator_4);
	}
}
