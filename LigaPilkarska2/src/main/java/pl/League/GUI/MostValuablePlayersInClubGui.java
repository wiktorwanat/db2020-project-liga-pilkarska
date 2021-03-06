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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pl.League.DAO.PlayerDao;
import pl.League.models.Player;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.JSeparator;

public class MostValuablePlayersInClubGui extends JFrame {

	private JPanel contentPane;
	private JTextField clubNameField;
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
					MostValuablePlayersInClubGui frame = new MostValuablePlayersInClubGui();
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
	public MostValuablePlayersInClubGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel clubValueTitle = new JLabel("Most Valuable Players in Club");
		clubValueTitle.setHorizontalAlignment(SwingConstants.CENTER);
		clubValueTitle.setForeground(new Color(0, 128, 0));
		clubValueTitle.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		clubValueTitle.setBackground(new Color(0, 128, 0));
		clubValueTitle.setBounds(10, 11, 414, 38);
		contentPane.add(clubValueTitle);
		
		JLabel clubNameLabel = new JLabel("Club name:");
		clubNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clubNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clubNameLabel.setBounds(10, 60, 169, 21);
		contentPane.add(clubNameLabel);
		
		clubNameField = new JTextField("");
		clubNameField.setColumns(10);
		clubNameField.setBounds(52, 92, 331, 26);
		contentPane.add(clubNameField);
		
		JButton confirmButton = new JButton("Submit");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Player> mostValuablePlayers=PlayerDao.mostValuablePlayersFromClub(clubNameField.getText());

				textField.setText(mostValuablePlayers.get(0).getFirst_name()+" "+mostValuablePlayers.get(0).getSurname());
				textField_1.setText(mostValuablePlayers.get(1).getFirst_name()+" "+mostValuablePlayers.get(1).getSurname());
				textField_2.setText(mostValuablePlayers.get(2).getFirst_name()+" "+mostValuablePlayers.get(2).getSurname());
				textField_3.setText(mostValuablePlayers.get(3).getFirst_name()+" "+mostValuablePlayers.get(3).getSurname());
				textField_4.setText(mostValuablePlayers.get(4).getFirst_name()+" "+mostValuablePlayers.get(4).getSurname());
				
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
		textField.setBounds(95, 154, 246, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(95, 204, 246, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(95, 263, 246, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(95, 305, 246, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(95, 352, 246, 20);
		contentPane.add(textField_4);
		
		JLabel iterator = new JLabel("1.");
		iterator.setHorizontalAlignment(SwingConstants.CENTER);
		iterator.setFont(new Font("Tahoma", Font.PLAIN, 18));
		iterator.setBounds(27, 154, 36, 21);
		contentPane.add(iterator);
		
		JLabel iterator_1 = new JLabel("2.");
		iterator_1.setHorizontalAlignment(SwingConstants.CENTER);
		iterator_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		iterator_1.setBounds(27, 207, 36, 21);
		contentPane.add(iterator_1);
		
		JLabel iterator_2 = new JLabel("3.");
		iterator_2.setHorizontalAlignment(SwingConstants.CENTER);
		iterator_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		iterator_2.setBounds(27, 260, 36, 21);
		contentPane.add(iterator_2);
		
		JLabel iterator_3 = new JLabel("4.");
		iterator_3.setHorizontalAlignment(SwingConstants.CENTER);
		iterator_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		iterator_3.setBounds(27, 308, 36, 21);
		contentPane.add(iterator_3);
		
		JLabel iterator_4 = new JLabel("5.");
		iterator_4.setHorizontalAlignment(SwingConstants.CENTER);
		iterator_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		iterator_4.setBounds(27, 355, 36, 21);
		contentPane.add(iterator_4);
	}
}
