package INTERFACE;

 
import javax.swing.*;           

import java.awt.*;
import java.awt.event.*;

import javax.swing.plaf.synth.*;

public class LoginDesign implements ActionListener {

	static JFrame frame;
	private static JTextField txtUsername;
	private static JPasswordField txtPass;
	static JButton btnSubmit;
	
    public Component createComponents() {       
    	
    	btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBounds(170, 150, 85, 20);
		frame.getContentPane().add(btnSubmit);
    	
    	
       // JButton buttonSub = new JButton("Submit");
		txtUsername = new JTextField();
		txtUsername.setBounds(180, 68, 116, 22);
		txtUsername.setBackground(Color.yellow);
		txtUsername.setForeground(Color.red);
        frame.getContentPane().add(txtUsername);
        
        txtPass = new JPasswordField();
        txtPass.setBounds(180, 103, 116, 22);
        txtPass.setBackground(Color.yellow);
        txtPass.setForeground(Color.red);
        frame.getContentPane().add(txtPass);
       
        Label lblUsername = new Label("Username");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 12));
		lblUsername.setBackground(Color.lightGray);
		lblUsername.setBounds(64, 68, 89, 24);
		frame.getContentPane().add(lblUsername);
		
		Label lblPass = new Label("Password");
		lblPass.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPass.setBounds(64, 103, 89, 24);
		lblPass.setBackground(Color.lightGray);
		frame.getContentPane().add(lblPass);
     
        /*
         * An easy way to put space between a top-level container
         * and its contents is to put the contents in a JPanel
         * that has an "empty" border.
         */
        JPanel pane = new JPanel(new GridLayout(0, 1));
      
       // pane.add(buttonSub);
       // pane.add(label);
        pane.setBorder(BorderFactory.createEmptyBorder(
        								200, //top
                                        200, //left
                                        40, //bottom
                                        200) //right
                                        );
        return pane;
    }

    
    public void actionPerformed(ActionEvent e) {
      
    	
    }


    private static void initLookAndFeel() {
       // String lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
       @SuppressWarnings("unused")
	SynthLookAndFeel lookAndFeel = new SynthLookAndFeel();
       
 
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Set the look and feel.
        initLookAndFeel();

        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LoginDesign app = new LoginDesign();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        actionlogin();
    }

    /**
     * actionLogin() just accept the text which typed from username field and
     * password field after pressing the button submit. Later it checks if the 
     * username and password is as written within this code. if not the same 
     * it will give the message and allow the user to input the correct one, 
     * otherwise it will sign in and terminate the frame. 
     */
    public static void actionlogin() {
    	btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ae) {
				String username = txtUsername.getText();
				String password = txtPass.getText();
				if (username.equals("Admin") && password.equals("Pass")) {
					frame.dispose();
					JOptionPane.showMessageDialog(null,"Login successfully!");
				} else {

					JOptionPane.showMessageDialog(null,
							"Wrong Password / Username");
					txtUsername.setText("");
					txtPass.setText("");
					txtUsername.requestFocus();
				}

			}
		});
	}
    
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
                
            }
        });
    }
}
