package INTERFACE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Font;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(174, 150, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(207, 68, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(207, 103, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		Label lblUsername = new Label("UserName");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 12));
		lblUsername.setBounds(64, 68, 89, 24);
		frame.getContentPane().add(lblUsername);
		
		Label lblPass = new Label("Pass");
		lblPass.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPass.setBounds(64, 103, 89, 24);
		frame.getContentPane().add(lblPass);
	}
}
