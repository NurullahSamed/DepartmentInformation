package departmentinformation;
import java.sql.*;


import GUI.Frame;
public class JdbcConnection {

	public static void main(String[] args) {
		
		System.out.println("-------- PostgreSQL "
				+ "JDBC 'ye Baðlanýlýyor ------------");
		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("JDBC Driver bulunamadý! "
					+ "Kütüphane yoluna ekleyin !");
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

			System.out.println("Baðlantý hatasý!");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("Baðlantý baþarýyla kuruldu.");
		} else {
			System.out.println("Baðlantý kurulumu baþarýsýz!");
		}
		
		//Connection tipindeki nesne Frame nesnesine parametre olarak gönderildi.
		Frame frame = new Frame(connection);
	}
	

}
