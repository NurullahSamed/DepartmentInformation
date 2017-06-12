package departmentinformation;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import GUI.Frame;
public class JdbcConnection {

	public static void main(String[] args) {
		
		System.out.println("-------- PostgreSQL "
				+ "JDBC 'ye Ba�lan�l�yor ------------");
		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("JDBC Driver bulunamad�! "
					+ "K�t�phane yoluna ekleyin !");
			e.printStackTrace();
			return;

		}


		System.out.println("PostgreSQL JDBC Driver Bulundu !");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/employee", "nurullahsamed",
					"yonkou54");

		} catch (SQLException e) {

			System.out.println("Ba�lant� hatas�!");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("Ba�lant� ba�ar�yla kuruldu.");
		} else {
			System.out.println("Ba�lant� kurulumu ba�ar�s�z!");
		}
		
		//Connection tipindeki nesne Frame nesnesine parametre olarak g�nderildi.
		Frame frame = new Frame(connection);
	}
	

}
