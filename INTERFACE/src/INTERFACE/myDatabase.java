package INTERFACE;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings({ "serial", "unused" })
public class myDatabase extends Frame {
	private ImageIcon image1;
	private JLabel label1;
	Connection con;
	TextField tf1, tf2;
	TextArea t1, t2;
	Label l1, l2;
	Panel p1, p2, p3, p4;
	Button b1, b2, b3, b4, b5, b6, b7, b8;
	//private javax.swing.JLabel L_Backgroung;
	static final String DB_URL = "jdbc:sqlserver://localhost\\SMKANA01:1433";

	public myDatabase() {
		super("GUI_SQL-Database");
		setLayout(new FlowLayout());
		setLocation(300, 80);
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		
		/*
		ImageIcon bg = new ImageIcon(getClass().getResource("sitting-room.jpg"));
		ImageIcon icon = new ImageIcon("sitting-room.jpeg", "a pretty but meaningless splat");
		image1 = new ImageIcon(getClass().getResource("sitting-room.jpg"));
		label1 = new JLabel(image1);
		add(label1);
		L_Backgroung.setIcon(bg);
		L_Backgroung.setLocation(300, 80);
		L_Backgroung.setSize(new Dimension(500, 500));*/
		
		p1.setLayout(new GridLayout(3, 3, 20, 20));
		p2.setLayout(new BorderLayout());
		p3.setLayout(new GridLayout(2, 3, 15, 15));
		tf1 = new TextField("", 20);
		tf2 = new TextField("", 20);
		tf2.setEchoChar('*');
		t1 = new TextArea("Enter query", 5, 60);
		t2 = new TextArea("Result", 5, 60);
		l1 = new Label("username");
		l2 = new Label("Password");
		b1 = new Button("connect");
		b2 = new Button("Disconnect");
		b3 = new Button("Select");
		b4 = new Button("Update");
		b5 = new Button("Insert");
		b6 = new Button("Delete");
		b7 = new Button("Clear query");
		b8 = new Button("Clear result");
		p1.add(l1);
		p1.add(tf1);
		p1.add(l2);
		p1.add(tf2);
		p1.add(b1);
		p1.add(b2);
		p2.add("Center", t1);
		p3.add(b3);
		p3.add(b4);
		p3.add(b5);
		p3.add(b6);
		p3.add(b7);
		p3.add(b8);
		p2.add("South", p3);
		p4.add(t2);
		add(p1);
		add(p2);
		add(p4);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		b1.addActionListener(new ConnectDB());
		b2.addActionListener(new DisconnectDB());
		b3.addActionListener(new Select());
		b5.addActionListener(new Insert());
		b4.addActionListener(new Update());
		b6.addActionListener(new Delete());
		b7.addActionListener(new ClearQuery());
		b8.addActionListener(new ClearResult());
	}

	// }

	class ConnectDB implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				// String s = InetAddress.getLocalHost();
				con = DriverManager.getConnection(DB_URL, tf1.getText(),tf2.getText());
				t2.setText("Connection success");
			} catch (ClassNotFoundException e2) {
				t2.setText("Class not found");
			} catch (Exception e1) {
				t2.setText("error in connection");
			}
		}
	}

	class DisconnectDB implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				con.commit();
				con.close();
				t2.append("Connection closed");
			} catch (Exception e1) {
				t2.setText("error in disconnection");
			}
		}
	}

	class Select implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Statement stmt;
				ResultSet rs;
				String query;
				boolean more;
				stmt = con.createStatement();
				int count = 0;
				query = t1.getText();
				rs = stmt.executeQuery(query);
				more = rs.next();
				if (!more) {
					t2.append("No results");
					return;
				}
				t2.append("NO\tBName\tAname\tRate");
				while (more) {
					t2.append("\n" + rs.getString("ano") + "\t"
							+ rs.getString("bname") + "\t"
							+ rs.getString("aname") + "\t"
							+ rs.getString("rate"));
					count++;
					more = rs.next();
				}
				t2.append("\n" + count + " rows selected");
				rs.close();
				stmt.close();
			} catch (Exception e1) {
				t2.setText("error in selection");
			}
		}
	}

	class Update implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Statement stmt;
				String query;
				int rows;
				stmt = con.createStatement();
				query = t1.getText();
				rows = stmt.executeUpdate(query);
				if (rows == -1) {
					t2.append("Table dropped");
				}

				else {
					t2.append("\n" + rows + " rows updated");
				}
				con.commit();
				stmt.close();
			} catch (Exception e1) {
			}
		}
	}

	class Insert implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Statement stmt;
				String query;
				int rows;
				stmt = con.createStatement();
				query = t1.getText();
				rows = stmt.executeUpdate(query);
				if (rows == -1) {
					t2.append("Table dropped");
				}

				else {
					t2.append("\n" + rows + " rows inserted");
				}
				con.commit();
				stmt.close();
			} catch (Exception e1) {

			}
		}
	}

	class Delete implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Statement stmt;
				String query;
				int rows;
				stmt = con.createStatement();
				query = t1.getText();
				rows = stmt.executeUpdate(query);
				if (rows == -1) {
					t2.append("Table dropped");
				}

				else {
					t2.append("\n" + rows + " row deleted");
				}
				con.commit();
				stmt.close();
			} catch (Exception e1) {

			}
		}
	}

	class ClearQuery implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			t1.setText("");
		}
	}

	class ClearResult implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			t2.setText("");
		}
	}

	public static void main(String[] args) {
		myDatabase c = new myDatabase();
		c.setVisible(true);
		c.setSize(500, 500);
		c.setResizable(false);
		//c.setBackground(Color.blue.lightGray);
		//c.pack();

	}

}
