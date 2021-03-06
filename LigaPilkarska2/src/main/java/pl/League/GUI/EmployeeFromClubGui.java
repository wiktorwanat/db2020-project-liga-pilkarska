package pl.League.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pl.League.DAO.EmployeeDao;

public class EmployeeFromClubGui extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameField;
	private JTable playersValueTable;
	private JTextField surnameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFromClubGui frame = new EmployeeFromClubGui();
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
	public EmployeeFromClubGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel clubValueTitle = new JLabel("Delete employee");
		clubValueTitle.setHorizontalAlignment(SwingConstants.CENTER);
		clubValueTitle.setForeground(new Color(0, 128, 0));
		clubValueTitle.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		clubValueTitle.setBackground(new Color(0, 128, 0));
		clubValueTitle.setBounds(10, 11, 414, 38);
		contentPane.add(clubValueTitle);
		
		JLabel firstNameLabel = new JLabel("First name");
		firstNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		firstNameLabel.setBounds(10, 60, 169, 21);
		contentPane.add(firstNameLabel);
		
		firstNameField = new JTextField("");
		firstNameField.setColumns(10);
		firstNameField.setBounds(52, 92, 331, 26);
		contentPane.add(firstNameField);
		
		JButton confirmButton = new JButton("Submit");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeDao.deleteByEmployeeName(firstNameField.getText(), surnameField.getText());
				dispose();
				EmployeeGui emp=new EmployeeGui();
				emp.setVisible(true);
			}});
		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		confirmButton.setBounds(10, 223, 141, 29);
		contentPane.add(confirmButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EmployeeGui emp=new EmployeeGui();
				emp.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		backButton.setBounds(283, 223, 141, 29);
		contentPane.add(backButton);
		
		
		JLabel surnameLabel = new JLabel("Surname");
		surnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		surnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		surnameLabel.setBounds(10, 129, 169, 21);
		contentPane.add(surnameLabel);
		
		surnameField = new JTextField("");
		surnameField.setColumns(10);
		surnameField.setBounds(52, 159, 331, 26);
		contentPane.add(surnameField);
	}
}
