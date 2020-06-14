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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class EmployeeGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeGui frame = new EmployeeGui();
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
	public EmployeeGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton backbutton = new JButton("Back");
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main main=new Main();
				main.setVisible(true);
			}
		});
		backbutton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backbutton.setBounds(172, 147, 89, 23);
		contentPane.add(backbutton);
		
		JLabel employeesTitle = new JLabel("Employees");
		employeesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		employeesTitle.setForeground(new Color(0, 128, 0));
		employeesTitle.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		employeesTitle.setBackground(new Color(0, 128, 0));
		employeesTitle.setBounds(10, 11, 414, 38);
		contentPane.add(employeesTitle);
		
		JButton addEmployeeButton = new JButton("Add new Employe");
		addEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddEmployeeGui addEmployeeGui=new AddEmployeeGui();
				addEmployeeGui.setVisible(true);
			}
		});
		addEmployeeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		addEmployeeButton.setBounds(39, 113, 355, 23);
		contentPane.add(addEmployeeButton);
		
		JButton deleteButton = new JButton("Delete Employe");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EmployeeFromClubGui gui=new EmployeeFromClubGui();
				gui.setVisible(true);
			}
		});
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		deleteButton.setBounds(39, 79, 355, 23);
		contentPane.add(deleteButton);
	}
}
