package departmentinformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JTextField;

import GUI.SorguPanel;

public class Kapat implements ActionListener {
	
	private SorguPanel sPanel;
	private Connection conn;
	
	public Kapat(SorguPanel sPanel,Connection connection){
		this.sPanel = sPanel;
		this.conn = connection;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		try {
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("Baðlantý kapatýldý.");
		System.exit(0);
		
	}

}
